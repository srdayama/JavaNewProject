package com.scp.java.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//This is springbean.xml file configuration--
//
@Configuration // java configuration for bean file
@EnableWebMvc // spring mvc enabling
@ComponentScan(basePackages = "com.scp.java") // context:componentscan base package
//@PropertySource(value = { "classpath:application.properties" }) //propertyplaceholder
public class SpringBeanJavaConfig  extends WebMvcConfigurerAdapter{
	 
	static{
		System.out.println("inside SpringmvcXmlconfig......");
	}
	
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	
	@Bean // <bean 
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();  // internalresourceviewresolover
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/"); //prefix
		viewResolver.setSuffix(".jsp"); //suffix
		return viewResolver;
	}
	
	@Bean 
    public LocalSessionFactoryBean sessionFactory() {
		System.out.println("Sessionactory created...!");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();//class
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.scp.java.entity" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
	
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        return properties;        
    }

	
	
}