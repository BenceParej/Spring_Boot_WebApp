package StockTracker.service;

import StockTracker.dao.ExchangeRateRepository;
import StockTracker.entity.ExchangeRate;
import StockTracker.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{

    private ExchangeRateRepository exchangeRateRepository;

    public ExchangeRateServiceImpl(){}
    @Autowired
    public ExchangeRateServiceImpl(ExchangeRateRepository theExchangeRateRepository){
        exchangeRateRepository=theExchangeRateRepository;
    }


    @Override
    public void save(ExchangeRate exchangeRate) {
        exchangeRateRepository.save(exchangeRate);
    }

    @Override
    public List<ExchangeRate> findAll() {
        return exchangeRateRepository.findAll();
    }

    @Override
    public ExchangeRate findById(int id) {
        Optional<ExchangeRate> resultexchange =exchangeRateRepository.findById(id);

        ExchangeRate theexch=null;

        if(resultexchange.isPresent()){
            theexch = resultexchange.get();
        } else {
            //we didnt find employee
            throw new RuntimeException("Did not found employee id - " + id);
        }
        return theexch;
    }


}
