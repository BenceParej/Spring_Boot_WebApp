package StockTracker.controller;

import StockTracker.entity.Currency;
import StockTracker.entity.Stock;
import StockTracker.entity.Transaction;
import StockTracker.service.CurrencyService;
import StockTracker.service.StockService;
import org.glassfish.jaxb.core.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/stocks")
public class StockController {

    private StockService stockService;
    private CurrencyService currencyService;
    @Autowired
    public StockController(StockService theStockService, CurrencyService theCurrencyService){
        this.stockService=theStockService;
        this.currencyService=theCurrencyService;
    }

    //Listing mappings
    @GetMapping("/list")
    public String getList(Model theModel){

        //get stocks from the db
        List<Stock> stocks = stockService.findAll();
        List<Double> stocknums = new ArrayList<>();
        for (Stock stock : stocks) {
            stocknums.add(stockService.countQuantityForStockId(stock.getId()));
        }
        //add them to the spring model
        theModel.addAttribute("stocks",stocks);
        theModel.addAttribute("stocknums",stocknums);
        return "stocks/list-stocks";
    }


    //Add new attribute mappings
    @GetMapping("/addNewStockForm")
    public String addNewStock (Model theModel){
        Stock theStock = new Stock();
        theModel.addAttribute("stock", theStock);

        return "stocks/stock-form";
    }

    //Save attribute mappings
    @PostMapping("/save")
    public String saveStock(@ModelAttribute("stock") Stock theStock){
        //save the employee
        stockService.save(theStock);
        //use a redirect to prevent duplicate submissions
        return "redirect:/stocks/list";
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
