import customTools.DBUtils;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String line = "<form action=BullCall method=post class=bs-example>"
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		model.Microblog user = new model.Microblog();
		String user_text = request.getParameter("text_name");	
		user.setUserText(user_text);
		DBtrans.insert(user);
		
		// get the list of values to display
	    String line = "<table class=" 
        		+ "\"table table-striped\"" 
        		+ "style=width:60%>";
        
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

}
