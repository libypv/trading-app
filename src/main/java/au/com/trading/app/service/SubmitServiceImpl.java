package au.com.trading.app.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.trading.app.constant.Constants;
import au.com.trading.app.domain.TradingCalendar;
import au.com.trading.app.repository.TradingCalendarRepository;

@Service
public class SubmitServiceImpl implements SubmitService {

	@Autowired
	TradingCalendarRepository tradingCalendarRepository;

	/* (non-Javadoc)
	 * @see au.com.trading.app.service.SubmitService#submitTradingCalendar(java.time.LocalDate, java.time.LocalDate)
	 */
	public String submitTradingCalendar(LocalDate recordDate, LocalDate paymentDate) {
		try {
			Date date = Date.from(recordDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			TradingCalendar tradingCalendar = new TradingCalendar();
			tradingCalendar.setDateValue(date);
			tradingCalendar.setIsTradingDate("Y");
			tradingCalendarRepository.save(tradingCalendar);
		} catch (Exception ex) {
			return null;
		}
		return Constants.SUCCESS;
	}

}
