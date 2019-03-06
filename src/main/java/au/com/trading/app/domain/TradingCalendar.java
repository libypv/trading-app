package au.com.trading.app.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import au.com.trading.app.constant.Constants;

/**
 * This is the hibernate entity to represent TRADING_CALENDAR table
 *
 */
@Entity
@Table(name = "TRADING_CALENDAR")
public class TradingCalendar implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_VALUE", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.INPUT_DATE_PATTERN)
	@Id
	private Date dateValue;

	@Column(name = "IS_TRADING_DATE", nullable = false)
	private String isTradingDate;

	public Date getDateValue() {
		return dateValue;
	}

	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	public String getIsTradingDate() {
		return isTradingDate;
	}

	public void setIsTradingDate(String isTradingDate) {
		this.isTradingDate = isTradingDate;
	}
}
