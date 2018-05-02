package com.appleieye.maya.cases;

import com.appleieye.maya.config.TestConfig;
import com.appleieye.maya.model.AddUserCase;
import com.appleieye.maya.utils.DatabaseUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.annotations.Test;
import sun.security.timestamp.TSRequest;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * @author: wujianjun
 * @date:
 * @description:
 */

public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue")
    public void addUser() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSession();
        AddUserCase addUserCase = sqlSession.selectOne("addUserCase",1);
        System.out.println(addUserCase);
        System.out.println(TestConfig.addUserUrl);

        String result = getResult(addUserCase);
        assertEquals(addUserCase.getExpected(),result);


    }


    public String getResult(AddUserCase addUserCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("username","haha");
        param.put("password","1234");
        param.put("age","19");
        param.put("sex","男");
        param.put("permission","1");
        param.put("isDelete","1");

        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        post.setHeader("content-type","application/json");

        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        String  result;
        HttpResponse response  = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        return result;

    }

}
