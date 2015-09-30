<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of Skills</title>
<link rel="stylesheet"
	href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>
	
<link rel="stylesheet"
	href='<c:url value="/web-resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>

<style type="text/css">
th {
	text-align: left
}
</style>

</head>
<body>
<br /><br />
<table width="50%">
<tr>
	<td>&nbsp; </td>
	<td>
	<a href="employee/listEmployees" class="pure-button pure-button-primary">
		<i class="fa fa-times"></i>List of Employees -- Enter Employee Details 
	</a> 
	</td>
</tr>
<tr>
	<td>&nbsp; </td>
	<td>
	<a href="employee/skills" class="pure-button pure-button-primary" >
		<i class="fa fa-times"></i>Skill - Search Employees by Skills
	</a>
	</td>
</tr>
</table>


</body>
</html>
