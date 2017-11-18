<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
   content="Credit Login / Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript">
    addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
  
</script>
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Custom Theme files -->
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"
   media="all">
<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
   media="all" />
<link href="css/style2.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link href="//fonts.googleapis.com/css?family=Oswald:400,700"
   rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
   rel="stylesheet">

<!-- //web font -->

<link rel="stylesheet" href="css/page.css">
<link rel="stylesheet" href="fontello/css/fontello.css">

<script src="https://code.jquery.com/jquery-2.2.4.min.js" 
integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
crossorigin="anonymous"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<script src="http://cdn.jsdelivr.net/mojs/latest/mo.min.js"></script>


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
						data-toggle="dropdown" href="">마이페이지 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a class="w3_play_icon1"
                  href="#small-dialog1">회원가입</a></li>
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
					<li><a class="w3_play_icon1"
                  href="#small-dialog1"><span
							class="glyphicon glyphicon-user"></span> 회원가입</a></li>
					<li><a href="login.jsp"><span
							class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- navigator 끝 -->


	<article>
		<div class="content">최적의 매치 시스템을 통해 스포츠매니아들의 경기 매치를 성사하여 최고의 경기를 즐길
		수 있는 서비스를 제공해 드리겠습니다 </div>
	</article>
	<div class="music_play">
		<nav>
			<ul>
				<li><a href="page1.html">page1</a></li>
				<li><a href="page2.html">page2</a></li>
			</ul>
		</nav>
		<ul class="player">
			<li><a href="#play" class="play icon-play"><span>play</span></a></li>
			<li><a href="#stop" class="pause icon-pause"><span>pause</span></a></li>
		</ul>
	</div>
	
	
	 <div id="small-dialog1" class="mfp-hide">
      <div class="contact-form1">
         <div class="contact-w3-agileits">
            <h3>Register Form</h3>
            <form action="Join" method="post">
               <div class="form-sub-w3ls">
                  <input placeholder="ID" name="mmid" type="text" required="">
                  <div class="icon-agile">
                     <i class="fa fa-user" aria-hidden="true"></i>
                  </div>
               </div>
                 <div class="form-sub-w3ls">
                  <input placeholder="Password" name="mmpw" type="password" required="">
                  <div class="icon-agile">
                     <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                  </div>
               </div>
               <div class="form-sub-w3ls">
                  <input placeholder="Confirm Password" type="password" required="">
                  <div class="icon-agile">
                     <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                  </div>
               </div>
               <div class="form-sub-w3ls">
                  <input placeholder="Name" name="mmname" type="text" required="">
                  <div class="icon-agile">
                     <i class="fa fa-user" aria-hidden="true"></i>
                  </div>
               </div>
                  <div class="form-sub-w3ls">
                  <input placeholder="Phonenumber" name="mmnumber" type="text" required="">
                  <div class="icon-agile">
                     <i class="fa fa-phone" aria-hidden="true"></i>
                  </div>
               </div>
               <div class="form-sub-w3ls">
                  <input placeholder="Email" name="mmemail" class="mail" type="email" required="">
                  <div class="icon-agile">
                     <i class="fa fa-envelope-o" aria-hidden="true"></i>
                  </div>
               </div>
             
               <div>
                  <select name="lccode" required>
				<option>지역선택</option>
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
         <div class="login-check">
            <label class="checkbox"><input type="checkbox"
               name="checkbox" checked="">
               <p>I Accept Terms & Conditions</p></label>
         </div>
         <div class="submit-w3l">
            <input type="submit"  value="가입하기">
         </div>
         </form>
      </div>
   </div>
	
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
   <!-- pop-up-box -->
   <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
   <!--//pop-up-box -->
   <script>
      $(document).ready(function() {
         $('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
            type : 'inline',
            fixedContentPos : false,
            fixedBgPos : true,
            overflowY : 'auto',
            closeBtnInside : true,
            preloader : false,
            midClick : true,
            removalDelay : 600,
            mainClass : 'my-mfp-zoom-in'
         });

      });
   </script>
	
	
	
</body>
<script src="page.js"></script>
</html>