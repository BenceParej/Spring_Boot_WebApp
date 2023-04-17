package StockTracker.entity;

import jakarta.persistence.*;


import java.sql.Date;

@Entity
@Table(name="exchangerate")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer exchangeRateId;

    @Column(name="date")
    private Date dateOfRecorded;

    @Column(name="base_amount")
    private Double baseAmount;

    @Column(name="quantity")
    private Integer quantityExchange;

    @Column(name="destination_amount")
    private Double destAmount;

    @ManyToOne
    @JoinColumn(name="base_currency_id")
    private Currency baseCurrency;

    @ManyToOne
    @JoinColumn(name="destination_currency_id")
    private Currency destinationCurrency;


    public ExchangeRate(){}


    public ExchangeRate(Date dateOfRecorded, Double baseAmount, Integer quantity) {
        this.dateOfRecorded = dateOfRecorded;
        this.baseAmount = baseAmount;
        this.quantityExchange=quantity;
    }

    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    public Currency getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(Currency destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
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

    public Integer getQuantityExchange() {
        return quantityExchange;
    }

    public void setQuantityExchange(Integer quantityExchange) {
        this.quantityExchange = quantityExchange;
    }

    public Double getDestAmount() {
        return destAmount;
    }

    public void setDestAmount(Double destAmount) {
        this.destAmount = destAmount;
    }

    public void calculateDestinationAmount(Integer quantity){
        // this function calculates the destination amount with the given currencies
        //TODO: here needed an api call to get the actual currencies exchange rates
        destAmount=quantity*(baseAmount*(360/1));
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "exchangeRateId=" + exchangeRateId +
                ", dateOfRecorded=" + dateOfRecorded +
                ", baseAmount=" + baseAmount +
                ", quantityExchange=" + quantityExchange +
                ", destAmount=" + destAmount +
                '}';
    }
}
