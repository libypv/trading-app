<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <title>Success</title>    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
	<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
</head>
<body>
    <script src="/js/main.js"></script>
    <fmt:formatDate value="${recordDate}" pattern="dd/MM/yyyy" var="formattedRecordDate" />
    <fmt:formatDate value="${paymentDate}" pattern="dd/MM/yyyy" var="formattedPaymentDate" />
    <fieldset>
	    <label>Successful!</label>
		<ul>
			<li>
				<label>Record Date:</label> <span>${formattedRecordDate}</span>   
			</li>
			<li>
				<label>Payment Date:</label>  <span>${formattedPaymentDate}</span>   
			</li>
		 </ul>
	</fieldset>
</body>
</html>