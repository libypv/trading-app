package au.com.trading.app.service;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import au.com.trading.app.configuration.TestConfig;
import au.com.trading.app.constant.Constants;

/**
 * This test DateValidationService 
 * 
 * @throws JobsMatcherException
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestConfig.class)
public class DateValidationServiceTest {

	@Autowired
	DateValidationService dateValidationService;
	
	@Before
	public void setup(){
		//If required
	}
	
	@Test
	public void validateRecordDateTest_success() {
		LocalDate recordDate = LocalDate.of(2019, Month.MARCH, 1);
		LocalDate paymentDate = LocalDate.of(2019, Month.MARCH, 5);
		
		String status = dateValidationService.validateRecordDate(recordDate, paymentDate);
		assertEquals(Constants.SUCCESS, status);
	}
	
	@Test
	public void validateRecordDateTest_Saturday() {
		LocalDate recordDate = LocalDate.of(2019, Month.MARCH, 2);
		LocalDate paymentDate = LocalDate.of(2019, Month.MARCH, 5);
		
		String status = dateValidationService.validateRecordDate(recordDate, paymentDate);
		assertEquals(Constants.NOT_A_BUSINESS_DATE, status);
	}
	
	@Test
	public void validateRecordDateTest_null() {
		LocalDate recordDate = null;
		LocalDate paymentDate = null;
		
		String status = dateValidationService.validateRecordDate(recordDate, paymentDate);
		assertEquals(Constants.NOT_A_BUSINESS_DATE, status);
	}
	
	@Test
	public void validatePaymentDateTest_success() {
		LocalDate recordDate = LocalDate.of(2019, Month.MARCH, 1);
		LocalDate paymentDate = LocalDate.of(2019, Month.MARCH, 5);
		
		String status = dateValidationService.validatePaymentDate(recordDate, paymentDate);
		assertEquals(Constants.SUCCESS, status);
	}
	
	@Test
	public void validatePaymentDateTest_Failure() {
		LocalDate recordDate = LocalDate.of(2019, Month.MARCH, 11);
		LocalDate paymentDate = LocalDate.of(2019, Month.MARCH, 5);
		
		String status = dateValidationService.validatePaymentDate(recordDate, paymentDate);
		assertEquals(Constants.DATES_CROSS_VALIDATION_FAILED, status);
	}
}
