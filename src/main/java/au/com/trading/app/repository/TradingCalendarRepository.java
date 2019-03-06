package au.com.trading.app.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.com.trading.app.domain.TradingCalendar;

/**
 * This is the JPA repository for TRADING_CALENDAR table 
 *
 */
@Repository
public interface TradingCalendarRepository extends JpaRepository<TradingCalendar, Date>{

	
}
