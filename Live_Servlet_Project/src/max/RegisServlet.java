package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RegisBean;
import bo.RegisBO;
import bo.RegisBOIMPL;


@WebServlet("/RegisServlet")
public class RegisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String	uname =request.getParameter("uname");
	String	adhar =request.getParameter("adhar");
	String	dob =request.getParameter("dob");
	System.out.println("dob "+dob);
	String	add =request.getParameter("add");
	String[] skills = request.getParameterValues("skills");
	String	gender =request.getParameter("gender");
	String	education =request.getParameter("education");
	
	
	RegisBean regisBean=new RegisBean();
	regisBean.setUname(uname);
	regisBean.setAdd(add);
	regisBean.setAdhar(adhar);
	regisBean.setDob(dob);
	regisBean.setEducation(education);
	regisBean.setGender(gender);
	String sk="";
	for(String p:skills)
	{
		sk=sk+","+p;
	}
	regisBean.setSkill(sk);
		
	RegisBO regisBO=new RegisBOIMPL();
	if(regisBO.getUserRegisDetail(regisBean))
	{  
		out.println("Successs");
		request.getRequestDispatcher("regis.html").include(request, response);
	 }
	else
	{
		out.println("unSuccesss");
		request.getRequestDispatcher("regis.html").include(request, response);
		
	}
	
	}

	
	

}
