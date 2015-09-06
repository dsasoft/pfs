/**
 * TODO: Create doc
 */


$(document).ready(function() {
//	getData();
	createTabs();
	createDatePicker();
	createSelectCenter();
	createSelectAccount();
	applyNumericMask();
});

function applyNumericMask(){
	$('#intrans-amount').autoNumeric('init');

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
	$('#select-account-to').append(content);
}

function createSelectCenter(){
	$.ajax({
		url : '../pfs-rest-service/ws/center/all',
		mimeType : 'application/json',
		method : 'GET',
		dataType : 'json',
		success : function(data) {

			var content = '<select>'
				+'<option/>';
			$.each(data.centerEntity, function(index, value) {
				content += '<option value=\"'+value.id+'\">' + value.centerType + '</option>';
			});
			content += '</select>';
			$('#select-center').html(content);
		},
		error : function(data, status, error) {
			$('#select-center').html('<div>ERROR</div>');
		}
	});
}

function createDatePicker() {
	$("#datepicker").datepicker({
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

/**
 * Ajax based function to 
 * access/retrieve data from pfs-rest-service
 * */
function getData() {
	$.ajax({
		url : '../pfs-rest-service/ws/center/all',
		mimeType : 'application/json',
		method : 'GET',
		dataType : 'json',
		success : function(data) {

			var content = '<ul>';
			$.each(data.centerEntity, function(index, value) {
				content += '<li>' + value.centerType + '</li>';
			});
			content += '</ul>';
			$('#list-center').html(content);
		},
		error : function(data, status, error) {
			$('#list-center').html('<div>ERROR</div>');
		}
	});
}