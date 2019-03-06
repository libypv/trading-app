$(function() {
	$("#datepickerRecord").datepicker({
		dateFormat : 'dd/mm/yy'
	});
	$("#datepickerPayment").datepicker({
		dateFormat : 'dd/mm/yy'
	});

	$("#datepickerRecord").keydown(function(e) {
		if (e.which == 9)
			Validator.RecordDateValdate(e);
	});
	$("#datepickerRecord").change(Validator.RecordDateValdate);

	$("#datepickerPayment").change(Validator.PaymentdateValidate);
	$("#datepickerPayment").keydown(function(e) {
		if (e.which == 9)
			Validator.PaymentdateValidate(e);
	});
}
);

var Validator = (function() {

	function getUrlPaymentDate() {
		var daterecord = $("#datepickerRecord").val();
		var datepayment = $("#datepickerPayment").val();
		return '/paymentDateCheck?recDate=' + daterecord + '&payDate='
				+ datepayment;
	}
	function getUrlRecordDate() {
		var daterecord = $("#datepickerRecord").val();
		var datepayment = $("#datepickerPayment").val();
		return '/recordDateCheck?recDate=' + daterecord + '&payDate='
				+ datepayment;
	}
	var PaymentVal = function(e) {
		$.get(getUrlPaymentDate(), function(data, status) {
			if (data == "Success") {
				$('#paymentDateMessage').text("");
			} else {
				$('#paymentDateMessage').text(data);
			}
		});
	}

	var RecordVal = function(e) {
		$.get(getUrlRecordDate(), function(data, status) {
			if (data == "Success") {
				$('#recordDateMessage').text("");
			} else {
				$('#recordDateMessage').text(data);
			}
		});
	}

	return {
		RecordDateValdate : RecordVal,
		PaymentdateValidate : PaymentVal
	};
}());