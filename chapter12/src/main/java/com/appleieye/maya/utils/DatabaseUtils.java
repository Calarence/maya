package com.appleieye.maya.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author: wujianjun
 * @date: 2018-05-02
 * @description:
 */

public class DatabaseUtils {

    public static SqlSession getSession() throws IOException {

        Reader reader = Resources.getResourceAsReader("database.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }

}
