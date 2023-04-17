package StockTracker.controller;

import StockTracker.entity.Currency;
import StockTracker.entity.ExchangeRate;
import StockTracker.entity.Stock;
import StockTracker.service.CurrencyService;
import StockTracker.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/exchangerates")
public class ExchangeRateController {

    private CurrencyService currencyService;
    private ExchangeRateService exchangeRateService;

    @Autowired
    public ExchangeRateController(CurrencyService theCurrencyService, ExchangeRateService theExchangeRateService){
        currencyService=theCurrencyService;
        exchangeRateService=theExchangeRateService;
    }

    //list available exchangerates
    @GetMapping("/list")
    public String listExchangeRates(Model theModel){
        List<ExchangeRate> exchangeRates = exchangeRateService.findAll();
        ExchangeRate emptyExchangeRate = new ExchangeRate();

        theModel.addAttribute("exchangerates",exchangeRates);
        return ("exchangerates/list-exchangerates");
    }

    //Add new attribute mappings
    @GetMapping("/addExchangeRate")
    public String addNewStock (Model theModel){
        ExchangeRate emptyExchangeRate = new ExchangeRate();
        theModel.addAttribute("exchangerate", emptyExchangeRate);
        List<Currency> currencies = currencyService.findAll();
        theModel.addAttribute("currencies", currencies);

        return "exchangerates/exchangerate-form";
    }

    @PostMapping("/saveExchangeRate")
    public String saveExchangerate(@ModelAttribute("exchangerate") ExchangeRate exchangeRate,
                                   @RequestParam("baseCurrencyID") int theId){

        System.out.println(theId);


        return "exchangerates/exchangerate-form";
    }



}
