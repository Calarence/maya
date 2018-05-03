package com.appleieye.maya.cases;

import com.appleieye.maya.config.TestConfig;
import com.appleieye.maya.model.GetUserInfoCase;
import com.appleieye.maya.model.User;
import com.appleieye.maya.utils.DatabaseUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author: wujianjun
 * @date: 2018-05-03
 * @description:
 */

public class GetUserInfoTest {

    @Test(dependsOnGroups = "loginTrue")
    public void getUserInfo() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSession();
        GetUserInfoCase userInfo = sqlSession.selectOne("getUserInfo",1);
        System.out.println(userInfo.toString());
        System.out.println(TestConfig.getUserInfoUrl);

        User user = sqlSession.selectOne(userInfo.getExpected(),userInfo);
        List userList = new ArrayList();
        userList.add(user);
        JSONArray userListJson = new JSONArray(userList);
        JSONArray jsonArray = getResult(userInfo);
        assertEquals(jsonArray.toString(),userListJson.toString());

    }

    private JSONArray getResult(GetUserInfoCase userInfo) throws IOException {

        HttpPost post = new HttpPost();
        JSONObject param = new JSONObject();
        param.put("userId",userInfo.getUserId());

        post.setHeader("content-type","application/json");
        StringEntity entity = new  StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        HttpResponse response = TestConfig.defaultHttpClient.execute(post);

        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        JSONArray jsonArray = new JSONArray(result);
        return jsonArray;

    }
}
