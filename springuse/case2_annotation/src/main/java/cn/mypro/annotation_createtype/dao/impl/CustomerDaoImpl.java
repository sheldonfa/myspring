package cn.mypro.annotation_createtype.dao.impl;

import cn.mypro.annotation_createtype.dao.CustomerDao;
import cn.mypro.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerDaoImpl implements CustomerDao {


    @Override
    public Customer findById(Integer id) {
        Customer customer = new Customer();
        customer.setName("张三");
        return customer;
    }
}
