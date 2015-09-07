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
				<input type="text" id="it_datepicker" /> 
				<select id="select-account-from"></select> 
				<select id="select-account-to"></select>
				<input type="text" id="it_-amount"> 
				<input type="button" id="btn-save" value="save" />
			</div>
		</div>
		<div id="tabs-2">
			<p>
				<strong>Operation panel</strong>
			</p>

			<input type="text" id="op_datepicker" /> 
			<input type="text" id="op_amount">
			<select id="select-account"></select>
			
			 
			

			<p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus
				gravida ante, ut pharetra massa metus id nunc. Duis scelerisque
				molestie turpis. Sed fringilla, massa eget luctus malesuada, metus
				eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet
				fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam.
				Praesent in eros vestibulum mi adipiscing adipiscing. Morbi
				facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut
				posuere viverra nulla. Aliquam erat volutpat. Pellentesque
				convallis. Maecenas feugiat, tellus pellentesque pretium posuere,
				felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris
				consectetur tortor et purus.</p>
		</div>
	</div>
</body>
</html>
