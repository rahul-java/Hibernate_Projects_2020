<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="dto.RegisDTO" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data sheet</title>
<script type="text/javascript">
function getAdharDetail()
{   
	var adhr=document.getElementById("adhar").value;
	alert(adhr);
    var xmlhttp;
	if (window.XMLHttpRequest)
	{
	// code for IE7+, Firefox, Chrome, Opera, Safari
	     xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
	 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	 }
	
	
	xmlhttp.onreadystatechange=function()
	 {
	 if (xmlhttp.readyState==4 && xmlhttp.status==200)
	{
	//document.getElementById("fname").value
	 var s=xmlhttp.responseText;
	 alert("s "+s)
	       t=s.split(",");
	     document.getElementById("un").value=t[0];
	     document.getElementById("add").value=t[1];
	     document.getElementById("dob").value=t[2];
	}
	  
	 }
	
	
	
	
	
	
	 xmlhttp.open("GET","AdharServlet?adhar="+adhr,true);
     xmlhttp.send();
	
	}

</script>

</head>
 <%
 RegisDTO  ud=(RegisDTO)request.getAttribute("user");
 %>
 
<body bgcolor="palegoldenrod">
<h1>Data Sheet</h1>

<form action="UpdateServlet">
  <table border="3" bgcolor="lightskyblue" align="center">

<tr>
<td><input type="text" readonly="readonly" name="uid" id="uid" value=<%=ud.getUid() %>></td>


<tr><td>User Name </td>
<td><input type="text" name="uname" id="un" value=<%=ud.getUname() %>></td>

<td>Adhar</td>
<td><input type="text" name="adhar" id="adhar" onblur="getAdharDetail();"></td>
</tr>

<tr><td>DOB</td><td><input type="text" name="dob" id="dob"></td></tr>
<tr><td>Address</td><td><input type="text" name="add" id="add"></td></tr>
<tr><td>Gender</td>
<td><input type="radio" name="gender" value="m" checked> Male<br>
 <input type="radio" name="gender" value="f"> Female<br></td>
 
<td>Skills</td>

<td>
<input type="checkbox" name="skills" value="java">Java<br>
<input type="checkbox" name="skills" value="dotnet">DotNet<br>
<input type="checkbox" name="skills" value="php" >Php<br></td>
</tr>

<tr>
<td>Education</td>

<td>
<select name="education">
<option value="B.tech">B.tech</option>
<option value="Mca">Mca</option>
<option value="BCA">BCA</option>
<option value="BED">BED</option>
</select>
</td>
</tr>

<tr><td><input type="submit" value="Update">
<!-- <input type="submit">
 --></td>
 <td><a href=ViewServlet>View</a></td>
 
 </tr>


</table>
</form>
</body>
</html>