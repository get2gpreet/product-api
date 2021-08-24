package com.preet.product.service;

import com.preet.product.dto.OrderRequest;
import com.preet.product.model.Customer;
import com.preet.product.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer placeOrder(OrderRequest request){
        return customerRepo.save(request.getCustomer());
    }

    public List<Customer> findAllOrders(){
        return customerRepo.findAll();
    }


}
