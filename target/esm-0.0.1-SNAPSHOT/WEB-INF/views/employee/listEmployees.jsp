<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of Employees</title>
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

	<div style="width: 95%; margin: 0 auto;">


		<div id="employeeDialog" style="display: none;">

			<%@ include file="employeeForm.jsp"%>

		</div>




		<h1>List Of Books</h1>


		<button class="pure-button pure-button-primary"
			onclick="addEmployee()">

			<i class="fa fa-plus"></i> Add Employee

		</button>

		<br>

		<table class="pure-table pure-table-bordered pure-table-striped">

			<thead>

				<tr>

					<th width="4%">S.N</th>

					<th width="12%">Name</th>

					<th width="12%">Department</th>
					<!-- 
                  <th width="12%">Price</th>

                  <th width="12%">Authors</th>

                  <th width="12%">ISBN</th>

                  <th width="12%">Publisher</th>

                  <th width="12%">Published On</th>
 -->
					<th width="12%"></th>

				</tr>

			</thead>

			<tbody>

				<c:forEach items="${employeeList}" var="book"
					varStatus="loopCounter">

					<tr>

						<td><c:out value="${loopCounter.count}" /></td>

						<td><c:out value="${employee.name}" /></td>

						<td><c:out value="${book.department}" /></td>
						<!-- 
                   <td><c:out value="${book.price}" /></td>

                   <td><c:out value="${book.authors}" /></td>

                   <td><c:out value="${book.isbn}" /></td>

                   <td><c:out value="${book.publisher}" /></td>

                   <td><c:out value="${book.publishedOn}" /></td>
 -->



						<td><nobr>

								<button onclick="editEmployee(${employee.id});"
									class="pure-button pure-button-primary">


									<i class="fa fa-pencil"></i> Edit

								</button>




								<a href="delete/${employee.id}"
									class="pure-button pure-button-primary"
									onclick="return confirm('Are you sure you want to delete this employee?');">

									<i class="fa fa-times"></i>Delete

								</a>

							</nobr></td>

					</tr>

				</c:forEach>

			</tbody>

		</table>

	</div>

	<!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->



	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'></script>

	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>

	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>

	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listEmployees.js"/>'></script>
</body>

</html>