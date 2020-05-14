package com.chs.springboot.springAOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.chs.springboot.springAOP.service.CustomerService;
import com.chs.springboot.springAOP.service.CustomerServiceImpl;
import com.chs.springboot.springAOP.service.ProductServiceImpl;

/**
 * Hello world!
 *
 */
//@SpringBootApplication
@Component
@ComponentScan(value="com.chs.springboot.springAOP")
@EnableAspectJAutoProxy
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        SpringApplication.run(App.class, args);
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext("com.chs.springboot.springAOP");
        CustomerService service = app.getBean(CustomerService.class);
//        service.addCustomer();
        service.getCustomer("Tom");
//        System.out.println(service instanceof CustomerServiceImpl);
//        ProductServiceImpl product = (ProductServiceImpl)app.getBean("productServiceImpl");
//        product.addProduct();
//        product.deleteProduct();
        
    }
}
