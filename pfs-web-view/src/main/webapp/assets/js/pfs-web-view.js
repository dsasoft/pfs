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
	$('#op_btn-save').click(function(){
		$.ajax({
			url : '../pfs-rest-service/ws/operation/save',
			mimeType : 'application/json',
			method : 'GET',
			dataType : 'json',
			//TODO: content: JSON.stringfy({ 'field-1:' + $('field-1').value });
			success : function(data) {
				//TODO: parse the response to $('#result').append('html')
			},
			error : function(data, status, error) {}
		});
	});
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

//$.fn.serializeObject = function()
//{
//  var o = {};
//  var a = this.serializeArray();
//  $.each(a, function() {
//      if (o[this.name] !== undefined) {
//          if (!o[this.name].push) {
//              o[this.name] = [o[this.name]];
//          }
//          o[this.name].push(this.value || '');
//      } else {
//          o[this.name] = this.value || '';
//      }
//  });
//  return o;
//};
//
//$(function() {
//  $('form').submit(function() {
//  	alert('...');
//      $('#result').text(JSON.stringify($('form').serializeObject()));
//      return false;
//  });
//});