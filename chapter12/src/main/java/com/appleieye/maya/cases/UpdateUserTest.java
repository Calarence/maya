package com.appleieye.maya.cases;

import com.appleieye.maya.config.TestConfig;
import com.appleieye.maya.model.UpdateUserInfoCase;
import com.appleieye.maya.utils.DatabaseUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author: wujianjun
 * @date: 2018-05-02
 * @description:
 */

public class UpdateUserTest {

    @Test(dependsOnGroups = "loginTrue")
    public void updateUser() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase",1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);

    }
}
