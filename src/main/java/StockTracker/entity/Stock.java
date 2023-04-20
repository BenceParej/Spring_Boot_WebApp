package StockTracker.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="stock")
public class Stock {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="isin")
    private String isin;

    @Column(name="quantity")
    private int stockQuantity;

    @OneToMany(fetch= FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="stock")
    private List<Transaction> transactions;


    public Stock(){};

    public Stock(String name, String isin, int quantity) {
        this.name = name;
        this.isin = isin;
        this.stockQuantity = quantity;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void addTransaction (Transaction tempTransaction){
        if (transactions==null){
            transactions = new ArrayList<>();
        }

        transactions.add(tempTransaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isin='" + isin + '\'' +
                ", stockQuantity=" + stockQuantity +
                '}';
    }

/*    @OneToMany(fetch=FetchType.LAZY,
            cascade={CascadeType.ALL})
    @JoinColumn(name="stock_id")
    private List<Transaction> transactions;

    public void add(Transaction tempTransaction){
        if (transactions==null){
            transactions=new ArrayList<>();
        }
        transactions.add(tempTransaction);
    }*/

}
