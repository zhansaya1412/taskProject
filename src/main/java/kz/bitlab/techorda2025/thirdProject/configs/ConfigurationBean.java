package kz.bitlab.techorda2025.thirdProject.configs;

import kz.bitlab.techorda2025.thirdProject.beans.ExampleBean;
import kz.bitlab.techorda2025.thirdProject.beans.SomeBean;
import kz.bitlab.techorda2025.thirdProject.beans.SomeBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationBean {

    @Bean
    @Scope("singleton")
    public SomeBean someBean() {
        System.out.println("Initializing SomeBean 1");
        return new SomeBean("Test Bitlab Bean");
    }

    @Bean
    @Scope("singleton")
    public SomeBean1 someBean1() {
        System.out.println("Initializing SomeBean 2");
        return new SomeBean1("Test Bitlab Bean 2");
    }

    @Bean
    @Scope("prototype")
    public ExampleBean exampleBean1() {
        System.out.println("Creating a new instance of ExampleBean");
        return new ExampleBean();
    }


}
