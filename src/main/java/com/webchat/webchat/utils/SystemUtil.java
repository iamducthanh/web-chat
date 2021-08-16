package com.webchat.webchat.utils;

import com.webchat.webchat.constant.UsersOnline;

public class SystemUtil {
    public static int findConnect(String room){
        for(int i = 0; i < UsersOnline.userConnect.size() ; i++){
            if(UsersOnline.userConnect.get(i).getRoom().equals(room)){
                return i;
            }
        }
        return -1;
    }
}
