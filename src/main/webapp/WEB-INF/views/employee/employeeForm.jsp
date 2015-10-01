
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="save" />
<form:form id="employeeForm" commandName="employee" method="post"
	action="${actionUrl }" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>
		<table>
			<tr>
				<td>
				<label for="name">Name</label>
			 	</td>
			 	<td>&nbsp;</td>
				<td> 
				<form:input path="name" placeholder="Employee Name" />
				</td>
			</tr>
			<tr>
				<td> <label for="code">Department</label></td>
				<td>&nbsp;</td>
				<td> <form:input path="department" placeholder="Department" maxlength="15" /></td>
			</tr>
			<tr>
				<td> <label for="code">Skills</label></td>
				<td>&nbsp;</td>
				<td> <form:select path="skills" items="${skillsList}" multiple="true" itemValue="id" itemLabel="name" class="form-control input-sm" /></td>
			</tr>
		</table>
				
		<form:input path="id" type="hidden" />
		
	</fieldset>

</form:form>