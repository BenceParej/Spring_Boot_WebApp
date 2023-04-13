package StockTracker.service;

import StockTracker.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateService {

    public void save(ExchangeRate exchangeRate);


}
