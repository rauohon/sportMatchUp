<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/message.css">
<!-- <link rel="stylesheet" href="css/page.css">  -->
<!-- <link rel="stylesheet" href="css/style.css"> -->
<!-- <link rel="stylesheet" href="css/style2.css"> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"
	integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script>
	/*  네이게이션 function 모음    */
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
	function messageReceiveInfo() {
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
		i.value = "${mmid }";
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

	function memberDrop() {
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
	function pwCheckPage() {
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
	function messageInfo() {
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
	function messageSendPage() {
		var f = document.createElement("form");
		var i = document.createElement("input");
		f.name = "messagesendpage";
		f.action = "MessageSendPage";
		f.method = "post";
		document.body.appendChild(f);

		i.type = "hidden";
		i.name = "mmid";
		i.value = "${mmid }";
		f.appendChild(i);

		document.messagesendpage.submit();
	}

	//내게 메세지 쓰기
	function messageToMeSendPage() {
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
	function messageSent() {
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
	function memberLcUpdatePage() {

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

	function memberInfoProfile() {
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
		makefoda("matchCreateDel", "MatchCreateDel", rqid);

		document.matchCreateDel.submit();
	}
	function matchcreateupdpage(md) {
		//확인
		makefoda("matchCreateUpdPage", "MatchCreateUpdPage", md);

		document.matchCreateUpdPage.submit();
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
	function matchend(rqid) {

		makefoda("matchEnd", "MatchEnd", rqid);

		document.matchEnd.submit();

	}
	function makefoda(formName, actionName, data) {
		//확인
		var sdata = data.split(":");

		// 		alert(sdata);
		// 		alert(sdata[0] + " : rqid");
		// 		alert(sdata[1] + " : mmid");

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
</script>
</head>
<body>





	<div id="wrap" class="skin_white">
		<!-- header -->

		<!-- <script type="text/javascript" charset="UTF-8"
		src="http://pwe.naver.net/js/release/deskhome_menu_20151023.js"></script> -->
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
					<li><a><span class="glyphicon glyphicon-user"></span>
							${param.mmid } 님</a></li>
						<li><a onClick="accessOut()"><span
								class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- navigator 끝 -->

		<div id="gnb" class="login_area">
			<strong class="blind">사용자 링크</strong>
			<ul class="gnb_lst" id="gnb_lst" style="display: none">
				<li class="gnb_login_li" id="gnb_login_layer"><a
					class="gnb_btn_login" href="#" id="gnb_login_button"><span
						class="gnb_bg"></span><span class="gnb_bdr"></span><span
						class="gnb_txt">로그인</span></a></li>
				<li class="gnb_my_li" id="gnb_my_layer" style="display: none"><div
						class="gnb_my_namebox" id="gnb_my_namebox">
						<a href="javascript:;" class="gnb_my"
							onclick="gnbUserLayer.clickToggle(); return false;"><img
							id="gnb_profile_img"
							src="data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs%3D"
							width="26" height="26" alt=""> <span class="gnb_name"
							id="gnb_name1"></span><em class="blind">내정보 보기</em><span
							class="ico_arrow"></span></a><a href="#" class="gnb_emp" id="gnb_emp">(임직원혜택)</a>
					</div>
					<div class="gnb_my_lyr" id="gnb_my_lyr">
						<div class="gnb_my_content">
							<div class="gnb_img_area">
								<span class="gnb_mask"></span><img
									src="data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs%3D"
									width="80" height="80" alt=""><a
									href="https://nid.naver.com/user2/api/naverProfile.nhn?m=checkIdType"
									class="gnb_change"><span class="blind">프로필 사진 변경</span></a>
							</div>
							<div class="gnb_txt_area">
								<p class="gnb_account">
									<span class="gnb_name" id="gnb_name2"><a
										class="gnb_nick"
										href="https://nid.naver.com/user2/api/naverProfile.nhn?m=checkIdType">_</a>님</span><a
										class="gnb_btn_login" href="#" id="gnb_logout_button"><span
										class="gnb_bg"></span><span class="gnb_bdr"></span><span
										class="gnb_txt">로그아웃</span></a>
								</p>
								<a href="http://mail.naver.com" class="gnb_mail_address">@naver.com</a>
								<ul class="gnb_edit_lst">
									<li class="gnb_info"><a
										href="https://nid.naver.com/user2/help/myInfo.nhn?menu=home">내정보</a></li>
									<li class="gnb_secure" id="gnb_secure_lnk"><a
										href="https://nid.naver.com/user2/help/myInfo.nhn?m=viewSecurity&amp;menu=security">보안설정</a></li>
								</ul>
								<p class="gnb_pay_check" id="gnb_pay_check">
									<em>N Pay</em><a href="http://pay.naver.com" id="gnb_pay_point"><span>내
											페이포인트</span></a>
								</p>
							</div>
						</div>
						<div class="gnb_my_community">
							<a href="http://blog.naver.com/MyBlog.nhn" class="gnb_blog">내
								블로그</a><a href="http://section.cafe.naver.com" class="gnb_cafe">가입한
								카페</a><a href="http://pay.naver.com" class="gnb_pay"><span>N
									Pay</span></a>
						</div>
						<a href="#" class="gnb_my_interface" style="display: none"><span
							class="blind">환경설정</span></a>
					</div> <iframe id="gnb_my_lyr_iframe" title="빈 프레임" class="gnb_pad_lyr"
						name="padding" width="0" height="0" scrolling="no" frameborder="0"
						style="top: 34px; right: -4px; width: 320px; height: 174px; display: none; opacity: 0; -ms-filter: alpha(opacity = 0)"></iframe></li>
				<li class="gnb_notice_li" id="gnb_notice_layer"
					style="display: none"><a href="javascript:;"
					class="gnb_notice"
					onclick="gnbNaverMeLayer.clickToggle(); return false;"><span
						class="blind">알림</span><span class="gnb_icon"></span><em
						class="gnb_ico_num" id="gnb_me_menu" style="display: none"><span
							class="gnb_ico_new"><span class="gnb_count"
								id="gnb_me_count"></span></span></em><span class="ico_arrow"></span></a>
					<div class="gnb_notice_lyr" id="gnb_notice_lyr">
						<div class="svc_noti svc_panel">
							<div class="svc_scroll">
								<div class="svc_head">
									<strong class="gnb_tit">전체 알림</strong>
									<div class="task_right">
										<button onclick="gnbNaverMeLayer.deleteReadList(this, event);"
											id="gnb_btn_read_noti_del">읽은 알림 삭제</button>
										<button onclick="gnbNaverMeLayer.showDeleteAlert();"
											id="gnb_btn_all_noti_del">모두 삭제</button>
									</div>
								</div>
								<div class="svc_body" id="gnb_naverme_layer"></div>
							</div>
							<div class="gnb_ly_alert" id="gnb_ly_alert"
								style="display: none;">
								<p class="gnb_msg">
									<strong>알림을 모두 삭제하시겠습니까?</strong>
								</p>
								<div class="gnb_btns">
									<button id="ly_alert_confirm"
										onclick="gnbNaverMeLayer.deleteAllList(this, event);">확인</button>
									<button onclick="gnbNaverMeLayer.hideDeleteAlert();">취소</button>
								</div>
								<button class="gnb_btn_close"
									onclick="gnbNaverMeLayer.hideDeleteAlert();">
									<i>레이어 닫기</i>
								</button>
							</div>
							<a href="http://me.naver.com/box/noti.nhn" class="gnb_notice_all">내
								알림 전체보기</a>
						</div>
					</div> <iframe id="gnb_notice_lyr_iframe" title="빈 프레임"
						class="gnb_pad_lyr" name="padding" width="0" height="0"
						scrolling="no" frameborder="0"
						style="top: 34px; right: -4px; width: 299px; height: 332px; display: none; opacity: 0; -ms-filter: alpha(opacity = 0)"></iframe></li>
				<li class="mail_li" id="gnb_mail_layer" style="display: none"><a
					href="http://mail.naver.com" class="gnb_mail"><span
						class="blind">메일</span><span class="gnb_icon"></span><em
						class="gnb_ico_num" id="gnb_mail_menu" style="display: none"><span
							class="gnb_ico_new"><span class="gnb_count"
								id="gnb_mail_count"></span></span></em></a></li>
				<li class="gnb_service_li" id="gnb_service_layer"><a
					href="javascript:;" class="gnb_service"
					onclick="gnbMoreLayer.clickToggle(); return false;"><span
						class="blind">서비스 더보기</span><span class="gnb_icon"></span><span
						class="ico_arrow"></span></a>
					<div class="gnb_service_lyr" id="gnb_service_lyr">
						<div class="gnb_favorite_search" id="gnb_favorite_search">
							<div class="gnb_favorite_area">
								<div class="gnb_favorite_lstwrp">
									<div class="gnb_first_visit" style="display: none">
										<span class="blind">나만의 즐겨찾기를 추가해 보세요!</span><a href="#"
											class="gnb_close"><span class="blind">닫기</span></a>
									</div>
									<strong class="blind">즐겨찾는 서비스</strong>
									<ul class="gnb_favorite_lst" id="gnb_favorite_lst">
										<li class="gnb_add"><a href="#"><span class="ic_add"></span>추가</a></li>
										<li class="gnb_add"><a href="#"><span class="ic_add"></span>추가</a></li>
										<li class="gnb_add"><a href="#"><span class="ic_add"></span>추가</a></li>
										<li class="gnb_add"><a href="#"><span class="ic_add"></span>추가</a></li>
									</ul>
									<a href="#" class="gnb_my_interface"
										onclick="gnbMoreLayer.clickToggleWhole(); return false;"><span
										class="blind">즐겨찾기 설정</span></a>
								</div>
							</div>
							<div class="gnb_search_area">
								<div class="gnb_search_box"
									onmouseover="gnb_search.mouseOver(this);"
									onmouseout="gnb_search.mouseOut(this);">
									<input id="gnb_svc_search_input" type="text" title="서비스 검색"
										value="더 많은 서비스를 간편하게 시작하세요!"
										onfocus="gnb_search.clearInput(this);"
										onblur="gnb_search.resetInput(this);"
										onkeydown="gnb_search.keyDown(event);"
										onkeyup="gnb_search.keyUp(event);"><a href="#"
										class="gnb_del_txt" id="gnb_del_txt" style="display: none"><span
										class="blind">삭제</span></a>
									<div class="gnb_pop_input" id="gnb_pop_input" tabindex="0"
										onfocus="gnb_search.searchPopOnMouse = true; return false;"
										onfocusout="gnb_search.searchPopOnMouse = false; return false;"
										onmouseover="gnb_search.searchPopOnMouse = true; return false;"
										onmouseout="gnb_search.searchPopOnMouse = false; return false;"
										style="display: none">
										<ul class="gnb_pop_lst"></ul>
									</div>
								</div>
								<div class="gnb_search_lstwrp">
									<ul class="gnb_search_lst gnb_first">
										<li class="gnb_first"><a href="http://cafe.naver.com/">카페</a></li>
										<li><a href="http://news.naver.com/">뉴스</a></li>
										<li><a href="http://map.naver.com/">지도</a></li>
										<li><a href="http://sports.news.naver.com/">스포츠</a></li>
										<li><a href="http://game.naver.com/">게임</a></li>
									</ul>
									<ul class="gnb_search_lst">
										<li class="gnb_first"><a
											href="http://section.blog.naver.com/">블로그</a></li>
										<li><a href="http://post.naver.com/main.nhn">포스트</a></li>
										<li><a href="http://dic.naver.com/">사전</a></li>
										<li><a href="http://kin.naver.com/">지식iN</a></li>
										<li><a href="http://weather.naver.com/">날씨</a></li>
									</ul>
									<ul class="gnb_search_lst">
										<li class="gnb_first"><a href="http://mail.naver.com/">메일</a></li>
										<li><a href="http://stock.naver.com/">증권</a></li>
										<li><a href="http://land.naver.com/">부동산</a></li>
										<li><a href="http://music.naver.com/">뮤직</a></li>
										<li><a href="http://book.naver.com">책</a></li>
									</ul>
									<ul class="gnb_search_lst">
										<li class="gnb_first"><a
											href="http://shopping.naver.com/">쇼핑</a></li>
										<li><a href="http://comic.naver.com/">웹툰</a></li>
										<li><a href="http://movie.naver.com/">영화</a></li>
										<li><a href="http://cloud.naver.com/">클라우드</a></li>
										<li><a href="http://auto.naver.com/">자동차</a></li>
									</ul>
								</div>
							</div>
							<div class="gnb_banner">
								<a href="http://campaign.naver.com/pointevent/"
									class="gnb_service_event"><img id="gnb_promo"
									alt="네이버페이 | 7월 이벤트" width="265" height="47"
									src="http://static.naver.net/common/gnb/2014/promo_npay.png"></a>
							</div>
							<div class="gnb_linkwrp">
								<a href="http://www.naver.com/more.html" class="gnb_service_all"
									id="gnb_service_all">전체 서비스 보기</a>
							</div>
						</div>
						<div class="gnb_svc_more" id="gnb_svc_more" style="">
							<strong class="blind">네이버 주요 서비스</strong>
							<div class="gnb_bg_top"></div>
							<div class="gnb_svc_hd">
								<strong class="gnb_svc_tit">바로가기 설정</strong><span class="link"><a
									href="http://www.naver.com/more.html">전체 서비스 보기</a></span>
							</div>
							<div class="gnb_svc_lstwrp">
								<div class="gnb_svc_lst1">
									<ul class="gnb_first">
										<li><input type="checkbox" id="nsvc_game" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_game">게임</label></li>
										<li><input type="checkbox" id="nsvc_weather"
											name="selmenu" class="gnb_input_check" value=""> <label
											for="nsvc_weather">날씨</label></li>
										<li><input type="checkbox" id="nsvc_shopping"
											name="selmenu" class="gnb_input_check" value=""> <label
											for="nsvc_shopping">네이버쇼핑</label></li>
										<li><input type="checkbox" id="nsvc_navercast"
											name="selmenu" class="gnb_input_check" value=""> <label
											for="nsvc_navercast">네이버캐스트</label></li>
										<li><input type="checkbox" id="nsvc_cloud" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_cloud">네이버클라우드</label></li>
										<li class="gnb_event"><input type="checkbox"
											id="nsvc_naverpay" name="selmenu" class="gnb_input_check"
											value=""> <label for="nsvc_naverpay">네이버페이</label><em
											class="ic_gnb_new">New</em></li>
										<li><input type="checkbox" id="nsvc_news" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_news">뉴스</label></li>
										<li><input type="checkbox" id="nsvc_comic" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_comic">만화/웹툰</label></li>
										<li><input type="checkbox" id="nsvc_memo" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_memo">메모</label></li>
										<li><input type="checkbox" id="nsvc_mail" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_mail">메일</label></li>
										<li><input type="checkbox" id="nsvc_music" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_music">뮤직</label></li>
										<li><input type="checkbox" id="nsvc_land" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_land">부동산</label></li>
										<li><input type="checkbox" id="nsvc_bookmark"
											name="selmenu" class="gnb_input_check" value=""> <label
											for="nsvc_bookmark">북마크</label></li>
									</ul>
									<ul class="">
										<li><input type="checkbox" id="nsvc_blog" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_blog">블로그</label></li>
										<li><input type="checkbox" id="nsvc_dic" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_dic">사전</label></li>
										<li><input type="checkbox" id="nsvc_software"
											name="selmenu" class="gnb_input_check" value=""> <label
											for="nsvc_software">소프트웨어</label></li>
										<li><input type="checkbox" id="nsvc_sports"
											name="selmenu" class="gnb_input_check" value=""> <label
											for="nsvc_sports">스포츠</label></li>
										<li><input type="checkbox" id="nsvc_ya9" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_ya9">야구9단</label></li>
										<li><input type="checkbox" id="nsvc_movie" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_movie">영화</label></li>
										<li><input type="checkbox" id="nsvc_office"
											name="selmenu" class="gnb_input_check" value=""> <label
											for="nsvc_office">오피스</label></li>
										<li><input type="checkbox" id="nsvc_novel" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_novel">웹소설</label></li>
										<li><input type="checkbox" id="nsvc_auto" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_auto">자동차</label></li>
										<li><input type="checkbox" id="nsvc_contact"
											name="selmenu" class="gnb_input_check" value=""> <label
											for="nsvc_contact">주소록</label></li>
										<li><input type="checkbox" id="nsvc_finance"
											name="selmenu" class="gnb_input_check" value=""> <label
											for="nsvc_finance">증권(금융)</label></li>
										<li><input type="checkbox" id="nsvc_map" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_map">지도</label></li>
										<li><input type="checkbox" id="nsvc_kin" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_kin">지식iN</label></li>
									</ul>
									<ul class="">
										<li><input type="checkbox" id="nsvc_terms" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_terms">지식백과</label></li>
										<li><input type="checkbox" id="nsvc_book" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_book">책</label></li>
										<li><input type="checkbox" id="nsvc_cafe" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_cafe">카페</label></li>
										<li><input type="checkbox" id="nsvc_calendar"
											name="selmenu" class="gnb_input_check" value=""> <label
											for="nsvc_calendar">캘린더</label></li>
										<li><input type="checkbox" id="nsvc_photo" name="selmenu"
											class="gnb_input_check" value=""> <label
											for="nsvc_photo">포토갤러리</label></li>
										<li><input type="checkbox" id="nsvc_nstore"
											name="selmenu" class="gnb_input_check" value=""> <label
											for="nsvc_nstore">N스토어</label></li>
										<li><input type="checkbox" id="nsvc_navertv"
											name="selmenu" class="gnb_input_check" value=""> <label
											for="nsvc_navertv">네이버TV</label></li>
									</ul>
								</div>
								<div class="svc_lst2">
									<div class="svc_spc gnb_first">
										<strong><a href="http://dic.naver.com/">어학사전</a></strong>
										<ul class="">
											<li><input type="checkbox" id="nsvc_krdic"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_krdic">국어사전</label></li>
											<li><input type="checkbox" id="nsvc_endic"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_endic">영어/영영사전</label></li>
											<li><input type="checkbox" id="nsvc_hanja"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_hanja">한자사전</label></li>
											<li><input type="checkbox" id="nsvc_jpdic"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_jpdic">일어사전</label></li>
											<li><input type="checkbox" id="nsvc_cndic"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_cndic">중국어사전</label></li>
											<li><input type="checkbox" id="nsvc_frdic"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_frdic">프랑스어사전</label></li>
											<li><input type="checkbox" id="nsvc_dedic"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_dedic">독일어사전</label></li>
											<li><input type="checkbox" id="nsvc_rudic"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_rudic">러시아어사전</label></li>
											<li><input type="checkbox" id="nsvc_vndic"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_vndic">베트남어사전</label></li>
											<li><input type="checkbox" id="nsvc_spdic"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_spdic">스페인어사전</label></li>
											<li><input type="checkbox" id="nsvc_translate"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_translate">번역기</label></li>
										</ul>
									</div>
									<div class="svc_spc">
										<strong>인기/신규서비스</strong>
										<ul class="">
											<li><input type="checkbox" id="nsvc_grafolio"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_grafolio">그라폴리오</label></li>
											<li><input type="checkbox" id="nsvc_post" name="selmenu"
												class="gnb_input_check" value=""> <label
												for="nsvc_post">포스트</label></li>
											<li><input type="checkbox" id="nsvc_luncherapp"
												name="selmenu" class="gnb_input_check" value=""> <label
												for="nsvc_luncherapp">도돌런처</label></li>
											<li><input type="checkbox" id="nsvc_band" name="selmenu"
												class="gnb_input_check" value=""> <label
												for="nsvc_band">밴드</label></li>
											<li><input type="checkbox" id="nsvc_line" name="selmenu"
												class="gnb_input_check" value=""> <label
												for="nsvc_line">라인</label></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="svc_btnwrp">
								<div class="svc_btns">
									<button class="gnb_save"
										onclick="if(gnbFavorite.addService()){gnbMoreLayer.clickToggleWhole()} return false;">
										<strong class="blind">확인</strong>
									</button>
									<button class="gnb_close"
										onclick="gnbFavorite.cancel(); return false;">
										<span class="blind">취소</span>
									</button>
									<button class="gnb_return"
										onclick="gnbFavorite.resetService(); return false;">
										<span class="blind">초기 설정으로 변경</span>
									</button>
								</div>
							</div>
							<div class="gnb_bg_btm"></div>
						</div>
					</div> <iframe id="gnb_service_lyr_iframe" title="빈 프레임"
						class="gnb_pad_lyr" name="padding" width="0" height="0"
						scrolling="no" frameborder="0"
						style="display: none; top: 34px; right: 297px; width: 585px; height: 385px; opacity: 0; -ms-filter: alpha(opacity = 0)"></iframe>
					<iframe id="gnb_svc_more_iframe" title="빈 프레임" class="gnb_pad_lyr"
						name="padding" width="0" height="0" scrolling="no" frameborder="0"
						style="display: none; top: 34px; right: -4px; width: 295px; height: 385px; opacity: 0; -ms-filter: alpha(opacity = 0)"></iframe></li>
			</ul>
		</div>
		<!-- //header -->
		<!-- container -->
		<div id="container">
			<!-- 서비스 메뉴 -->
			<div id="nav_snb">
				<h3 class="blind">쪽지</h3>
				<div id="menu_write" class="btn_workset">
					<a onClick="messageSendPage()"
						class="btn_quickwrite _click(nWrite|openWrite|new) _ccr(lmn.write) _stopDefault"
						style="height: 41px;"><span>쪽지쓰기</span></a><a
						onClick="messageToMeSendPage()" class="btn_import _click(nWrite|openWrite|toMe) _ccr(lmn.tome) _stopDefault"
						"="" style="height: 41px;"><span>내게쓰기</span></a>
				</div>
				<div class="svc_menu_area">
					<h3 class="blind">쪽지 서비스 메뉴</h3>
					<div class="list_menu">
						<!-- [D] 마우스오버시 li에 ovr, 클릭시 li에 click 클래스 추가 -->
						<ul>
							<li id="inbox_folder"
								class="_click(nFolder|clickFolder|inbox) _mouseover(nFolder|overPointer) _mouseout(nFolder|outPointer) _ccr(lmn.inbox) _stopDefault click"><a
								onClick="messageReceiveInfo()" class="bu2">받은쪽지함</a> <a href="#"
								class="article _click(nFolder|clickFolder|inbox|1) _ccr(lmn.inbox) _stopDefault"><em></em></a></li>
							<li id="toMe_folder"
								class="_click(nFolder|clickFolder|toMe) _mouseover(nFolder|overPointer) _mouseout(nFolder|outPointer) _ccr(lmn.tomebox) _stopDefault"><a
								href="#" class="bu3">내게쓴쪽지함</a> <a href="#"
								class="article _click(nFolder|clickFolder|toMe|1)_ccr(lmn.tomebox)  _stopDefault"><em></em></a></li>
							<li id="sent_folder"
								class="_click(nFolder|clickFolder|sent) _mouseover(nFolder|overPointer) _mouseout(nFolder|outPointer) _ccr(lmn.sent) _stopDefault"><a
								onClick="messageInfo()" class="bu4">보낸쪽지함</a> <a href="#"
								class="article _click(nFolder|clickFolder|sent|1) _ccr(lmn.sent) _stopDefault"><em></em></a></li>
							<li id="save_folder"
								class="_click(nFolder|clickFolder|save) _mouseover(nFolder|overPointer) _mouseout(nFolder|outPointer) _ccr(lmn.keep) _stopDefault"><a
								href="#" class="bu5">쪽지보관함</a> <a href="#"
								class="article _click(nFolder|clickFolder|save|1) _ccr(lmn.keep) _stopDefault"><em></em></a></li>

						</ul>
					</div>

					<!-- 좌측메뉴 하단 프로모션영역 -->
					<div id="banner_promotion" class="section_promotion"></div>
					<!-- //좌측메뉴 하단 프로모션영역 -->

				</div>
			</div>
			<!-- //서비스 메뉴 -->
			<div id="section_cen">
				<div id="section_cen_fix">
					<div id="content">
						<div id="cont_fix_area" style="display: block;">

							<div id="image_promotion" class="cmn_promotion_image"
								style="display: none"></div>
							<div class="content_header">
								<!-- 검색 -->
								<h3 class="blind">공지 및 검색</h3>
								<form name="" id="search_form" action="#"
									onsubmit="return false;" style="display: block;">
									<fieldset class="msearch">
										<legend>쪽지검색</legend>
										<label for="q01" class="blind">검색할 쪽지함 선택</label> <select
											id="q01">
											<option value="8">전체쪽지</option>
											<option value="0">받은쪽지</option>
											<option value="1">보낸쪽지</option>
											<option value="7">보관쪽지</option>
											<option value="2">내게쓴쪽지</option>
										</select> <label for="q02" class="blind">검색 옵션 선택</label> <select
											id="q02">
											<option value="0">아이디</option>
											<option value="1">별명</option>
											<option value="2">내용</option>
										</select>

									</fieldset>
								</form>
								<!-- //검색 -->
								<!-- 공지사항 -->
								<h4 class="blind">공지사항</h4>
								<span id="notice" class="notice"> </span>
								<!-- //공지사항 -->
								<!-- 타이틀 -->
								<div class="list_head">
									<h4>받은쪽지함</h4>
									<span class="default"><a
										class="new_note _click(nFolder|clickFolder|inbox|1) _ccr(ibx.uncheck) _stopDefault"
										href="#">0</a><span class="slash" style="display:">/</span><a
										class="_click(nFolder|clickFolder|inbox) _ccr(ibx.all) _stopDefault"
										href="#"><strong>0</strong></a></span> <a
										class="del_unread _click(nList|deleteUnreadNote) _ccr(ibx.delnoview) _stopDefault"
										href="#" style="display:">안읽은 쪽지 삭제</a>
								</div>
								<!-- //타이틀 -->

								<!-- [D] 좌측메뉴 접기 버튼 마크업 변경 -->
								<a href="#"
									class="btn_fold _click(nFolder|toggleSnb) _stopDefault"> <span
									class="ico"></span> <span class="blind">좌측메뉴 접기</span>
								</a>
							</div>

							<div id="text_promotion" class="cmn_promotion_text"
								style="display: none;"></div>
							<div class="searchkey_result" style="display: none;">
								<p class="keyword">
									<strong>검색결과 <a href="#"
										class="_click(nList|movePage|1) _stopDefault">0건</a> <span
										class="search_keyword"></span></strong>
								</p>
							</div>
							<div class="task_btn" style="display: block;">
								<h3 class="blind">쪽지 목록 기능 버튼</h3>
								<div class="buttonSet">
									<a id="del_btn" href="#"
										class="button b _click(nList|deleteNote) _ccr(ibx.del) _stopDefault"><span
										class="bu_del"></span><span class="blind">선택한 쪽지 </span>삭제</a> <a
										id="save_btn" href="#"
										class="button _click(nList|saveNote) _ccr(ibx.keep) _stopDefault"><span
										class="blind">선택한 쪽지 </span>보관</a> <a id="spamReport_btn" href="#"
										class="button b _click(nReport|showReportLayer) _ccr(ibx.spam) _stopDefault"><span
										class="blind">선택한 쪽지 </span>스팸신고</a> <a id="cancelSpam_btn"
										class="button b _click(nList|spamRelease) _ccr(spb.allow) _stopDefault"
										href="#" style="display: none;"><span class="blind">선택한
											쪽지 </span>스팸해제</a> <a id="reply_btn" href="#"
										class="button _click(nList|replyNote) _ccr(ibx.reply) _stopDefault"><span
										class="blind">선택한 쪽지 </span>답장</a> <a id="sendCancel_btn" href="#"
										class="button _click(nList|sendCancelNote) _stopDefault"
										style="display: none"><span class="blind">선택한 쪽지 </span>발송취소</a>
									<a id="readNewWindow_btn" href="#" class="button"
										style="display: none"><span class="ico_window"></span>새창<span
										class="blind">으로 읽기</span></a> <a id="readSubSet_list_btn"
										href="javascript:;"
										class="_click(nRead|toggleFrame|list) _stopDefault"
										style="display: none">목록</a> <a id="prev_btn" href="#"
										class="bu_prev" style="display: none">이전</a> <span
										id="readSubSet_bar" class="bar" style="display: none">|</span>
									<a id="next_btn" href="#" class="bu_next" style="display: none">다음</a>
									<span class="category"> <a id="unread_filter" href="#"
										class="_click(nFolder|clickFolder|inbox|1) _ccr(ibx.unread) _stopDefault">안읽은
											쪽지<span class="blind"> 보기</span>
									</a>
									</span>
								</div>
								<div class="subSet" style="display: block;">
									<label for="viewType" class="blind">서비스별 쪽지 보기</label> <select
										id="viewType" class="inbox_filter"
										onchange="nList.changeSvcType(event);"
										style="display: inline;">
										<option value="-1,-1">전체쪽지</option>
										<option value="2,2">카페단체</option>
										<option value="2,3">카페개인</option>
										<option value="1,-1">블로그</option>
										<option value="3,-1">지식iN</option>
										<option value="17,-1">캘린더</option>
										<option value="22,-1">포토앨범</option>
									</select> <select id="viewType" class="private_filter"
										onchange="nList.changeSvcType(event);" style="display: none;">
										<option value="-1,-1">전체쪽지</option>
										<option value="2,3">카페개인</option>
										<option value="1,-1">블로그</option>
										<option value="3,-1">지식iN</option>
										<option value="17,-1">캘린더</option>
										<option value="22,-1">포토앨범</option>
									</select> <select id="viewType" class="save_filter"
										onchange="nList.changeSvcType(event);" style="display: none;">
										<option value="7">전체쪽지</option>
										<option value="3">받은쪽지</option>
										<option value="4">보낸쪽지</option>
									</select> <a href="#"
										class="refresh _ccr(ibx.refresh) _click(nList|refreshList) _stopDefault"
										title="새로고침"><span class="blind">목록 새로고침</span></a> <a
										title="쪽지 목록만 보기" href="#"
										class="mode_list on _click(nList|setDivideMode|normal) _stopDefault"><span
										class="blind">쪽지 목록만 보기</span></a><a title="좌우 분할로 보기" href="#"
										class="mode_hor _click(nList|setDivideMode|horizon) _stopDefault"><span
										class="blind">좌우 분할로 보기</span></a><a title="상하 분할로 보기" href="#"
										class="mode_ver _click(nList|setDivideMode|vertical) _stopDefault"><span
										class="blind">상하 분할로 보기</span></a>
									<!--[if lte IE 7]>
								<script>$$.getSingle(".mode_list").style.display="none";$$.getSingle(".mode_hor").style.display="none";$$.getSingle(".mode_ver").style.display="none";</script>
								<![endif]-->
								</div>
								<!--
							<div class="subSet_read" style="display:none">
								 <a href="#" class="button"><span class="ico_window"></span>새창<span class="blind">으로 읽기</span></a>
							</div>
							 -->
							</div>
							<!-- 쓰기 버튼 -->
							<div class="write_btn" style="display: none;">
								<h3 class="blind">쪽지 목록 기능 버튼</h3>
								<div class="buttonSet">
									<a href="#"
										class="button b _click(nWrite|clickSendMemo) _ccr(wrm.send) _stopDefault"><span
										class="ico_send"></span>보내기</a> <a href="#"
										class="button _click(nWrite|openWrite|popup) _stopDefault"><span
										class="ico_window"></span>새창<span class="blind">으로 읽기</span></a>
								</div>
								<div class="subSet_write">
									<a href="#"
										class="button _click(nWrite|moveToMailForm) _ccr(wrm.mail) _stopDefault"><span
										class="ico_mail"></span>메일로 보내기</a>
								</div>
							</div>
							<!-- //쓰기 버튼 -->
							<!-- 메일로 보내기 폼 -->
							<form id="mail_form" name="fm" method="POST" action="">
								<input type="hidden" name="cmd" value=""> <input
									type="hidden" name="srvid" value=""> <input
									type="hidden" name="to" value=""> <input type="hidden"
									name="body" value="">
							</form>
							<!-- //메일로 보내기 폼 -->
						</div>
						<!-- [D] #cont_fix_area의 높이를 cont_flex_area의 top으로 추가. ( 없는 경우 0 )
						
						분할모드 
							normal_mode		: 일반목록
							horizon_mode	: 좌우분할
							vertical_mode 	: 상하분할
							read_mode 		: 읽기
					-->

						<div id="cont_flex_area" style="top: 100px; display: block;"
							class="normal_mode">
							<div class="cont_list" style="display: block;">
								<h3 class="blind">쪽지 목록</h3>
								<!-- 쪽지 목록 제목 -->

								<div class="notelist ">
									<ul class="notelist_head"
										style="padding-bottom: 0px; height: 31px; padding-left: 0px;">

										<li class="note_cont"><span class="from">보낸사람</span><span
											class="separator"> / </span><span class="title"
											style="margin-left: 40px;">내용</span></li>
										<li class="note_info"><span class="date_send"
											style="display: none">보낸날짜</span><span class="date"
											style="display:; right: 370px;">날짜</span><span
											class="separator" style="display:"> / </span></li>

									</ul>
									${messageReceivelist}
								</div>
								<!-- //쪽지 목록 제목 -->



							</div>
						</div>
					</div>
				</div>
			</div>
</body>
</html>
