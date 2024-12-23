//package com.xyz.easymycart.filters;
//
//import javax.servlet.*;
//import java.io.IOException;
//
//public class MyFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Initialization logic (if required)
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        // Pre-processing logic
//        System.out.println("Before request processing");
//
//        chain.doFilter(request, response); // Pass the request to the next filter or servlet
//
//        // Post-processing logic
//        System.out.println("After request processing");
//    }
//
//    @Override
//    public void destroy() {
//        // Cleanup logic (if required)
//    }
//}