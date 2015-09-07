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
			<li><a href="#tabs-1">Internal Transfer</a></li>
			<li><a href="#tabs-2">Operation</a></li>
		</ul>
		<div id="tabs-1">
			<p>
				<strong>Internal transfer panel</strong>
			</p>
			<div id="tab1-content">
				<form action="" method="post">
					<input id="it_datepicker" type="text"/> 
					<select id="select-account-from"></select> 
					<select id="select-account-to"></select>
					<input id="it_amount" type="text" > 
					<input id="btn-save" type="submit" value="save" />
				</form>
			</div>
		</div>
		<div id="tabs-2">
			<p>
				<strong>Operation panel</strong>
			</p>

			<input type="text" id="op_datepicker" /> 
			<input type="text" id="op_amount">
			<select id="select-center"></select>
			<select id="select-account"></select>
			<input type="button" id="btn-save" value="save" />
			 
		</div>
	</div>
	<div id="result"></div>
</body>
</html>
