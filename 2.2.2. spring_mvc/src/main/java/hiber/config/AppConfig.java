package hiber.config;
import hiber.DAO.UserDAOImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(value = "hiber")
@EnableTransactionManagement
public class AppConfig {

//   @Autowired
//   private Environment env;
//
//   @Bean
//   public DataSource getDataSource() {
//      DriverManagerDataSource dataSource = new DriverManagerDataSource();
//      dataSource.setDriverClassName(env.getProperty("db.driver"));
//      dataSource.setUrl(env.getProperty("db.url"));
//      dataSource.setUsername(env.getProperty("db.username"));
//      dataSource.setPassword(env.getProperty("db.password"));
//      return dataSource;
//   }
//
//   @Bean
//   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//      LocalContainerEntityManagerFactoryBean em
//              = new LocalContainerEntityManagerFactoryBean();
//      em.setDataSource(getDataSource());
//      em.setPackagesToScan(new String[] { "hiber" });
//
//      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//      em.setJpaVendorAdapter(vendorAdapter);
//      em.setJpaProperties(additionalProperties());
//
//      return em;
//   }
//
//
//   @Bean
//   public PlatformTransactionManager transactionManager() {
//      JpaTransactionManager transactionManager = new JpaTransactionManager();
//      transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//
//      return transactionManager;
//   }
//
//   @Bean
//   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//      return new PersistenceExceptionTranslationPostProcessor();
//   }
//
//   public Properties additionalProperties() {
//      Properties properties = new Properties();
//      properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//      return properties;
//   }

//   @Bean
//   public UserServiceImpl getUserServiceImpl () {
//      return new UserServiceImpl();
//   }

   private Environment env;

   @Autowired
   public void setEnv(Environment env) { this.env = env; }

   private Properties jpaProperties() {
      Properties properties = new Properties();
      properties.put("hibernate.dialect", env.getRequiredProperty("hiberdeal"));
      properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
      properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
      return properties;
   }
   @Bean
   public DataSource dataSource() {
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
      dataSource.setUrl(env.getRequiredProperty("db.url"));
      dataSource.setUsername(env.getRequiredProperty("db.username"));
      dataSource.setPassword(env.getRequiredProperty("db.password"));
      return dataSource;
   }
   @Bean
   public JpaVendorAdapter vendorAdapter() {
      return new HibernateJpaVendorAdapter();
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean managerFactory() {
      LocalContainerEntityManagerFactoryBean managerFactory = new LocalContainerEntityManagerFactoryBean();
      managerFactory.setDataSource(dataSource());
      managerFactory.setJpaVendorAdapter(vendorAdapter());
      managerFactory.setPackagesToScan(env.getRequiredProperty("db.entity.pacage"));
      managerFactory.setJpaProperties(jpaProperties());
      return managerFactory;
   }
   @Bean
   public JpaTransactionManager transactionManager() {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(managerFactory().getObject());
      return transactionManager;
   }

//   @Bean
//   public UserDAOImpl getUserDaoImpl() {
//      return new UserDAOImpl();
//   }
}
