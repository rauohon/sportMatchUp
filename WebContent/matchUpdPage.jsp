<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경기 생성 페이지</title>
<link rel="stylesheet" href="css/page.css">
<link rel="stylesheet" href="css/style.css"> 
<link rel="stylesheet" href="css/style2.css">
 <!-- <link rel="stylesheet" href="css/style3.css">  -->

<link rel="stylesheet" href="fontello/css/fontello.css">
<!-- 네비 자바스크립트 모음 -->
<!-- <script src="js/navi.js" type="text/javascript" charset="UTF-8"></script> -->


<script src="https://code.jquery.com/jquery-2.2.4.min.js"
	integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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
		document.gotomain.submit();
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
		// 확인
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
	//확인
      makefoda("matchInsertPage", "MatchInsertPage", "");

      document.matchInsertPage.submit();
   }   
   function matchpage() {
	//확인
      makefoda("matchPage", "MatchPage", "");

      document.matchPage.submit();
   }
   function matchapply(rqid) {
	//확인
      makefoda("matchApply", "MatchApply", rqid);

      document.matchApply.submit();
   }
   function matchrejectapplier(rqidacid) {
	//확인
      makefoda("matchRejectApplier", "MatchRejectApplier", rqidacid);

      document.matchRejectApplier.submit();
   }
   function matchapplierfix(rqidacid) {
	//확인
      makefoda("matchApplierFix", "MatchApplierFix", rqidacid);

      document.matchApplierFix.submit();
   }
   function matchfix(rqid) {
	//확인
      makefoda("matchFix", "MatchFix", rqid);

      document.matchFix.submit();
   }
   function matchapplypage(rqid) {
	   // 확인
      //       alert(rqid + ": Rqid");

      makefoda("matchApplyPage", "MatchApplyPage", rqid);

      document.matchApplyPage.submit();
   }
   function matchcreatedel(rqid) {
	//확인
		makefoda("matchCreateDel", "MatchCreteDel", rqid);

		document.matchCreateDel.submit();
	}
	function matchcreateupd(md) {
	//확인	
		document.matchCreateUpd.submit();
	}
	function mataccmeminfpage(rqidacid) {
	//확인
		makefoda("matAccMemInfPage", "MatAccMemInfPage", rqidacid);

		document.matAccMemInfPage.submit();
	}
	function matchapplydel(rqid) {
	//확인
		makefoda("matchApplyDel", "MatchApplyDel", rqid);
		
		document.matchApplyDel.submit();
	}
	function matchfixpage(rqid) {
	//확인
		makefoda("matchFixPage", "MatchFixPage", rqid);

		document.matchFixPage.submit();
	}
	function matcomcredel(rqid) {
	//확인
		makefoda("matchComCreDel", "MatchComCreDel", rqid);

		document.matchComCreDel.submit();
	}
	function matcomappdel(rqid) {
	//확인
		makefoda("matchComAppDel", "MatchComAppDel", rqid);

		document.matchComAppDel.submit();
	}
	function makefoda(formName, actionName, data) {
	//확인
		var sdata = data.split(":");

		alert(sdata);
		alert(sdata[0] + " : rqid");
		alert(sdata[1] + " : mmid");

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
		mi.value = "${mmid}";

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
	window.onload = function(){
		var sDay = 1;
		var eDay = 31;	
		var sTime = 0;
		var eTime = 23;
		var sMinute = 0;
		var eMinute = 59;		
		
		var strDay = "";
		var strTime = "";
		var strMinute = "";
		
		for(var i = sDay ; i <= eDay ; i++){
			if (i < 10){
				strDay +="<option value = \'0" + i + "\'>"+ i + "일</option>";
			}else {
				strDay +="<option value = " + i + ">"+ i + "일</option>"
			}
			
		}
		for(var i = sTime; i <= eTime ; i++){
			if (i < 10){
				strTime +="<option value = \'0" + i + "\'>"+ i + "시</option>"
			}else {
				strTime +="<option value = " + i + ">"+ i + "시</option>"
			}			
		}
		for(var i = sMinute; i <= eMinute ; i += 30){
			
				strMinute +="<option value = " + i + ">"+ i + "분</option>"
		}	
		
		document.getElementById("fixdate").innerHTML = strDay;
		document.getElementById("fixtime").innerHTML = strTime;
		document.getElementById("fixminute").innerHTML = strMinute;
	}
	function matchinsert(){
		document.matchInsert.submit();
	}

	


</script>
<!-- 네이게이션 function 모음    -->
<style>
select {
background-color: rgba(250,250,250,0.93);
}

select:hover {
background: #df5799;
	color: #ffffff;
}

input[type=button]{
background:#ffffff;
width: 50%;
float: left;
margin-top: 20px;
}
input[type=button]:hover
 {
background: #df5799;
	color: #ffffff;
	transition: 0.3s all;
	-webkit-transition: 0.3s all;
	-moz-transition: 0.3s all;
	-o-transition: 0.3s all;
	-ms-transition: 0.3s all;
}
</style>

</head>

<body>
	<!-- onBeforeunload="return browser_close() -->
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
					<li><a onClick = "pwCheckPage()"><span class="glyphicon glyphicon-user"></span>
							${mmid } 님</a></li>
					<li><a onClick="accessOut()"><span
							class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- navigator 끝 -->

	<div id="small-dialog1" class="mfp-hide">
		<form name="matchCreateUpd" action="MatchCreateUpd" method="post">
			<div class="contact-form1"
				style="margin-left: 330px; width: 670px; margin-top: 120px; height: 450px">
				<div class="contact-w3-agileits">
					<h3>Match Update Form</h3>
					<input type="hidden" name="mmid" value="${mmid }" />
					<input type="hidden" name="rqid" value="${rqid }" />

					<div class="form-sub-w3ls">
						<input placeholder="시작 전 한마디" name="description" type="text" style="margin-left: 28px;
    background-color: rgb(255,255,255); color: black; font-weight: bolder;"
							required>
						<div class="icon-agile">
							<i class="fa fa-user" aria-hidden="true"></i>
						</div>
					</div>
					<div class="form-sub-w3ls">
						<select name="fixyear" style="width: 33.4%; float: left;">
							<option value="" >년 도</option>
							<option value="2017">2017년</option>
							<option value="2018">2018년</option>
						</select> <select name="fixmonth" style="width: 33.3%; float: left;">
							<option value="">달</option>
							<option value="01">1월</option>
							<option value="02">2월</option>
							<option value="03">3월</option>
							<option value="04">4월</option>
							<option value="05">5월</option>
							<option value="06">6월</option>
							<option value="07">7월</option>
							<option value="08">8월</option>
							<option value="09">9월</option>
							<option value="10">10월</option>
							<option value="11">11월</option>
							<option value="12">12월</option>
						</select> <select name="fixdate"  style="width: 33.3%; float: left;" id="fixdate">
						</select><br /> <select name="fixtime" id="fixtime" style="width: 50%; float: left;">
						</select> <select name="fixminute" id="fixminute" style="width: 50%; float: left;">
						</select>
					</div>
					<div>
						<!--                경기 종목 -->
						<select name="stcode">
							<option value="">경기 종목 선택</option>
							<option value="A">배드민턴(2인)</option>
							<option value="B">배드민턴(4인)</option>
							<option value="C">테니스(2인)</option>
							<option value="D">테니스(4인)</option>
							<option value="E">풋살(5인)</option>
							<option value="F">풋살(6인)</option>
							<option value="G">농구(3인)</option>
							<option value="H">농구(5인)</option>
						</select>
					</div>
					<div>
						<!--                지역 코드 -->
						<select name="lccode">
							<option value="">지역선택</option>
							<option value="S1">서울:강북구,도봉구,성북구,노원구</option>
							<option value="S2">서울:동대문구,중랑구,성동구,광진구</option>
							<option value="S3">서울:강동구,송파구</option>
							<option value="S4">서울:서초구,강남구</option>
							<option value="S5">서울:동작구,관악구,금천구</option>
							<option value="S6">서울:강서구,양천구,영등포구,구로구</option>
							<option value="S7">서울:은평구,마포구,서대문구</option>
							<option value="I1">서울:종로구,중구,용산구</option>
							<option value="I2">인천:서구,부평구,계양구</option>
							<option value="I3">인천:남구,중구</option>
							<option value="K1">인천:연수구,남동구</option>
							<option value="K2">경기:의정부시,양주시,포천시</option>
							<option value="K3">경기:구리시,남양주시</option>
							<option value="K4">경기:하남시,광주시</option>
							<option value="K5">경기:성남시,용인시</option>
							<option value="K6">경기:안양시,과천시,의왕시,안산시,군포시,수원시</option>
							<option value="K7">경기:부천시,김포시,광명시,시흥시</option>
							<option value="K8">경기:파주시,고양시</option>
						</select>
					</div>
				</div>
				<div>
				</div>
				<div class="submit-w3l">
					<input type="button" id="yj" value="매치 수정" onClick="matchcreateupd(${rqid})" /> <input
						type="button"  id="yj" value="뒤로 가기" onClick="mymatchinfo()" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>