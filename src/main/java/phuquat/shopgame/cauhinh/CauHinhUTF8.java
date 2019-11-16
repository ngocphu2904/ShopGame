package phuquat.shopgame.cauhinh;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class CauHinhUTF8 extends WebMvcConfigurerAdapter{

	   // Cau hinh de dung css js img
	   @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
	       registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
	       registry.addResourceHandler("/images/**").addResourceLocations("/images/").setCachePeriod(31556926);
	       registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	   }
}
