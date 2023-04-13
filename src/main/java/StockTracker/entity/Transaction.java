package StockTracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @Column(name="transaction_id")
    private String transactionId;

    @Column(name="stock_name")
    private String stockName;

    @Column(name="quantity")
    private Integer transactionQuantity;

    @Column(name="broker")
    private String broker;

    @Column(name="date")
    private Date dateOfBuy;

    @Column(name="base_currency_id")
    private Integer baseCurrencyId;

    @Column(name="funded_base")
    private Double fundedBase;

    @Column(name="destination_currency_id")
    private Integer destinationCurrencyId;

    @Column(name="funded_destination")
    private Double fundedDestination;

    public Transaction(){};

    public Transaction(String transactionId, String stockName, Integer quantity, String broker,
                       Date dateOfBuy, Integer baseCurrencyId, Double fundedBase, Integer destinationCurrencyId,
                       Double fundedDestination) {
        this.transactionId = transactionId;
        this.stockName = stockName;
        this.transactionQuantity = quantity;
        this.broker = broker;
        this.dateOfBuy = dateOfBuy;
        this.baseCurrencyId = baseCurrencyId;
        this.fundedBase = fundedBase;
        this.destinationCurrencyId = destinationCurrencyId;
        this.fundedDestination = fundedDestination;
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

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Integer getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(Integer transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public Date getDateOfBuy() {
        return dateOfBuy;
    }

    public void setDateOfBuy(Date dateOfBuy) {
        this.dateOfBuy = dateOfBuy;
    }

    public Integer getBaseCurrencyId() {
        return baseCurrencyId;
    }

    public void setBaseCurrencyId(Integer baseCurrencyId) {
        this.baseCurrencyId = baseCurrencyId;
    }

    public Double getFundedBase() {
        return fundedBase;
    }

    public void setFundedBase(Double fundedBase) {
        this.fundedBase = fundedBase;
    }

    public Integer getDestinationCurrencyId() {
        return destinationCurrencyId;
    }

    public void setDestinationCurrencyId(Integer destinationCurrencyId) {
        this.destinationCurrencyId = destinationCurrencyId;
    }

    public Double getFundedDestination() {
        return fundedDestination;
    }

    public void setFundedDestination(Double fundedDestination) {
        this.fundedDestination = fundedDestination;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", stockName='" + stockName + '\'' +
                ", transactionQuantity=" + transactionQuantity +
                ", broker='" + broker + '\'' +
                ", dateOfBuy=" + dateOfBuy +
                ", baseCurrencyId=" + baseCurrencyId +
                ", fundedBase=" + fundedBase +
                ", destinationCurrencyId=" + destinationCurrencyId +
                ", fundedDestination=" + fundedDestination +
                '}';
    }
}
