package com.emirleroglu.stocksproject;



import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class StockController {


    @GetMapping
     public String getHome(Model model){
        model.addAttribute("name","halil");
        return "demo";
    }
    @GetMapping("/api")
    public String getApi(Model model) throws UnirestException {
        HisseList mylist = new HisseList();


        model.addAttribute("x",mylist.parseJson());
        return "api";
    }



}
