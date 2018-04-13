package com.appleieye.maya.dal.user;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ximalaya.xmen.cable.commons.utils.DateTimeUtils;
import com.ximalaya.xmen.cable.commons.pagination.Page;

/**
 * 访问接口单元测试类
 * @author		clarence
 * @create		2018-04-12 17:19:51
 */
public abstract class BaseUserDAOTest{
	/**
	 * 系统日志输出句柄
	 */
	protected final Logger logger = LoggerFactory.getLogger(BaseUserDAOTest.class);

	/**
	 * 访问接口
	 */
    @Autowired
	protected UserDAO dao;

    protected Integer id;

    @Before
    public void setup() {
        testInsert();
    }

    @After
    public void clear() {
        //测试删除操作
        testDelete();
    }

	/**
	 * 测试插入操作
	 * @return
	 */
	private void testInsert() {
		// 构造对象
		UserDO insertAflEO = new UserDO();

		insertAflEO.setName(insertName);
		insertAflEO.setAge(insertAge);
		insertAflEO.setSex(insertSex);
		insertAflEO.setCreatetime(insertCreatetime);
		insertAflEO.setUpdatettime(insertUpdatettime);
		
		//执行插入
        id = dao.insert(insertAflEO);
		assertNotNull(id);
	}

	/**
	 * 测试查询操作
	 * @param id
	 * @param selectEO
	 * @return 
	 */
    @Test
	public void testSelect() {
		//执行查询
		UserDO selectEO = dao.select(id);
		
		//判断查询出的数据是否正确
		assertEquals(id,selectEO.getId());
		assertEquals(insertName,selectEO.getName().trim());
		assertEquals(insertAge,selectEO.getAge());
		assertEquals(insertSex,selectEO.getSex());
		assertEquals(insertCreatetime,selectEO.getCreatetime());
		assertEquals(insertUpdatettime,selectEO.getUpdatettime());
	}

    /**
     * 测试根据对象查询操作
     * @param selectEO
     * @return
     */
    @Test
    public void testSelectByEO() {
        UserDO eo = dao.select(id);
        UserDO selectEO = dao.selectByEO(eo);

        assertEquals(id,selectEO.getId());
        assertEquals(insertName,selectEO.getName().trim());
        assertEquals(insertAge,selectEO.getAge());
        assertEquals(insertSex,selectEO.getSex());
        assertEquals(insertCreatetime,selectEO.getCreatetime());
        assertEquals(insertUpdatettime,selectEO.getUpdatettime());
    }

    /**
     * 测试根据对象查询List操作
     * @param selectEO
     * @return
     */
    @Test
    public void testSelectListByEO() {
        UserDO eo = dao.select(id);
        List<UserDO> resultList = dao.selectListByEO(eo);

        assertEquals(1, resultList.size());
        UserDO selectEO = resultList.get(0);

            assertEquals(id,selectEO.getId());
        assertEquals(insertName,selectEO.getName().trim());
        assertEquals(insertAge,selectEO.getAge());
        assertEquals(insertSex,selectEO.getSex());
        assertEquals(insertCreatetime,selectEO.getCreatetime());
        assertEquals(insertUpdatettime,selectEO.getUpdatettime());
    }

    /**
     * 测试根据对象分页查询操作
     * @param selectEO
     * @return
    */
    @Test
    public void testQueryForPage() {
        UserDO eo = dao.select(id);
        Page<UserDO> page = new Page<UserDO>();
        page.setPageNo(1);
        page.setPageSize(10);
        Page<UserDO> resultPage = dao.queryForPage(eo, page);

        assertEquals(1, resultPage.getTotalCount());
        UserDO selectEO = resultPage.getResult().get(0);

        assertEquals(id,selectEO.getId());
        assertEquals(insertName,selectEO.getName().trim());
        assertEquals(insertAge,selectEO.getAge());
        assertEquals(insertSex,selectEO.getSex());
        assertEquals(insertCreatetime,selectEO.getCreatetime());
        assertEquals(insertUpdatettime,selectEO.getUpdatettime());
        }

	/**
	 * 测试更新操作
	 * @param id 被更新记录的主键
	 * @param selectEO 被更新的EO对象
	 */
    @Test
    public void testUpdate() {
        UserDO selectEO = dao.select(id);

		// 更改各个字段的值
		selectEO.setName(updateName);
		selectEO.setAge(updateAge);
		selectEO.setSex(updateSex);
		selectEO.setCreatetime(updateCreatetime);
		selectEO.setUpdatettime(updateUpdatettime);
		
		//执行更新操作
		int updateCount = dao.update(selectEO);
		assertEquals(1,updateCount);

        }
	
	/**
	 * 测试更新操作
	 * @param id 被更新记录的主键
	 * @param selectEO 被更新的EO对象
	 */
    @Test
    public void testUpdateField() {
        UserDO selectEO = dao.select(id);

		// 更改各个字段的值
		selectEO.setName(updateFieldName);
		selectEO.setAge(updateFieldAge);
		selectEO.setSex(updateFieldSex);
		selectEO.setCreatetime(updateFieldCreatetime);
		selectEO.setUpdatettime(updateFieldUpdatettime);

        UserDO old = new UserDO();
        old.setId(id);
	
		//执行更新操作
		int updateCount = dao.updateByField(old, selectEO);
		assertEquals(1,updateCount);
	}

	/**
	 * 测试删除操作
	 * @param id 被删除记录的主键
	 * @param selectEO 被删除的EO对象
	 */
	private void testDelete() {
        // 构造对象
        UserDO selectEO = new UserDO();
        selectEO.setId(id);

		// 执行删除操作
		dao.delete(selectEO);

        UserDO result = dao.select(id);

		assertNull(result);
	}


    //////////////////////////insert的初始数据//////////////////////////////////////////////////

    /**
     * 
     */
    private Integer insertId = new Integer("2147483647");

    /**
     * 姓名
     */
    private String insertName = "1";

    /**
     * 年龄
     */
    private Integer insertAge = new Integer("1");

    /**
     * 性别
     */
    private Integer insertSex = new Integer("1");

    /**
     * 创建时间
     */
    private Date insertCreatetime = DateTimeUtils.parse("2019-01-01 00:00:00");

    /**
     * 最后更新时间
     */
    private Date insertUpdatettime = DateTimeUtils.parse("2019-01-01 00:00:00");


    ////////////////////////////update的初始数据/////////////////////////////////////////////////

    /**
     * 姓名
     */
    private String updateName = "2";

    /**
     * 年龄
     */
    private Integer updateAge = new Integer("2");

    /**
     * 性别
     */
    private Integer updateSex = new Integer("2");

    /**
     * 创建时间
     */
    private Date updateCreatetime = DateTimeUtils.parse("2019-02-02 00:00:00");

    /**
     * 最后更新时间
     */
    private Date updateUpdatettime = DateTimeUtils.parse("2019-02-02 00:00:00");


////////////////////////////update field的初始数据/////////////////////////////////////////////////

    /**
     * 姓名
     */
    private String updateFieldName = "3";

    /**
     * 年龄
     */
    private Integer updateFieldAge = new Integer("3");

    /**
     * 性别
     */
    private Integer updateFieldSex = new Integer("3");

    /**
     * 创建时间
     */
    private Date updateFieldCreatetime = DateTimeUtils.parse("2019-03-03 00:00:00");

    /**
     * 最后更新时间
     */
    private Date updateFieldUpdatettime = DateTimeUtils.parse("2019-03-03 00:00:00");

}
