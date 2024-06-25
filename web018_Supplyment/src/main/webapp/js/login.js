document.addEventListener("DOMContentLoaded", () => {
	document.querySelectorAll("button")[0].onclick = function(e) {
		e.preventDefault();

		var id = document.getElementById("id");
		var pw = document.getElementById("pw");

		if (id.value == "" || pw.value == "") {
			alert("아이디와 비밀번호는 필수값입니다.");
		} else {
			document.forms[0], submit();
		}
	}//일반 로그인


	document.querySelectorAll("button")[1].onclick = function(e) {
		e.preventDefault();

		console.log("Ajax 로그인");

		var id = document.getElementById("id");
		var pw = document.getElementById("pw");

		/** form 이름으로*/
		var frm = document.loginForm;

		/**유효성 검사 */
		if (id.value == "" || id.value.trim() == "") {
			//alert("잘못된 아이디입니다.");
			document.getElementById("notMember").innerHTML
				= "<span style='color:red;'>아이디 입력은 필수입니다.</span>";
			id.value = "";
			id.focus();
		} else if (pw.value == "" || pw.value.trim() == "") {
			//alert("잘못된 비밀번호입니다.");
			document.getElementById("notMember").innerHTML
				= "<span style='color:red;'>비밀번호 입력은 필수입니다.</span>";
			pw.value = "";
			pw.focus();
		} else {
			$.ajax({
				url: "./loginCheckAjax.do", //요청 주소
				type: "post", //요청 프로토콜

				//data:"id="+id+"&pw="+pw //queryString 방식

				data: { "id": id.value, "pw": pw.value }, //json 방식의 서버 전달 값
				dataType: "json", //json으로 형 변환 후 가져옴, 서버에서 반환된 결과의 반환 타입
				success: function(msg) { //msg는 서버에서 json 형태로 전달된 값! state 4, status 200인 경우
					console.log(typeof msg, msg.isc);

					if (msg.isc == true) {
						frm.submit();
					} else {
						document.getElementById("notMember").innerHTML
							= "<span style='color:red;'>로그인 정보가 없습니다.</span>";

					}
				},
				error: function() {
					alert("잘못된 요청 처리입니다.");
				}
			});
		}


	}
});