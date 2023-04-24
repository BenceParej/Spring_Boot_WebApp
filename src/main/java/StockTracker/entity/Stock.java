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


    @OneToMany(fetch= FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="stock")
    private List<Transaction> transactions;


    public Stock(){};

    public Stock(String name, String isin) {
        this.name = name;
        this.isin = isin;
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
                '}';
    }

}
