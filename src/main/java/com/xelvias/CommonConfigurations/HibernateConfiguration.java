package com.xelvias.CommonConfigurations;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.xelvias"})
@PropertySource(value = {"classpath:mysql-hib.prop"})
public class HibernateConfiguration {
    @Autowired
    Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory= new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.xelvias.models"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("mysql.driver"));
        dataSource.setUrl(environment.getRequiredProperty("mysql.jdbcUrl"));
        dataSource.setUsername(environment.getRequiredProperty("mysql.username"));
        dataSource.setPassword(environment.getRequiredProperty("mysql.password"));
        return dataSource;
    }


    private Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto",environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s){
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}





//
//@Configuration
//@PropertySource("classpath:mysql-hib.prop")
//@EnableTransactionManagement
//@ComponentScan(value = {"com.xelvias"})
//public class PersistenceConfig {
//
//    @Autowired
//    private Environment env;
//
////    @Bean
////    public SessionFactory getSessionFactory() {
//////        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//////        factoryBean.setConfigLocation(context.getResource("classpath:persistence-mysql.prop"));
//////        factoryBean.setAnnotatedClasses(Person.class);
//////        return factoryBean;
////        SessionFactory sessionFactory = new Configuration().configure("classpath:persistence-mysql.prop").buildSessionFactory();
////    }
//
//
//    @Bean
//    public LocalSessionFactoryBean getSessionFactory() {
//        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//
//        Properties props = new Properties();
//
//        // Setting JDBC properties
//        props.put(DRIVER, env.getProperty("mysql.driver"));
//        props.put(URL, env.getProperty("mysql.jdbcUrl"));
//        props.put(USER, env.getProperty("mysql.username"));
//        props.put(PASS, env.getProperty("mysql.password"));
//        props.put(DIALECT,env.getProperty("mysql.dialect"));
//        // Setting Hibernate properties
//        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
//        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
//
////        // Setting C3P0 properties
////        props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
////        props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
////        props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
////        props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
////        props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
//
//        factoryBean.setHibernateProperties(props);
//        factoryBean.setAnnotatedClasses(Person.class);
//
//        return factoryBean;
//    }
//
//    @Bean
//    public HibernateTransactionManager getTransactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(getSessionFactory().getObject());
//        return transactionManager;
//    }
//
//
////    @Bean
////    @Autowired
////    public HibernateTransactionManager transactionManager(
////            SessionFactory sessionFactory) {
////
////        HibernateTransactionManager txManager
////                = new HibernateTransactionManager();
////        txManager.setSessionFactory(sessionFactory);
////
////        return txManager;
////    }
//
//
//
//}
