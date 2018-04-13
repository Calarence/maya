package com.appleieye.maya.dal.user;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ximalaya.xmen.cable.commons.utils.DateTimeUtils;

/**
 * 访问接口单元测试类
 * @author		clarence
 * @create		2018-04-12 17:19:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:ctx-maya-test.xml" })
@ContextConfiguration(locations = "classpath:ctx-maya-dal.xml")
public class UserDAOTest extends BaseUserDAOTest{


}
