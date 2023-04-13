package StockTracker.entity;

import jakarta.persistence.*;


import java.sql.Date;

@Entity
@Table(name="currency")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer exchangeRateId;

    @Column(name="date")
    private Date dateOfRecorded;

    @Column(name="base_amount")
    private Double baseAmount;

    @Column(name="destination_amount")
    private Double destAmount;

    public ExchangeRate(){}


    public ExchangeRate(Date dateOfRecorded, Double baseAmount, Double destAmount) {
        this.dateOfRecorded = dateOfRecorded;
        this.baseAmount = baseAmount;
        this.destAmount = destAmount;
    }

    public Integer getExchangeRateId() {
        return exchangeRateId;
    }

    public void setExchangeRateId(Integer exchangeRateId) {
        this.exchangeRateId = exchangeRateId;
    }

    public Date getDateOfRecorded() {
        return dateOfRecorded;
    }

    public void setDateOfRecorded(Date dateOfRecorded) {
        this.dateOfRecorded = dateOfRecorded;
    }

    public Double getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(Double baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Double getDestAmount() {
        return destAmount;
    }

    public void setDestAmount(Double destAmount) {
        this.destAmount = destAmount;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "dateOfRecorded=" + dateOfRecorded +
                ", baseCurrency="  +
                ", baseAmount=" + baseAmount +
                ", destCurrency="  +
                ", destAmount=" + destAmount +
                '}';
    }
}
