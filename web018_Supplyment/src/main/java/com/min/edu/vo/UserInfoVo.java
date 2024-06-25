package com.min.edu.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * TODO 001 회원의 정보를 담아서 사용하거나 가져갈 때 사용하는 자바
 */

@Data
@Getter
@Setter
@ToString
public class UserInfoVo {
	private String id;
	private String name;
	private String email;
	private String auth;
	private String enable;
	private String joinindate;
}
