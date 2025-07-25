package com.xyz.easymycart.filters;

import com.xyz.easymycart.model.Session;
import com.xyz.easymycart.repository.SessionRepository;
import com.xyz.easymycart.utilities.UtilityHelper;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebFilter(urlPatterns = "/*") // Filters all requests
public class MyFilter implements Filter {

  private final SessionRepository sessionRepository;

  @Autowired
  public MyFilter(SessionRepository sessionRepository) {
    this.sessionRepository = sessionRepository;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // Initialization code, if needed
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    // Pre-processing logic

    HttpServletResponse httpResponse = (HttpServletResponse) response;

    HttpServletRequest httpRequest = (HttpServletRequest) request;

    httpResponse.setHeader("Access-Control-Allow-Origin", "http://easymycart.s3-website.ap-south-1.amazonaws.com"); // Frontend URL
//    httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
    httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST,PATCH, PUT, DELETE, OPTIONS");
    httpResponse.setHeader(
        "Access-Control-Allow-Headers", "Content-Type, Authorization, userId, sessionId");
    httpResponse.setHeader("Access-Control-Allow-Credentials", "true");

    if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
      httpResponse.setStatus(HttpServletResponse.SC_OK);
    } else {
      //            chain.doFilter(request, response);

      System.out.println("Request intercepted by CustomFilter");

      // Get the full path of the API
      String requestURI = httpRequest.getRequestURI(); // Example: "/api/products/123"
      String contextPath = httpRequest.getContextPath(); // Example: "/api"
      String servletPath = httpRequest.getServletPath(); // Example: "/products/123"

      System.out.println("Request URI: " + requestURI);
      System.out.println("Context Path: " + contextPath);
      System.out.println("Servlet Path: " + servletPath);

      if (!requestURI.contains("api")) {
        // Extracting a specific header value
        String sessionId = httpRequest.getHeader("sessionId");
        Long userId = Long.valueOf(httpRequest.getHeader("userId"));

        Session session = sessionRepository.getBySessionId(sessionId);
        if (session == null) throw new RuntimeException("Please Login");
        else if (session.getExpiresAt() < UtilityHelper.getCurrentMillis())
          throw new RuntimeException("Session is expired, Please login again");
        else if (!session.getUserId().equals(userId)) {
          throw new RuntimeException("User Not Authorized, Please signout and signin again");
        }
      }
      // Continue the request
      chain.doFilter(request, response);
    }

    // Post-processing logic (optional)
  }

  @Override
  public void destroy() {
    // Cleanup code, if needed
  }
}
