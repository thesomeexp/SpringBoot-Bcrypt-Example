package com.someexp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping("/addOrder")
    public String addOrder(){
        return "addOrder";
    }

    @RequestMapping("/showOrder")
    public String showOrder(){
        return "showOrder";
    }

    @RequestMapping("/deleteOrder")
    public String deleteOrder(){
        return "deleteOrder";
    }

    @RequestMapping("/updateOrder")
    public String updateOrder(){
        return "updateOrder";
    }
}
