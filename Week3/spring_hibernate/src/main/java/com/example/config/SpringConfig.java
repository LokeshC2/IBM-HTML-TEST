package com.example.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.example.*")
public class SpringConfig {

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource());
    sessionFactoryBean.setHibernateProperties(hibernateProperties());
    sessionFactoryBean.setPackagesToScan("com.example.entity");
    return sessionFactoryBean;
  }

  @Bean
  public DataSource dataSource() {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    try {
      dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
      dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/springDb");
      dataSource.setUser("lox");
      dataSource.setPassword("mysql0");
      dataSource.setMinPoolSize(5);
      dataSource.setMaxPoolSize(20);
      dataSource.setMaxIdleTime(5000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dataSource;
  }

  private Properties hibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty(
      "hibernate.dialect",
      "org.hibernate.dialect.MySQL8Dialect"
    );
    hibernateProperties.setProperty("hibernate.show_sql", "true");
    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
    hibernateProperties.setProperty("hibernate.show_sql", "true");
    hibernateProperties.setProperty("hibernate.format_sql", "true");
    return hibernateProperties;
  }
}
