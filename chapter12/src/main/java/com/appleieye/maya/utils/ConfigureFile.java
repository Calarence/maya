package com.appleieye.maya.utils;

import com.appleieye.maya.model.InterfaceName;
import org.omg.CORBA.StringHolder;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author: wujianjun
 * @date: 2018-05-02
 * @description:
 */

public class ConfigureFile {

    private static  ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String baseUrl = bundle.getString("base.url");
        String uri = "";
        if (InterfaceName.ADDUSERINFO == name){
            uri = bundle.getString("addUser.uri");
        }
        if (InterfaceName.GETUSERINFO == name){
            uri = bundle.getString("getUserInfo.uri");
        }
        if (InterfaceName.GETUSERLIST == name){
            uri = bundle.getString("getUserList.uri");
        }
        if (InterfaceName.UPDATEUSERINFO == name){
            uri = bundle.getString("updateUserInfo.uri");
        }
        if (InterfaceName.LOGIN == name){
            uri = bundle.getString("login.uri");
        }

        return baseUrl + uri;
    }


}
