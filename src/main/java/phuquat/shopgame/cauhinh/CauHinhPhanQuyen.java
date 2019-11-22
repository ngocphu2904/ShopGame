package phuquat.shopgame.cauhinh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import phuquat.shopgame.phanquyen.PhanQuyen;

@Configuration
@EnableWebSecurity /* @EnableWebSecurity = @EnableWebMVCSecurity + Extra features */
public class CauHinhPhanQuyen extends WebSecurityConfigurerAdapter {
	
	@Autowired
	PhanQuyen phanquyen;
	
	   @Autowired
	   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	       // Cac nguoi dung trong Database
	       auth.userDetailsService(phanquyen);
	   }
	   
	   @Override
	   protected void configure(HttpSecurity http) throws Exception {
	 
	       http.csrf().disable();
	       
	       // Chuyen toi trang dang nhap khi muon vao trang duoi (neu chua dang nhap)
	       http.authorizeRequests().antMatchers("/thongtin","/themtaikhoan","/thongke","taikhoandamua")
			  .access("hasAnyRole('ROLE_QUAN_TRI','ROLE_NGUOI_DUNG')");
	       
	       http.authorizeRequests().antMatchers("/taikhoan").access("hasRole('ROLE_QUAN_TRI')");
	       
	       // Chuyen toi 403 neu co y vao trang khong dung quyen
	       http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
	  
	       // Cau hinh trang dang nhap
	       http.authorizeRequests().and().formLogin().loginProcessingUrl("/check")//khi dang nhap no nhay vao
           .loginPage("/dangnhap").defaultSuccessUrl("/")
           .failureUrl("/dangnhap?loi=true")//khi dang nhap loi
           .usernameParameter("tenDangNhap") //bien name trang jsp
           .passwordParameter("matKhau") // bien name trang jsp
           .and().logout().logoutUrl("/dangxuat").logoutSuccessUrl("/");//dang xuat
	   }
}
