package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.database.SqlDaoSupport;
import com.min.edu.vo.UserInfoVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserInfoDaoImpl implements IUserInfoDao {
	
	private SqlSessionFactory factory=SqlDaoSupport.getFactory();
	private final String NS="userinfo_statement."; //namespace 명
	
	@Override
	public UserInfoVo login(Map<String, Object> map) {
		log.info("로그인: {}",map);
		SqlSession session= factory.openSession();
		UserInfoVo userInfoVo= session.selectOne(NS+"login",map);
		
		return userInfoVo;
	}

}
