package com.appleieye.maya.cases;

import com.appleieye.maya.config.TestConfig;
import com.appleieye.maya.model.InterfaceName;
import com.appleieye.maya.model.LoginCase;
import com.appleieye.maya.utils.ConfigureFile;
import com.appleieye.maya.utils.DatabaseUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.io.IOException;

/**
 * @author: wujianjun
 * @date:2018-05-02
 * @description:
 */

public class LoginTest {

    @BeforeTest(groups = "loginTrue")
    public void beforeTest(){
        TestConfig.addUserUrl = ConfigureFile.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.getUserInfoUrl = ConfigureFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.updateUserInfoUrl = ConfigureFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.getUserListUrl = ConfigureFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.loginUrl = ConfigureFile.getUrl(InterfaceName.LOGIN);

        TestConfig.defaultHttpClient = new DefaultHttpClient();

    }

    @Test(groups = "loginTrue")
    public void loginTrue() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

    }

    @Test(groups = "loginFalse")
    public void loginFalse() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
    }
}
