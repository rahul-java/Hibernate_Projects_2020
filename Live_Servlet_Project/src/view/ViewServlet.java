package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dl.RegisDAOIMPL;
import dto.RegisDTO;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisDAOIMPL regisDAOIMPL=new RegisDAOIMPL();
		PrintWriter out = response.getWriter();
	List<RegisDTO> list = regisDAOIMPL.fatchRegisdetail();
	if(list.size()>0)
	{
		out.println("<html><body>");
		out.println("<table border='3' bgcolor='yellow'>");
		out.println("<tr><td>UID</td><td>Name</td><td>Add</td><td>Addhar</td><td>DOB</td><td>GNDR</td><td>Skills</td><td>Education</td></tr>");
		
		for(RegisDTO p:list)
		{
out.println("<tr><td>"+p.getUid()+"</td><td>"+p.getUname()+"</td><td>"+p.getAdd()+"</td><td><a href=ViewByAdhar?adhar="+p.getAdhar()+">"+p.getAdhar()+"</td><td>"+p.getDob()+"</td><td>"+p.getGender()+"</td><td>"+p.getSkill()+"</td><td>"+p.getEducation()+"</td></tr>");
				
		}
		out.println("</table></body></html>");
		
	}
	
	}

}
