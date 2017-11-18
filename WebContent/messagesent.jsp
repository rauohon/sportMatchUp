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
	
		<!-- container -->
		<div id="container">
			<!-- 서비스 메뉴 -->
			<div id="nav_snb">
				<h3 class="blind">쪽지</h3>
				<div id="menu_write" class="btn_workset">
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
							
								</div>
								<!-- //쪽지 목록 제목 -->
								${messagelist }



							</div>
						</div>
					</div>
				</div>
			</div>
</body>
</html>
