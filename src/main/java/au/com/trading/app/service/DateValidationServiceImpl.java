package au.com.trading.app.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.trading.app.constant.Constants;
import au.com.trading.app.domain.TradingCalendar;
import au.com.trading.app.repository.TradingCalendarRepository;

@Service
public class DateValidationServiceImpl implements DateValidationService {

	@Autowired
	TradingCalendarRepository tradingCalendarRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * au.com.trading.app.service.DateValidationService#validateRecordDate(java.
	 * time.LocalDate, java.time.LocalDate)
	 */
	public String validateRecordDate(LocalDate recordDate, LocalDate paymentDate) {
		String status = null;

		if (recordDate == null) {
			return Constants.NOT_A_BUSINESS_DATE;
		}

		status = validateIfRecordDateIsBusinessDate(recordDate);

		if (Constants.SUCCESS.equals(status) && paymentDate != null) {
			status = doDateCrossValidation(recordDate, paymentDate);
		}
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * au.com.trading.app.service.DateValidationService#validatePaymentDate(java
	 * .time.LocalDate, java.time.LocalDate)
	 */
	public String validatePaymentDate(LocalDate recordDate, LocalDate paymentDate) {

		return doDateCrossValidation(recordDate, paymentDate);
	}

	private String doDateCrossValidation(LocalDate recordDate, LocalDate paymentDate) {

		if (paymentDate == null) {
			return Constants.DATES_CROSS_VALIDATION_FAILED;
		}

		if (Period.between(recordDate, paymentDate).getDays() >= 1) {
			return Constants.SUCCESS;
		}
		return Constants.DATES_CROSS_VALIDATION_FAILED;
	}

	private String validateIfRecordDateIsBusinessDate(LocalDate recordDate) {
		String status = null;
		try {
			if (!(recordDate.getDayOfWeek().equals(DayOfWeek.SATURDAY))
					&& !(recordDate.getDayOfWeek().equals(DayOfWeek.SUNDAY))) {
				status = Constants.SUCCESS; // Assumption: Success, if record
											// date
											// is
											// either a business day or a
											// trading
											// day.
			} else { // Check trading_calendar table
				Date date = Date.from(recordDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				Optional<TradingCalendar> tradingCalendarData = tradingCalendarRepository.findById(date);
				if (tradingCalendarData.isPresent()
						&& "Y".equals(((TradingCalendar) tradingCalendarData.get()).getIsTradingDate())) {
					status = Constants.SUCCESS;
				}
			}

			if (!Constants.SUCCESS.equals(status)) {
				status = Constants.NOT_A_BUSINESS_DATE;
			}
		} catch (Exception ex) {
			status = Constants.NOT_A_BUSINESS_DATE;
		}
		return status;
	}
}
