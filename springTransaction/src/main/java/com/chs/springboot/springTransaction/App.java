package com.chs.springboot.springTransaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chs.springboot.springTransaction.model.Address;
import com.chs.springboot.springTransaction.model.Customer;
import com.chs.springboot.springTransaction.service.CustomerManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserService userService = context.getBean(UserService.class);
        
        CustomerManager customerManager = context.getBean(CustomerManager.class);
        
		customerManager.create(createDummyCustomer());
        
//        List<Customer> list = new ArrayList();
//        Customer cust = new Customer();
//        cust.setName("Tom");
//        list.add(cust);
//        
//        cust = new Customer();
//        cust.setName("Tom");
//        list.add(cust);
//        
//        userService.add(list);
		context.close();
    }
    
    private static Customer createDummyCustomer() {
		Customer customer = new Customer();
		customer.setId(2);
		customer.setName("Pankaj");
		Address address = new Address();
		address.setId(2);
		address.setCountry("India");
		// setting value more than 20 chars, so that SQLException occurs
		address.setAddress("Albany Dr, San Jose, CA 95129");
		customer.setAddress(address);
		return customer;
	}
}
