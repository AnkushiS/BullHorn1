import customTools.DBUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		model.User user = new model.User();
		user.setUserName(request.getParameter("user_name"));
		user.setPassword(request.getParameter("Password"));
		System.out.println(request.getParameter("Password"));
		HttpSession session = request.getSession();
		session.setAttribute("username", request.getParameter("user_name"));
		session.setAttribute("password", request.getParameter("Password"));
		
				
		
		// check if user name and password match
		 
		String line= "";
		boolean yes=DBtrans.checkLogin(request.getParameter("user_name"), request.getParameter("Password"));
		
		if(yes==true){
			line += "<h3> Hello!!   " + request.getParameter("user_name")+"</h3>";
			line += "<form action=BullCall method=post class=bs-example>"
		     	       + "<label name=enter text> Enter text</label>"
					 +   "<br>"
					 +  "<textarea rows=2 cols=50 name=text_name style=bottom-ex>"
					 +"</textArea><br><div>"
					 +"<input type=submit value=submit name=sub_write >"
					 + "</div></form>"
					 ;
		}else{
			
			line += "wrong username passsword";
			DBtrans.insertUsr(user);
		}
		
		request.setAttribute("message", line);
		getServletContext().getRequestDispatcher("/Display.jsp").forward(request, response);	
					
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
		
		String line = "<table class=" 
        		+ "\"table table-striped\"" 
        		+ "style=width:60%>";
		// get the list of values to display
	    
        
        line += 
 			"<tr>" 
 			+"<th>" + "user_text" + "</th> <br>"
 			+ "</tr>"
 			;
		
        for(int i=0; i<DBtrans.selectBlog().size(); i++){
        	line += "<tr>" 
        			+"<td>" + DBtrans.selectBlog().get(i).getUserText()+ "</td>"
        			+"</tr>"
        	        ;
        	}
        
        	line += "</table>";
		request.setAttribute("message", line);
		getServletContext().getRequestDispatcher("/Display.jsp").forward(request, response);
		
	}
	
	protected void Posts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String line = "<table class=" 
        		+ "\"table table-striped\"" 
        		+ "style=width:60%>";
		// get the list of values to display
	    
        
        line += 
 			"<tr>" 
 			+"<th>" + "user_text" + "</th> <br>"
 			+ "</tr>"
 			;
        request.setAttribute("message", line);
		getServletContext().getRequestDispatcher("/Display.jsp").forward(request, response);
	}

}
