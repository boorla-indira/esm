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
<h1>List of Skills</h1>

<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="4%">S.N</th>
					<!-- 
					<th width="12%">Id</th>
					 -->
					<th width="12%">Name</th>					
					<th width="12%"></th>
				</tr>
			</thead>

			<tbody>

			<c:forEach items="${skillsList}" var="skill" varStatus="loopCounter">
				<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<!-- 
						<td><c:out value="${skill.id}" /></td>
						 -->
						<td><c:out value="${skill.name}" /></td>						
						<td><nobr>
				
							<a href="skills/${skill.id}" class="pure-button pure-button-primary" >
								<i class="fa fa-times"></i>Show Employees with this skill
							</a> <br />
						</nobr>
						</td>
				</tr>
			</c:forEach>
	</tbody>
	
	<a href="/esm" class="pure-button pure-button-primary" >
								<i class="fa fa-times"></i>Main Page
							</a> <br />
</body>

