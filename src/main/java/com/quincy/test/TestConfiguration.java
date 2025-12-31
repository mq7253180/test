package com.quincy.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class TestConfiguration implements WebMvcConfigurer, HandlerInterceptor {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//			.allowedOriginPatterns("*");
//			.allowedOriginPatterns("http://jep8566.com", "http://*.jep8566.com", "http://www.xxx.com", "http://localhost:*")
//			.allowCredentials(true)
//			.allowedHeaders("*")
//			.allowedMethods("*");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "http://www.jep8566.com");
		response.setHeader("Access-Control-Allow-Credentials", "true");
//		response.setHeader("Access-Control-Allow-Headers", "Authorization, x-requested-with, content-type, x-token");
//		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				@Nullable ModelAndView modelAndView) throws Exception {
		
	}
}
