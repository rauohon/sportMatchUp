<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function access() {
	var f = document.createElement("form");
	f.name = "access";
	f.action = "Access";
	f.method = "get";
	document.body.appendChild(f);

	f.appendChild(i);
	/* i.style.display="none"; */
	document.access.submit();
}

function goToMain() {
	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "gotomain";
	f.action = "GoToMain";
	f.method = "post";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid}";
	f.appendChild(i);
	/* i.style.display="none"; */
	document.gotomain.submit();
}
</script>
</head>
<body>

<!-- navigator 시작-->
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="main.jsp">Match Now</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="main.jsp">HOME</a></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="login.jsp">마이페이지 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="login.jsp">회원가입</a></li>
							<li><a href="login.jsp">로그인</a></li>
						</ul></li>


					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="login.jsp">매치보드 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="login.jsp">매치보드</a></li>
							<li><a href="login.jsp">매치신청</a></li>
							<li><a href="login.jsp">매치 신청 관리</a></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="login.jsp">커뮤니티 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="login.jsp">공지사항</a></li>
							<li><a href="login.jsp">자유게시판</a></li>
							<li><a href="login.jsp">국내축구소식</a></li>
							<li><a href="login.jsp">해외축구소식</a></li>
							<li><a href="login.jsp">축구동영상</a></li>
							<li><a href="login.jsp">축구갤러리</a></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="login.jsp">경기장 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="login.jsp">경기장 안내</a></li>
						</ul></li>
					<li><a href="launch/commingsoon.html">SHOP</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.jsp"><span
							class="glyphicon glyphicon-user"></span> 회원가입</a></li>
					<li><a href="login.jsp"><span
							class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- navigator 끝 -->
</body>
</html>