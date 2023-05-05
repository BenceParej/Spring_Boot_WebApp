package StockTracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "closed_transaction")
public class ClosedTransaction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "open_exchange_id")
    private ExchangeRate openExchangeRate;

    @OneToOne
    @JoinColumn(name = "close_exchange_id")
    private ExchangeRate closeExchangeRate;

    @Column(name = "closing_fee")
    private Double closeFee;


    @Column(name = "tax_fee")
    private Double taxFee;

    public ClosedTransaction(){}

    public ClosedTransaction(ExchangeRate openExchange,Double closeFee) {
        this.closeFee = closeFee;
        this.openExchangeRate=openExchange;
        this.closeExchangeRate=new ExchangeRate();
    }

    public ExchangeRate getOpenExchangeRate() {
        return openExchangeRate;
    }

    public void setOpenExchangeRate(ExchangeRate openExchangeRate) {
        this.openExchangeRate = openExchangeRate;
    }

    public ExchangeRate getCloseExchangeRate() {
        return closeExchangeRate;
    }

    public void setCloseExchangeRate(ExchangeRate closeExchangeRate) {
        this.closeExchangeRate = closeExchangeRate;
    }

    public Double getCloseFee() {
        return closeFee;
    }

    public void setCloseFee(Double closeFee) {
        this.closeFee = closeFee;
    }

    public Double getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(Double taxFee) {
        this.taxFee = taxFee;
    }

    public Double calculateTaxFee(){
        //get openfee
        Double openFee=this.openExchangeRate.getTransaction().getFee() * this.openExchangeRate.getRate();

        Double closeFee = this.closeFee * this.closeExchangeRate.getRate();

        Double stockRevenue =this.openExchangeRate.getDestAmount() - this.closeExchangeRate.getDestAmount();

        return (stockRevenue-openFee-closeFee)*0.15;
    }


}
