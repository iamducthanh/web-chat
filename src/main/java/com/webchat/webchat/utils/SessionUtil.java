package com.webchat.webchat.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class SessionUtil {
    @Autowired
    private HttpServletRequest req;

    public void addObject(String key, Object value){
        req.getSession().setAttribute(key, value);
    }

    public Object getObject(String key){
        return req.getSession().getAttribute(key);
    }

    public void removeObject(String key){
        req.getSession().removeAttribute(key);
    }

}
