package cn.myspring.applicationcontext.sample;


import cn.myspring.core.ClassPathXmlApplicationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleA {
    private static Logger logger = LogManager.getLogger(ClassPathXmlApplicationContext.class);

    private boolean properlyDestroyed = false;
    private boolean properlyInit = false;

    public ExampleA() {
    }

    private void destroy() {
        this.properlyDestroyed = true;
    }

    private void init() {
        this.properlyInit = true;
    }

    public boolean isProperlyInit() {
        return this.properlyInit;
    }

    public boolean isProperlyDestroyed() {
        return this.properlyDestroyed;
    }
}
