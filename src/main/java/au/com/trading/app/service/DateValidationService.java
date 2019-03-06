package au.com.trading.app.service;

import java.time.LocalDate;

public interface DateValidationService {
	/**
	 * This service validates the record date. It validates if the record date
	 * the user entered is a business day, i.e. Mon-Fri. It also validates
	 * against the “Trading_Calendar”. If it is not a business day or a trading
	 * day, it returns the following error “Record date must be a Business
	 * Date”. Also, it validates the record date against payment date.
	 * 
	 * If validation rules are met, it returns "Success"
	 * 
	 * @see validatePaymentDate method in this interface
	 * 
	 * @param recordDate
	 * @param paymentDate
	 * @return
	 */
	public String validateRecordDate(LocalDate recordDate, LocalDate paymentDate);

	/**
	 * This service validates the payment date. It validates if the paymentDate
	 * is at least one day after the recordDate. If not, it must return the
	 * following error “Payment date must be at least one day after the Record
	 * Date”.
	 * 
	 * @param recordDate
	 * @param paymentDate
	 * @return
	 */
	public String validatePaymentDate(LocalDate recordDate, LocalDate paymentDate);
}
