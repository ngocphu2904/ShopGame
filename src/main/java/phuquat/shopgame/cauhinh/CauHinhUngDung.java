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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import phuquat.shopgame.dao.DonMuaDAO;
import phuquat.shopgame.dao.EmailDao;
import phuquat.shopgame.dao.HinhAnhDAO;
import phuquat.shopgame.dao.NguoiDungDAO;
import phuquat.shopgame.dao.TaiKhoanDAO;
import phuquat.shopgame.service.DonMuaService;
import phuquat.shopgame.service.EmailService;
import phuquat.shopgame.service.HinhAnhService;
import phuquat.shopgame.service.NguoiDungService;
import phuquat.shopgame.service.TaiKhoanService;

@Configuration
@ComponentScan("phuquat.shopgame.*")
@EnableTransactionManagement
//Dung o bien Environment.
@PropertySource("classpath:database.properties")
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
	   
	   @Bean(name = "multipartResolver")
	   public CommonsMultipartResolver multipartResolver() {
		    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    	multipartResolver.setMaxUploadSize(20971520);
		    return multipartResolver;
	   }
	   
	   @Bean(name = "nguoiDungDAO")
	   public NguoiDungDAO getNguoiDungDAO(){
		   return new NguoiDungDAO();
	   }
	   
	   @Bean(name = "nguoiDungService")
	   public NguoiDungService getNguoiDungService(){
		   return new NguoiDungService();
	   }
	   
	   @Bean(name = "taiKhoanDAO")
	   public TaiKhoanDAO getTaiKhoanDAO(){
		   return new TaiKhoanDAO();
	   }
	   
	   @Bean(name = "taiKhoanService")
	   public TaiKhoanService getTaiKhoanService(){
		   return new TaiKhoanService();
	   }
	   
	   @Bean(name="hinhAnhDAO")
	   public HinhAnhDAO getHinhAnhDAO() {
		   return new HinhAnhDAO();
	   }
	   
	   @Bean(name="hinhAnhService")
	   public HinhAnhService getHinhAnhService() {
		   return new HinhAnhService();
	   }
   
	   @Bean(name="donMuaDAO")
	   public DonMuaDAO getDonMuaDAO() {
		   return new DonMuaDAO();
	   }
	   
	   @Bean(name="donMuaService")
	   public DonMuaService getDonMuaService() {
		   return new DonMuaService();
	   }
	   
	   @Bean(name="emailDAO")
	   public EmailDao getEmailDAO() {
		   return new EmailDao();
	   }
	   
	   @Bean(name="emaiService")
	   public EmailService getEmailService() {
		   return new EmailService();
	   }
}
