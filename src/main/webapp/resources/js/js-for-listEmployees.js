function addEmployee() {
	$('#employeeDialog').dialog("option", "title", 'Add Employee');
	$('#employeeDialog').dialog('open');
}

function editEmployee(id) {

	$.get("get/" + id, function(result) {

		$("#employeeDialog").html(result);

		$('#employeeDialog').dialog("option", "title", 'Edit Employee');

		$("#employeeDialog").dialog('open');

		initializeDatePicker();
	});
}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#employeeDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#employeeForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#employeeForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
