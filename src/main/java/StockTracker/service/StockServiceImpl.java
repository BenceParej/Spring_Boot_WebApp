package StockTracker.service;

import StockTracker.dao.StockRepository;
import StockTracker.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService{

    private StockRepository stockRepository;

    public StockServiceImpl(StockRepository theStockRepository){
        stockRepository=theStockRepository;
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Stock findById(int theId) {
        Optional<Stock> resultStock =stockRepository.findById(theId);

        Stock theStock=null;

        if(resultStock.isPresent()){
            theStock = resultStock.get();
        } else {
            //we didnt find employee
            throw new RuntimeException("Did not found employee id - " + theId);
        }
        return theStock;
    }

    @Override
    public Stock save(Stock theStock) {
        return stockRepository.save(theStock);
    }

    @Override
    public void deleteById(int theId) {
        stockRepository.deleteById(theId);
    }
}
