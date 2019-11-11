package phuquat.shopgame.cauhinh;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import phuquat.shopgame.dao.NguoiDungDAO;

@Configuration
@ComponentScan("phuquat.shopgame.*")
@EnableTransactionManagement
//Dung o bien Environment.
@PropertySource("classpath:hibernate.properties")
public class CauHinhUngDung {

	   // Luu cac gia tri o @PropertySource vao moitruong.
	   @Autowired
	   private Environment moitruong;
	
	   @Bean(name = "viewResolver")
	   public InternalResourceViewResolver getViewResolver() {
	       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	       viewResolver.setPrefix("/WEB-INF/views/");
	       viewResolver.setSuffix(".jsp");
	       return viewResolver;
	   }
	  
	   @Bean(name = "dataSource")
	   public DataSource getDataSource() {
	       DriverManagerDataSource dataSource = new DriverManagerDataSource();

	       // Load: hibernate.properties
	       dataSource.setDriverClassName(moitruong.getProperty("ds.database-driver"));
	       dataSource.setUrl(moitruong.getProperty("ds.url"));
	       dataSource.setUsername(moitruong.getProperty("ds.username"));
	       dataSource.setPassword(moitruong.getProperty("ds.password"));
	        
	       System.out.println("## getDataSource: " + dataSource);
	        
	       return dataSource;
	   }
	   
	   @Autowired
	   @Bean(name = "sessionFactory")
	   public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
	       Properties properties = new Properties();
	  
	       // Load: hibernate.properties
	       properties.put("hibernate.dialect", moitruong.getProperty("hibernate.dialect"));
	       properties.put("hibernate.show_sql", moitruong.getProperty("hibernate.show_sql"));
	       properties.put("current_session_context_class", moitruong.getProperty("current_session_context_class"));
	        	 
	       LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	  
	       // Package chua cac bang
	       factoryBean.setPackagesToScan(new String[] { "phuquat.shopgame.entity" });
	       factoryBean.setDataSource(dataSource);
	       factoryBean.setHibernateProperties(properties);
	       factoryBean.afterPropertiesSet();
	       //
	       SessionFactory sf = factoryBean.getObject();
	       System.out.println("## getSessionFactory: " + sf);
	       return sf;
	   }
	 
	   @Autowired
	   @Bean(name = "transactionManager")
	   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	       HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	 
	       return transactionManager;
	   }
	   
	   @Bean(name = "nguoiDungDAO")
	   public NguoiDungDAO getApplicantDAO() {
	       return new NguoiDungDAO();
	   }
	
}
