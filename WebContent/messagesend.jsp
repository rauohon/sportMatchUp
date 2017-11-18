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
		i.value = "${mmid}";
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
	/*  네이게이션 function 모음    */

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





<script>
	function sendMessage() {
		document.sendmessage.submit();
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

		<div id="container">
			<!-- 서비스 메뉴 -->
			<div id="nav_snb">
				<h3 class="blind">쪽지</h3>
				<div id="menu_write" class="btn_workset" style="height: 60px;">
					<a onClick="messageSendPage()"
						class="btn_quickwrite _click(nWrite|openWrite|new) _ccr(lmn.write) _stopDefault"
						style="height: 41px;"><span>쪽지쓰기</span></a><a onClick="messageToMeSendPage()"
						class="btn_import _click(nWrite|openWrite|toMe) _ccr(lmn.tome) _stopDefault"
						"="" style="height: 41px;"><span>내게쓰기</span></a>
				</div>
				<div class="svc_menu_area">
					<h3 class="blind">쪽지 서비스 메뉴</h3>
					<div class="list_menu">
						<!-- [D] 마우스오버시 li에 ovr, 클릭시 li에 click 클래스 추가 -->
						<ul>
							<li id="inbox_folder"
								class="_click(nFolder|clickFolder|inbox) _mouseover(nFolder|overPointer) _mouseout(nFolder|outPointer) _ccr(lmn.inbox) _stopDefault"><a
								onClick="messageReceiveInfo()" class="bu2">받은쪽지함</a> <a href="#"
								class="article _click(nFolder|clickFolder|inbox|1) _ccr(lmn.inbox) _stopDefault"><em></em></a></li>
							<li id="toMe_folder"
								class="_click(nFolder|clickFolder|toMe) _mouseover(nFolder|overPointer) _mouseout(nFolder|outPointer) _ccr(lmn.tomebox) _stopDefault"><a
								href="#" class="bu3">내게쓴쪽지함</a> <a href="#"
								class="article _click(nFolder|clickFolder|toMe|1)_ccr(lmn.tomebox)  _stopDefault"></a></li>
							<li id="sent_folder"
								class="_click(nFolder|clickFolder|sent) _mouseover(nFolder|overPointer) _mouseout(nFolder|outPointer) _ccr(lmn.sent) _stopDefault"><a
								onClick="messageSent()" class="bu4">보낸쪽지함</a> <a href="#"
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
									onsubmit="return false;" style="display: none;">
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
										</select> <label for="q03" class="blind">검색 키워드 입력</label>

									</fieldset>
								</form>
								<!-- //검색 -->
								<!-- 공지사항 -->
								<h4 class="blind">공지사항</h4>
								<span id="notice" class="notice"> </span>
								<!-- //공지사항 -->
								<!-- 타이틀 -->
								<div class="list_head">
									<h4>쪽지쓰기</h4>
								</div>
								<!-- //타이틀 -->
								<!-- 알림 레이어 -->
								<div class="header_alert" style="display: none">
									<h5 class="blind">알림</h5>
									<p>
										신고가 성공적으로 접수되었습니다.
										<button type="button"
											onclick="$$.getSingle('.header_alert').style.opacity=0;">
											<span class="blind">닫기</span>
										</button>
									</p>
								</div>
								<!-- //알림 레이어 -->
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
							<div class="task_btn" style="display: none;">
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
							<div class="write_btn"
								style="display: block; padding-bottom: 30px;">
								<h3 class="blind">쪽지 목록 기능 버튼</h3>
								<div class="buttonSet">
									<a onClick="sendMessage();"
										class="button b _click(nWrite|clickSendMemo) _ccr(wrm.send) _stopDefault"><span
										class="ico_send"></span>보내기</a>

								</div>
								<div class="subSet_write"></div>
							</div>
							<!-- //쓰기 버튼 -->

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
								<div class="notelist " style="display: none;">
									<ul class="notelist_head"
										style="padding-bottom: 0px; height: 31px; padding-left: 0px;">
										<li class="check"><input type="checkbox" id="nl_t01"
											class="ipt_chk _click(nList|toggleCheckAll) _mousedown(nList|toggleCheckAll) _stopDefault"><label
											for="nl_t01" class="blind">쪽지 전체 선택</label></li>
										<li class="note_cont"><span class="from">보낸사람</span><span
											class="separator"> / </span><span class="title">내용</span></li>
										<li class="note_info"><span class="date_send"
											style="display: none">보낸날짜</span><span class="date"
											style="display:; right: 370px;">날짜</span><span
											class="separator" style="display:"> / </span><span
											class="refuse" style="display:">차단</span><span class="refuse"
											style="display: none">발송취소</span></li>
									</ul>
								</div>
								<!-- //쪽지 목록 제목 -->

								<!-- 쪽지 목록 -->
								<div class="list_wrap" style="display: none;">
									<div class="notelist notelist_self">
										<p class="note_none" style="display: block;">쪽지가 없습니다.</p>
										<ol class="notelist_item" style="display: none;"></ol>
									</div>
								</div>
								<div class="paginate" style="display: none;">
									<h4 class="blind">목록 페이지 이동</h4>
									<span class="pageSelector"><label class="blind"
										for="select_page_num">이동할 페이지 번호를 입력하세요 </label><input
										id="select_page_num" type="text" value="1"
										onfocus="nList.focusSelectPage();ccr(this, 'lbp.page', event);"
										onblur="nList.blurSelectPage();"
										onkeyup="nList.checkInputPage(event);"> / 1</span> <a
										href="javascript:;" class="pre_end_n _ccr(lbp.first)"
										title="첫 페이지로 이동"><span class="blind">첫 페이지로 이동</span></a><a
										href="javascript:;" class="pre_n _ccr(lbp.prev)"
										title="이전 페이지로 이동"><span class="blind">이전 페이지로 이동</span></a> <strong>1</strong>
									<a href="javascript:;" class="next_n _ccr(lbp.next)"
										title="다음 페이지로 이동"><span class="blind">다음 페이지로 이동</span></a><a
										class="next_end_n _ccr(lbp.last)" title="마지막 페이지로 이동"
										href="javascript:;"><span class="blind">마지막 페이지로 이동</span></a>
								</div>
							</div>
							<div class="cont_read" style="display: none;">
								<div class="divider _mousedown(nList|moveBar) _stopDefault"
									title="분할위치 조정"></div>
								<div class="note_read">
									<div class="read_scroll" style="display: none">
										<div class="msg_header">
											<dl class="info">
												<dt id="sender_title">보낸사람</dt>
												<dd>
													<span class="title" style="margin-left: 35px;"> <a
														href="#" target="_blank" title="" class="tit_lnk"><span></span></a>
														<span class="t_ico t_leaf"></span>
													</span>
												</dd>
												<dt id="date_title">받은시간</dt>
												<dd id="receive_date"></dd>
											</dl>
											<p class="refuse">
												<a href="#" id="block_btn">차단</a> <span class="vline">|</span>
												<a href="#" id="report_btn"><span class="ico_report"></span>신고</a>
											</p>
										</div>
										<div class="msg_contents" id="readbody"></div>
									</div>
									<div class="msg_delete" style="display: none">
										<p>
											읽은 쪽지는 30일 후에 자동으로 삭제됩니다.<br>읽지 않은 카페 단체 쪽지는 3개월 후
											자동삭제됩니다. <a href="#">자세히</a>
										</p>
									</div>
									<div class="note_none" style="display: block;">
										<strong>다음 설정을 통하여 편리하게 쪽지를 이용해 보세요!</strong>
										<ul>
											<li>분할모드 첫화면 첫번째 쪽지 자동 보기 설정을 할 수 있습니다. <a href="#"
												class="_click(nOption|openOptionPage) _ccr(fot.config) _stopDefault">환경설정
													보기</a>
											</li>
											<li>쪽지삭제 후 자동으로 다음/이전 쪽지로 이동할 수 있습니다. <a href="#"
												class="_click(nOption|openOptionPage) _ccr(fot.config) _stopDefault">환경설정
													보기</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
							<div class="divider_guide" style="display: none;"></div>
							<!-- 쪽지 목록 -->
							<!-- 쪽지 쓰기 -->
							<div class="send_window" style="display: block;">
								<div id="replyMode" style="display: none">
									<span class="tf_tit"> <span class="recipient">받는사람</span>
									</span> <span class="tf_cont"> <a id="reply_id" href="#"></a>
									</span>
								</div>
								<div id="normalMode" style="display: block;">
									<span class="tf_tit"> <label for="who" class="recipient">받는사람</label>

									</span> <span class="tf_cont"> <span id="toTextbox" class="tx">
											<form name="sendmessage" method=post action="SendMessage">
												<input type="hidden" name="mmid" value="${mmid }"> <input
													type="text" id="who" name="remmid" placeholder="받으시는분  아이디"
													onkeyup="nWrite.checkTargetId(event)"
													onfocus="nWrite.clearInitMessageFocus();"
													onblur="nWrite.clearInitMessageBlur();"
													style="ime-mode: disabled;">
									</span>
									</span>
								</div>
								<div class="writing_area">
									<textarea id="writeNote" name="text" style="resize: none;"
										onkeyup="nWrite.checkContentLength();" rows="5" cols="55"
										placeholder="쪽지 내용을 입력해 주세요."></textarea>
								</div>
								</form>
								<div>${message }</div>




								<div id="save_tooltip" class="dh_layer"
									style="top: 25px; left: 50px; display: none">
									<div class="ly_savenote">
										<p>
											보낸쪽지함에 저장하면<br>수신 확인/발송 취소가 가능합니다.
										</p>
										<span class="arr"></span>
									</div>
								</div>
							</div>


						</div>
					</div>
					<!-- 쪽지 쓰기 -->
				</div>
				<!-- 컨텍스트 레이어 -->
				<div id="user_info_layer" class="dh_layer" style="display: none">
					<div class="type_a">
						<ul class="selector">
							<li><a id="gotoMail" href="javascript:;"
								onmouseover="this.focus();">메일보내기</a></li>
							<li><a id="gotoBlog" href="javascript:;"
								onmouseover="this.focus();">블로그보기</a></li>
							<li><a id="gotoKin" href="javascript:;"
								onmouseover="this.focus();">지식iN정보보기</a><a href="#"
								class="blind" onfocus="nCore.tabAction('user_info_layer');"></a></li>
						</ul>
					</div>
				</div>
				<!-- //컨텍스트 레이어 -->

				<!-- 환경설정 -->
				<div id="cont_option_area" class="note_setup" style="display: none">
					<div class="content_header">
						<!-- 타이틀 -->
						<div class="list_head">
							<h3>환경설정</h3>
							<span class="default"><a
								class="back_home _click(nOption|closeOptionPage) _ccr(cfg.back) _stopDefault"
								href="#"><span class="icon_back"></span>쪽지로 돌아가기</a></span>
						</div>
						<!-- //타이틀 -->
						<!-- [D] 좌측메뉴 접기 버튼 마크업 변경 -->
						<a href="#"
							class="btn_fold _click(nFolder|toggleSnb) _stopDefault"> <span
							class="ico"></span> <span class="blind">좌측메뉴 접기</span>
						</a>
					</div>
					<div class="setup_menu_area">
						<h4 class="blind">환경설정 메뉴</h4>
						<ul>
							<li id="general_tab_li" class="on"><a href="#"
								class="_click(nOption|getOption|General) _ccr(cfg.basic) _stopDefault">기본
									설정</a></li>
							<li id="receive_tab_li"><a href="#"
								class="_click(nOption|getOption|Receive) _ccr(cfg.rcv) _stopDefault">수신
									설정</a></li>
							<li id="spam_tab_li"><a href="#"
								class="_click(nOption|getOption|Spam) _ccr(cfg.spam) _stopDefault">스팸
									설정</a></li>
						</ul>
					</div>
					<div class="setup_content">
						<!-- 기본설정 -->
						<div id="generalOption" class="cont_wrap">
							<h4 class="blind">기본 설정</h4>
							<p class="description">쪽지를 편리하게 읽고 쓸 수 있도록 설정을 변경합니다.</p>
							<h5 class="subtitle">읽기 설정</h5>
							<ul class="setup_items">
								<li><h6 class="set_tit">쪽지 글꼴 설정</h6>
									<div class="set_option">
										<select id="note_font" title="쪽지 글꼴 설정"
											onclick="ccr(this,'cfg_bas.fontset',event);">
											<option value="Dotum">시스템 글꼴</option>
											<option value="Nanumgothic">나눔고딕</option>
										</select>
									</div></li>
								<li><h6 class="set_tit">새 창으로 쪽지 읽기</h6>
									<div class="set_option">
										<input id="use_popup_read" type="radio" class="setup_input"
											onclick="ccr(this,'cfg_bas.newon',event);" name="ns_r_1"><label
											for="use_popup_read">사용함</label> <input id="unuse_popup_read"
											type="radio" class="setup_input"
											onclick="ccr(this,'cfg_bas.newoff',event);" name="ns_r_1"><label
											for="unuse_popup_read">사용안함</label>
										<p class="desc">[쪽지 목록만 보기]에서 새 쪽지를 선택했을 때만 설정한 내용이 적용됩니다.</p>
									</div></li>
								<li><h6 class="set_tit">새 쪽지 통수 표시</h6>
									<div class="set_option">
										<input id="view_new_count_all" type="radio"
											class="setup_input" name="ns_r_5"><label
											for="view_new_count_all">받은쪽지함 + 내게쓴쪽지함 + 쪽지보관함</label> <input
											id="view_new_count_received" type="radio" class="setup_input"
											name="ns_r_5"><label for="view_new_count_received">받은쪽지함</label>
									</div></li>
								<li><h6 class="set_tit">쪽지 삭제 후 화면 표시</h6>
									<div class="set_option">
										<input id="action_after_delete1" type="radio"
											class="setup_input" onclick="ccr(this,'cfg_bas.list',event);"
											name="ns_r_2"><label for="action_after_delete1">쪽지
											목록 보기</label> <input id="action_after_delete2" type="radio"
											class="setup_input"
											onclick="ccr(this,'cfg_bas.prevmail',event);" name="ns_r_2"><label
											for="action_after_delete2">이전 쪽지 보기</label> <input
											id="action_after_delete3" type="radio" class="setup_input"
											onclick="ccr(this,'cfg_bas.nextmail',event);" name="ns_r_2"><label
											for="action_after_delete3">다음 쪽지 보기</label>
										<p class="desc">쪽지 읽기 화면에서 쪽지를 삭제하거나 이동한 후의 동작을 설정합니다.</p>
									</div></li>
							</ul>
							<h5 class="subtitle">쓰기 설정</h5>
							<ul class="setup_items">
								<li><h6 class="set_tit">새 창으로 쪽지 쓰기</h6>
									<div class="set_option">
										<input id="use_popup_write" type="radio" class="setup_input"
											onclick="ccr(this,'cfg_bas.newwindowon',event);"
											name="ns_r_3"><label for="use_popup_write">사용함</label>
										<input id="unuse_popup_write" type="radio" class="setup_input"
											onclick="ccr(this,'cfg_bas.newwindowoff',event);"
											name="ns_r_3"><label for="unuse_popup_write">사용안함</label>
									</div></li>
							</ul>
							<h5 id="view_setup_1" class="subtitle">보기설정</h5>
							<ul id="view_setup_2" class="setup_items">
								<li><h6 class="set_tit">쪽지 목록 보기</h6>
									<div class="set_option">
										<input id="divideMode_L" type="radio" class="setup_input"
											onclick="ccr(this,'cfg_bas.titleonly',event);nOption.toggleOpenFirstNote(this.id);"
											name="ns_r_4"><label for="divideMode_L"><span
											class="ico_list1"></span> 쪽지 목록만 보기</label> <input id="divideMode_H"
											type="radio" class="setup_input"
											onclick="ccr(this,'cfg_bas.vertical',event);nOption.toggleOpenFirstNote(this.id);"
											name="ns_r_4"><label for="divideMode_H"><span
											class="ico_list2"></span> 좌우 분할로 보기</label> <input id="divideMode_V"
											type="radio" class="setup_input"
											onclick="ccr(this,'cfg_bas.hortizontal',event);nOption.toggleOpenFirstNote(this.id);"
											name="ns_r_4"><label for="divideMode_V"><span
											class="ico_list3"></span> 상하 분할로 보기</label>
										<p class="sub_option">
											<input id="open_firstnote" type="checkbox"
												class="setup_input"
												onclick="ccr(this,'cfg_bas.autodisplay',event);"><label
												for="open_firstnote">목록의 첫 번째 쪽지를 자동으로 표시하기</label>
										</p>
										<p class="desc">분할모드 화면에서 목록의 첫 번째 쪽지를 자동으로 표시합니다.</p>
									</div></li>
							</ul>
							<div class="btns">
								<a href="#"
									class="button b _click(nOption|setOption|General) _ccr(cfg_bas.ok) _stopDefault">확인</a>
								<a href="#"
									class="button _click(nOption|closeOptionPage) _ccr(cfg_bas.cancel) _stopDefault">취소</a>
								<a href="#"
									class="button set_default _click(nOption|setDefault|General) _ccr(cfg_bas.default) _stopDefault">기본
									설정으로</a>
							</div>
						</div>
						<!-- //기본설정 -->

						<!-- 수신 설정 -->
						<div id="receiveOption" class="cont_wrap">
							<h4 class="blind">기본 설정</h4>
							<p class="description">개인과 카페에서 발송되는 쪽지의 수신 범위를 설정하고 쪽지 차단
								목록을 관리할 수 있습니다.</p>
							<h5 class="subtitle">쪽지 수신</h5>
							<ul class="setup_items">
								<li><h6 class="set_tit">개인</h6>
									<div class="set_option">
										<p>
											<input id="recevie_policy_1" type="radio" class="setup_input"
												onclick="ccr(this,'cfg_bas.allowall',event);" name="ns_r_1"><label
												for="recevie_policy_1">모든 쪽지를 받습니다.</label>
										</p>
										<p>
											<input id="recevie_policy_2" type="radio" class="setup_input"
												onclick="ccr(this,'cfg_bas.blogonly',event);" name="ns_r_1"><label
												for="recevie_policy_2">블로그 이웃의 쪽지만 받습니다.</label>
										</p>
										<p>
											<input id="recevie_policy_3" type="radio" class="setup_input"
												onclick="ccr(this,'cfg_bas.denyall',event);" name="ns_r_1"><label
												for="recevie_policy_3">모든 쪽지를 받지 않습니다.</label>
										</p>
										<p class="desc">※ 시스템에 의해 발송되는 쪽지는 수신을 차단하실 수 없습니다.</p>
									</div></li>
								<li><h6 class="set_tit">카페전체</h6>
									<div class="set_option">
										<div class="cafe_receive_range">
											<div class="cafe_allow_list">
												<label for="cafe_allow_select">수신 허용된 카페 목록</label> <select
													id="cafe_allow_select" size="9" multiple="multiple"
													onchange="nOption.toggleCafe(this);">
												</select> <a href="#"
													class="select_all _click(nOption|toggleSelectAll|cafe_allow_select) _stopDefault">전체
													선택</a>
											</div>
											<div class="cafe_deny_list">
												<label for="cafe_block_select">수신 차단된 카페 목록</label> <select
													id="cafe_block_select" size="9" multiple="multiple"
													onchange="nOption.toggleCafe(this);">
												</select> <a href="#"
													class="select_all _click(nOption|toggleSelectAll|cafe_block_select) _stopDefault">전체
													선택</a>
											</div>
											<div class="btns">
												<p>
													<a href="#" id="change_allow"
														class="button _click(nOption|moveSelect|cafe_block_select|cafe_allow_select|1) _ccr(cfg_rcv.allowcafe) _stopDefault"><span
														class="ico_allow"></span>허용</a>
												</p>
												<p>
													<a href="#" id="change_deny"
														class="button _click(nOption|moveSelect|cafe_allow_select|cafe_block_select|0) _ccr(cfg_rcv.denycafe) _stopDefault"><span
														class="ico_deny"></span>차단</a>
												</p>
											</div>
										</div>
									</div></li>
							</ul>
							<p class="description2">카페 목록 허용/차단 후 [확인] 버튼을 클릭하셔야 적용됩니다.</p>
							<h5 class="subtitle">
								쪽지 차단 목록 <span class="sub_text">(차단된 사람 총 <span
									id="block_user_count" class="cnt b">6</span> 명)
								</span>
							</h5>
							<div class="add_deny_id">
								<label for="block_userid_input" class="blind">네이버 아이디를
									입력하세요.</label> <input type="text" class="setup_textfield "
									id="block_userid_input" value="네이버 아이디를 입력하세요"
									onfocus="nOption.focusBlockUserId(this);"
									onblur="nOption.blurBlockUserId(this);"
									style="ime-mode: disabled;"> <a href="#"
									class="button_s _click(nOption|addBlockUser) _ccr(cfg_rcv.denyuser) _stopDefault">수신
									차단 추가</a>
							</div>
							<div class="block_list">
								<table cellspacing="0" summary="쪽지 차단 목록" class="cutlistTable">
									<!--<caption>쪽지 차단 목록</caption>-->
									<colgroup>
										<col width="35%">
										<col width="15%">
										<col width="35%">
										<col width="15%">
									</colgroup>
									<thead>
										<tr>
											<th scope="row">아이디</th>
											<th scope="row" class="line">날짜</th>
											<th scope="row">아이디</th>
											<th scope="row" class="last-child">날짜</th>
										</tr>
									</thead>
									<tbody id="block_user_tbody">
										<!--
									<tr>
										<td colspan="4" align="center"> 차단하신 사용자가 없습니다.</td>
									</tr>
									
									<tr>
										<td>
											<input id="ns_r_06" type="checkbox" name="blockId" class="setup_input" value="rewindme2">
											<label for="ns_r_06"><a href="#">rewindme(rewindme2)</a></label>
										</td>
										<td class="line"><em>12-10-15[16:20]</em></td>
										<td>
											<input id="ns_r_07" type="checkbox" name="blockId" class="setup_input" value="rewindme3">
											<label for="ns_r_07"><a href="#">rewindme(rewindme2)</a></label>
										</td>
										<td class="line"><em>12-10-15[16:20]</em></td>
									</tr>
									-->
									</tbody>
								</table>

								<div class="list_under">
									<div class="paginate">
										<h4 class="blind">쪽지 차단 목록 페이지 이동</h4>
										<!-- [D] 띄어쓰기, 줄바꿈 지켜주세요. -->
										<a class="pre_end_n" title="첫 페이지로 이동"><span class="blind">첫
												페이지로 이동</span></a><a class="pre_n" title="이전 페이지로 이동"><span
											class="blind">이전 페이지로 이동</span></a> <strong>1</strong><a href="#">2</a>
										<a class="next_n" title="다음 페이지로 이동"><span class="blind">다음
												페이지로 이동</span></a><a href="#" class="next_end" title="마지막 페이지로 이동"><span
											class="blind">마지막 페이지로 이동</span></a>
									</div>
									<p class="select_all">
										<input id="ns_r_08" type="checkbox"
											class="setup_input _click(nOption|selectAllBlockUserList) _ccr(cfg_rcv.salldenyuser)"><label
											for="ns_r_08">전체선택</label>
									</p>
									<p class="do_allow">
										<a href="#"
											class="button_s _click(nOption|removeBlockuser) _ccr(cfg_rcv.allowuser) _stopDefault"
											onclick="return false">수신 허용</a>
									</p>
								</div>
							</div>
							<div class="btns">
								<a href="#"
									class="button b _click(nOption|setOption|Receive) _ccr(cfg_rcv.ok) _stopDefault">확인</a>
								<a href="#"
									class="button _click(nOption|closeOptionPage) _ccr(cfg_rcv.cancel) _stopDefault">취소</a>
								<a href="#"
									class="button set_default _click(nOption|setDefault|Receive) _ccr(cfg_rcv.default) _stopDefault">기본
									설정으로</a>
							</div>
						</div>
						<!-- //수신 설정 -->

						<!-- 스팸 설정 -->
						<div id="spamOption" class="cont_wrap">
							<h4 class="blind">기본 설정</h4>
							<p class="description">스팸 쪽지함 설정 및 스팸 키워드를 직접 등록하여 차단하실 수
								있습니다.</p>
							<h5 class="subtitle">스팸 쪽지함 설정</h5>
							<ul class="setup_items">
								<li><h6 class="set_tit">스팸 쪽지함 숨기기</h6>
									<div class="set_option">
										<input id="unuse_spambox" type="radio" class="setup_input"
											onclick="ccr(this,'cfg_spam.disapper',event);" name="ns_r_1"><label
											for="unuse_spambox">숨기기</label> <input id="use_spambox"
											type="radio" class="setup_input"
											onclick="ccr(this,'cfg_spam.appear',event);" name="ns_r_1"><label
											for="use_spambox">표시하기</label>
										<p class="desc">
											스팸쪽지함에 있는 쪽지는 새 쪽지 통수에 표시하지 않습니다.<br>스팸쪽지함을 숨기기 기능을 사용해도
											스팸으로 신고된 쪽지는 스팸쪽지함으로 이동됩니다.
										</p>
									</div></li>
								<li class="double"><h6 class="set_tit">
										스팸 쪽지함 <br>쪽지 보관 기간
									</h6>
									<div class="set_option">
										<select id="spam_save_period" title="스팸 쪽지함  쪽지 보관 기간"
											onclick="ccr(this,'cfg_spam.saveterm',event);">
											<option value="0">자동삭제 안함</option>
											<option value="5">5일</option>
											<option value="10">10일</option>
											<option value="15">15일</option>
											<option value="20">20일</option>
											<option value="25">25일</option>
											<option value="30">30일</option>
											<option value="35">35일</option>
											<option value="40">40일</option>
											<option value="45">45일</option>
											<option value="50">50일</option>
										</select>
									</div></li>
							</ul>
							<h5 class="subtitle">스팸신고 쪽지 설정</h5>
							<ul class="setup_items">
								<li><h6 class="set_tit">스팸신고 쪽지 처리</h6>
									<div class="set_option">
										<input id="move_spambox" type="radio" class="setup_input"
											onclick="ccr(this,'cfg_spam.spammove',event);" name="ns_r_2"
											checked="true"><label for="move_spambox">스팸
											쪽지함으로 이동</label> <input id="delete_spam" type="radio"
											class="setup_input" onclick="ccr(this,'cfg_spam.del',event);"
											name="ns_r_2"><label for="delete_spam">영구 삭제</label>
										<p class="desc">[영구 삭제]로 설정하면 스팸 신고 시 쪽지가 영구 삭제되어 복구되지 않으니
											주의하세요.</p>
									</div></li>
								<li><h6 class="set_tit">스팸 쪽지 보낸이 차단</h6>
									<div class="set_option">
										<input id="use_block_spam" type="checkbox"
											class="setup_input _click(nOption|clickSpamBlock)"
											onclick="(this);"><label for="use_block_spam">스팸
											신고한 쪽지 보낸이 차단하기</label>
									</div></li>
							</ul>

							<h5 class="subtitle">
								스팸 키워드 직접등록 <span class="posr status">등록된 스팸 키워드 (<em
									id="keyword_count">0</em>/100) <a href="#"
									class="icon_tip _click(nOption|showTooltipLayer|keyword_tooltip_layer) _ccr(cfg_spam.kwordhelp) _stopDefault"><span
										class="blind">도움말</span></a></span>
							</h5>
							<ul class="form_ul1">
								<li>
									<h5 class="form_title">
										<label for="add_sKeyword">스팸 키워드</label>
									</h5>
									<div class="form_content">
										<div class="keyword_register">
											<p class="input_keyword">
												<input type="text" id="add_sKeyword" name="input_keyword"
													class="input_text">
												<button type="button"
													class="button_s _click(nOption|addKeyword) _ccr(cfg_spam.kwordadd)">
													<img
														src="https://ssl.pstatic.net/static/pwe/mail/deskhome/b.gif"
														width="6" height="6" class="icon_add" alt="">추가
												</button>
											</p>
											<div id="ly_keyword_list" class="list_keyword">
												<ul id="keyword_list">
												</ul>
											</div>
											<p class="btn_area">
												<span class="desc_under">* Shift키를 사용해서 여러 개를 선택할 수
													있습니다.</span>
												<button type="button"
													class="btn_txt _click(nOption|removeKeyword) _ccr(cfg_spam.delkword)">
													<img
														src="https://ssl.pstatic.net/static/pwe/mail/deskhome/b.gif"
														width="6" height="5" alt="" class="icon_delete">삭제
												</button>
											</p>
										</div>
									</div>
								</li>
							</ul>
							<div class="btns">
								<a href="#"
									class="button b _click(nOption|setOption|Spam) _ccr(cfg_spam.ok) _stopDefault">확인</a>
								<a href="#"
									class="button _click(nOption|closeOptionPage) _ccr(cfg_spam.cancel) _stopDefault">취소</a>
								<a href="#"
									class="button set_default _click(nOption|setDefault|Spam) _ccr(cfg_spam.default) _stopDefault">기본
									설정으로</a>
							</div>
						</div>
						<!-- //스팸 설정 -->
						<!-- 컨텍스트 레이어 -->
						<div id="user_info_layer_option" class="dh_layer"
							style="display: none">
							<div class="type_a">
								<ul class="selector">
									<li><a id="gotoBlog_option" href="#">블로그보기</a></li>
									<li><a id="gotoKin_option" href="#">지식iN정보보기</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!-- 환경설정 -->
			</div>
		</div>
	</div>
	</div>


	</div>
</body>


</html>