//값 처리 시 인코딩 문제가 생기는 경우-> encodeURIComponent();
function getParameter() {
	var name = document.getElementById("name").value;
	var kor = document.getElementById("kor").value;
	var eng = document.getElementById("eng").value;
	var math = document.getElementById("math").value;

	var returnValue = `name=${name}&kor=${kor}&eng=${eng}&math=${math}`;
	console.log(returnValue);

	return returnValue;
}
/**
 * AJAX(Asyncronized Javascript And Xml) 비동기식처리
 * XMLHttpRequest: javascript에서 Object를 통한 HTTP 데이터 송수신이 가능하도록 만들어주는 객체
 * 
 * state(작동의 진행 0~4)/ status(작동 후 상태 code 200, 404, 401, 403, 500, 505,,: 완료된 정상적 성공은 200)
 * 
 * callback을 발생시켜주는 함수 <= callback 함수를 만들어 리터럴로 사용하면 됨
 * 
 * onreadystatechange: 상태 정보의 callback 실행 함수
 * - readystate
 * 	 0. uninitialized: 실행(load)이 되어있지 않음
 *   1. loading: 로드단계 
 *   2. loaded: 로드완료
 *   3. interactive: 통신완료(응답 값 처리)
 *   4. complete: 완료
 * 
 * - 각 상태를 표현해주는 code: status code -> onreadystatechange에 의해 실행되는 callback 함수에 의해 확인
 * 	 200: 성공
 * 	 404: 요청 페이지 혹은 프로토콜이 없다
 * 	 403: forbidden 미인가 접근(서버에서 해당 ip를 차단했을 경우)
 *   500: 서버사이드 문제
 */


window.onload = function() {
	//AJAX GET 방식
	document.getElementById("process1").onclick = function(event) {
		event.preventDefault();
		ajaxLoad();
	}
	//AJAX POST 방식
	document.getElementById("process2").onclick = function(event) {
		event.preventDefault();
		ajaxLoad2();
	}
}