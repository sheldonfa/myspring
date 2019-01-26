package cn.mypro.annotation_createtype.controller;

import cn.mypro.domain.Customer;
import cn.mypro.service.CustomerService;

public class CustomerController {

    private CustomerService customerService;

    public Customer findById(Integer id){
        return customerService.findById(id);
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
