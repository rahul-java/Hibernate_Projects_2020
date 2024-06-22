package logout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String uid = request.getParameter("uid");
		LogoutDAO logoutDAO=new LogoutDAO();
		String ud = logoutDAO.logout(uid);
		if(ud.equalsIgnoreCase(uid))
		{    request.getSession().invalidate();
		   PrintWriter out = response.getWriter();
		   out.println("User successfully Logout "+uid);
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}

}
