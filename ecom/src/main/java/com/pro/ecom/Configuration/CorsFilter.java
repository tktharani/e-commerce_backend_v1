package com.pro.ecom.Configuration;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
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

        // Allow requests from all origins (you can refine this if needed)
        response.setHeader("Access-Control-Allow-Origin", "*");

        // Allow specific HTTP methods
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

        // Allow specific headers
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        // Handle pre-flight OPTIONS requests
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
