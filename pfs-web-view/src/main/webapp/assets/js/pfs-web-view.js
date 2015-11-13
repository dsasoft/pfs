/**
 * TODO: ** Create documentation ** 
 */
$(document).ready(function() {
	createTabs();
	createDatePicker();
	createSelectAccount();
	applyNumericMask();
	createSelectCenter();
});


$(document).ready(function(){
	$('#btn-save-operation').click(function(){
		var operationForm = operationFormToJSON();
		$(this).prop('disabled',true);
		$.ajax({
			url: '../pfs-rest-service/ws/operation/save',
			mimeType: 'application/json',
			contentType : 'application/json',
			method: 'POST',
			dataType: 'json',
			data: operationForm,
			success: function(data){
				
				$('body').append('<span>' + JSON.stringify(data) + '</span>')
				
				$('#result').fadeIn(1500, function(){
					$(this).html(operationForm);
				});
				setTimeout(function(){ 
					$('#result').fadeOut(5000,function(){
						$(this).html('');
					});
					$('#btn-save-operation').prop('disabled',false);
				}, 5000);
				
			},
			error: function(data, status, error){}
		});
			
	});
});

/**
 * op_datepicker
 * op_amount
 * select-center
 * select-account
 * */
function operationFormToJSON(){
	return JSON.stringify({
		"date":$('#op_datepicker').val(),
		"amount":$('#op_amount').val(),
		"center":$('#select-center').val(),
		"account":$('#select-account').val()
	});
}

function applyNumericMask(){
	var options = {
		aSep: '.', aDec: ',', aSign: 'R$ '
	};
	$('#it_amount').autoNumeric('init', options);
	$('#op_amount').autoNumeric('init', options);
}

function createSelectAccount(){
	
	var accountList;
	
	$.ajax({
		url : '../pfs-rest-service/ws/account/all',
		mimeType : 'application/json',
		method : 'GET',
		dataType : 'json',
		success : function(data) {
			var content = '<option/>';
			$.each(data.accountEntity, function(index, value) {
				content += '<option value=\"'+value.id+'\">' + value.name + '</option>';
			});
			$('#select-account-from').append(content);
			
			$('#select-account-to').append(content);
			
			$('#select-account').append(content);
		},
		error : function(data, status, error) {
			$('#select-account-from').html('<div>ERROR</div>');
		}
	});
}

function createDatePicker() {
	var calOptions = {
			showOn : "button",
			buttonImage : "assets/images/calendar.gif",
			buttonImageOnly : true,
			buttonText : "Select date",
	};
	$("#it_datepicker").datepicker(calOptions);
	
	$("#op_datepicker").datepicker(calOptions);
}
/**
 * Create to switch between In-transfer and operation's panel 
 * */
function createTabs() {
	$("#tabs").tabs();
}

function createSelectCenter() {
	$.ajax({
		url : '../pfs-rest-service/ws/center/all',
		mimeType : 'application/json',
		method : 'GET',
		dataType : 'json',
		success : function(data) {

			var content = '<select>' + '<option/>';
			
			if(! $.isEmptyObject(data)){
				$.each(data.centerEntity, function(index, value) {
					content += '<option value=\"' + value.id + '\">'
					+ value.name + '</option>';
				});
			}
			content += '</select>';
			$('#select-center').html(content);
		},
		error : function(data, status, error) {
			$('#select-center').html('<div>ERROR</div>');
		}
	});
}
