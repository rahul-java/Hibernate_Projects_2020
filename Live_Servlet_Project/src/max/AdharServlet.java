package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdharServlet")
public class AdharServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adhr=request.getParameter("adhar");
		PrintWriter out = response.getWriter();
		AdharMasterDAO adharMasterDAO=new AdharMasterDAO();
		String detail = adharMasterDAO.getDetails(adhr);
		System.out.println("di "+detail);
		out.println(detail);
	}

}
