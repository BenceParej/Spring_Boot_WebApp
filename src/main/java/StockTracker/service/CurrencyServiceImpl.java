package StockTracker.service;


import StockTracker.dao.CurrencyRepository;
import StockTracker.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl (CurrencyRepository theCurrencyRepository){
        currencyRepository=theCurrencyRepository;
    }

    @Override
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency findById(int theId) {

        Optional<Currency> resultCurrency =currencyRepository.findById(theId);

        Currency theCurrency=null;

        if(resultCurrency.isPresent()){
            theCurrency = resultCurrency.get();
        } else {
            //we didnt find employee
            throw new RuntimeException("Did not found employee id - " + theId);
        }
        return theCurrency;
    }

    @Override
    public Currency save(Currency theCurrency) {
        return currencyRepository.save(theCurrency);
    }

    @Override
    public void deleteById(int theId) {
        currencyRepository.deleteById(theId);

    }

/*    @Override
    public Currency findByName(String name) {
        Currency tempCurrency=currencyRepository.findByCurrencyname(name);
        return tempCurrency;
    }*/
}
