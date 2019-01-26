package cn.mypro.annotation_injection.autowired.demo2_confused_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfusedAutowired {

    @Autowired
    private Plan plan;

    public Plan getPlan() {
        return plan;
    }
}
