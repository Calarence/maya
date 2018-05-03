package com.appleieye.maya.cases;

import com.appleieye.maya.config.TestConfig;
import com.appleieye.maya.model.GetUserListCase;
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
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author: wujianjun
 * @date:2018-05-02
 * @description:
 */

public class GetUserListTest {

    @Test(dependsOnGroups = "loginTrue")
    public void getUserList() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSession();
        GetUserListCase getUserListCase = sqlSession.selectOne("getUserListCase",1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);

        JSONArray resultJson = getResult(getUserListCase);

        List<User> userList = sqlSession.selectList("getUserList",getUserListCase);
        JSONArray userListJson = new JSONArray(userList);
        assertEquals(userListJson.length(),resultJson.length());

        for (int i = 0;i<resultJson.length();i++){
          JSONObject   actual = (JSONObject) userListJson.get(i);
          JSONObject expect = (JSONObject) resultJson.get(i);
            assertEquals(expect.toString(),actual.toString());
        }

    }

    private JSONArray getResult(GetUserListCase getUserListCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        JSONObject param = new JSONObject();
        param.put("username",getUserListCase.getUsername());
        param.put("sex",getUserListCase.getSex());

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        HttpResponse response = TestConfig.defaultHttpClient.execute(post);

        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        JSONArray jsonArray = new JSONArray(result);
        return jsonArray;

    }


//    @Test(dependsOnGroups = "loginTrue")
//    public void getUserInfo() throws IOException {
//        SqlSession sqlSession = DatabaseUtils.getSession();
//        GetUserInfoCase userInfo = sqlSession.selectOne("getUserInfo",1);
//        System.out.println(userInfo.toString());
//        System.out.println(TestConfig.getUserInfoUrl);
//    }




}
