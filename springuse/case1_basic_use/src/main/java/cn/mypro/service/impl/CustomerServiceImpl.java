package cn.mypro.service.impl;

import cn.mypro.annotation_createtype.dao.CustomerDao;
import cn.mypro.domain.Customer;
import cn.mypro.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;


    public Customer findById(Integer id) {
        return customerDao.findById(id);
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
