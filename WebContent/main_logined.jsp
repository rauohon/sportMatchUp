<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<link rel="stylesheet" href="css/page.css">
<!-- <link rel="stylesheet" href="css/style.css"> -->
<link rel="stylesheet" href="css/style2.css">
<!-- <link rel="stylesheet" href="css/style3.css"> -->

<link rel="stylesheet" href="fontello/css/fontello.css">
<!-- 네비 자바스크립트 모음 -->
<!-- <script src="js/navi.js" type="text/javascript" charset="UTF-8"></script> -->


<script src="https://code.jquery.com/jquery-2.2.4.min.js" 
integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
crossorigin="anonymous"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 네이게이션 function 모음    -->
<script>

//내 정보 
function memberInfo() {
	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "memberinfo";
	f.action = "MemberInfo";
	f.method = "post";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid}";
	f.appendChild(i);
	/* i.style.display="none"; */
	document.memberinfo.submit();
}

//내 메세지함 
function messageReceiveInfo(){
	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "messagereceiveinfo";
	f.action = "MessageReceiveInfo";
	f.method = "post";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid}";
	f.appendChild(i);
	/* i.style.display="none"; */
	document.messagereceiveinfo.submit();

}


// 메인 페이지로 이동  위치: 홈으로 + 로고 
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
// 	document.gotomain.submit();
}

//로그아웃 	 	위치: 우측 끝 
function accessOut() {
	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "accessout";
	f.action = "AccessOut";
	f.method = "get";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid}";
	f.appendChild(i);
	/* i.style.display="none"; */
	document.accessout.submit();
}


//회원탈퇴

function memberDrop(){
	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "memberdrop";
	f.action = "MemberDrop";
	f.method = "get";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid}";
	f.appendChild(i);
	/* i.style.display="none"; */
	document.memberdrop.submit();
}
//내정보 --> 패스워드 재입력 페이지
function pwCheckPage(){
	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "pwcheckpage";
	f.action = "PwCheckPage";
	f.method = "post";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid}";
	f.appendChild(i);
	/* i.style.display="none"; */
	document.pwcheckpage.submit();

}


//??? 메세지 인포
function messageInfo(){
	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "messageinfo";
	f.action = "MessageInfo";
	f.method = "post";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid}";
	f.appendChild(i);
	/* i.style.display="none"; */
	document.messageinfo.submit();

}



function browser_close() {

	accessOut();
	return "이 페이지 나가기를 누르시면 로그아웃이 됩니다.";
}


//message 페이지 전용 


//메세지 쓰기 페이지 이동
function messageSendPage(){
	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "messagesendpage";
	f.action = "MessageSendPage";
	f.method = "post";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid}";
	f.appendChild(i);

	document.messagesendpage.submit();
}

//내게 메세지 쓰기
function messageToMeSendPage(){
	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "messagesendpage";
	f.action = "MessageSendPage";
	f.method = "post";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid}";
	i.type = "hidden";
	i.name = "remmid";
	i.value = "${mmid}";
	f.appendChild(i);

	document.messagetomesendpage.submit();
}

//보낸 메세지 보기
function messageSent(){
	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "messagesent";
	f.action = "MessageSent";
	f.method = "post";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid}";
	f.appendChild(i);

	document.messagesent.submit();
}

//회원 지역 수정 
function memberLcUpdatePage(){

	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "memberlcupdatepage";
	f.action = "MemberLcUpdatePage";
	f.method = "post";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid}";
	f.appendChild(i);
	document.memberlcupdatepage.submit();
}



//프로필 수정 
function memberInfoProfile(){
	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "memberinfoprofile";
	f.action = "MemberInfoProfile";
	f.method = "post";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid}";
	f.appendChild(i);
	/* i.style.display="none"; */
	document.memberinfoprofile.submit();
}

// 태휘형이 주신 function 아마 문제없다함

