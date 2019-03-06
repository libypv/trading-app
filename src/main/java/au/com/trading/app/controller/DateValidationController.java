package au.com.trading.app.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import au.com.trading.app.service.DateValidationService;

@Controller
public class DateValidationController {

	@Autowired
	DateValidationService dateValidationService;

	/**
	 * This controller validates record date rules
	 * 
	 * @param model
	 * @param recordDate
	 * @param paymentDate
	 * @return success or error response message
	 */
	@GetMapping({ "/recordDateCheck" })
	public @ResponseBody String validateRecordDate(
			@RequestParam(value = "recDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate recordDate,
			@RequestParam(value = "payDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate paymentDate) {

		System.out.println("recordDateCheck*********recordDate : " + recordDate);
		System.out.println("recordDateCheck*********paymentDate : " + paymentDate);

		String status = dateValidationService.validateRecordDate(recordDate, paymentDate);
		return status;
	}

	/**
	 * This controller validates payment date rules
	 * 
	 * @param recordDate
	 * @param paymentDate
	 * @return success or error response message
	 */
	@GetMapping({ "/paymentDateCheck" })
	public @ResponseBody String validatePaymentDate(
			@RequestParam(value = "recDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate recordDate,
			@RequestParam(value = "payDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate paymentDate) {

		System.out.println("paymentDateCheck*********recordDate : " + recordDate);
		System.out.println("paymentDateCheck*********paymentDate : " + paymentDate);

		String status = dateValidationService.validatePaymentDate(recordDate, paymentDate);
		return status;
	}

	/**
	 * This is the main default page
	 * 
	 * @return
	 */
	@GetMapping({ "/" })
	public String main() {
		return "main";
	}
}