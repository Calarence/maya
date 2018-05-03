package com.appleieye.maya.cases;

import com.appleieye.maya.config.TestConfig;
import com.appleieye.maya.model.InterfaceName;
import com.appleieye.maya.model.LoginCase;
import com.appleieye.maya.utils.ConfigureFile;
import com.appleieye.maya.utils.DatabaseUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

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

        String result = getResult(loginCase);
        assertEquals(loginCase.getExpected(),result);
    }



    @Test(groups = "loginFalse")
    public void loginFalse() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        String result = getResult(loginCase);
        assertEquals(loginCase.getExpected(),result);

    }

    private String getResult(LoginCase loginCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        JSONObject param = new JSONObject();
        param.put("username",loginCase.getUsername());
        param.put("password",loginCase.getPassword());

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();
        return result;
    }
}
