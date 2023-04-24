package StockTracker;

import StockTracker.entity.*;
import StockTracker.service.ExchangeRateServiceImpl;
import StockTracker.service.StockService;
import StockTracker.service.StockServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Console;
import java.sql.Date;
import java.util.List;


public class ExchangeRateTest {

    @Test
    public void SaveStock(){
        Stock teststock= new Stock("test", "testISIN");

        Currency eur = new Currency("EUR");
        Currency huf = new Currency("HUF");

        String str="2023-04-15";
        Date date=Date.valueOf(str);

        Transaction transaction = new Transaction("ID234", "IBKR", 2.);

        teststock.addTransaction(transaction);

        ExchangeRate exchangeRate = new ExchangeRate(date,3., 100., eur);
        exchangeRate.setDestinationCurrency(huf);
        exchangeRate.setDestAmount();

        transaction.setExchangeRate(exchangeRate);


        StockService stockService= new StockServiceImpl();

        stockService.save(teststock);


    }

    @Test
    public void CloseStock(){
        Currency usd = new Currency("USD");
        Currency huf = new Currency("HUF");

        String close="2023-04-23";
        Date date=Date.valueOf(close);

        ExchangeRate openRate = new ExchangeRateServiceImpl().findById(36);
        ClosedTransaction closedTransaction = new ClosedTransaction(openRate,3.);

        ExchangeRate closeRate = new ExchangeRate(date, 1., 300., usd);
        closeRate.setDestinationCurrency(huf);
        closeRate.setDestAmount();

        closedTransaction.setOpenExchangeRate(openRate);
        closedTransaction.setCloseExchangeRate(closeRate);

        closedTransaction.calculateTaxFee(openRate,closeRate);


        //Transaction transaction = new Transaction("ID2123", "Tesla", "IBKR", miafasz);


    }








}
