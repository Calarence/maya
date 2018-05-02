package com.appleieye.maya.cases;

import com.appleieye.maya.config.TestConfig;
import com.appleieye.maya.model.AddUserCase;
import com.appleieye.maya.utils.DatabaseUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

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
    }
}
