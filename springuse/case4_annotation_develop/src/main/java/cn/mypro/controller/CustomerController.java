package cn.mypro.controller;

import cn.mypro.domain.Customer;
import cn.mypro.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public Customer findById(Integer id) {
        return customerService.findById(id);
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
