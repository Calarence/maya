package com.appleieye.maya.cases;

import com.appleieye.maya.config.TestConfig;
import com.appleieye.maya.model.GetUserInfo;
import com.appleieye.maya.model.GetUserListCase;
import com.appleieye.maya.utils.ConfigureFile;
import com.appleieye.maya.utils.DatabaseUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author: wujianjun
 * @date:2018-05-02
 * @description:
 */

public class GetUserListTest {

    @Test(dependsOnGroups = "loginTrue")
    public void getUserList() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSession();
        GetUserListCase getUserListCase = sqlSession.selectOne("getUserList",1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);
    }

    @Test(dependsOnGroups = "loginTrue")
    public void getUserInfo() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSession();
        GetUserInfo userInfo = sqlSession.selectOne("getUserInfo",1);
        System.out.println(userInfo.toString());
        System.out.println(TestConfig.getUserInfoUrl);

    }
}
