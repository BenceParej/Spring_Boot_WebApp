package StockTracker.dao;

import StockTracker.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    //Currency findByCurrencyname(String currencyname);
}
