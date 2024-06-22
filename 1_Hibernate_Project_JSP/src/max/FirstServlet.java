package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String adhar = request.getParameter("adhar");
		String dob = request.getParameter("dob");
		String add = request.getParameter("add");
		String gender = request.getParameter("gender");
		String education = request.getParameter("education");
	   PrintWriter out = response.getWriter();
		RBean rb = new RBean();   // xml json
		rb.setAdhar(adhar);
		rb.setUname(uname);
		rb.setAdd(add);
		rb.setDob(dob);
		rb.setEducation(education);
		rb.setGender(gender);
		Session ses = SessionUtility.getSession();
		Transaction tx = ses.beginTransaction();
		String adhr=(String)ses.save(rb);
		tx.commit();
		if(adhr.equalsIgnoreCase(adhar))
		{
			out.println("successss");
			request.getRequestDispatcher("w.jsp").include(request, response);
		}
		else
		{
			out.println("fail");
			request.getRequestDispatcher("w.jsp").include(request, response);
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
