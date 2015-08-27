/**
 * TODO: Create doc
 */

$(document).ready(function() {
	getData();
});
function getData() {

	$.ajax({
		url : 'http://localhost:8081/pfs-rest-service/ws/center/all',
		mimeType : 'application/json',
		method : 'GET',
		dataType: 'json',
		success : function(data) {
			
			var content = '<ul>';
			$.each(data.centerEntity, function(index, value){
				content +=  '<li>' + value.centerType + '</li>';
			});
			content += '</ul>';
			$('#list-center').html(content);
		},
		error : function(data, status, error) {

		}
	});
}