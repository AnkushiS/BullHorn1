

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewPosts
 */
@WebServlet("/viewPosts")
public class viewPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewPosts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		model.Microblog user = new model.Microblog();
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
