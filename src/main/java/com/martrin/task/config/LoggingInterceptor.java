package com.martrin.task.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Log request details
        String requestURL = request.getRequestURL().toString();
        String requestMethod = request.getMethod();
        String queryString = request.getQueryString();
        // Log request parameters if needed
        // String parameterName = request.getParameter("parameterName");

        // Log request details
        System.out.println("Request URL: " + requestURL);
        System.out.println("Request Method: " + requestMethod);
        System.out.println("Query String: " + queryString);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Log response details
        int responseStatus = response.getStatus();
        // Log response content if needed
        // String responseBody = ...;

        // Log response details
        System.out.println("Response Status: " + responseStatus);
    }
}
