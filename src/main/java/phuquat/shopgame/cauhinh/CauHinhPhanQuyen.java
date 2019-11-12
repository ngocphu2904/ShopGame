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
	       
	       // Chuyen toi trang dang nhap khi muon vao 2 trang duoi (neu chua dang nhap)
	       http.authorizeRequests().antMatchers("/thongtin", "/doimatkhau")
			  .access("hasAnyRole('ROLE_QUAN_TRI','ROLE_NGUOI_DUNG')");
	       
	       http.authorizeRequests().antMatchers("/taikhoan").access("hasRole('ROLE_QUAN_TRI')");
	  
	       // Cau hinh trang dang nhap
	       http.authorizeRequests().and().formLogin().loginProcessingUrl("/check")
           .loginPage("/dangnhap").defaultSuccessUrl("/")//
           .failureUrl("/dangnhap?loi=true")
           .usernameParameter("tenDangNhap")
           .passwordParameter("matKhau")
           .and().logout().logoutUrl("/dangxuat").logoutSuccessUrl("/");
	   }
}
