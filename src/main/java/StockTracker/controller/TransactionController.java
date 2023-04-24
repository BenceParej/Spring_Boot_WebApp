package StockTracker.controller;

import StockTracker.entity.Currency;
import StockTracker.entity.ExchangeRate;
import StockTracker.entity.Stock;
import StockTracker.entity.Transaction;
import StockTracker.service.CurrencyService;
import StockTracker.service.ExchangeRateService;
import StockTracker.service.StockService;
import StockTracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private StockService stockService;
    private CurrencyService currencyService;
    private TransactionService transactionService;

    @Autowired
    public TransactionController(StockService theStockService, CurrencyService theCurrencyService,
    TransactionService theTransactionService){
        stockService=theStockService;
        currencyService=theCurrencyService;
        transactionService=theTransactionService;
    }


    @GetMapping("/listTransactions")
    public String listTransactions(@RequestParam("stockId") int theId, Model theModel){

        //find the stock with ID
        Stock tempStock = stockService.findById(theId);

        //get the list of transactions
        List<Transaction> theTransactions= tempStock.getTransactions();

        //add them to the spring model
        theModel.addAttribute("transactions",theTransactions);
        theModel.addAttribute("stock",tempStock);
        return "transactions/list-transactions";
    }


    //TODO here need modifications to save the transactions with new properties
    @PostMapping("/saveTransaction")
    public String saveTransaction(@ModelAttribute("transaction") Transaction theTransaction,
                                  @ModelAttribute("exchangeRate") ExchangeRate theExchangeRate,
                                  @RequestParam("id") int theId,
                                  @RequestParam("baseCurrencyID") int baseID,
                                  @RequestParam("destCurrencyID") int destID,
                                  Model theModel){

        Stock tempStock = stockService.findById(theId);
        //add transaction to the stock
        tempStock.addTransaction(theTransaction);
        theTransaction.setStockName(tempStock);

        //populate Exchangerate object with MNB data
        theExchangeRate.setBaseCurrency(currencyService.findById(baseID));
        theExchangeRate.setDestinationCurrency(currencyService.findById(destID));
        theExchangeRate.setBaseAmount();
        theExchangeRate.setDestAmount();

        //set exchangerate to the transaction
        theTransaction.setExchangeRate(theExchangeRate);

        theTransaction.setStock(tempStock);
        stockService.save(tempStock);

        //add attributes to the model
        theModel.addAttribute("transactions", tempStock.getTransactions());

        //use a redirect to prevent duplicate submissions
        String returnPath ="redirect:/transactions/listTransactions?stockId=" + tempStock.getId();
        return (returnPath);
    }

    @GetMapping("/addTransaction")
    public String addTransaction(@RequestParam("stockId") int theId, Model theModel){

        Stock tempStock = stockService.findById(theId);
        Transaction tempTransaction = new Transaction();
        ExchangeRate tempExchangeRate = new ExchangeRate();
        List<Currency> currencies = currencyService.findAll();

        theModel.addAttribute("stock",tempStock);
        theModel.addAttribute("transaction",tempTransaction);
        theModel.addAttribute("exchangeRate",tempExchangeRate);
        theModel.addAttribute("currencies",currencies);

        return "transactions/transaction-form";
    }

}
