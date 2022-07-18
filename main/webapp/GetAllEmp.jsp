<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.List,com.chainsys.jspproject.pojo.Employee,java.util.ArrayList"
    import = "com.chainsys.jspproject.dao.EmployeeDao"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GetAll Employee</title>
</head>
<body>
	<table> 
<thead></thead> 
<% 
List<Employee> allEmployee = EmployeeDao.getAllEmployees();
for(Employee emp: allEmployee){
 %>
 <tr>
  
  <td> <%=emp.getE_Id()%> </td>
  <td> <%=emp.getFirst_Name()%> </td>
  <td> <%=emp.getLast_Name()%> </td>
  <td> <%=emp.getEmail()%> </td>
  <td> <%=emp.getHire_Date()%> </td>
  <td> <%=emp.getJob_ID()%> </td>
  <td> <%=emp.getSalary()%> </td>
  
  
 </tr>
 <%}%>
 </table>
		
	</form>
</body>
</html>