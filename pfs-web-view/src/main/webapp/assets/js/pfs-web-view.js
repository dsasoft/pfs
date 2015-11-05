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
		$('#result').fadeIn(1500, function(){
			$(this).html(operationForm);
		});
		setTimeout(function(){ 
			$('#result').fadeOut(5000,function(){
				$(this).html('');
			});
		}, 5000);
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


$(function() {
//    $('form').submit(function() {
//    	alert('...');
//        $('#result').text(JSON.stringify($('form').serializeObject()));
//        return false;
//    });
});

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

function createSelectAccountTo(data, idx){
	
	//TODO: Create logic...
	
	$.each(data.accountEntity, function(index, value){
		//if(value.id == index) skip to next...
	});
	//$('#select-account-to').append(content);
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


/**
 * Ajax based function to 
 * access/retrieve data from pfs-rest-service
 * */
//function getData() {
//	$.ajax({
//		url : '../pfs-rest-service/ws/center/all',
//		mimeType : 'application/json',
//		method : 'GET',
//		dataType : 'json',
//		success : function(data) {
//
//			var content = '<ul>';
//			$.each(data.centerEntity, function(index, value) {
//				content += '<li>' + value.centerType + '</li>';
//			});
//			content += '</ul>';
//			$('#list-center').html(content);
//		},
//		error : function(data, status, error) {
//			$('#list-center').html('<div>ERROR</div>');
//		}
//	});
//}