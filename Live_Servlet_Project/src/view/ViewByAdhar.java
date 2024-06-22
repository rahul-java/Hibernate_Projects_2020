package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dl.RegisDAOIMPL;
import dto.RegisDTO;

/**
 * Servlet implementation class ViewByAdhar
 */
@WebServlet("/ViewByAdhar")
public class ViewByAdhar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String adhar = request.getParameter("adhar");
		out.println("adhar "+adhar);
	
		
		RegisDAOIMPL b=new RegisDAOIMPL();
		RegisDTO p = b.fatchRegisdetail(adhar);
		
		request.setAttribute("user", p);
		request.getRequestDispatcher("updateregis.jsp").forward(request, response);
		
		
	}
		
	}


