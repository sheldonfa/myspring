package cn.mypro.annotation_injection.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class QualifierDemo {

    @Autowired
    @Qualifier("IKEADesk")
    private Desk desk;


    public Desk getDesk() {
        return desk;
    }
}
