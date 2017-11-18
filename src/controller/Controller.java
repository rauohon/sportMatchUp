package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;
import services.*;


@WebServlet({"/Access","/AccessOut", "/Join", "/MemberInfo", "/MemberLcUpdate", 
	"/MemberDrop", "/MemberMatchInfo", "/SendMessage", "/MessageSendPage","/MessageSent",
	"/MemberInfoProfile" ,"/MessageInfo","/GoToMain","/MessageReceiveInfo" ,"/PwCheck","/PwCheckPage",
	"/MemberLcUpdatePage","/FindPassword", "/MatchPage","/MatchApplyPage", "/MatchApply", "/MyMatchInfo","/MatchInsertPage", "/MatchInsert", "/MatAccMemInfPage", 
	"/MatchFixPage", "/MatchFix", "/MatchApplierFix", "/MatchRejectApplier", "/MatchCreateDel", "/MatchCreateUpdPage", 
	"/MatchCreateUpd", "/MatchApplyDel", "/MatchComCreDel", "/MatchComAppDel", "/MatchEnd", "/SearchInfo",
	"/AdminSearchPage", "/AdminSearchInfo", "/AdminMemberList"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Bean b;
	MemberService memberserivce;
	MatchService ms;
	AdminService as;


	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward af = null;
		b = new Bean();
		/* 요청서비스명 추출 */
		String command = request.getRequestURI()
				.substring(request.getContextPath().length());

		/*request와 bean을 Service에 전달*/
		if(command.equals("/Access")){
			System.out.println("ACCESS");
			/*로그인*/

			b.setMmid(request.getParameter("mmid"));
			b.setMmpw(request.getParameter("mmpw"));

			memberserivce = new MemberService(request);

			af = memberserivce.entrance('A', b);

		} else if (command.equals("/Join")){
			System.out.println("Join");
			/*회원가입*/

			b.setMmid(request.getParameter("mmid"));
			/*mb.setPassword(request.getParameterValues("mmpw")[0]);*/
			b.setMmpw(request.getParameter("mmpw"));
			b.setMmname(request.getParameter("mmname"));
			b.setMmnumber(request.getParameter("mmnumber"));
			b.setMmemail(request.getParameter("mmemail"));
			b.setLccode(request.getParameter("lccode"));

			System.out.println(request.getParameter("mmid"));	
			System.out.println(request.getParameter("mmpw"));
			System.out.println(request.getParameter("mmname"));
			System.out.println(request.getParameter("mmnumber"));
			System.out.println(request.getParameter("mmemail"));
			System.out.println(request.getParameter("lccode"));
			memberserivce = new MemberService(request);

			af = memberserivce.entrance('B', b);

		} else if (command.equals("/AccessOut")){
			System.out.println("AccessOut");
			/*회원가입*/

			b.setMmid(request.getParameter("mmid"));
			b.setMmpw(request.getParameter("mmpw"));
			b.setLccode(request.getParameter("lccode"));

			System.out.println(request.getParameter("mmid"));	
			System.out.println(request.getParameter("mmpw"));
			System.out.println(request.getParameter("lccode"));
			memberserivce = new MemberService(request);

			af = memberserivce.entrance('C', b);

		}else if (command.equals("/MemberInfo")){
			System.out.println("MemberInfo");
			/*회원가입*/

			b.setMmid(request.getParameter("mmid"));
			System.out.println(request.getParameter("mmid"));
			memberserivce = new MemberService(request);

			af = memberserivce.entrance('D', b);

		}else if (command.equals("/MemberDrop")){
			System.out.println("MemberDrop");
			/*회원가입*/
			b.setMmid(request.getParameter("mmid"));
			System.out.println(request.getParameter("mmid"));
			System.out.println("컨트롤러 mmid 확인");

			memberserivce = new MemberService(request);

			af = memberserivce.entrance('E', b);
		}else if (command.equals("/MemberLcUpdate")){
			System.out.println("MemberLcUpdate");
			/*회원가입*/

			b.setMmid(request.getParameter("mmid"));
			b.setLccode(request.getParameter("lccode"));
			System.out.println(request.getParameter("mmid"));
			System.out.println("컨트롤러  멤버 업데이트 mmid 확인");
			memberserivce = new MemberService(request);

			af = memberserivce.entrance('F', b);


		}else if (command.equals("/MessageSendPage")){
			System.out.println("MessageSendPage");

			b.setMmid(request.getParameter("mmid"));
			b.setLccode(request.getParameter("lccode"));
			System.out.println(request.getParameter("mmid"));
			System.out.println(" MessgeSendPage mmid 확인");

			memberserivce = new MemberService(request);

			af = memberserivce.entrance('G', b);

		}else if (command.equals("/SendMessage")){
			System.out.println("SendMessage");


			b.setMmid(request.getParameter("mmid"));
			b.setRemmid(request.getParameter("remmid"));
			b.setText(request.getParameter("text"));
			System.out.println(request.getParameter("mmid"));
			System.out.println(request.getParameter("remmid"));
			System.out.println(request.getParameter("text"));
			System.out.println("SendMessgae mmid 확인");

			memberserivce = new MemberService(request);

			af = memberserivce.entrance('H', b);
		}else if (command.equals("/MessageInfo")){
			System.out.println("MessageInfo");

			b.setMmid(request.getParameter("mmid"));
			System.out.println(request.getParameter("mmid"));
			System.out.println("MessageInfo mmid 확인");

			memberserivce = new MemberService(request);

			af = memberserivce.entrance('I', b);
		}else if (command.equals("/MessageReceiveInfo")){
			System.out.println("MessageReceiveInfo");

			b.setMmid(request.getParameter("mmid"));
			System.out.println(request.getParameter("mmid"));
			System.out.println("MessageReceiveInfo mmid 확인");

			memberserivce = new MemberService(request);

			af = memberserivce.entrance('J', b);



		}else if (command.equals("/MemberInfoProfile")){
			System.out.println("MemberInfoProfile");

			b.setMmid(request.getParameter("mmid"));
			System.out.println(request.getParameter("mmid"));

			memberserivce = new MemberService(request);

			af = memberserivce.entrance('M', b);
		}

		else if(command.equals("/GoToMain")) {
			System.out.println("GoToMain");

			b.setMmid(request.getParameter("mmid"));
			System.out.println(request.getParameter("mmid : " + b.getMmid()));
			memberserivce = new MemberService(request);

			af = memberserivce.entrance('N', b);
			/*af = ms.entrance(1, b);*/

		}	
		else if(command.equals("/MessageSent")) {
			System.out.println("MessageSent");

			b.setMmid(request.getParameter("mmid"));
			System.out.println(request.getParameter("mmid"));
			memberserivce = new MemberService(request);
			af = memberserivce.entrance('L', b);
		}	
		else if(command.equals("/PwCheck")) {
			System.out.println("PwCheck");
			b.setMmpw(request.getParameter("mmpw"));
			b.setMmid(request.getParameter("mmid"));
			System.out.println(request.getParameter("mmid"));
			memberserivce = new MemberService(request);
			af = memberserivce.entrance('Z', b);
		}	

		else if(command.equals("/PwCheckPage")) {
			System.out.println("PwCheckPage");

			b.setMmid(request.getParameter("mmid"));
			System.out.println(request.getParameter("mmid"));
			memberserivce = new MemberService(request);
			af = memberserivce.entrance('Y', b);


		}else if (command.equals("/MemberLcUpdatePage")){
			System.out.println("MemberLcUpdatePage");
			/*회원가입*/

			b.setMmid(request.getParameter("mmid"));
			b.setLccode(request.getParameter("lccode"));
			System.out.println(request.getParameter("mmid"));
			System.out.println("컨트롤러  멤버 업데이트  페이지 이동 mmid 확인");
			memberserivce = new MemberService(request);

			af = memberserivce.entrance('X', b);
		
		
		}else if (command.equals("/FindPassword")){
		System.out.println("FindPassword");
		/*회원가입*/

		b.setMmid(request.getParameter("mmid"));
		b.setMmname(request.getParameter("mmname"));
		b.setMmemail(request.getParameter("mmemail"));
		System.out.println(request.getParameter("mmid"));
		System.out.println("컨트롤러:  비밀번호찾기   mmid 확인");
		memberserivce = new MemberService(request);

		af = memberserivce.entrance('P', b);
	}
		
		
		
		///////////////////////////////////////////////////////////////
		////////////////////////// 이하 매칭 관련 //////////////////////////
		//////////////////////////////////////////////////////////////
		
		else if (command.equals("/MyMatchInfo")){
			// 개인 경기 정보 페이지 이동
			b.setMmid(request.getParameter("mmid"));

			ms = new MatchService(request);

			af = ms.entrance(2, b);

		}else if (command.equals("/MatchInsertPage")){
			// 경기 생성 페이지 이동
			b.setMmid(request.getParameter("mmid"));

			ms = new MatchService(request);

			af = ms.entrance(3, b);

		}else if (command.equals("/MatchInsert")){
			// 경기 생성
			b.setMmid(request.getParameter("mmid"));
			b.setDescription(request.getParameter("description"));
			String time = request.getParameter("fixyear")+request.getParameter("fixmonth")+request.getParameter("fixdate")+request.getParameter("fixtime")+request.getParameter("fixminute")+"00";

			b.setFixdate(time);
			b.setStcode(request.getParameter("stcode"));
			b.setLccode(request.getParameter("lccode"));

			ms = new MatchService(request);

			af = ms.entrance(4, b);

		}else if (command.equals("/MatAccMemInfPage")){
			// 경기 신청자 정보 페이지 이동
			b.setMmid(request.getParameter("mmid"));
			b.setAcid(request.getParameter("acid"));
			b.setRqid(request.getParameter("rqid"));			

			ms = new MatchService(request);

			af = ms.entrance(5, b);

		}else if (command.equals("/MatchApplierFix")){
			// 경기 신청자 확정
			b.setMmid(request.getParameter("mmid"));
			b.setAcid(request.getParameter("acid"));
			b.setRqid(request.getParameter("rqid"));	

			ms = new MatchService(request);

			af = ms.entrance(6, b);

		}else if (command.equals("/MatchRejectApplier")){
			// 경기 신청자 거절
			b.setMmid(request.getParameter("mmid"));
			b.setAcid(request.getParameter("acid"));
			b.setRqid(request.getParameter("rqid"));	

			ms = new MatchService(request);

			af = ms.entrance(7, b);

		}else if (command.equals("/MatchCreateUpdPage")){
			// 경기 생성 내용 수정 페이지 이동
			b.setMmid(request.getParameter("mmid"));
			b.setRqid(request.getParameter("rqid"));
			b.setDescription(request.getParameter("description"));

			ms = new MatchService(request);

			af = ms.entrance(8, b);

		}else if (command.equals("/MatchCreateUpd")){
			// 경기 생성 내용 수정
			String time = request.getParameter("fixyear")+request.getParameter("fixmonth")+request.getParameter("fixdate")+request.getParameter("fixtime")+request.getParameter("fixminute")+"00";
			b.setMmid(request.getParameter("mmid"));
			b.setRqid(request.getParameter("rqid"));
			b.setDescription(request.getParameter("description"));
			b.setFixdate(time);
			b.setStcode(request.getParameter("stcode"));
			b.setLccode(request.getParameter("lccode"));
			System.out.println(b.getRqid() + " : rqid contro");
			ms = new MatchService(request);
			af = ms.entrance(9, b);

		}else if (command.equals("/MatchCreateDel")){
			// 생성한 경기 삭제
			b.setMmid(request.getParameter("mmid"));
			b.setRqid(request.getParameter("rqid"));

			ms = new MatchService(request);

			af = ms.entrance(10, b);

		}else if (command.equals("/MatchApplyPage")){
			// 신청한 경기 삭제
			b.setMmid(request.getParameter("mmid"));
			b.setRqid(request.getParameter("rqid"));
			ms = new MatchService(request);

			af = ms.entrance(11, b);

		}else if (command.equals("/MatchApply")){
			// 생성되어 있는 경기에 참가 신청
			b.setMmid(request.getParameter("mmid"));
			b.setRqid(request.getParameter("rqid"));

			ms = new MatchService(request);

			af = ms.entrance(12, b);

		}else if (command.equals("/MatchApplyDel")){
			// 참가 신청 취소
			b.setMmid(request.getParameter("mmid"));
			b.setRqid(request.getParameter("rqid"));;
			ms = new MatchService(request);
			af = ms.entrance(13, b);

		}else if (command.equals("/MatchPage")){
			// 신청 가능한 전체 경기 페이지 이동
			b.setMmid(request.getParameter("mmid"));

			ms = new MatchService(request);

			af = ms.entrance(14, b);

		}else if (command.equals("/MatchFixPage")){
			// 경기 확정 페이지 이동
			b.setMmid(request.getParameter("mmid"));
			b.setRqid(request.getParameter("rqid"));

			ms = new MatchService(request);
			af = ms.entrance(15, b);

		}else if (command.equals("/MatchFix")){
			// 경기 확정
			b.setMmid(request.getParameter("mmid"));
			b.setRqid(request.getParameter("rqid"));

			ms = new MatchService(request);
			af = ms.entrance(16, b);

		}else if (command.equals("/MatchEnd")){
			// 경기 완료 설정
			b.setMmid(request.getParameter("mmid"));
			b.setRqid(request.getParameter("rqid"));
			ms = new MatchService(request);
			af = ms.entrance(17, b);
			
		}else if (command.equals("/MatchComCreDel")){
			// 완료된 내가 생성한 경기 삭제
			b.setMmid(request.getParameter("mmid"));
			b.setRqid(request.getParameter("rqid"));

			ms = new MatchService(request);

			af = ms.entrance(18, b);

		}else if (command.equals("/MatchComAppDel")){
			// 완료된 내가 신청한 경기 삭제
			b.setMmid(request.getParameter("mmid"));
			b.setAcid(request.getParameter("mmid"));
			b.setRqid(request.getParameter("rqid"));

			ms = new MatchService(request);
			
			af = ms.entrance(19, b);

		}else if (command.equals("/SearchInfo")){
			// 검색
			b.setMmid(request.getParameter("mmid"));			
			b.setTitle(request.getParameter("column"));
			b.setDescription(request.getParameter("description"));
			
			ms = new MatchService(request);
			
			af = ms.entrance(20, b);
			
		}else if (command.equals("/AdminSearchPage")){
			// 관리자 검색
			
			b.setMmid(request.getParameter("mmid"));
						
			as = new AdminService(request);
			
			af = as.entrance(1, b);
			
		}else if (command.equals("/AdminSearchInfo")){
			// 관리자 검색
			
			b.setMmid(request.getParameter("mmid"));
			
			b.setTitle(request.getParameter("type"));
			b.setDescription(request.getParameter("keyword"));
			b.setStcode(request.getParameter("updown"));
			b.setMetitle(request.getParameter("metitle"));
						
			as = new AdminService(request);
			
			af = as.entrance(2, b);
			
		}else if (command.equals("/AdminMemberList")){
			b.setMmid(request.getParameter("mmid"));

	         as = new AdminService(request);

	         af = as.entrance(3, b);
	         
	      }



		/*sendDirect Or forward*/
		if(af.isRedirect()){
			response.sendRedirect(af.getPage());
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(af.getPage());
			dispatcher.forward(request, response);
		}
	}
}

