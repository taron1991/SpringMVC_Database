package spring.app.configs;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DBconfig {

    @Bean
    public BasicDataSource getData(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        basicDataSource.setPassword("westside");
        basicDataSource.setUsername("postgres");
        return basicDataSource;
    }

    @Bean
    public TransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager hiber = new HibernateTransactionManager();
        hiber.setSessionFactory(sessionFactory);
        return hiber;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(BasicDataSource basicDataSource){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(basicDataSource);
        localSessionFactoryBean.setPackagesToScan("spring.app.models");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }
}
