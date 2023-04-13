package StockTracker.rest;


import StockTracker.entity.Stock;
import StockTracker.service.StockService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StockRestController {

    private StockService stockService;

    @Autowired
    public StockRestController(StockService theStockService){this.stockService=theStockService;}

    //expose /stocks to return a list of stocks
    @GetMapping("/stocks")
    public List<Stock> getStocks(){
        return stockService.findAll();
    }

    //expose /stocks/{id} for getting a stock byId
    @GetMapping("/stocks/{id}")
    public Stock getStock(@PathVariable int id){
        return stockService.findById(id);
    }

    @PostMapping("/stocks")
    public Stock addStock(@RequestBody Stock theStock){
        theStock.setId(0);
        Stock dbStock = stockService.save(theStock);
        return dbStock;
    }


    //add mapping for PUT to update existing stock
    @PutMapping("/stocks")
    public Stock updateStock(@RequestBody Stock theStock){
        Stock dbStock = stockService.save(theStock);
        return dbStock;
    }


    @DeleteMapping("stocks/{id}")
    public String deleteStock(@PathVariable int theId){
        Stock actualStock = stockService.findById(theId);

        stockService.deleteById(theId);

        return "Deleted Stock : "  + theId;
    }


}
