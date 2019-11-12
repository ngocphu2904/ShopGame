package phuquat.shopgame.cauhinh;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class CauHinhUTF8 extends WebMvcConfigurerAdapter{

	private static final Charset UTF8 = Charset.forName("UTF-8");
	  
		// Cai dat utf8 cho cac trang
	   @Override
	   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	       StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
	       stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", UTF8)));
	       converters.add(stringConverter);
	   }
	 
	   // Cau hinh de dung css js img
	   @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
	       registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
	       registry.addResourceHandler("/images/**").addResourceLocations("/images/").setCachePeriod(31556926);
	       registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	   }
}
