package com.appleieye.maya.cases;

import com.appleieye.maya.config.TestConfig;
import com.appleieye.maya.model.UpdateUserInfoCase;
import com.appleieye.maya.model.User;
import com.appleieye.maya.utils.DatabaseUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * @author: wujianjun
 * @date: 2018-05-02
 * @description:
 */

public class UpdateUserTest {

    @Test(dependsOnGroups = "loginTrue")
    public void updateUser() throws IOException, InterruptedException {
        SqlSession sqlSession = DatabaseUtils.getSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase",1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);

        int result = getResult(updateUserInfoCase);
        User user = sqlSession.selectOne("getUpdateUserInfo",updateUserInfoCase);
//        Assert.assertNotNull(result);

        assertEquals(1,result);


    }

    private Integer getResult(UpdateUserInfoCase updateUserInfoCase) throws IOException, InterruptedException {
        HttpPost post = new HttpPost(TestConfig.updateUserInfoUrl);
        JSONObject param = new JSONObject();

        param.put("id",updateUserInfoCase.getUserId());
        param.put("username",updateUserInfoCase.getUsername());
        param.put("sex",updateUserInfoCase.getSex());
        param.put("age",updateUserInfoCase.getAge());
        param.put("password",updateUserInfoCase.getPassword());
        param.put("isDelete",updateUserInfoCase.getIsDelete());
        param.put("permission",updateUserInfoCase.getPermission());

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        Thread.sleep(10000);
        return Integer.parseInt(result);

    }
}
