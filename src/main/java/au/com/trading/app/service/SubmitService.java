package au.com.trading.app.service;

import java.time.LocalDate;

public interface SubmitService {
	/**
	 * This service submits the trading calendar form. It insert the record
	 * date as “TradingDate = Y” into the “Trading_Calendar” table.
	 * 
	 * @param recordDate
	 * @param paymentDate
	 * @return
	 */
	public String submitTradingCalendar(LocalDate recordDate, LocalDate paymentDate);
}
