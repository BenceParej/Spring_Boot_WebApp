package StockTracker.service;

import StockTracker.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {

    List<Stock> findAll();

    Stock findById(int theId);

    Stock save(Stock theCurrency);

    void deleteById(int theId);

}
