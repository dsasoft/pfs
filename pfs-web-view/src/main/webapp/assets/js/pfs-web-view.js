/**
 * TODO: ** Create documentation ** 
 */


$(document).ready(function() {
	createTabs();
	createDatePicker();
	createSelectAccount();
	applyNumericMask();
	createSelectCenter();
//	getData();
});

function applyNumericMask(){
	var options = {
		aSep: '.', aDec: ',', aSign: 'R$ '
	};
	$('#it_amount').autoNumeric('init', options);
	$('#op_amount').autoNumeric('init', options);
//	$('#intrans-amount').mask('decimal',{
//		radixPoint:".", 
//        groupSeparator: ",", 
//        digits: 2,
//        autoGroup: true,
//        prefix: 'R$ '
//	});
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
	$("#it_datepicker").datepicker({
		showOn : "button",
		buttonImage : "assets/images/calendar.gif",
		buttonImageOnly : true,
		buttonText : "Select date",
	});
	
	$("#op_datepicker").datepicker({
		showOn : "button",
		buttonImage : "assets/images/calendar.gif",
		buttonImageOnly : true,
		buttonText : "Select date",
	});
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
			$.each(data.centerEntity, function(index, value) {
				content += '<option value=\"' + value.id + '\">'
						+ value.name + '</option>';
			});
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