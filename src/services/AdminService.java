package services;

import java.net.URLEncoder;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;


import beans.*;
import dao.*;
import controller.ActionForward;
import controller.IActionForward;


public class AdminService {
	private HttpServletRequest request = null;
	private Bean b;

	public AdminService(HttpServletRequest request){
		// Controller로부터 전달받은 request는 잡 실행 메서드에서 사용
		this.request = request;
	}

	public ActionForward entrance(int jobcode, Bean b){
		ActionForward forward = null;
		/* DownCast : Object >> OwnerBean */

		switch(jobcode){
		
		case 1 :
			/* 전체 경기 조건별 조회 */
			forward = AdminInqTotalMacthSearchPage(b);
			break;
			
		case 2 :
			/* 전체 경기 조건별 조회 */
			forward = AdminInqTotalMacthPage(b);
			break;	

		case 3 :
			/* 전체 회원 조회*/
			forward = MemberList(b);
			break;


		}
		return forward;
	}
	// 관리자가 전체 경기를 조건별로 조회 페이지
	private ActionForward AdminInqTotalMacthSearchPage(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();

		try {
			System.out.println("mmid : " + b.getMmid());
			request.setAttribute("mmid", b.getMmid());
			forward.setRedirect(false);
			forward.setPage("adsearch.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}		
		return forward;
	}
	// 관리자가 전체 경기를 조건별로 조회 페이지
	private ActionForward AdminInqTotalMacthPage(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> bList;

		try {
			bList = dao.adminInqTotalMacthDao(b, b.getTitle(), b.getDescription(), b.getStcode());
			request.setAttribute("adminTotalMatchSearch", this.adminInqTotalMatch(bList));
			forward.setRedirect(false);
			forward.setPage("main_match.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}		
		return forward;
	}

	// 관리자가 전체 경기를 조건별로 조회결과 태그 페이지
	private String adminInqTotalMatch(LinkedList<Bean> bList) {
		StringBuffer adminInqTotalMatchInfo = new StringBuffer();		

		adminInqTotalMatchInfo.append("<table class = \'table\'><tr><th colspan = \"9\">전체 매치 내역</th></tr>");
		adminInqTotalMatchInfo.append("<tr><td>경기 주최자 아이디<br/>이름</td><td>경기종목</td><td>인원<br/>현재 / 필요</td><td>지역</td><td>경기<br/>날짜 & 시간</td><td>경기 상태</td><td>신청자</td><td><정보확인></td></tr>");
		for(int i = 0 ; i < bList.size() ; i++) {
			if((i+1) < bList.size()) {				
				if(!bList.get(i).getRqid().equals(bList.get(i+1).getRqid())) {
					adminInqTotalMatchInfo.append("<tr><td>" + bList.get(i).getMmid() + "<br/>" + bList.get(i).getMmname() +"</td><td>");
					adminInqTotalMatchInfo.append(bList.get(i).getStname() +"</td><td>" + bList.get(i).getNownum() + "/" + bList.get(i).getStnumber() + "</td><td>" + bList.get(i).getLcname() +"</td><td>" + bList.get(i).getFixdate() +"</td><td>" + bList.get(i).getStatusname()+ "</td>");
					adminInqTotalMatchInfo.append("<td>" +  totalInqMatAccepter(bList, bList.get(i).getRqid()) + "</td><td>");
					adminInqTotalMatchInfo.append("<input type =\"button\" class = \"reqAcc\" value = \"정보 확인 하기\" onClick = \"matchapplypage(\'"+ bList.get(i).getRqid() + "\')\" /></td>");
				}else {
					adminInqTotalMatchInfo.append("");
				}
			}else {
				adminInqTotalMatchInfo.append("<tr><td>" + bList.get(i).getMmid() + "<br/>" + bList.get(i).getMmname() +"</td><td>");
				adminInqTotalMatchInfo.append(bList.get(i).getStname() +"</td><td>" + bList.get(i).getNownum() + "/" + bList.get(i).getStnumber() + "</td><td>" + bList.get(i).getLcname() +"</td><td>" + bList.get(i).getFixdate() +"</td><td>" + bList.get(i).getStatusname() + "</td>");
				adminInqTotalMatchInfo.append("<td>" +  totalInqMatAccepter(bList, bList.get(i).getRqid()) + "</td><td>");
				adminInqTotalMatchInfo.append("<input type =\"button\" class = \"reqAcc\" value = \"정보 확인 하기\" onClick = \"matchapplypage(\'"+ bList.get(i).getRqid() + "\')\" /></td>");
			}
		}
		adminInqTotalMatchInfo.append("</tr></table>");
		return adminInqTotalMatchInfo.toString();
	}
	// 생성된 경기에 신청한 회원을 뿌려주는 메서드
	private String totalInqMatAccepter(LinkedList<Bean> bList1, String rqid) {
		StringBuffer inqPerCreMatAcrInfo = new StringBuffer();
		Dao dao = new Dao();
		try {
			bList1 = dao.admininqCreMatAccepterDao(rqid);
			inqPerCreMatAcrInfo.append("<table class = \'table\'>");
			for(int i = 0 ; i < bList1.size() ; i++) {
				if(bList1.get(i).getAcid() != null) {
					if(bList1.get(i).getAcstatus().equals("D6")) {
						inqPerCreMatAcrInfo.append("<tr><td><input type = \"button\" value =\"" + bList1.get(i).getAcid() + "\" /><br/></td><td style = \" width:150px;\">");
						inqPerCreMatAcrInfo.append("<input type = \"button\" value = \"경기 취소 됨\" /></td></tr>");
					}else if(bList1.get(i).getAcstatus().equals("D4")) {
						inqPerCreMatAcrInfo.append("<tr><td><input type = \"button\" value =\"" + bList1.get(i).getAcid() + "\" /><br/></td><td style = \" width:150px;\">");
						inqPerCreMatAcrInfo.append("<input type = \"button\" value = \"삭제 함\" /></td></tr>");
					}else if(bList1.get(i).getAcstatus().equals("D3")) {
						inqPerCreMatAcrInfo.append("<tr><td><input type = \"button\" value =\"" + bList1.get(i).getAcid() + "\" /><br/></td><td style = \" width:150px;\">");
						inqPerCreMatAcrInfo.append("<input type = \"button\" value = \"취소 함\" /></td></tr>");
					}else if(bList1.get(i).getAcstatus().equals("D2")) {
						inqPerCreMatAcrInfo.append("<tr><td><input type = \"button\" value =\"" + bList1.get(i).getAcid() + "\" /><br/></td><td style = \" width:150px;\">");
						inqPerCreMatAcrInfo.append("<input type = \"button\" value = \"거절 함\" /></td></tr>");
					}else if(bList1.get(i).getAcstatus().equals("D1")) {
						inqPerCreMatAcrInfo.append("<tr><td><input type = \"button\" value =\"" + bList1.get(i).getAcid() + "\" /><br/></td><td style = \" width:150px;\">");
						inqPerCreMatAcrInfo.append("<input type = \"button\" value = \"수락 함\" /></td></tr>");
					}else {
						inqPerCreMatAcrInfo.append("<tr><td><input type = \"button\" value =\"" + bList1.get(i).getAcid() + "\" /><br/></td><td style = \" width:150px;\">");
						inqPerCreMatAcrInfo.append("<input type = \"button\" value = \"대기 중\" /></td></tr>");						
					}
				}else {
					i = bList1.size()-1;
					inqPerCreMatAcrInfo.append("<tr><td>신청 회원 없음</td></tr>");
				}
			}
			inqPerCreMatAcrInfo.append("</table>");
		}catch(Exception e) {
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally{
			dao.closeConnection();
		}
		return inqPerCreMatAcrInfo.toString();
	}
	// 회원 내역을 조회하는 메서드
	private ActionForward MemberList(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> messageList;

		try{
			/* messageInfo */
			dao.setAutoCommit(false);

			if(dao.idCheck(b)){
				if(dao.memberStatus(b)){

					System.out.println("memberList : 정상적으로 실행 1");
					messageList = dao.memberTotalList();

					//System.out.println(b.getMmid());
					StringBuffer sb = new StringBuffer();
					sb.append("<table class = \"table\">");
					sb.append("<tr>");
					sb.append("<td>아이디</td><td>이름</td><td>이메일</td><td>전화번호</td>");
					sb.append("<td>지역</td>");
					sb.append("</tr>");
					for(Bean msb : messageList){
						request.setAttribute("mmid", msb.getMmid());
						request.setAttribute("mmname", msb.getMmname());
						request.setAttribute("mmemail", msb.getMmemail());
						request.setAttribute("number", msb.getMmnumber());
						request.setAttribute("name", msb.getLcname());
						System.out.println(msb.getMmname());
						sb.append("<tr>");
						sb.append("<td>" + msb.getMmid() + "</td>");
						sb.append("<td>" + msb.getMmname() + "</td>");
						sb.append("<td>" + msb.getMmemail() + "</td>");
						sb.append("<td>" + msb.getMmnumber() + "</td>");
						sb.append("<td>" + msb.getLcname() + "</td>");
						sb.append("</tr>");
					}
					sb.append("</table>");

					forward.setPage("main_match.jsp");
					request.setAttribute("adminmemberlist", sb.toString());
					forward.setRedirect(false); // Dispatcher

				}else{
					/* 이미 로그아웃인 상태 */
					System.out.println("MemberInfo -- 이미 로그아웃된 상태");
					String message = URLEncoder.encode("로그아웃된 상태입니다. 먼저 로그인해주세요", "UTF-8");
					forward.setPage("messagebox.jsp?message="+ b);
					forward.setRedirect(true);
				}
			}else{
				System.out.println("MemberInfo -- 아이디 無");
				// 아이디가 없는 경우
				String message = URLEncoder.encode("아이디가 존재하지 않습니다. 회원가입해주세요", "UTF-8");
				forward.setPage("messagebox.jsp?message="+ b);
				forward.setRedirect(true);
			}
		}catch(Exception ex){
			ex.printStackTrace();

		}finally{
			dao.closeConnection();
		}
		return forward;
	}
}


