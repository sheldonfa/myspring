package cn.mypro.service.impl;

import cn.mypro.annotation_createtype.dao.CustomerDao;
import cn.mypro.doamin.Customer;
import cn.mypro.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer findById(Integer id) {
        return customerDao.findById(id);
    }
}
