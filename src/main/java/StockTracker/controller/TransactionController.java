package StockTracker.controller;

import StockTracker.entity.Currency;
import StockTracker.entity.Stock;
import StockTracker.entity.Transaction;
import StockTracker.service.CurrencyService;
import StockTracker.service.ExchangeRateService;
import StockTracker.service.StockService;
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

    @Autowired
    public TransactionController(StockService theStockService, CurrencyService theCurrencyService){
        stockService=theStockService;
        currencyService=theCurrencyService;
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
                                  @RequestParam("id") int theId){

        Stock tempStock = stockService.findById(theId);
        //save the transaction
        tempStock.addTransaction(theTransaction);

        stockService.save(tempStock);
        //use a redirect to prevent duplicate submissions
        String returnPath ="redirect:/stocks/listTransactions?stockId=" + tempStock.getId();
        return (returnPath);
    }

    @GetMapping("/addTransaction")
    public String addTransaction(@RequestParam("stockId") int theId, Model theModel){

        Stock tempStock = stockService.findById(theId);
        Transaction tempTransaction = new Transaction();
        List<Currency> currencies = currencyService.findAll();

        //TODO here needed to find by name and not by id
        Currency HUF = currencyService.findById(1);

        theModel.addAttribute("stock",tempStock);
        theModel.addAttribute("transaction",tempTransaction);
        theModel.addAttribute("currencies",currencies);
        theModel.addAttribute("HUF",HUF);

        return "transactions/transaction-form";
    }

}
