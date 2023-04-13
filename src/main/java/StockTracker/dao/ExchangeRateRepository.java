package StockTracker.dao;

import StockTracker.entity.Currency;
import StockTracker.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {
}
