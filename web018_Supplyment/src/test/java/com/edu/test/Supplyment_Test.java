package com.edu.test;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.database.SqlDaoSupport;
import com.min.edu.vo.UserInfoVo;

public class Supplyment_Test {

	@Test
	public void test() {
		SqlSessionFactory factory=SqlDaoSupport.getFactory();
		SqlSession session=factory.openSession();
		assertNotNull("SqlSessionFactory 객체 생성",session);
	}
	
	@Test
	public void login_test() {
		SqlSessionFactory factory=SqlDaoSupport.getFactory();
		SqlSession session=factory.openSession();
		
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("id","A001");
		map.put("pw","A001");
		UserInfoVo userInfoVo= session.selectOne("userinfo_statement.login",map);
		assertNotNull(userInfoVo);
		
	}

}
