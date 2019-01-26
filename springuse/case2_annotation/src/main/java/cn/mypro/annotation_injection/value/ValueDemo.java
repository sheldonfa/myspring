package cn.mypro.annotation_injection.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueDemo {

    @Value("15")
    private Integer id;
    @Value("zhangsan")
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
