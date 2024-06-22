package view;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.Father;


@WebServlet("/ViewChildParentDetails")
public class ViewChildParentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 System.out.println("vvvvv");
	 ViewDAO b=new  ViewDAO();
	Map<String, Object> cf = b.fatchChildFatherDetails();
	//List<Father> flist=(List<Father>) cf.get("flist");
	//List<ChildDTO> clist=(List<ChildDTO>) cf.get("clist");
	            if(cf.size()>0)
	            {
	            	request.setAttribute("map", cf);
	            	request.getRequestDispatcher("view.jsp").forward(request, response);
	  	          
	            	         }
	            else
	            {
	            	request.getRequestDispatcher("A.jsp").forward(request, response);
	         	   	
	            }
	            
	            
	
	}

}
