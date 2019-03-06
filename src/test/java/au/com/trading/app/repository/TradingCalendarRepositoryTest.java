package au.com.trading.app.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import au.com.trading.app.configuration.TestConfig;
import au.com.trading.app.domain.TradingCalendar;

/**
 * This test TradingCalendarRepository
 * 
 * @throws JobsMatcherException
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestConfig.class)
public class TradingCalendarRepositoryTest {

	@Autowired
	TradingCalendarRepository tradingCalendarRepository;

	@Test
	public void validateRecordDateTest_success() {
		Date recordDate = new GregorianCalendar(2019, Calendar.FEBRUARY, 11).getTime();

		TradingCalendar tradingCalendar = new TradingCalendar();
		tradingCalendar.setDateValue(recordDate);
		tradingCalendar.setIsTradingDate("N");

		tradingCalendarRepository.delete(tradingCalendar);
		tradingCalendarRepository.save(tradingCalendar);
		Optional<TradingCalendar> response = tradingCalendarRepository.findById(recordDate);

		assertTrue(response.isPresent());
		assertEquals(recordDate, ((TradingCalendar) response.get()).getDateValue());
		assertEquals("N", ((TradingCalendar) response.get()).getIsTradingDate());
	}

}
