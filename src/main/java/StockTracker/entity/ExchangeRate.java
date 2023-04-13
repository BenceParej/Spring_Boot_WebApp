package StockTracker.entity;

import jakarta.persistence.*;


import java.sql.Date;

@Entity
@Table(name="currency")
public class ExchangeRate {

    @Id
    @Column(name="date")
    private Date dateOfRecorded;


    private Currency baseCurrency;

    @Column(name="base_amount")
    private Double baseAmount;


    private Currency destCurrency;
    @Column(name="destination_amount")
    private Double destAmount;

    public ExchangeRate(){}

    public ExchangeRate(Date dateOfRecorded, Currency baseCurrency, Double baseAmount, Currency destCurrency, Double destAmount) {
        this.dateOfRecorded = dateOfRecorded;
        this.baseCurrency = baseCurrency;
        this.baseAmount = baseAmount;
        this.destCurrency = destCurrency;
        this.destAmount = destAmount;
    }

    public Date getDateOfRecorded() {
        return dateOfRecorded;
    }

    public void setDateOfRecorded(Date dateOfRecorded) {
        this.dateOfRecorded = dateOfRecorded;
    }

    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Double getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(Double baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Currency getDestCurrency() {
        return destCurrency;
    }

    public void setDestCurrency(Currency destCurrency) {
        this.destCurrency = destCurrency;
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
                ", baseCurrency=" + baseCurrency +
                ", baseAmount=" + baseAmount +
                ", destCurrency=" + destCurrency +
                ", destAmount=" + destAmount +
                '}';
    }
}
