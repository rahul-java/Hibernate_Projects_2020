package shgregistration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String stateName = request.getParameter("stateName");
		String distCode = request.getParameter("distCode");
		String shgName = request.getParameter("shgName");
		String acount = request.getParameter("acount");
		String ifsc = request.getParameter("ifsc");
		String[] cname = request.getParameterValues("cname");
		String[] age = request.getParameterValues("age");
		String[] cadhar = request.getParameterValues("cadhar");
		
		RegistrationBean registrationBean=new RegistrationBean();
		
		registrationBean.setStateName(stateName);
		registrationBean.setDistCode(distCode);
		registrationBean.setAcount(acount);
		registrationBean.setIfsc(ifsc);
		registrationBean.setShgName(shgName);
		
		
		registrationBean.setAge(age);
		registrationBean.setCadhar(cadhar);
		registrationBean.setCname(cname);
		RegistrationBO registrationBO=new	RegistrationBO();
		if(registrationBO.getRegistrationData(registrationBean))
		{
			request.getRequestDispatcher("A.jsp").forward(request, response);	
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
	}

}
