package kz.bitlab.techorda2025.thirdProject.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("singleton")
public class TestBean {

    private String text;

    public TestBean(){
        this.text = "Some Text Value";
    }

    public TestBean(String someText){
        this.text = someText;
    }

    public String getSomeText(){
        return text;
    }

}


