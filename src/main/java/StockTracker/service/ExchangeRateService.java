package StockTracker.service;

import StockTracker.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeRateService {

    public void save(ExchangeRate exchangeRate);


    List<ExchangeRate> findAll();
}