function mymatchinfo() {
	
	var f = document.createElement("form");
	var i = document.createElement("input");
	f.name = "mymatchinfo";
	f.action = "MyMatchInfo";
	f.method = "post";
	document.body.appendChild(f);

	i.type = "hidden";
	i.name = "mmid";
	i.value = "${mmid }";
	f.appendChild(i);
	
      document.mymatchinfo.submit();
   }
   function matchinsertpage() {

      makefoda("matchInsertPage", "MatchInsertPage", "");

      document.matchInsertPage.submit();
   }   
   function matchpage() {

      makefoda("matchPage", "MatchPage", "");

      document.matchPage.submit();
   }
   function matchapply(rqid) {

      makefoda("matchApply", "MatchApply", rqid);

      document.matchApply.submit();
   }
   function matchrejectapplier(rqidacid) {

      makefoda("matchRejectApplier", "MatchRejectApplier", rqidacid);

      document.matchRejectApplier.submit();
   }
   function matchapplierfix(rqidacid) {

      makefoda("matchApplierFix", "MatchApplierFix", rqidacid);

      document.matchApplierFix.submit();
   }
   function matchfix(rqid) {

      makefoda("matchFix", "MatchFix", rqid);

      document.matchFix.submit();
   }
   function matchapplypage(rqid) {
      //       alert(rqid + ": Rqid");

      makefoda("matchApplyPage", "MatchApplyPage", rqid);

      document.matchApplyPage.submit();
   }
   function makefoda(formName, actionName, data) {

      var sdata = data.split(":");
      
      // form 만드는 변수
      var f = document.createElement("form");
      // mmid 만드는 변수
      var mi = document.createElement("input");
      // rqid 만드는 변수
      var ri = document.createElement("input");
      // acid 만드는 변수
      var ai = document.createElement("input");

      f.name = formName;
      f.action = actionName;
      f.method = "post";
      document.body.appendChild(f);

      mi.type = "hidden";
      mi.name = "mmid";
      mi.value = "${mmid }";

      f.appendChild(mi);

      ri.type = "hidden";
      ri.name = "rqid";
      ri.value = sdata[0];

      f.appendChild(ri);
      
      ai.type = "hidden";
      ai.name = "acid";
      ai.value = sdata[1];

      f.appendChild(ai);

   }

</script>
<!-- 네이게이션 function 모음    -->

</head>

<body ><!-- onBeforeunload="return browser_close() -->
	<script src="http://cdn.jsdelivr.net/mojs/latest/mo.min.js"></script>


	<!-- navigator 시작 -->
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" onClick="goToMain()">Match Now</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a onClick="goToMain()">HOME</a></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown">마이페이지 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a onClick="pwCheckPage()">내 정보</a></li>
							<li><a onClick="mymatchinfo()">내 매치 정보</a></li>
							<li><a onClick="messageReceiveInfo()">메세지함</a></li>
							<li><a onClick="accessOut()">로그아웃</a></li>
						</ul></li>


					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">매치보드 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a onClick="matchpage()">매치보드</a></li>
							<li><a onClick="matchinsertpage()">매치신청</a></li>
							<li><a onClick="mymatchinfo()">매치 신청 관리</a></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">커뮤니티 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">공지사항</a></li>
							<li><a href="#">자유게시판</a></li>
							<li><a href="#">국내축구소식</a></li>
							<li><a href="#">해외축구소식</a></li>
							<li><a href="#">축구동영상</a></li>
							<li><a href="#">축구갤러리</a></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">경기장 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">경기장 안내</a></li>
						</ul></li>
					<li><a href="launch/commingsoon.html">SHOP</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a onClick = "pwCheckPage()"><span
							class="glyphicon glyphicon-user"></span> ${mmid } 님</a></li>
					<li><a onClick= "accessOut()"><span
							class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- navigator 끝 -->
		

	<article>
		<div class="content">최적의 매치 시스템을 통해 스포츠매니아들의 경기 매치를 성사하여 최고의 경기를 즐길
		수 있는 서비스를 제공해 드리겠습니다 
		<font style = "color :red;">${message }</font></div>
	</article>
	
	
	
	
	<div class="music_play">
		<nav>
			<ul>
				<li><a href="#">page1</a></li>
				<li><a href="#">page2</a></li>
			</ul>
		</nav>
		<ul class="player">
			<li><a href="#play" class="play icon-play"><span>play</span></a></li>
			<li><a href="#stop" class="pause icon-pause"><span>pause</span></a></li>
		</ul>
	</div>
	
</body>
<script src="page.js"></script>
</html>