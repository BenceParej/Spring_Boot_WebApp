package StockTracker.controller;


import StockTracker.entity.Stock;
import StockTracker.entity.Transaction;
import StockTracker.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stocks")
public class StockController {

    private StockService stockService;

    @Autowired
    public StockController(StockService theStockService){this.stockService=theStockService;}

    //Listing mappings
    @GetMapping("/list")
    public String getList(Model theModel){

        //get stocks from the db
        List<Stock> stocks = stockService.findAll();
        //add them to the spring model
        theModel.addAttribute("stocks",stocks);

        return "stocks/list-stocks";
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
        return "stocks/list-transactions";
    }


    //Add new attribute mappings
    @GetMapping("/addNewStockForm")
    public String addNewStock (Model theModel){
        Stock theStock = new Stock();
        theModel.addAttribute("stock", theStock);

        return "stocks/stock-form";
    }

    @GetMapping("/addTransaction")
    public String addTransaction(@RequestParam("stockId") int theId, Model theModel){

        Stock tempStock = stockService.findById(theId);
        Transaction tempTransaction = new Transaction();

        //itt létre kell majd hozni a exchange rate objektumot

        //add them to the spring model
        theModel.addAttribute("stock",tempStock);
        theModel.addAttribute("transaction",tempTransaction);

        return "stocks/transaction-form";
    }

    //Save attribute mappings
    @PostMapping("/save")
    public String saveStock(@ModelAttribute("stock") Stock theStock){
        //save the employee
        stockService.save(theStock);
        //use a redirect to prevent duplicate submissions
        return "redirect:/stocks/list";
    }

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

    //Update attribute mappings
    @GetMapping("/updateStockForm")
    public String showFormForUpdate(@RequestParam("stockId") int theId, Model theModel) {

        //get employee from the DB with id
        Stock theStock = stockService.findById(theId);

        //set employee in the model to prepropulate the form
        theModel.addAttribute("stock", theStock);

        //send over to our form
        return "stocks/stock-form";
    }


    //Delete attribute mappings
    @GetMapping("/delete")
    public String deleteStock(@RequestParam("stockId") int theId){
        stockService.deleteById(theId);

        return "redirect:/stocks/list";
    }





}
