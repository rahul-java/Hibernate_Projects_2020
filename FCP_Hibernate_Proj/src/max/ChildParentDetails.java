package max;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChildParentDetails
 */
@WebServlet("/ChildParentDetails")
public class ChildParentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------");
		PrintWriter out = response.getWriter();
		Father f=new Father();
		f.setAdhar(request.getParameter("adhar"));
		f.setFname(request.getParameter("fname"));
		f.setDob(request.getParameter("dob"));
		f.setGender(request.getParameter("gender"));
		f.setStateCode(request.getParameter("stateCode"));
		f.setDistrictCode(request.getParameter("districtCode"));
		f.setEdu(request.getParameter("edu"));
		f.setDistrictCode(request.getParameter("districtCode"));
		
		Child c=new Child();
		String[] name = request.getParameterValues("cname");
		String[] age = request.getParameterValues("age");
	    String[] adhr = request.getParameterValues("cadhar");
		List<Child> list = new ArrayList<Child>();
		
		for(int i=0;i<name.length;i++)
		{ Child c1=new Child();
		c1.setCname(name[i]);
		c1.setAge(age[i]);
		c1.setCadhar(adhr[i]);
		list.add(c1);	
		}
		f.setList(list);
		
		
		
		
		ChildParentDAO cdao=new ChildParentDAO();
		if(cdao.insertDetailS(f))
		{
			out.println("insert ");
		}
		else
		{
		out.println("errrr");
		}
		
		
	}

}
