package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.min.edu.model.IUserInfoDao;
import com.min.edu.model.UserInfoDaoImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginAjaxServlet extends HttpServlet {

	private static final long serialVersionUID = -3886885719485452912L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("로그인 여부 Ajax 처리");
		
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		
		log.info("요청받은 전달 값:{}/{}",id,pw);
		
		IUserInfoDao dao=new UserInfoDaoImpl();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", id);
		map.put("pw", pw);
		boolean isc= (dao.login(map)==null)?false:true;
		
		//resp.getWriter().print("{\"isc\":\"true\"}");
		
		JSONObject json=new JSONObject();
		json.put("isc", isc);
		
		resp.getWriter().print(json.toJSONString());
	}

}
