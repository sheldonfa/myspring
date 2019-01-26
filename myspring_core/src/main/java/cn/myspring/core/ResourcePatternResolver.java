package cn.myspring.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourcePatternResolver {

    private static Logger logger = LogManager.getLogger(ClassPathXmlApplicationContext.class);

    public List<BeanDefinition> parse(String path) {
        try {
            // 解析文档
            Document document = getXpathDocument(path);
            // 获取后代元素需要添加命名空间ns
            List<Element> beanList = document.selectNodes("//ns:bean");
            ArrayList<BeanDefinition> results = new ArrayList<>();
            for (Element e : beanList) {
                String id = e.attributeValue("id");
                String fullPathClassName = e.attributeValue("class");
                BeanDefinition bean = new BeanDefinition();
                bean.setId(id);
                bean.setClassPath(fullPathClassName);

                String initMethod = e.attributeValue("init-method");
                if(initMethod!=null){
                    bean.setInitMethod(initMethod);
                }
                String destroyMethod = e.attributeValue("destroy-method");
                if(destroyMethod!=null){
                    bean.setDestroyMethod(destroyMethod);
                }
                results.add(bean);
            }
            return results;
        } catch (Exception e) {
            logger.error("解析文档失败", e);
        }
        return null;
    }

    private Document getXpathDocument(String path) throws DocumentException {
        // 工厂注入namespace
        DocumentFactory factory = new DocumentFactory();
        Map<String, String> map = new HashMap<>();
        factory.setXPathNamespaceURIs(map);
        // 创建 document对象
        SAXReader reader = new SAXReader(factory);
        Document document = reader.read(this.getClass().getClassLoader().getResourceAsStream(path));
        map.put("ns", document.getRootElement().getNamespaceURI());
        return document;
    }

}
