package com.example.chatplatform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        // Lấy đường dẫn tuyệt đối đến thư mục uploads trong project
	        String uploadPath = System.getProperty("user.dir") + "/uploads/";

	        registry.addResourceHandler("/uploads/**")
	                .addResourceLocations("file:" + uploadPath);
	    }
}
