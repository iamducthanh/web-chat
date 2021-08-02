package com.webchat.webchat.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
    public static SessionUtil sessionUtil = null;

    public static SessionUtil getSessionUtil(){
        if(sessionUtil == null){
            return new SessionUtil();
        }
        return sessionUtil;
    }

    public void addObject(HttpServletRequest req, String key, Object value){
        req.getSession().setAttribute(key, value);
    }

    public Object getObject(HttpServletRequest req, String key){
        return req.getSession().getAttribute(key);
    }

    public void removeObject(HttpServletRequest req, String key){
        req.getSession().removeAttribute(key);
    }

}
