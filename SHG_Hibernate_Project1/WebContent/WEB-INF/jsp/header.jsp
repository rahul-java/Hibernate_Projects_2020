<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   String uid=(String) session.getAttribute("uid");
%>

<table border="3" bgcolor="cyan">
<tr><td colspan="2"> HHHHHHHHHHHHHHHHHHHHHHHHHHHH  </td> <td> <a style="color:red" href=Logout?uid=<%=uid%>><%=uid%></a>  </td>    </tr>
<tr>
<td><a href=SGHModification>SHGModification</a></td>
<td><a href=SGHView>SHGView</a></td>
<td><a href=SGHDelete>SHGDelete</a></td>
 </tr>
</table>


</body>
</html>