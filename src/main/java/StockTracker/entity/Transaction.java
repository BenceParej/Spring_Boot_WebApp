package StockTracker.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @Column(name="transaction_id")
    private String transactionId;

    @Column(name="stock_name")
    private String stockName;

    @Column(name="broker")
    private String broker;

    @Column(name="fee")
    private Double fee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="exchange_id")
    private ExchangeRate exchangeRate;

    @ManyToOne ( cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="stock_id")
    private Stock stock;


    @OneToOne(mappedBy = "transaction")
    private ClosedTransaction closedTransaction;


    public Transaction(){};


    public Transaction(String transactionId, String broker, Double fee) {
        this.transactionId = transactionId;
        this.broker = broker;
        this.fee = fee;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public ClosedTransaction getClosedTransaction() {
        return closedTransaction;
    }

    public void setClosedTransaction(ClosedTransaction closedTransaction) {
        this.closedTransaction = closedTransaction;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(Stock stock) {
        this.stockName = stock.getName();
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }



    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", stockName='" + stockName + '\'' +
                ", broker='" + broker + '\'' +
                ", exchangeRate=" + exchangeRate +
                ", stock=" + stock +
                '}';
    }
}
