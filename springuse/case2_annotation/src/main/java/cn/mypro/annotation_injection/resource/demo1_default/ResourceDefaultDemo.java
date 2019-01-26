package cn.mypro.annotation_injection.resource.demo1_default;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ResourceDefaultDemo {

    @Resource
    private Coco coco;

    public Coco getCoco() {
        return coco;
    }

    public void setCoco(Coco coco) {
        this.coco = coco;
    }
}
