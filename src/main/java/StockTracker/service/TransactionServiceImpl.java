package StockTracker.service;

import StockTracker.dao.TransactionRepository;
import StockTracker.entity.Stock;
import StockTracker.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Transaction findById(String id) {
        Optional<Transaction> resultTransaction =transRepo.findById(id);

        Transaction transaction=null;

        if(resultTransaction.isPresent()){
            transaction = resultTransaction.get();
        } else {
            //we didnt find employee
            throw new RuntimeException("Did not found employee id - " + id);
        }
        return transaction;
    }
}
