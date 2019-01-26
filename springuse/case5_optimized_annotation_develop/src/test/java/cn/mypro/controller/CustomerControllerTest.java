package cn.mypro.controller;


import cn.mypro.config.SpringConfiguration;
import cn.mypro.controller.CustomerController;
import cn.mypro.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class CustomerControllerTest {

    @Autowired
    private CustomerController controller;

    @Test
    public void findById() {
        Customer c = controller.findById(1);
        System.out.println(c);
        assertNotNull(c);
    }
}