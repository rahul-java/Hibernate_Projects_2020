<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.Map" %>
      <%@ page import="java.util.List" %>
        <%@ page import="max.Father" %>
        <%@ page import="view.ChildDTO" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <table  border="3"  align="center" bgcolor="green">
   <tr><td>Pid</td><td>Fname</td><td>Adhar</td><td>DOB</td><td>Gender</td><td>StateCode</td><td>DistCode</td><td>Education</td></tr>  
   
    <%
    
    Map<String, Object> m= (Map<String, Object>) request.getAttribute("map");
  List<Father> flist=(List<Father>) m.get("fdetails");
    System.out.println("innnn "+flist.size());
  	List<ChildDTO> clist=(List<ChildDTO>) m.get("cdetails");
  	   for(   Father p:flist)
  	   {
  		   
  	  
    %>
     <tr> <th colspan="8" bgcolor="red">  Father Details  </th></tr>
   <tr><td><%=p.getPid() %></td>
   <td><%=p.getFname() %></td>
   <td><%=p.getAdhar() %></td>
   <td><%=p.getDob() %></td>
   <td><%=p.getGender() %></td>
   <td><%=p.getStateCode() %></td>
   <td><%=p.getDistrictCode() %></td>
   <td><%=p.getEdu() %></td></tr>
   <tr> <th colspan="8" bgcolor="yellow">  Child Details  </th></tr>
   <%
      int fid= p.getPid();
   for(ChildDTO c:clist)
   {
	  int cpid= c.getPid();
	  if(fid==cpid)
	  {
	%>
		<tr><td><%=c.getCid() %></td><td><%=c.getName() %></td><td><%=c.getAge() %></td><td><%=c.getAdhar()%></td></tr>
		
		
		
		<%  
	  }
	  
   }
  	   } 
   %>
   <tr><td colspan="8"><a href=uploadServlet>Upload ON Server </a> </td></tr>
   </table>

    
    
    
</body>
</html>