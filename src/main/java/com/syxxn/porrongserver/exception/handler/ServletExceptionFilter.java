package com.syxxn.porrongserver.exception.handler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.syxxn.porrongserver.exception.response.ErrorResponse;
import org.springframework.web.filter.OncePerRequestFilter;

public class ServletExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (GlobalException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage());
            response.setStatus(e.getStatusCode());
            response.setContentType("application/json");
            response.getWriter().write(errorResponse.toString());
        }
    }

}
