package StockTracker.service;

import StockTracker.entity.Currency;
import java.util.List;

public interface CurrencyService {

    List<Currency> findAll();

    Currency findById(int theId);

    Currency save(Currency theCurrency);

    void deleteById(int theId);

    //Currency findByName(String name);

}
