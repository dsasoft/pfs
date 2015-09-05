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
				<input type="text" id="datepicker"/>
				<select id="select-account-from"></select>
				<select id="select-account-to"></select>
				<input type="text" id="intrans-amount">
				<input type="button" id="btn-save" value="save"/>
			</div>
		</div>
		<div id="tabs-2">
			<p>
				<strong>Click this tab again to close the content pane.</strong>
			</p>

			<div id="list-center"></div>
			
			<div id="select-center"></div>

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
<!-- 		<div id="tabs-3"> -->
<!-- 			<p> -->
<!-- 				<strong>Click this tab again to close the content pane.</strong> -->
<!-- 			</p> -->
<!-- 			<p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, -->
<!-- 				semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra -->
<!-- 				justo vitae neque. Praesent blandit adipiscing velit. Suspendisse -->
<!-- 				potenti. Donec mattis, pede vel pharetra blandit, magna ligula -->
<!-- 				faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. -->
<!-- 				Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi -->
<!-- 				lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean -->
<!-- 				vehicula velit eu tellus interdum rutrum. Maecenas commodo. -->
<!-- 				Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus -->
<!-- 				hendrerit hendrerit.</p> -->
<!-- 		</div> -->
	</div>
</body>
</html>
