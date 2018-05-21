package com.inventory.controllers;


import com.inventory.models.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by andy on 20/05/2018.
 */
@Controller
public class CustomerController {

    @Autowired
    BeverageRepository beverageRepo;
    @Autowired
    CustomerOrderRepository customerOrderRepository;
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/customer")
    public ModelAndView doHome() {
        ModelAndView mv = new ModelAndView("index");
        mv.getModel().put("beverageList", beverageRepo.findAll());
        return mv;
    }

    @GetMapping("/customer/customer")
    public ModelAndView yep(){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        return mv;
    }

    @GetMapping("/customer/customerOrderList")
    public ModelAndView doOrders() {
        ModelAndView mv = new ModelAndView("customerOrderList");
        mv.getModel().put("customerOrderList", customerOrderRepository.findAll());
        return mv;

    }

    @GetMapping(value= "/customer/customerOrder")
    public ModelAndView addOrder(){
        ModelAndView mv = new ModelAndView("customerOrder");
        return mv;
    }

    @PostMapping(value = "/customer/customerOrder")
    public ModelAndView doOrderSave( @RequestParam(name="customer_name") String customerName,
                                     @RequestParam(name="productName") String productName,
                                     @RequestParam(name="quantity") float quantity, @RequestParam(name="total_price") float totalPrice){

        CustomerOrder customerOrder = new CustomerOrder(customerName, productName, quantity, totalPrice);
        customerOrderRepository.save(customerOrder);
        ModelAndView mv = new ModelAndView("redirect:/customer/customerOrderList");
        return mv;
    }

}



