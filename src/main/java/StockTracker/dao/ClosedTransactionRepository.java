package StockTracker.dao;

import StockTracker.entity.ClosedTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClosedTransactionRepository extends JpaRepository<ClosedTransaction, Integer> {

}
