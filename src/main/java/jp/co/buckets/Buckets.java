package jp.co.buckets;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class Buckets {
    @Autowired
    DataSource dataSource;
    
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
       LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
       sessionFactory.setDataSource(dataSource);
       sessionFactory.setPackagesToScan(new String[] { "jp.co.buckets.dto" });
       sessionFactory.setHibernateProperties(hibernateProperties());
  
       return sessionFactory;
    }
    Properties hibernateProperties() {
        return new Properties() {
            private static final long serialVersionUID = 1L;
        {
              setProperty("hibernate.hbm2ddl.auto", "update");
              setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
              setProperty("hibernate.globally_quoted_identifiers", "true");
           }
        };
     }
  
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory);
  
       return txManager;
    }
  
    public static void main(String[] arguments) {
        SpringApplication.run(Buckets.class, arguments);
    }
    


}