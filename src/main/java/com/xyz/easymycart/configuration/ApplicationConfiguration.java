package com.xyz.easymycart.configuration;

//import com.xyz.easymycart.filters.MyFilter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RestTemplate createBean(){
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(5))
                .setReadTimeout(Duration.ofSeconds(5))
                .build();

    }

//    @Bean
//    public FilterRegistrationBean<MyFilter> myFilterRegistrationBean() {
//        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new MyFilter());
//        registrationBean.addUrlPatterns("/api/*"); // Apply filter to specific URL patterns
//        registrationBean.setOrder(1); // Set filter order
//        return registrationBean;
//    }
}
