package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DistrictBean;
import master.DistrictDAO;
import master.StateBean;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		
		String pass = request.getParameter("pass");
		LoginBean loginBean = new LoginBean();
		loginBean.setPass(pass);
		loginBean.setUid(uid);
		LoginDAO loginDAO=	new	LoginDAO();
		String st = loginDAO.login(loginBean);
		if(st.equalsIgnoreCase(uid))
		{
			request.getSession().setAttribute("uid", st);
			StateBean d = DistrictDAO.getStateCode(uid.substring(0, 2));
			request.setAttribute("stateName", d.getStateName());
			request.setAttribute("lst", DistrictDAO.getDistictDetail(d.getStateCode()));
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
		else if(st.equalsIgnoreCase("AL"))
		{
			out.println("User Allready Login "+uid);
	 request.getRequestDispatcher("login.jsp").include(request, response);
			
		}
		else
		{
			out.println("Wrong Passs");
	out.println("<a href=ResetPass?uid="+uid+">ForgetPass</a>");
			 request.getRequestDispatcher("login.jsp").include(request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
