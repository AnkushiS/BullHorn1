import customTools.DBUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Microblog;

/**
 * Servlet implementation class BullCall
 */
@WebServlet("/BullCall")
public class BullCall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BullCall() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		model.User user = new model.User();
		user.setUserName(request.getParameter("user_name"));
		user.setPassword(request.getParameter("Password"));

		HttpSession session = request.getSession();
		session.setAttribute("username", request.getParameter("user_name"));
		session.setAttribute("password", request.getParameter("Password"));
		// check if user name and password match

		String line = "";

		boolean yes = DBtrans.checkLogin(request.getParameter("user_name"),
				request.getParameter("Password"));

		if (yes == true) {
			line += "<h3> Hello!!   " + session.getAttribute("username")
					+ "</h3>";
			line += "<form action=BullCall method=post class=bs-example>"
					+ "<label name=enter text> Enter text</label>"
					+ "<br>"
					+ "<textarea rows=2 cols=50 name=text_name style=bottom-ex>"
					+ "</textArea><br><div>"
					+ "<input type=submit value=submit name=sub_write >"
					+ "</div></form>";
		} else {

			line += "wrong username passsword";
			DBtrans.insertUsr(user);
		}

		request.setAttribute("message", line);
		getServletContext().getRequestDispatcher("/Display.jsp").forward(
				request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		SimpleDateFormat date = new SimpleDateFormat("MM/dd/YYYY");
		Date datein = new Date();

		System.out.println(date.format(datein));

		model.Microblog user = new model.Microblog();
		// blog text
		String user_text = request.getParameter("text_name");
		user.setUserText(user_text);

		// user name insert
		HttpSession session = request.getSession();
		user.setUserName(session.getAttribute("username").toString());

		// set date
		user.setDatein(datein);

		DBtrans.insert(user);

		String line = getAllBlogs();
		request.setAttribute("message", line);
		getServletContext().getRequestDispatcher("/Display.jsp").forward(
				request, response);
	}

	public static String getAllBlogs() {
		String line = "<table class=" + "\"table table-striped\""
				+ "style=width:60%>";
		// get the list of values to display

		line += "<tr>" + "<th>" + "user_text" + "</th> <br>" + "<th>"
				+ "user_name" + "</th> <br>" + "</tr>";

		
		List<Microblog> all_blogs = DBtrans.selectBlog();
		for (int i = 0; i < all_blogs.size(); i++) {
			line += "<tr>" + 
					"<td>" + all_blogs.get(i).getUserText() + "</td>"
					+ "<td><a href='profile?method=post&Username=" +all_blogs.get(i).getUserName() +"\'" +">" + all_blogs.get(i).getUserName() + "</a></td>"
					+ "</tr>";
		}

		line += "</table>";

		return line;

	}

	public static String getUsrBlogs(String usrname) {

		String line = "<table class=" + "\"table table-striped\""
				+ "style=width:60%>";

		line += "<tr>" + "<th>" + "Your blogs" + "</th> <br>" + "</tr>";

		List<Microblog> all_blogs = DBtrans.selectBlog();
		ArrayList<String> usr_blogs = new ArrayList<String>();

		for (int i = 0; i < all_blogs.size(); i++) {
			if (all_blogs.get(i).getUserName().equals(usrname)) {
				System.out.println("in usr_blogs");
				usr_blogs.add(all_blogs.get(i).getUserText());
			}
		}

		System.out.println(usr_blogs.size());
		for (int i = 0; i < usr_blogs.size(); i++) {
			line += "<tr>" + "<td>" + usr_blogs.get(i) + "</td>" + "</tr>";

		}

		line += "</table>";

		return line;
	}

}
