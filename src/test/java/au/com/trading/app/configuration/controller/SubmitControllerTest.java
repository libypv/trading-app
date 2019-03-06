package au.com.trading.app.configuration.controller;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import au.com.trading.app.configuration.TestConfig;
import au.com.trading.app.controller.SubmitController;

/**
 * This test SubmitController 
 * 
 * @throws JobsMatcherException
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestConfig.class)
public class SubmitControllerTest {

	@Autowired
	SubmitController submitController;
	
	@Test
	public void validateRecordDateTest_success() {
		LocalDate recordDate = LocalDate.of(2019, Month.MARCH, 1);
		LocalDate paymentDate = LocalDate.of(2019, Month.MARCH, 5);
		
		RedirectAttributes attr = new RedirectAttributesModelMap() ;
		ModelAndView modelAndView = submitController.handleSubmission(recordDate, paymentDate, attr );
		assertEquals("redirect:/success", modelAndView.getViewName());		
	}
}
	

