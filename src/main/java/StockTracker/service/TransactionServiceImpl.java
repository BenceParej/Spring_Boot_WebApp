package StockTracker.service;

import StockTracker.dao.TransactionRepository;
import StockTracker.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl  implements TransactionService{

    private TransactionRepository transRepo;

    @Autowired
    public TransactionServiceImpl(TransactionRepository theTransRepo){
        this.transRepo=theTransRepo;
    }

    @Override
    public void save(Transaction tempTransaction) {
        transRepo.save(tempTransaction);
    }
}
