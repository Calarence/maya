package com.appleieye.maya.dal.user;

import java.math.BigDecimal;
import java.util.Date;

import com.ximalaya.xmen.cable.commons.base.BaseObject;
/**
 * 实体对象
 * @author		clarence
 * @create		2018-04-12 17:19:51
 */
public abstract class BaseUserDO extends  BaseObject  implements java.io.Serializable {
	/**
	 * 
	 */
	protected Integer id;

	/**
	 * 姓名
	 */
	protected String name;

	/**
	 * 年龄
	 */
	protected Integer age;

	/**
	 * 性别
	 */
	protected Integer sex;

	/**
	 * 创建时间
	 */
	protected Date createtime;

	/**
	 * 最后更新时间
	 */
	protected Date updatettime;

	/**
	 * 取得 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 取得 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取得 年龄
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * 设置 年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * 取得 性别
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * 设置 性别
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * 取得 创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * 设置 创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 取得 最后更新时间
	 */
	public Date getUpdatettime() {
		return updatettime;
	}

	/**
	 * 设置 最后更新时间
	 */
	public void setUpdatettime(Date updatettime) {
		this.updatettime = updatettime;
	}

}