package cn.mypro.annotation_createtype.dao;

import cn.mypro.domain.Customer;

public interface CustomerDao {
    Customer findById(Integer id);
}
