package com.quincy.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.quincy.test.auto.FooTemplate;
import com.quincy.test.auto.Template;

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
		registry.addMapping("/**")
			.allowedOriginPatterns("http://pc.jep8566.*", "http://10.200.*");
//			.allowedOriginPatterns("http://10.200.*");
//			.allowedOriginPatterns("http://jep8566.com", "http://*.jep8566.com", "http://www.xxx.com", "http://localhost:*")
//			.allowCredentials(true)
//			.allowedHeaders("*")
//			.allowedMethods("*");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		response.setHeader("Access-Control-Allow-Origin", "http://pc.jep8566.com");
//		response.setHeader("Access-Control-Allow-Headers", "Authorization, x-requested-with, content-type, x-token");
//		response.setHeader("Access-Control-Allow-Credentials", "true");
//		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				@Nullable ModelAndView modelAndView) throws Exception {
		
	}

	@Template
	@Bean
	public FooTemplate fooTemplate1() {
		FooTemplate t = new FooTemplate();
		t.setName("1111");
		return t;
	}

	@Template
	@Bean
	public FooTemplate fooTemplate2() {
		FooTemplate t = new FooTemplate();
		t.setName("222");
		return t;
	}

	@Template
	@Bean
	public FooTemplate fooTemplate3() {
		FooTemplate t = new FooTemplate();
		t.setName("333");
		return t;
	}
}
