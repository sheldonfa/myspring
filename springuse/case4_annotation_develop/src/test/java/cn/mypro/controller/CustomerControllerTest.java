package cn.mypro.controller;


import cn.mypro.config.SpringConfiguration;
import cn.mypro.controller.CustomerController;
import cn.mypro.domain.Customer;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.TestCase.*;

public class CustomerControllerTest {

    /**
     * 基本环境搭建
     */
    @Test
    public void findById() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        CustomerController controller = (CustomerController) ctx.getBean("customerController");
        Customer c = controller.findById(1);
        System.out.println(c);
        assertNotNull(c);
    }
}