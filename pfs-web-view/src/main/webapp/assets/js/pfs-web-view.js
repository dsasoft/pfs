/**
 * TODO: ** Create documentation ** 
 */
$(document).ready(function() {
	createTabs();
	createDatePicker();
	createSelectAccount();
	applyNumericMask();
	createSelectCenter();
	
	// Form validation
	op_frm_validation();
	it_frm_validation();
});

function op_frm_validation(){
	$("#op_frm").validate({
		rules : {
			op_datepicker : {
				required : true,
				date : true
			},	
			'select-center' : { 
				required : true 
			},
			'select-account' : {
				required : true
			},
			op_amount : {
				required : true
			}
		},
		
		errorClass : 'alert-danger glyphicon glyphicon-exclamation-sign',
		
		messages:{
			op_datepicker : '&nbsp;',
			'select-center' : '',
			'select-account'  : '',
			op_amount : ''
		},
		errorPlacement : function(error, element) {
			error.insertBefore(element);
		},
		submitHandler: function(form) {
//			$('#btn-save-operation').click(function(){
				var operationForm = operationFormToJSON();
//				$(this).prop('disabled',true);
				$.ajax({
					url: '../pfs-rest-service/ws/operation/save',
					mimeType: 'application/json',
					contentType : 'application/json',
					method: 'POST',
					dataType: 'json',
					data: operationForm,
					success: function(data){
						
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
//			});
			form.submit();
		}
	});
}

function it_frm_validation(){
	$("#it_frm").validate({
		rules : {
			it_datepicker : {
				required : true,
				date : true
			},	
			'select-account-from' : { 
				required : true 
			},
			'select-account-to' : {
				required : true
			},
			it_amount : {
				required : true
			}
		},
		
		errorClass : 'alert-danger glyphicon glyphicon-exclamation-sign',
		
		messages:{
			it_datepicker : '&nbsp;',
			'select-account-from': '',
			'select-account-to'  : '',
			it_amount : ''
		},
		errorPlacement : function(error, element) {
			error.insertBefore(element);
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
}

$(document).ready(function(){
	$('#select-account-from').change(function(){
		
		$('#select-account-to').html('');
		
		if(! $(this).val()) return;
		
		$.ajax({
			url: '../pfs-rest-service/ws/account/all/except/' + $(this).val(),
			mimeType: 'application/json',
			contentType : 'application/json',
			method: 'GET',
			dataType: 'json',
			success:function(data){
				
				var _object = data.accountEntity;
				
				var content = '<select>';
				if( $.isArray(_object)){
					
					$.each(_object, function(index, value) {
						content += '<option value=\"'+value.id+'\">' + value.name + '</option>';
					});
				}else{
					content += '<option value=\"'+ _object.id +'\">' + _object.name + '</option>'; 
				}
				content += '</select>';
				$('#select-account-to').html(content);
			},
			error:function(data, status, error){}
		});
	})
});

//$(document).ready(function(){
//	$('#btn-save-operation').click(function(){
//		var operationForm = operationFormToJSON();
//		$(this).prop('disabled',true);
//		$.ajax({
//			url: '../pfs-rest-service/ws/operation/save',
//			mimeType: 'application/json',
//			contentType : 'application/json',
//			method: 'POST',
//			dataType: 'json',
//			data: operationForm,
//			success: function(data){
//				
//				$('#result').fadeIn(1500, function(){
//					$(this).html(operationForm);
//				});
//				setTimeout(function(){ 
//					$('#result').fadeOut(5000,function(){
//						$(this).html('');
//					});
//					$('#btn-save-operation').prop('disabled',false);
//				}, 5000);
//				
//			},
//			error: function(data, status, error){}
//		});
//			
//	});
//});

function operationFormToJSON(){
	var stringified = JSON.stringify({
		"date":$('#op_datepicker').val(),
		"amount":$('#op_amount').val(),
		"center":$('#select-center').val(),
		"account":$('#select-account').val(),
		"description":$('#op_description').val()
	});
	
	cleanOperationForm();
	
	return stringified;
}

function cleanOperationForm(){
	// Clean Form
	$('#op_datepicker').val('');
	$('#op_amount').val('');
	$('#select-center').val('');
	$('#select-account').val('');
	$('#op_description').val('');
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
					
					if(value.centerType === 'OUTCOME') //
						content += '<option  class=\"alert alert-danger\" value=\"' + value.id + '\">' + value.name + '</option>';
					else
						content += '<option  value=\"' + value.id + '\">' + value.name + '</option>';
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
