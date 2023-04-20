package StockTracker.controller;


import StockTracker.dao.ExchangeRateRepository;
import StockTracker.entity.Currency;
import StockTracker.entity.ExchangeRate;
import StockTracker.service.CurrencyService;
import StockTracker.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.CallableStatement;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/currencies")
public class CurrencyController {

    private CurrencyService currencyService;
    private ExchangeRateService exchangeRateService;

    @Autowired
    public CurrencyController(CurrencyService theCurrencyService, ExchangeRateService theExchangeRateService){
        currencyService=theCurrencyService;
        exchangeRateService=theExchangeRateService;
    }

    //list available currencies
    @GetMapping("/list")
    public String listCurrencies(Model theModel){
        List<Currency> currencies = currencyService.findAll();
        Currency emptyCurrency = new Currency();

        theModel.addAttribute("currencies",currencies);
        theModel.addAttribute("currency",emptyCurrency);
        return ("currencies/list-currencies");
    }

    //add currency
    @PostMapping("/save")
    public String addCurrency(@ModelAttribute("currency") Currency theCurrency){

        currencyService.save(theCurrency);

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        ExchangeRate exchangeRate=new ExchangeRate(date, 122.1,2.);
        exchangeRateService.save(exchangeRate);
        theCurrency.addToExchangeRate(exchangeRate,true);
        currencyService.save(theCurrency);
        Currency anotherCurrency = currencyService.findById(2);
        anotherCurrency.addToExchangeRate(exchangeRate,false);


        currencyService.save(anotherCurrency);

         return "redirect:/currencies/list";
    }

    //Delete attribute mappings
    @GetMapping("/delete")
    public String deleteStock(@RequestParam("currencyId") int theId){
        currencyService.deleteById(theId);

        return "redirect:/currencies/list";
    }
}
