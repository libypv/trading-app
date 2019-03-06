package au.com.trading.app.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import au.com.trading.app.constant.Constants;
import au.com.trading.app.service.DateValidationService;
import au.com.trading.app.service.SubmitService;

@Controller
public class SubmitController {

	@Autowired
	SubmitService submitService;

	@Autowired
	DateValidationService dateValidationService;

	/**
	 * This controller is called on submitting the trading calendar form. First
	 * it validate the date rules and if success persist in data base and
	 * respond success. If data validation rule fails it will just return back
	 * to the main page.
	 * 
	 * @param recordDate
	 * @param paymentDate
	 * @param attr
	 * @return
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ModelAndView handleSubmission(
			@ModelAttribute(value = "recordDate") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate recordDate,
			@ModelAttribute(value = "paymentDate") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate paymentDate,
			RedirectAttributes attr) {

		System.out.println("submit*********recordDate : " + recordDate);
		System.out.println("submit*********paymentDate : " + paymentDate);

		ModelAndView modelAndView = new ModelAndView();

		String status = dateValidationService.validateRecordDate(recordDate, paymentDate);

		if (Constants.SUCCESS.equals(status)) {
			submitService.submitTradingCalendar(recordDate, paymentDate);
			attr.addFlashAttribute("recordDate",
					Date.from(recordDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			attr.addFlashAttribute("paymentDate",
					Date.from(paymentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			modelAndView.setStatus(HttpStatus.CREATED);
			modelAndView.setViewName("redirect:/success");
			return modelAndView;
		} else {
			attr.addFlashAttribute("recordDateMessage", status);
			modelAndView.setStatus(HttpStatus.BAD_REQUEST);
			modelAndView.setViewName("redirect:/");
			return modelAndView;
		}
	}

	/**
	 * This controller method is called if submit is successful
	 * 
	 * @param recordDate
	 * @param paymentDate
	 * @return
	 */
	@GetMapping({ "/success" })
	public ModelAndView success(
			@ModelAttribute(value = "recordDate") @DateTimeFormat(pattern = "dd/MM/yyyy") Date recordDate,
			@ModelAttribute(value = "paymentDate") @DateTimeFormat(pattern = "dd/MM/yyyy") Date paymentDate) {

		System.out.println("success*********recordDate : " + recordDate);
		System.out.println("success*********paymentDate : " + paymentDate);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("recordDate", recordDate);
		modelAndView.addObject("paymentDate", paymentDate);
		modelAndView.setViewName("success");
		return modelAndView;
	}
}