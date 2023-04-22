package StockTracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "closed_transaction")
public class ClosedTransaction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "transaction")
    private Transaction transaction;

    @Column(name = "position_open_amount")
    private Double positionOpenAmount;
    @Column(name = "open_fee")
    private Double openFee;
    @Column(name = "closing_price")
    private Double closeStockPrice;
    @Column(name = "close_quantity")
    private Double closeQuantity;
    @Column(name = "position_closed_amount")
    private Double positionClosedAmount;
    @Column(name = "closing_fee")
    private Double closeFee;

    @Column(name = "tax_fee")
    private Double taxFee;

    public ClosedTransaction(){}

    public ClosedTransaction(Double positionOpenAmount, Double openFee, Double closeStockPrice, Double closeQuantity, Double positionClosedAmount, Double closeFee) {
        this.positionOpenAmount = positionOpenAmount;
        this.openFee = openFee;
        this.closeStockPrice = closeStockPrice;
        this.closeQuantity = closeQuantity;
        this.positionClosedAmount = positionClosedAmount;
        this.closeFee = closeFee;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Double getPositionOpenAmount() {
        return positionOpenAmount;
    }

    public void setPositionOpenAmount(Double positionOpenAmount) {
        this.positionOpenAmount = positionOpenAmount;
    }

    public Double getOpenFee() {
        return openFee;
    }

    public void setOpenFee(Double openFee) {
        this.openFee = openFee;
    }

    public Double getCloseStockPrice() {
        return closeStockPrice;
    }

    public void setCloseStockPrice(Double closeStockPrice) {
        this.closeStockPrice = closeStockPrice;
    }

    public Double getCloseQuantity() {
        return closeQuantity;
    }

    public void setCloseQuantity(Double closeQuantity) {
        this.closeQuantity = closeQuantity;
    }

    public Double getPositionClosedAmount() {
        return positionClosedAmount;
    }

    public void setPositionClosedAmount(Double positionClosedAmount) {
        this.positionClosedAmount = positionClosedAmount;
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
}
