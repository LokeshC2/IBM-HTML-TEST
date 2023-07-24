package com.ibm.config;

import java.beans.PropertyVetoException;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = "com.ibm")
@PropertySource("classpath:application.properties")
public class AppConfig {

  @Autowired
  private DataSource dataSource;

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setHibernateProperties(hibernateProperties());
    sessionFactory.setPackagesToScan("com.ibm.model");
    return sessionFactory;
  }

  @Bean
  public DataSource getdataSource(
      @Value("${spring.datasource.driverClassName}") String driverClassName,
      @Value("${spring.datasource.url}") String url,
      @Value("${spring.datasource.username}") String username,
      @Value("${spring.datasource.password}") String password) {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    try {
      dataSource.setDriverClass(driverClassName);
      dataSource.setJdbcUrl(url);
      dataSource.setUser(username);
      dataSource.setPassword(password);
      dataSource.setMinPoolSize(5);
      dataSource.setMaxPoolSize(20);
      dataSource.setMaxIdleTime(5000);
    } catch (PropertyVetoException e) {
      e.printStackTrace();
    }
    return dataSource;
  }

  @Bean
  Random random() {
    return new Random();
  }

  // @Bean
  // Map<String, Double> commissionRates(
  //     @Value("${app.commission.buy}") String buyCommissionRate,
  //     @Value("${app.commission.sell}") String sellCommissionRate) {
  //   Double buy = Double.parseDouble(buyCommissionRate);
  //   Double sell = Double.parseDouble(sellCommissionRate);
  //   return Map.of("buy", buy, "sell", sell);
  // }

  @Bean
  Map<String, Double> commissionRates() {
    return Map.of("buy", 0.5, "sell", 1.0);
  }

  private Properties hibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
    hibernateProperties.setProperty("hibernate.show_sql", "false");
    // hibernateProperties.setProperty("hibernate.format_sql", "true");
    return hibernateProperties;
  }

}
