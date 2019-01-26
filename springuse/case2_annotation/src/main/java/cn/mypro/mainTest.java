package cn.mypro;


import cn.mypro.annotation_createtype.controller.CustomerController;
import cn.mypro.domain.Customer;
import cn.mypro.annotation_injection.autowired.demo1_default.Animal;
import cn.mypro.annotation_injection.autowired.demo1_default.AutowiredDemo;
import cn.mypro.annotation_injection.autowired.demo1_default.Service;
import cn.mypro.annotation_injection.autowired.demo2_confused_type.ConfusedAutowired;
import cn.mypro.annotation_injection.autowired.demo2_confused_type.Plan;
import cn.mypro.annotation_injection.qualifier.QualifierDemo;
import cn.mypro.annotation_injection.resource.demo1_default.ResourceDefaultDemo;
import cn.mypro.annotation_injection.value.ValueDemo;
import cn.mypro.annotation_scope.ScopePrototypeDemo;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.TestCase.*;

public class mainTest {

    /**
     * 创建类型注解
     *
     * @Component
     * @Controller
     * @Service
     * @Repository
     */
    @Test
    public void findById() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");
        CustomerController controller = (CustomerController) ctx.getBean("customerController");
        Customer c = controller.findById(1);
        assertNotNull(c);
    }

    /**
     * 范围注解
     * 多例注解@Scope("prototype")
     */
    @Test
    public void testScopePrototype() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ScopePrototypeDemo demo1 = (ScopePrototypeDemo) ctx.getBean("scopePrototypeDemo");
        ScopePrototypeDemo demo2 = (ScopePrototypeDemo) ctx.getBean("scopePrototypeDemo");
        assertNotSame(demo1, demo2);
    }

    /**
     * 范围注解
     * 默认单例Singleton
     */
    @Test
    public void testScopeSingleton() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        CustomerController demo1 = (CustomerController) ctx.getBean("customerController");
        CustomerController demo2 = (CustomerController) ctx.getBean("customerController");
        assertSame(demo1, demo2);
    }

    /**
     * 注入类型注解@Autowreid
     * 默认按照类型注入，其次按照名称注入
     */
    @Test
    public void testAutowired() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("autowired_default_beans.xml");
        AutowiredDemo demo = (AutowiredDemo) ctx.getBean("autowiredDemo");
        // 默认按照类型注入。SameButNotAnimal虽然name相同，但是类型不同，没有被注入
        Animal animal = demo.getAnimal();
        assertNotNull(animal);
        // 多个相同类型，按照名称注入
        Service service = demo.getService();
        assertNotNull(service);
    }

    /**
     * 注入类型注解@Autowreid
     * 多个相同类型，名称也不匹配，会报错
     */
    @Test(expected = UnsatisfiedDependencyException.class)
    public void testConfusedAutowired() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ConfusedAutowired bean = (ConfusedAutowired) ctx.getBean("confusedAutowired");
        Plan plan = bean.getPlan();
    }

    /**
     * @Qualifier配合@Autowired使用 必须name匹配才能注入
     */
    @Test
    public void testQualifier() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("qualifier_beans.xml");
        // 前两个字母大写的class生成的beanName就是自己，首字母并不小写
        QualifierDemo bean = (QualifierDemo) ctx.getBean("qualifierDemo");
        assertNotNull(bean.getDesk());
    }

    /**
     * 测试@Resource默认按照名称注入
     * CocoNone类型不匹配但名称匹配
     */
    @Test(expected = BeanCreationException.class)
    public void testResourceDefault() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("resource_beans.xml");
        // CocoName不是Coco类型，但是因为名字叫coco，@Resource名字优先注入导致报错
        ResourceDefaultDemo bean = (ResourceDefaultDemo) ctx.getBean("resourceDefaultDemo");
    }

    /**
     * 测试@Value注入基本变量+String
     */
    @Test
    public void testValue(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("value_beans.xml");
        // CocoName不是Coco类型，但是因为名字叫coco，@Resource名字优先注入导致报错
        ValueDemo bean = (ValueDemo) ctx.getBean("valueDemo");
        assertTrue(bean.getId()==15);
    }
}