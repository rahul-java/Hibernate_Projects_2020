<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="master.DistrictBean" %>

   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
function getAdharDetail() {
var adhar=document.getElementById("adhar").value;
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
       t=s.split(",");
     document.getElementById("t1").value=t[0];
     document.getElementById("t2").value=t[1];
}
  
 }
  xmlhttp.open("GET","AdharDetailservlet?adhar="+adhar,true);
      xmlhttp.send();
}


   function addRow()
   {
   var table=document.getElementById("child");
   var rowCount=table.rows.length;
   var row=table.insertRow(rowCount);
   var cell1=row.insertCell(0);
   cell1.innerHTML=rowCount;
   var cell2=row.insertCell(1);
   
   var element2=document.createElement("input");
   element2.type="checkbox";
   element2.name="chk";
   cell2.appendChild(element2);
   var cell3=row.insertCell(2);
   
   var element3=document.createElement("input");
   element3.type="text";
   element3.name="cname";
   cell3.appendChild(element3);
   var cell4=row.insertCell(3);
   
   var element4=document.createElement("input");
   element4.type="text";
   element4.name="age";
   cell4.appendChild(element4);
   var cell5=row.insertCell(4);
   
   var element5=document.createElement("input");
   element5.type="text";
   element5.name="cadhar";
   cell5.appendChild(element5);
   }
   function deleteRow()
   {
     var table=document.getElementById("child");
	 var i=1;
	 if(chkbox==cheked)
	 {
	   table.deleteRow(i);
	   i++;
	 }
	
   }
   
   
   
   
</script>
<% 
   
  String st=(String) request.getAttribute("stateName");
List<DistrictBean> list=(List<DistrictBean>)request.getAttribute("lst");
     
     %>
</head>
<body>
<form action="SHGDetailServlet">
<table id="parent" bgcolor="red" border ="3">
<tr>
   <td colspan="4" align="center">SHG Detail</td>
</tr>

<tr><td>State Name</td><td><input type="text" readonly="readonly" name="stateCode" value="<%=st%>">  <td>


<td>District Name</td>
        <td><select name="distCode">
                            <option value="0">select District</option>
                   <%
                   for(DistrictBean p:list)
                   {
                   
                   %>
                      
                                   
            <option value="<%=p.getDistCode()%>"><%=p.getDistName()%></option>
						
						<%} %>
						</select></td>
</tr>

<tr>



<td>SHGName</td><td><input type="text" name="shgName" id="t1"></td>
<td>Acount</td><td><input type="text" name="acount" id="t2"></td></tr>
<tr><td>IFSC</td><td><input type="text" name="ifsc"></td></tr>




</table>
<table id="child" bgcolor="yellow" border ="3">
  <tr>
   <td colspan="4" align="center">Member Detail </td><td align="right"> <input type="button" id="b1"  value="Addd" onclick="addRow();"></td>
</tr>
  <tr>
     <td>S.No.</td><td>Select</td><td> Name</td><td>Age</td><td>Adhar</td>
  </tr>
  <tr>
     <td>1</td><td><input type="checkbox" name="chk"></td>
     <td><input type="text" name="cname"></td>
     <td><input type="text" name="age"></td>
     <td><input type="text" name="cadhar"></td>
  </tr>
  
</table>
<table>
<tr><td><input type="submit" value="Save"></td>

</tr>
</table>

</form>
</body>
</html>