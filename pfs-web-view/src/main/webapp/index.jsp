<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="assets/jquery/jquery-1.11.3.js"></script>
<script type="text/javascript" src="assets/jquery/jquery.mask.min.js"></script>
<script type="text/javascript" src="assets/jquery/autoNumeric.js"></script>
<script type="text/javascript" src="assets/jquery/ui/jquery-ui.js"></script>
<script type="text/javascript" src="assets/js/pfs-web-view.js"></script>

<link rel="stylesheet" type="text/css" href="assets/jquery/ui/jquery-ui.css" />

<style type="text/css">
.ui-widget input {
	width: 110px;
}
</style>
</head>
<body>
	<div id="tabs">
		<h2>Personal Financial Statement</h2>
		<ul>
			<li><a href="#tabs-1">Operation</a></li>
			<li><a href="#tabs-2">Internal Transfer</a></li>
		</ul>
		<div id="tabs-1">
			<p>
				<strong>Operation panel</strong>
			</p>

			<form action="../pfs-rest-service/ws/operation/save" method="POST">
				<input type="text" id="op_datepicker" /> 
				<input type="text" id="op_amount">
				<select id="select-center"></select>
				<select id="select-account"></select>
				<input type="button" id="op_btn-save" value="save" />
			</form>
		</div>
		
		<div id="tabs-2">
			 <p>
				<strong>Internal transfer panel</strong>
			</p>
			<div id="tab1-content">
				<form action="../pfs-rest-service/ws/intransfer/save" method="post">
					<input id="it_datepicker" name="it_datepicker" type="text"/>
					
					<label for="select-account-from">From: </label> 
					<select id="select-account-from" name="select-account-from"></select>
					
					<label for="select-account-to">To: </label> 
					<select id="select-account-to" name="select-account-to"></select>
					
					<input id="it_amount" name="it_amount" type="text" >
					
					<input id="btn-save" type="submit" value="save" />
				</form>
			</div>
		</div>
	</div>
	<div id="result"></div>
</body>
</html>
