package cn.mypro.annotation_createtype.dao.impl;

import cn.mypro.annotation_createtype.dao.CustomerDao;
import cn.mypro.domain.Customer;

public class CustomerDaoImpl implements CustomerDao {


    public Customer findById(Integer id) {
        Customer customer = new Customer();
        customer.setName("张三");
        customer.setAge("27");
        return customer;
    }
}
