

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
		String method = request.getParameter("method");
		if(method.equals("post")){
			doPost(request, response);
		}else{
		model.Microblog user = new model.Microblog();
		// get posts
		String line = BullCall.getAllBlogs();			
		request.setAttribute("message", line);
		getServletContext().getRequestDispatcher("/AllPost.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		model.Microblog user = new model.Microblog();
		System.out.println("in post of viewPosts");
		System.out.println(session.getAttribute("username").toString());
		String line = BullCall.getUsrBlogs(session.getAttribute("username").toString());
		request.setAttribute("message", line);
		getServletContext().getRequestDispatcher("/Display.jsp").forward(request, response);
		
		
	}

}
