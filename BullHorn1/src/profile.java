

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Microblog;
import model.User;


@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String method = request.getParameter("method");
	 
		if(method.equals("post")){
			
			doPost(request, response);
		}else{
		String line = "<h3> Hello!!   " + session.getAttribute("username")+"</h3>";
		line += "<form action=BullCall method=post class=bs-example>"
	     	       + "<label name=enter text> Enter text</label>"
				 +   "<br>"
				 +  "<textarea rows=2 cols=50 name=text_name style=bottom-ex>"
				 +"</textArea><br><div>"
				 +"<input type=submit value=submit name=sub_write >"
				 + "</div></form>"
				 ;
		request.setAttribute("message", line);
		getServletContext().getRequestDispatcher("/Display.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String usrname = "";
		
//		if(request.getParameter("Username"){
//			usrname = session.getAttribute("username").toString();
//			
//		}else{
//			usrname = request.getParameter("Username");
//		}
		System.out.println("$$$$$$$$      " + usrname);
		 String line = "<table class=" 
				 	+ "\"table bs-example\"" 
				 	+ "style=width:60%"
				 	+ "style=font-weight: bold"
				 	+ ">";
	        	        
	        List<User> Usr_profile = DBtrans.selectUsr();
	        ArrayList<String> usr_profile = new ArrayList<String>();
	        SimpleDateFormat dateform = new SimpleDateFormat("MM/dd/YYYY");
	        
	        for(int i=0; i<Usr_profile.size(); i++){
	        	if (Usr_profile.get(i).getUserName().equals(usrname)){
	        		line +=  "<tr>"
		        			+"<td><strong>" + "Username: " +Usr_profile.get(i).getUserName()+ "</strong></td></tr>"
		        			+"<tr><td><strong>" + "Motto:    " + Usr_profile.get(i).getUserMotto()+ "</strong></td></tr>"
		        			+"<tr><td><strong>" + "Join Date: "+ dateform.format(Usr_profile.get(i).getJoindate())+ "</strong></td></tr>"		
		        	        ;
	        	}
	        }	
	   
	        
	        line += "</table>";
	       	
	        request.setAttribute("message", line);
			getServletContext().getRequestDispatcher("/Display.jsp").forward(request, response);
		
	}

}
