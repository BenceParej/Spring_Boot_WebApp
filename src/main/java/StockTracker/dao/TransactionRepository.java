package StockTracker.dao;

import StockTracker.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    //@Query("SELECT t FROM transaction t WHERE t.stock_id=:id")
    //List<Transaction> findAllTransactionsByStockId(@Param("id") int theId);

    List<Transaction> findAllByStock_Id(int id);

}
