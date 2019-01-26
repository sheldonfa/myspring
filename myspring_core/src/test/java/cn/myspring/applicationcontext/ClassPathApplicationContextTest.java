package cn.myspring.applicationcontext;


import cn.myspring.applicationcontext.sample.ExampleA;
import cn.myspring.core.ClassPathXmlApplicationContext;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ClassPathApplicationContextTest {
    /**
     * 测试初始化
     */
    @Test
    public void testSingleConfigLocation() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        assertTrue(ctx.containsBean("examplea"));
        ExampleA examplea = (ExampleA) ctx.getBean("examplea");
        assertTrue(examplea.isProperlyInit());

    }

    /**
     * 测试destroy
     */
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        assertTrue(context.containsBean("examplea"));
        ExampleA examplea = (ExampleA) context.getBean("examplea");
        context.close();
        assertTrue(examplea.isProperlyDestroyed());
    }
}
