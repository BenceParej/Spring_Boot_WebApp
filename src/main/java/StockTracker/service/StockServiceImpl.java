package StockTracker.service;

import StockTracker.dao.StockRepository;
import StockTracker.dao.TransactionRepository;
import StockTracker.entity.Stock;
import StockTracker.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService{

    private StockRepository stockRepository;
    private TransactionRepository transactionRepository;
    @Autowired
    public StockServiceImpl(StockRepository theStockRepository, TransactionRepository theTransactionRepository){
        stockRepository=theStockRepository;
        transactionRepository=theTransactionRepository;
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

    @Override
    public Double countQuantityForStockId(int theId) {
        List<Transaction> transactions = transactionRepository.findAllByStock_Id(theId);
        Double num=0.;
        for(Transaction t : transactions){
            num += t.getExchangeRate().getQuantityExchange();
        }
        return num;
    }





}
