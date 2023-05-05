package StockTracker.controller;

import StockTracker.entity.ClosedTransaction;
import StockTracker.entity.ExchangeRate;
import StockTracker.entity.Stock;
import StockTracker.entity.Transaction;
import StockTracker.service.ClosedTransactionService;
import StockTracker.service.CurrencyService;
import StockTracker.service.StockService;
import StockTracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/closedtransactions")
public class ClosedTransactionController {

    private StockService stockService;
    private CurrencyService currencyService;
    private TransactionService transactionService;

    private ClosedTransactionService closedTransactionService;

    @Autowired
    public ClosedTransactionController(StockService theStockService, CurrencyService theCurrencyService,
                                 TransactionService theTransactionService, ClosedTransactionService tempClosedTrans){
        stockService=theStockService;
        currencyService=theCurrencyService;
        transactionService=theTransactionService;
        closedTransactionService=tempClosedTrans;
    }

    @PostMapping("/save")
    public String listClosedTransactions(@RequestParam("transactionid") String transactionId,
                                         @ModelAttribute("exchangerate")ExchangeRate closeExchange,
                                         @ModelAttribute("closedtransaction")ClosedTransaction closedTransaction)
    {

        Transaction transaction = transactionService.findById(transactionId);
        closedTransaction.setOpenExchangeRate(transaction.getExchangeRate());

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        closeExchange.setDateOfRecorded(date);
        closeExchange.setBaseCurrency(transaction.getExchangeRate().getBaseCurrency());
        closeExchange.setDestinationCurrency(transaction.getExchangeRate().getDestinationCurrency());
        closeExchange.setBaseAmount();
        closeExchange.setDestAmount();

        closedTransaction.setCloseExchangeRate(closeExchange);
        closedTransaction.calculateTaxFee();

        closedTransactionService.save(closedTransaction);

        //add them to the spring model

        return "redirect:/stocks/list";
    }

}
