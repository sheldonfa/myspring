package cn.mypro.annotation_injection.autowired.demo1_default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredDemo {

    @Autowired
    private Service service;

    @Autowired
    private Animal animal;

    public Service getService() {
        return service;
    }

    public Animal getAnimal() {
        return animal;
    }
}
