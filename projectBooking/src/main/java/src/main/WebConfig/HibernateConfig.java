package src.main.WebConfig;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import src.main.java.booking.Khachhang;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:datasource-cfg.properties")
public class HibernateConfig {
	@Autowired
    Environment evn;
	@Autowired
    private ApplicationContext context;
	@Bean
    public DriverManagerDataSource dataSource() throws IOException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(evn.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(evn.getProperty("jdbc.url"));
        dataSource.setUsername(evn.getProperty("jdbc.username"));
        dataSource.setPassword(evn.getProperty("jdbc.password"));
        return dataSource;
    }
    
    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.dialect", evn.getProperty("hibernate.dialect"));
                setProperty("hibernate.format_sql", evn.getProperty("hibernate.format_sql"));
                setProperty("hibernate.show_sql", evn.getProperty("hibernate.show_sql"));
            }
        };
    }
 
    @Bean
    public LocalSessionFactoryBean getSessionFactory() throws IOException {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
        factoryBean.setDataSource(dataSource());
        factoryBean.setHibernateProperties(hibernateProperties());
        return factoryBean;
    }
 
    @Bean
    public HibernateTransactionManager getTransactionManager() throws IOException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        
        return transactionManager;
    }
}
