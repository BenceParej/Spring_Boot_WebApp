package StockTracker.service;

import StockTracker.dao.ExchangeRateRepository;
import StockTracker.entity.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{

    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public ExchangeRateServiceImpl(ExchangeRateRepository theExchangeRateRepository){
        exchangeRateRepository=theExchangeRateRepository;
    }

    @Override
    public void save(ExchangeRate exchangeRate) {
        exchangeRateRepository.save(exchangeRate);
    }
}
