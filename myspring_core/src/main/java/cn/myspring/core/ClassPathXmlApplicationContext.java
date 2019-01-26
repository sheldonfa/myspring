package cn.myspring.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext {

    private static Logger logger = LogManager.getLogger(ClassPathXmlApplicationContext.class);

    private Map<String, BeanDefinition> container = new HashMap<>();

    private ResourcePatternResolver resolver = new ResourcePatternResolver();

    /**
     * 初始化解析xml文档
     *
     * @param path xml文件路径
     */
    public ClassPathXmlApplicationContext(String path) {
        // parse resource
        List<BeanDefinition> beanDefinitions = resolver.parse(path);
        // registe
        regist(beanDefinitions);
    }

    private void regist(List<BeanDefinition> beanDefinitions) {
        for (BeanDefinition b : beanDefinitions) {
            if (container.get(b.getId()) == null) {
                // 执行init方法
                try {
                    Class<?> clazz = Class.forName(b.getClassPath());
                    Object instance = clazz.newInstance();
                    if (b.getInitMethod() != null) {
                        Method method = clazz.getDeclaredMethod(b.getInitMethod());
                        method.setAccessible(true);
                        method.invoke(instance);
                    }
                    b.setInstance(instance);
                    container.put(b.getId(), b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean containsBean(String name) {
        BeanDefinition bd = (BeanDefinition) container.get(name);
        if (bd != null && bd.getInstance() != null) {
            return true;
        }
        return false;
    }

    public Object getBean(String name) {
        return container.get(name).getInstance();
    }

    public void refresh() {
        logger.trace("refresh");
    }

    public void close() {
        for (Map.Entry<String, BeanDefinition> entity : container.entrySet()) {
            BeanDefinition bd = entity.getValue();
            Object instance = bd.getInstance();
            if (bd.getDestroyMethod() != null) {
                try {
                    Method destroyMethod = instance.getClass().getDeclaredMethod(bd.getDestroyMethod());
                    destroyMethod.setAccessible(true);
                    destroyMethod.invoke(instance);
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }
}
