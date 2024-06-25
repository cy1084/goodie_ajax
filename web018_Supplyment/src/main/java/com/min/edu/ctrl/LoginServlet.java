package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.model.IUserInfoDao;
import com.min.edu.model.UserInfoDaoImpl;
import com.min.edu.vo.UserInfoVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 3828164570372890792L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LoginServlet 로그인");
		
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		
		log.info("요청받은 값: {}/{}",id,pw);
		
		IUserInfoDao dao=new UserInfoDaoImpl();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", id);
		map.put("pw", pw);
		UserInfoVo vo=dao.login(map);
		
		log.info("로그인된 정보: {}",vo);
		
		HttpSession session= req.getSession();
		session.setAttribute("loginVo", vo); //세션에 담음
		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
		
	}

}
