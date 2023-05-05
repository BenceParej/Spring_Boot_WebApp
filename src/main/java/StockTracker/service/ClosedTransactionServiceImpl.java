package StockTracker.service;

import StockTracker.dao.ClosedTransactionRepository;
import StockTracker.dao.ExchangeRateRepository;
import StockTracker.entity.ClosedTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClosedTransactionServiceImpl implements  ClosedTransactionService{

    private ClosedTransactionRepository closedTransactionRepository;

    public ClosedTransactionServiceImpl(){}

    @Autowired
    public ClosedTransactionServiceImpl(ClosedTransactionRepository tempclosedTransactionRepository){
        this.closedTransactionRepository=tempclosedTransactionRepository;
    }

    @Override
    public void save(ClosedTransaction closedTransaction) {
        closedTransactionRepository.save(closedTransaction);
    }
}
