//package kz.bitlab.techorda2025.thirdProject.beans;
//
//import kz.bitlab.techorda2025.thirdProject.configs.ConfigurationBean;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//@SpringBootApplication
//public class MainApplication {
//
//	public static void main(String[] args) {
//
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationBean.class);
//		// Запрос двух экземпляров ExampleBean
//		ExampleBean bean1 = context.getBean(ExampleBean.class);
//		ExampleBean bean2 = context.getBean(ExampleBean.class);
//		ExampleBean bean3 = context.getBean(ExampleBean.class);
//
//		// Проверка, что это разные экземпляры
//		System.out.println(bean1 == bean2); // Вывод: false, т.к. это разные экземпляры
//
//		context.close();
//	}
//
//}
