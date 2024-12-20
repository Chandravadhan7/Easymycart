//package com.xyz.easymycart.configuration;
//
////@EnableWebSecurity
////public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
////    }
////}
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable();
//    }
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedMethods("*");
//            }
//        };
//    }
//}