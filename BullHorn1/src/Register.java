

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date datejoin = new Date();
		// put into database the register value 
		model.User user = new model.User();
		user.setUserName(request.getParameter("user_name"));
		user.setPassword((request.getParameter("Password")));
		user.setUserMotto(request.getParameter("motto"));
		user.setJoindate(datejoin);
		
		HttpSession session = request.getSession();
		session.setAttribute("username", request.getParameter("user_name"));	
		
		DBtrans.insertUsr(user);
		
		getServletContext().getRequestDispatcher("/Login.html").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		getServletContext().getRequestDispatcher("/Login.html").forward(request, response);

	}

}
