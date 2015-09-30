<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Employees with Skills</title>
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

<h1>List of Employees with Skills</h1>
	<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="4%">S.N</th>
					<th width="12%">Id</th>
					<th width="12%">Name</th>					
					<th width="12%">Department</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${employeesWithSkills}" var="employee" varStatus="loopCounter">
					<tr>
							<td><c:out value="${loopCounter.count}" /></td>
							<td><c:out value="${employee.id}" /></td>
							<td><c:out value="${employee.name}" /></td>
							<td><c:out value="${employee.department}" /></td>						
							
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>

