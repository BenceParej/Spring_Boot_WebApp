package StockTracker.rest;

import StockTracker.entity.Currency;
import StockTracker.entity.Stock;
import StockTracker.entity.Views;
import StockTracker.service.CurrencyService;
import StockTracker.service.StockService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CurrenciesRestController {

    private CurrencyService currencyService;

    @Autowired
    public CurrenciesRestController(CurrencyService acurrencyService){this.currencyService=acurrencyService;}

    //expose /stocks to return a list of stocks
    @JsonView(Views.Public.class)
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/currencies")
    public List<Currency> getCurrencies(){
        return currencyService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/currencies")
    public Currency postCurrency(@RequestBody Currency currency){
        this.currencyService.save(currency);
        return currency;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/currencies/{id}")
    public void deleteCurrency(@PathVariable("id") Integer id){
        this.currencyService.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/currencies/{id}")
    public void updateCurrency(@RequestBody Currency currency){
        Currency tmpcurrency  = currencyService.findById(currency.getCurrencyID());
        tmpcurrency.setCurrencyName(currency.getCurrencyName());
        currencyService.save(tmpcurrency);
    }

}
