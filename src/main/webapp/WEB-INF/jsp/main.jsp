<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Trading Calendar</title>
	<link href="resources/static/css/main.css" rel="stylesheet">
	
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="resources/static/js/main.js"></script>

</head>

<body>

	<h3>Trading Calendar</h3>
	<form method="post" action="submit">
		<fieldset>
			<table>
				<tr>
					<td>
						<p>
							Record Date <input type="text" id="datepickerRecord" name="recordDate">
						</p>
						<div id='recordDateMessage'>${recordDateMessage}</div>
					</td>
					<td><p>
							Payment Date <input type="text" id="datepickerPayment" name="paymentDate">
						</p>
						<div id='paymentDateMessage'></div></td>
				</tr>
				<tr>
					<td colspan='2' style='text-align: center'><input
						type="submit" value="Submit" id="submit" />
					<td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>