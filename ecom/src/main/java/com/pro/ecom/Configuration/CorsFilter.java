package com.pro.ecom.Configuration;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Configuration
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic, if any
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Allow requests from specific origin (replace "http://example.com" with your actual origin)
        response.setHeader("Access-Control-Allow-Origin", "*");

        // Allow specific HTTP methods
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

        // Allow specific headers
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        // Allow credentials if needed
        // response.setHeader("Access-Control-Allow-Credentials", "true");

        // Set the maximum age for preflight requests (in seconds)
        // response.setHeader("Access-Control-Max-Age", "3600");

        // Handle preflight OPTIONS requests
        if ("OPTIONS".equals(request.getMethod())) {
            // Set response status to 200 OK
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // Proceed with the filter chain for non-OPTIONS requests
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        // Cleanup logic, if any
    }
}
