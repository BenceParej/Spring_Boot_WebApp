package StockTracker.service;

import StockTracker.entity.Stock;

import java.util.List;


public interface StockService {

    List<Stock> findAll();

    Stock findById(int theId);

    Stock save(Stock theStock);

    void deleteById(int theId);

    Double countQuantityForStockId(int theId);
}
