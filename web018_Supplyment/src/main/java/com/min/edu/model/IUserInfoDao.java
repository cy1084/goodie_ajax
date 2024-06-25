package com.min.edu.model;

import java.util.Map;

import com.min.edu.vo.UserInfoVo;

//TODO 002 기능을 정의
public interface IUserInfoDao {
/*
 * 로그인 정보를 화면에서 입력받아, Map의 객체로 입력하면 UserInfoVo를 반환
 */
	
	public UserInfoVo login(Map<String,Object> map);
}
