package cn.mypro.annotation_createtype.controller;

import cn.mypro.domain.Customer;
import cn.mypro.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {


    @Value("abc")
    private String description;

    @Autowired
    private CustomerService customerService;

    public Customer findById(Integer id) {
        return customerService.findById(id);
    }

    public String getDescription() {
        return description;
    }

}
