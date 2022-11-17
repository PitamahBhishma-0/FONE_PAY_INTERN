package com.gaurav.quoraapp.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
@Component
@Order(1)
public class LoggerFilterRequestResponse implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest servletRequest= (HttpServletRequest) request;
        log.info("Request URI {}",servletRequest.getRequestURI());

        log.info("Request name {}",servletRequest.getMethod());
        log.info("Request Body {}",servletRequest.getInputStream().toString());
  chain.doFilter(request,response);
        HttpServletResponse servletResponse= (HttpServletResponse) response;
    }
}
