package kz.bitlab.techorda2025.thirdProject.controllers;

import kz.bitlab.techorda2025.thirdProject.beans.ExampleBean;
import kz.bitlab.techorda2025.thirdProject.beans.SomeBean;
import kz.bitlab.techorda2025.thirdProject.beans.TestBean;
import kz.bitlab.techorda2025.thirdProject.configs.ConfigurationBean;
import kz.bitlab.techorda2025.thirdProject.interfaces.ThirdBean;
import kz.bitlab.techorda2025.thirdProject.interfaces.impls.ThirdBeanImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

//    @Autowired
//    TestBean testBean;

    @Autowired
    SomeBean someBean;

    @Autowired
    ExampleBean exampleBean1;

    @Autowired
    ExampleBean exampleBean2;

    @Autowired
    ThirdBean thirdBean;

//    TestBean testBean = new TestBean();

    @GetMapping(value = "/test")
    public String getTest(Model model) {
        System.out.println("tesBEan 3:" + new TestBean());
//        model.addAttribute("text", testBean.getSomeText());
        model.addAttribute("someBean", someBean.getSomeText());
        model.addAttribute("exampleBean1", exampleBean1.getSomeText());
        model.addAttribute("exampleBean2", exampleBean2.getSomeText());
        thirdBean.getData();
        return "tasks";
    }

    @GetMapping(value = "/test2")
    public String getTest2(Model model) {
        System.out.println("tesBEan 3:" + new TestBean());
//        model.addAttribute("text", testBean.getSomeText());
        return "tasks";
    }
}
