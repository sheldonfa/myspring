package cn.mypro.dao;

import cn.mypro.domain.Customer;

public interface CustomerDao {
    Customer findById(Integer id);
}
