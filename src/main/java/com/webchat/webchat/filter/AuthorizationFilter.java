package com.webchat.webchat.filter;

import com.webchat.webchat.entities.User;
import com.webchat.webchat.utils.SessionUtil;
import org.springframework.stereotype.Component;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class AuthorizationFilter implements Filter {
//    private final static Logger LOG = LoggerFactory.getLogger(AuthorizationFilter.class);

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
//        LOG.info("Initializing filter :{}", this);
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//        User user = (User) SessionUtil.getSessionUtil().getObject(req, "USER");
//        if(user != null){
            chain.doFilter(request, response);
//        } else {
//            res.sendRedirect(req.getContextPath() + "/signin");
//        }
    }

    @Override
    public void destroy() {
//        LOG.warn("Destructing filter :{}", this);
    }
}
