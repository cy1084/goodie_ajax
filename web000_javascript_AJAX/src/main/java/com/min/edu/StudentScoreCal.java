package com.min.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * 화면에서 요청받은 값을 계산하여 JSON 형태의 문자열로 Rest 처리
 */
public class StudentScoreCal extends HttpServlet {

	private static final long serialVersionUID = 3682372734955241606L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 화면에서 요청을 받을 때 encoding 처리
		req.setCharacterEncoding("UTF-8");

		resp.setContentType("text/html; charset=UTF-8"); // MIME TYPE
		// text 던질건데, html로 읽었으면 좋겠고 문자 타입은 UTF-8로 보내주세여
		// 응답으로 보낼 때의 encoding 처리와 MIME을 선언

		// javascript에서 AJAX를 통해서 데이터를 요청 받는 GET

		System.out.println("화면에서 요청받은 GET");

		// name, kor, eng, math
		String name = req.getParameter("name");
		String kor = req.getParameter("kor");
		String eng = req.getParameter("eng");
		String math = req.getParameter("math");

		System.out.printf("요청받은 request 값: %s %s %s %s\n", name, kor, eng, math);

		// 평균
		int sum = Integer.parseInt(math) + Integer.parseInt(kor) + Integer.parseInt(eng);
		double avg = Math.round(sum / 3d);

		// => 값 전달(response): JSON 형태로 전달
		resp.getWriter().print("{\"avg\":\"" + avg + "\"}");

		// => 값 전달(response): JSON을 만들어 주는 객체 json-Simple.jar, GSON.jar, jackson-bind.jar
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("sum", sum);
		obj.put("avg", avg);
		resp.getWriter().print(obj.toJSONString()); 

		// 1) WS에 페이지(HTML)를 요청
		// resp.sendRedirect("./index.jsp");

		// 2) HTML이 아닌, 값 전달(text)
		// resp.getWriter().print("안녕하세요");

		// 3) 값 전달(JSON)
		// resp.getWriter().println("{\"isc\":\"true\"}");

	}

}
