package org.zerock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages= {"org.zerock.controller"})
public class ServletConfig implements WebMvcConfigurer{

	@Bean
	public MultipartResolver multipartResolver() {
		
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(1024*1024*10);
		
		//업로드할때 한글이 깨지는 문제 해결하는 코드
		resolver.setDefaultEncoding("UTF-8");
		
		
		return resolver;
	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry
			.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		
		InternalResourceViewResolver resolver = 
				new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
		
		//jstl을 사용하고 싶으시면 이거 설정해주셔야합니다.
		resolver.setViewClass(JstlView.class);
		
		registry.viewResolver(resolver);
		
		
	}

	
}
