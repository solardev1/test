package com.martrin.task.config;

import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestResponseLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Log the request
        logRequest(request);

        // Proceed with the filter chain
        filterChain.doFilter(request, response);

        // Log the response
        logResponse(response);
    }

    private void logRequest(HttpServletRequest request) {
        // Log request details as needed
        // For example:
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Request Method: " + request.getMethod());
        // You can log more details such as headers, parameters, etc.
    }

    private void logResponse(HttpServletResponse response) {
        // Log response details as needed
        // For example:
        System.out.println("Response Status: " + response.getStatus());
        // You can log more details such as headers, response body, etc.
    }
}
