/**
 * 
 */
package com.appleieye.maya.dal.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.OptimisticLockingFailureException;

import com.ximalaya.xmen.cable.commons.mybatis.MybatisBaseDAOImpl;
import com.ximalaya.xmen.cable.commons.pagination.Page;

/**
 * 访问接口抽象实现
 * @author		clarence
 * @create		2018-04-12 17:19:51
 */
public abstract class BaseUserDAOImpl implements UserDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="mayaMybatisTemplate")
	protected MybatisBaseDAOImpl mybatisTemplete;

	@Override
	public Integer insert(UserDO eo) {
		if(eo.getId()!=null){
			mybatisTemplete.insert("BaseUserDAO.insertHasId", eo);
		}else{
			mybatisTemplete.insert("BaseUserDAO.insert", eo);
		}

        return eo.getId();
	}

	@Override
	public void batchInsert(List<UserDO> eoList, boolean generateKey) {
		if(generateKey){
			mybatisTemplete.insert("BaseUserDAO.batchInsert", eoList);
			
		}else{
			mybatisTemplete.insert("BaseUserDAO.batchInsertHasId", eoList);
			
		}
	}

	@Override
	public int update(UserDO eo) {
		int update = mybatisTemplete.update("BaseUserDAO.update", eo);
		
		if (update == 0) {
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		
		
		return update;
	}
	
	@Override
	public int updateByField(UserDO oldObj, UserDO newObj) {
        Map<String, UserDO> paramMap = new HashMap<String, UserDO>();
        paramMap.put("condition", oldObj);
        paramMap.put("template", newObj);

		return mybatisTemplete.update("BaseUserDAO.updateByField", paramMap);
	}
	
	@Override
	public void batchUpdate(List<UserDO> eoList) {
		mybatisTemplete.updateBatch("BaseUserDAO.update", eoList);
	}

	@Override
	public int delete(UserDO eo) {
		int delete = mybatisTemplete.delete("BaseUserDAO.delete", eo);
		
		return delete;
	}

	@Override
	public UserDO select(Integer id) {
		return select(id,false);
	}
	
	@Override
	public UserDO selectAndLock(Integer id) {
		return select(id,true);
	}
	
	public UserDO select(Integer id, boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("isLock", isLock);
		return (UserDO) mybatisTemplete.queryForObject("BaseUserDAO.select", paramMap);
	}
	
	
	@Override
	public UserDO selectByEO(UserDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return (UserDO) mybatisTemplete.queryForObject("BaseUserDAO.selectEOByEO", paramMap);
	}
	
	@Override
	public int countByEO(UserDO eo) {
		Integer count = (Integer)mybatisTemplete.queryForObject("BaseUserDAO.countByEO", eo);
		return count!=null?count:0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDO> selectListByEO(UserDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return mybatisTemplete.queryForList("BaseUserDAO.selectEOByEO", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserDO> selectListByIdList(List<Integer> idList,boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("idList", idList);
		paramMap.put("isLock", isLock);
		return mybatisTemplete.queryForList("BaseUserDAO.selectListByIdList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserDO> selectListByEO(UserDO eo,int pageNO,int pageSize) {
		Page<UserDO> page = new Page<UserDO>();
		page.setPageNo(pageNO);
		page.setPageSize(pageSize);
		
		page = queryForPage(eo, page);
		
		return page.getResult();
	}
	
    @Override
    public Page<UserDO> queryForPage(UserDO eo, Page<UserDO> page){
    	return mybatisTemplete.queryForPage("BaseUserDAO.selectEOByEO", eo, page);
    }
}
