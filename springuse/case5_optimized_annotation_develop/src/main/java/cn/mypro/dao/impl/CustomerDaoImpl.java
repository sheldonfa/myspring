package cn.mypro.dao.impl;

import cn.mypro.dao.CustomerDao;
import cn.mypro.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Customer findById(Integer id) {
        String sql = "select * from customer WHERE id = 1";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class));

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
