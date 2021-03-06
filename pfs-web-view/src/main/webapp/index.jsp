<%-- <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> --%>
<!DOCTYPE html>
<html>
<head>
<title>PFS - Personal Financial Statement</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="assets/bootstrap.3.3.5/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="assets/jquery/ui/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="assets/css/pfs-web-view.css" />

<link rel="shortcut icon" type="image/x-icon" href="${ pageContext.request.contextPath }/favicon.ico">
</head>
<body>
	<div id="content-wrapper">
		<h2>Personal Financial Statement</h2>
		<div id="tabs">

			<ul>
				<li><a href="#tabs-1">Internal Transfer</a></li>
				<li><a href="#tabs-2">Operation</a></li>
			</ul>
			<div id="tabs-1">
				<p>
					<strong>Internal transfer</strong>
				</p>
				<div id="tab1-content">

					<form id="it_frm" name="it_frm" class="frm" role="form" action="../pfs-rest-service/ws/intransfer/save"
						method="post">
						<div class="form-group">
							<label for="it_datepicker">
								<!--//TODO: I18n -->Date:
							</label> <input id="it_datepicker" name="it_datepicker" type="text"/>
						</div>
						<div class="form-group">
							<label for="select-account-from">
								<!--//TODO: I18n -->From:
							</label> <select id="select-account-from" name="select-account-from" class="form-control"></select>
						</div>
						<div class="form-group">
							<label for="select-account-to">
								<!--//TODO: I18n -->To:
							</label> <select id="select-account-to" name="select-account-to" class="form-control"></select>
						</div>
						<div class="form-group">
							<label for="it_amount">
								<!--//TODO: I18n -->Amount:
							</label> <input id="it_amount" name="it_amount" type="text" class="form-control control-group error"/>
						</div>

						<div class="form-group">
							<label for="it_description">
								<!--//TODO: I18n -->Description:
							</label> <input id="it_description" name="it_description" type="text" class="form-control input-block-level"/>
						</div>
						<input class="btn btn-default" id="btn-save-intransfer" type="submit" value="save" />
					</form>
				</div>
			</div>
			<div id="tabs-2">
				<p>
					<strong>Operation panel</strong>
				</p>
				<div id="tab2-content">
					<form id="op_frm" name="op_frm" class="frm"  role="form" action="../pfs-rest-service/ws/operation/save"
						method="post">
	
						<div class="form-group">
							<label for="op_datepicker">
								<!--//TODO: I18n -->Date:
							</label> <input id="op_datepicker" name="op_datepicker" type="text" />
						</div>
						<div class="form-group">
							<label for="op_amount">
								<!--//TODO: I18n -->Amount:
							</label> <input id="op_amount" name="op_amount" type="text" class="form-control" />
						</div>
						<div class="form-group">
							<label for="select-center">
								<!--//TODO: I18n -->Center:
							</label> <select id="select-center" name="select-center" class="form-control"></select>
						</div>
						<div class="form-group">
							<label for="select-account">
								<!--//TODO: I18n -->Account:
							</label> <select id="select-account" name="select-account" class="form-control"></select>
						</div>
						<div class="form-group">
							<label for="op_description">
								<!--//TODO: I18n -->Description:
							</label> <input id="op_description" name="op_description" type="text" class="form-control input-block-level"/>
						</div>
	
						<input class="btn btn-default" id="btn-save-operation" name="btn-save-operation" type="submit" value="save" />
					</form>
				</div>
			</div>
		</div>
		<!-- #tabs -->
	</div>
	<!--  #content-wrapper -->

	<div id="result"></div>
	<script type="text/javascript" src="assets/jquery/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="assets/jquery/jquery.mask.min.js"></script>
	<script type="text/javascript" src="assets/jquery/autoNumeric.js"></script>
	<script type="text/javascript" src="assets/jquery/jquery.validate.min.js "></script>
	<script type="text/javascript" src="assets/jquery/ui/jquery-ui.js"></script>
	<script type="text/javascript" src="assets/bootstrap.3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/pfs-web-view.js"></script>
</body>
</html>
