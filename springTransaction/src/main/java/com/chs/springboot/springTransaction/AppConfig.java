package com.chs.springboot.springTransaction;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScan("com.chs.springboot.springTransaction")
public class AppConfig {
	@Autowired
	private Environment env;
	
//	@Autowired
//	private ApplicationContext context;
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		
		return dataSource;
	}
	
//	@Bean
//	public LocalSessionFactoryBean getSessionFactory() {
//		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
////		factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
////		factoryBean.setPackagesToScan("com.chs.springboot.springTransaction.model.hibernate");
//		factoryBean.setDataSource(getDataSource());
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//		factoryBean.setHibernateProperties(properties);
//		factoryBean.setAnnotatedClasses(Customer.class);
//		
//		return factoryBean;
//	}
//	
//	@Bean 
//	public HibernateTransactionManager getTransactionManager() {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//		transactionManager.setSessionFactory(getSessionFactory().getObject());
//		return transactionManager;
//	}
	
//	@Bean
//	public HibernateTemplate hibernateTemplate() throws IOException {
//		HibernateTemplate template = new HibernateTemplate();
//		template.setSessionFactory(getSessionFactory().getObject());
//		return template;
//	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(getDataSource());
		return transactionManager;
	}
	
//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		return new JdbcTemplate(dataSource());
//	}
//	
//	@Bean
//	public CustomerDao customerDao() {
//		CustomerDaoImpl customerDao = new CustomerDaoImpl();
//		customerDao.setDataSource(dataSource());
//		return customerDao;
//	}
}
