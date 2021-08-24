package com.preet.product.api;

import com.preet.product.dto.OrderRequest;
import com.preet.product.model.Customer;
import com.preet.product.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/order")
public class OrderResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest){
        return customerService.placeOrder(orderRequest);
    }

    @GetMapping(value = "/findAllOrder")
    public List<Customer> findAllOrders(){
        return customerService.findAllOrders();
    }

}
