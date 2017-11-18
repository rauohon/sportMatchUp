package services;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.http.HttpServletRequest;

import beans.Bean;
import controller.ActionForward;
import dao.Dao;

public class MatchService {

	private HttpServletRequest request = null;
	private Bean b;
	// 생성자
	public MatchService(HttpServletRequest request) {
		this.request = request;
	}
	// 입구 분배 스위치
	public ActionForward entrance(int jobCode, Bean b) {
		ActionForward forward = null;

		switch(jobCode) {

		case 1 :
			// 신청 가능한 매치, 성사된 매치
			forward = inquireTotalMatchList(b);
			break;

		case 2 :
			// 내 경기 정보 페이지
			forward = MyMatchInfoPage(b);
			break;

		case 3 :
			// 경기 생성 페이지 이동
			forward = MatchInsertPage(b);
			break;

		case 4 :
			// 경기 생성
			forward = matchInsert(b);
			break;

		case 5:
			// 내가 생성한 경기에 신청한 사람을 누르면 해당 인원의 정보 출력 페이지
			forward = MatAccMemInfPage(b);
			break;

		case 6 :
			// 내가 생성한 경기에 신청한 사람 정보 페이지에서 확정
			forward = matchApplierFix(b);
			break;

		case 7 :
			// 내가 생성한 경기에 신청한 사람 정보 페이지에서 확정
			forward = matchRejectApplier(b);
			break;

		case 8 :
			// 내가 생성한 경기 수정 페이지
			forward = MatchCreateUpdPage(b);
			break;

		case 9 :
			// 내가 생성한 경기 수정
			forward = matchCreateUpd(b);
			break;

		case 10 :
			// 내가 생성한 경기 취소
			forward = matchCreateDel(b);
			break;

		case 11 :
			// 생성된 경기에 신청 누르면 정보 페이지 이동
			forward = MatchApplyPage(b);
			break;

		case 12 :
			// 생성된 경기 정보 페이지 에서 신청하기
			forward = matchApply(b);
			break;

		case 13 :
			// 내가 신청한 경기 취소
			forward = matchApplyDel(b);
			break;

		case 14 :
			// 매치보드 페이지 이동
			forward = TotalInquireMatchList(b);
			break;

		case 15 :
			// 경기 확정 페이지 이동
			forward = MatchFixPage(b);
			break;

		case 16 :
			// 경기 확정
			forward = matchFix(b);
			break;
			
		case 17 :
			// 완료된 내가 생성한 매치 삭제
			forward = matchEnd(b);
			break;

		case 18 :
			// 완료된 내가 생성한 매치 삭제
			forward = matComCreDel(b);
			break;

		case 19 :
			// 완료된 내가 신청한 매치 삭제
			forward = matComAppDel(b);
			break;

		case 20 :
			// 검색
			forward = searchMatch(b);
			break;
		}
		return forward;
	}
	// 1 (done) 메인에서 보여줄 전체 신청 가능한, 성사된 경기
	private ActionForward inquireTotalMatchList(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> bList;
		LinkedList<Bean> bList2;
		try {
			bList = dao.inqTotAppMatListDao(b);
			bList2 = dao.inqTotComMatListDao(b);
			Collections.sort(bList, new Comparator<Bean>(){
				@Override
				public int compare(Bean r2, Bean r1){
					return r1.getFixdate().compareTo(r2.getFixdate());
				}
			});
			Collections.sort(bList2, new Comparator<Bean>(){
				@Override
				public int compare(Bean r1, Bean r2){
					return r2.getFixdate().compareTo(r1.getFixdate());
				}
			});
			try {
				request.setAttribute("mmid", b.getMmid());
			}catch(Exception e){
				e.printStackTrace();
			}finally {
//				request.setAttribute("applicableMatch", inqTotAppMatList(bList , b));
//				request.setAttribute("completedMatch", inqTotComMatList(bList2));
				forward.setRedirect(false);
				forward.setPage("main_match.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}      
		return forward;
	}   
	// 1 - 1 (done) 메인에서 보여줄 신청 가능한 전체 경기의 태그를 뿌려주는 메서드
	private String inqTotAppMatList(LinkedList<Bean> bList, Bean b) {
		StringBuffer totalAppMatchInfo = new StringBuffer();
		totalAppMatchInfo.append("<table class = \'table\'><tr><th colspan = \"6\">신청 가능한 매치</th></tr>");
		totalAppMatchInfo.append("<tr><td>신청자</td><td>경기종목</td><td>현재 / 필요</td><td>지역</td><td>날짜 & 시간</td><td></td></tr>");
		for(int i = 0 ; i < 2 ; i++) {
			if((i+1) < bList.size()) {
				if(!bList.get(i).getRqid().equals(bList.get(i+1).getRqid())) {
					totalAppMatchInfo.append("<tr><td>" + bList.get(i).getMmid() +"</td><td>");
					totalAppMatchInfo.append(bList.get(i).getStname() +"</td><td>" + bList.get(i).getNownum() + "/" + bList.get(i).getStnumber() + "</td><td>" + bList.get(i).getLcname() +"</td><td>" + bList.get(i).getFixdate() +"</td>");
					if(bList.get(i).getAcstatus() != null){
						if(bList.get(i).getAcstatus().equals("D2")) {
							totalAppMatchInfo.append("<td><input type = \"button\" value=\"거절 됨\" ></td></tr>");
						}else {
							totalAppMatchInfo.append("<td><input type = \"button\" value=\"신청하기\" onClick = \"matchapplypage(\'" + bList.get(i).getRqid() +"\')\" ></td></tr>");
						}
					}else{
						totalAppMatchInfo.append("<td><input type = \"button\" value=\"신청하기\" onClick = \"matchapplypage(\'"+ bList.get(i).getRqid() +"\')\" ></td></tr>");
					}
				}else {
					totalAppMatchInfo.append("");
				}
			}else {
				if(bList.get(i).getAcstatus() != null){
					if(bList.get(i).getAcstatus().equals("D2")) {
						totalAppMatchInfo.append("<td><input type = \"button\" value=\"거절 됨\" ></td></tr>");
					}else {
						totalAppMatchInfo.append("<tr><td>" + bList.get(i).getMmid() +"</td><td>");
						totalAppMatchInfo.append(bList.get(i).getStname() +"</td><td>" + bList.get(i).getNownum() + "/" + bList.get(i).getStnumber() + "</td><td>" + bList.get(i).getLcname() +"</td><td>" + bList.get(i).getFixdate() +"</td>");
						totalAppMatchInfo.append("<td><input type = \"button\" value=\"신청하기\" onClick = \"matchapplypage(\'"+ bList.get(i).getRqid() +"\')\" ></td></tr>");
					}					
				}else{
					totalAppMatchInfo.append("<td><input type = \"button\" value=\"신청하기\" onClick = \"matchapplypage(\'"+ bList.get(i).getRqid() +"\')\" ></td></tr>");
				}
			}
		}
		totalAppMatchInfo.append("</table>");
		return totalAppMatchInfo.toString();
	}
	// 1 - 2 (done) 최근 성사된 전체 경기의 태그를 뿌려주는 메서드
	private String inqTotComMatList(LinkedList<Bean> bList2) {
		StringBuffer totalComMatchInfo = new StringBuffer();

		totalComMatchInfo.append("<table class = \'table\'><tr><th colspan = \"5\">최근 성사된 매치</th></tr>");
		totalComMatchInfo.append("<tr><td>신청자</td><td>경기종목</td><td>인원수</td><td>지역</td><td>날짜 & 시간</td></tr>");
		for(int i = 0 ; i < 2 && i < bList2.size() ; i++) {
			if((i+1) < bList2.size()) {
				if(!bList2.get(i).getRqid().equals(bList2.get(i+1).getRqid())) {
					totalComMatchInfo.append("<tr><td>" + bList2.get(i).getMmid() +"</td><td>");
					totalComMatchInfo.append(bList2.get(i).getStname() +"</td><td>" + bList2.get(i).getStnumber() + "</td><td>" + bList2.get(i).getLcname() +"</td><td>" + bList2.get(i).getFixdate() +"</td></tr>");               
				}else {
					totalComMatchInfo.append("");
				}
			}else {
				totalComMatchInfo.append("<tr><td>" + bList2.get(i).getMmid() +"</td><td>");
				totalComMatchInfo.append(bList2.get(i).getStname() +"</td><td>" + bList2.get(i).getStnumber() + "</td><td>" + bList2.get(i).getLcname() +"</td><td>" + bList2.get(i).getFixdate() +"</td></tr>");
			}
		}
		totalComMatchInfo.append("</table>");

		return totalComMatchInfo.toString();
	}
	// 2 (done)개인 경기 정보 페이지
	private ActionForward MyMatchInfoPage(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		// 내가 생성한 경기 LinkList
		LinkedList<Bean> bList1;
		// 내가 신청한 경기 LinkList
		LinkedList<Bean> bList2;
		// 완료된 내가 생성한 경기 LinkList
		LinkedList<Bean> bList3;
		// 완료된 내가 신청한 경기 LinkList
		LinkedList<Bean> bList4;
		// 확정된 내가 참가할 경기 LinkList
		LinkedList<Bean> bList5;

		try {
			if(dao.idCheck(b)) {
				// 각 리스트 dao에 연결
				bList1 = dao.inqPerCreMatListDao(b);
				bList2 = dao.inqPerAppMatListDao(b);
				bList3 = dao.inqPerComCreMatListDao(b);
				bList4 = dao.inqPerComAppMatListDao(b);
				bList5 = dao.inqFixMatchListDao(b);
				// 시간순 정렬
				Collections.sort(bList1, new Comparator<Bean>(){
					@Override
					public int compare(Bean r1, Bean r2){
						return r2.getFixdate().compareTo(r1.getFixdate());
					}
				});
				Collections.sort(bList2, new Comparator<Bean>(){
					@Override
					public int compare(Bean r1, Bean r2){
						return r2.getFixdate().compareTo(r1.getFixdate());
					}
				});
				Collections.sort(bList3, new Comparator<Bean>(){
					@Override
					public int compare(Bean r1, Bean r2){
						return r2.getFixdate().compareTo(r1.getFixdate());
					}
				});
				Collections.sort(bList4, new Comparator<Bean>(){
					@Override
					public int compare(Bean r1, Bean r2){
						return r2.getFixdate().compareTo(r1.getFixdate());
					}
				});
				Collections.sort(bList5, new Comparator<Bean>(){
					@Override
					public int compare(Bean r1, Bean r2){
						return r2.getFixdate().compareTo(r1.getFixdate());
					}
				});
				request.setAttribute("text", "나의 경기 목록");
				request.setAttribute("mmid", b.getMmid());
				// 내가 생성한 경기 전달
				request.setAttribute("gameIcreated", inqPerCreMatList(bList1));
				// 내가 신청한 경기 전달
				request.setAttribute("gameIapplied", inqPerAppMatList(bList2));
				// 완료된 내가 생성한 경기 전달
				request.setAttribute("completedCreateMatch", inqPerComCreMatList(bList3));
				// 완료된 내가 신청한 경기 전달
				request.setAttribute("completedApplyMatch", inqPerComAppMatList(bList4));
				// 확정된 내가 참가할 경기 전달
				request.setAttribute("fixedmatch",inqFixMatchList(bList5));

				forward.setRedirect(false);
				forward.setPage("main_match.jsp");
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);
				forward.setPage("login.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}      
		return forward;
	}
	// 2 - 1 (done) 내가 생성한 경기 내역을 뿌려주는 메서드
	private String inqPerCreMatList(LinkedList<Bean> bList1) {
		StringBuffer inqPerCreMatchInfo = new StringBuffer();
		inqPerCreMatchInfo.append("<table class = \'table\'><tr><th colspan = \"8\">내가 생성한 매치</th></tr>");
		inqPerCreMatchInfo.append("<tr><td>경기상태</td><td>경기종목</td><td>인원 수<br/>신청 / 전체</td><td>지역</td><td>날짜 & 시간</td><td>경기 수정</td><td>신청자</td></tr>");
		for(int i = 0 ; i < bList1.size() ; i++) {
			if((i+1) < bList1.size()) {
				if(!bList1.get(i).getRqid().equals(bList1.get(i+1).getRqid())) {
					inqPerCreMatchInfo.append("<tr><td>" + bList1.get(i).getStatusname() + "</td><td>");
					inqPerCreMatchInfo.append(bList1.get(i).getStname() +"</td><td>" + bList1.get(i).getNownum() +" / " +bList1.get(i).getStnumber() + "</td><td>" + bList1.get(i).getLcname() +"</td><td>" + bList1.get(i).getFixdate() +"</td>");
					inqPerCreMatchInfo.append("<td><input type = \"button\" value = \"경기 수정\" onClick = \"matchcreateupdpage(\'"+ bList1.get(i).getRqid() +"\')\"/><br/>");
					inqPerCreMatchInfo.append("<input type = \"button\" value = \"경기 취소\" onClick = \"matchcreatedel(\'"+ bList1.get(i).getRqid() +"\')\"/><br/>");
					inqPerCreMatchInfo.append("<input type = \"button\" value = \"경기 확정\" onClick = \"matchfixpage(\'"+ bList1.get(i).getRqid() +"\')\"/></td>");
					inqPerCreMatchInfo.append("<td>" + inqPerCreMatAccepter(bList1, bList1.get(i).getRqid()) + "</td></tr>");
				}else {
					inqPerCreMatchInfo.append("");
				}
			}else {
				inqPerCreMatchInfo.append("<tr><td>" + bList1.get(i).getStatusname() + "</td><td>");
				inqPerCreMatchInfo.append(bList1.get(i).getStname() +"</td><td>" + bList1.get(i).getNownum() +" / " +bList1.get(i).getStnumber() + "</td><td>" + bList1.get(i).getLcname() +"</td><td>" + bList1.get(i).getFixdate() +"</td>");
				inqPerCreMatchInfo.append("<td><input type = \"button\" value = \"경기 수정\" onClick = \"matchcreateupdpage(\'"+ bList1.get(i).getRqid() +"\')\"/><br/>");
				inqPerCreMatchInfo.append("<input type = \"button\" value = \"경기 취소\" onClick = \"matchcreatedel(\'"+ bList1.get(i).getRqid() +"\')\"/><br/>");
				inqPerCreMatchInfo.append("<input type = \"button\" value = \"경기 확정\" onClick = \"matchfixpage(\'"+ bList1.get(i).getRqid() +"\')\"/></td>");
				inqPerCreMatchInfo.append("<td>" + inqPerCreMatAccepter(bList1, bList1.get(i).getRqid()) + "</td></tr>");
			}         
		}
		inqPerCreMatchInfo.append("</table>");
		return inqPerCreMatchInfo.toString();
	}
	// 2 - 1 -1 (done) 내가 생성한 경기에 신청한 회원을 뿌려주는 메서드 (박유진)
	private String inqPerCreMatAccepter(LinkedList<Bean> bList1, String rqid) {
		StringBuffer inqPerCreMatAcrInfo = new StringBuffer();
		Dao dao = new Dao();
		try {
			bList1 = dao.inqPerCreMatAccepterDao(rqid);
			inqPerCreMatAcrInfo.append("<table class = \'table\'>");
			for(int i = 0 ; i < bList1.size() ; i++) {
				if(bList1.get(i).getAcid() != null) {
					System.out.println(bList1.get(i).getAcstatus());
					if(bList1.get(i).getAcstatus().equals("D3")) {
						inqPerCreMatAcrInfo.append("");
					}else if(bList1.get(i).getAcstatus().equals("D2")) {
						inqPerCreMatAcrInfo.append("<tr><td><input type = \"button\" value =\"" + bList1.get(i).getAcid() + "\" onClick = \"mataccmeminfpage(\'"+ bList1.get(i).getRqid() + ":"+ bList1.get(i).getAcid() + "\')\" /><br/></td><td style = \" width:150px;\">");
						inqPerCreMatAcrInfo.append("<input type = \"button\" value = \"거절 완료\" />");
					}else if(bList1.get(i).getAcstatus().equals("D1")) {
						inqPerCreMatAcrInfo.append("<tr><td><input type = \"button\" value =\"" + bList1.get(i).getAcid() + "\" onClick = \"mataccmeminfpage(\'"+ bList1.get(i).getRqid() + ":"+ bList1.get(i).getAcid() + "\')\" /><br/></td><td style = \" width:150px;\">");
						inqPerCreMatAcrInfo.append("<input type = \"button\" value = \"수락 완료\" />");
					}else {
						inqPerCreMatAcrInfo.append("<tr><td><input type = \"button\" value =\"" + bList1.get(i).getAcid() + "\" onClick = \"mataccmeminfpage(\'"+ bList1.get(i).getRqid() + ":"+ bList1.get(i).getAcid() + "\')\" /><br/></td><td style = \" width:150px;\">");
						inqPerCreMatAcrInfo.append("<input type = \"button\" value = \"정보\" onClick = \"mataccmeminfpage(\'"+ bList1.get(i).getRqid() + ":"+ bList1.get(i).getAcid() + "\')\" /><br/>");
						inqPerCreMatAcrInfo.append("<input type = \"button\" value = \"거절\" onClick = \"matchrejectapplier(\'"+ bList1.get(i).getRqid() + ":"+ bList1.get(i).getAcid() + "\')\" /></td></tr>");                  
					}
				}else {
					i = bList1.size()-1;
					inqPerCreMatAcrInfo.append("<tr><td>아직 신청하신 회원님이 없네요.</td></tr>");
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
	// 2 - 2 (done) 내가 신청한 경기를 뿌려주는 메서드
	private String inqPerAppMatList(LinkedList<Bean> bList2) {
		StringBuffer inqPerAppMatListInfo = new StringBuffer();
		inqPerAppMatListInfo.append("<table class = \'table\'><tr><th colspan = \"7\">");
		inqPerAppMatListInfo.append("내가 신청한 경기</th></tr>");

		inqPerAppMatListInfo.append("<tr><td>경기상태</td><td>경기 생성자</td><td>경기 종목</td><td>인원<br/>현재 / 경기 제한</td><td>지역</td><td>날짜 & 시간</td><td>취소</td></tr>");
		for( Bean b : bList2) {

			inqPerAppMatListInfo.append("<tr><td>" + b.getStatusname() + "</td><td>" + b.getMmid() + "</td><td>"+ b.getStname() + "</td><td>"+ b.getNownum() + " / " + b.getStnumber() +  "</td><td> " + b.getLcname() + "</td><td>" + b.getFixdate() + "</td><td>");
			inqPerAppMatListInfo.append("<input type = \"button\" class = \"acceptBtn\" value = \"신청 취소\"onClick=\"matchapplydel(\'"+b.getRqid()+"\')\" /></td></tr>");

		}
		inqPerAppMatListInfo.append("</table>");

		return inqPerAppMatListInfo.toString();
	}
	// 2 - 3 (done) 완료된 내가 생성한 경기를 뿌려주는 메서드
	private String inqPerComCreMatList(LinkedList<Bean> bList3) {
		StringBuffer inqPerComCreMatListInfo = new StringBuffer();
		inqPerComCreMatListInfo.append("<table class = \'table\'><tr><th colspan = \"6\">완료된 내가 생성한 매치</th></tr>");
		inqPerComCreMatListInfo.append("<tr><td>경기종목</td><td>지역</td><td>날짜 & 시간</td><td>상태</td><td></td></tr>");
		for(int i = 0 ; i < bList3.size() ; i++) {
			if((i+1) < bList3.size()) {
				if(!bList3.get(i).getRqid().equals(bList3.get(i+1).getRqid())) {
					inqPerComCreMatListInfo.append("<tr><td>"+ bList3.get(i).getStname() +"</td>");
					inqPerComCreMatListInfo.append("<td>" + bList3.get(i).getLcname() +"</td><td>" + bList3.get(i).getFixdate() +"</td><td>" + bList3.get(i).getStatusname() + "</td><td>");
					inqPerComCreMatListInfo.append("<input type = \"button\" value =\"삭제하기\" onClick = \"matcomcredel(\'" + bList3.get(i).getRqid() + "\')\" readonly /></td></tr>");
				}else {
					inqPerComCreMatListInfo.append("");
				}
			}else {
				inqPerComCreMatListInfo.append("<td>"+ bList3.get(i).getStname() +"</td>");
				inqPerComCreMatListInfo.append("<td>" + bList3.get(i).getLcname() +"</td><td>" + bList3.get(i).getFixdate() +"</td><td>" + bList3.get(i).getStatusname() + "</td><td>");
				inqPerComCreMatListInfo.append("<input type = \"button\" value =\"삭제하기\" onClick = \"matcomcredel(\'" + bList3.get(i).getRqid() +"\')\" readonly /></td></tr>");
			}         
		}
		inqPerComCreMatListInfo.append("</table>");
		return inqPerComCreMatListInfo.toString();
	}
	// 2 - 4 (done)완료된 내가 신청한 경기를 뿌려주는 메서드
	private String inqPerComAppMatList(LinkedList<Bean> bList4) {
		StringBuffer inqPerComAppMatListInfo = new StringBuffer();
		inqPerComAppMatListInfo.append("<table class = \'table\'><tr><th colspan = \"6\">완료된 내가 신청한 매치</th></tr>");
		inqPerComAppMatListInfo.append("<tr><td>신청아이디</td><td>경기종목</td><td>지역</td><td>날짜 & 시간</td><td>상태</td><td></td></tr>");
		for(int i = 0 ; i < bList4.size() ; i++) {
			if((i+1) < bList4.size()) {
				if(!bList4.get(i).getRqid().equals(bList4.get(i+1).getRqid())) {
					inqPerComAppMatListInfo.append("<tr><td>"+ bList4.get(i).getMmid()+"</td><td>"+ bList4.get(i).getStname() +"</td>");
					inqPerComAppMatListInfo.append("<td>" + bList4.get(i).getLcname() +"</td><td>" + bList4.get(i).getFixdate() +"</td><td>" + bList4.get(i).getStatusname() + "</td><td>");
					inqPerComAppMatListInfo.append("<input type = \"button\" value =\"삭제하기\" onClick = \"matcomappdel(\'" + bList4.get(i).getRqid()  + "\')\" readonly /></td>");
				}else {
					inqPerComAppMatListInfo.append("");
				}
			}else {
				inqPerComAppMatListInfo.append("<tr><td>"+ bList4.get(i).getMmid()+"</td><td>"+ bList4.get(i).getStname() +"</td>");
				inqPerComAppMatListInfo.append("<td>" + bList4.get(i).getLcname() +"</td><td>" + bList4.get(i).getFixdate() +"</td><td>" + bList4.get(i).getStatusname() + "</td><td>");
				inqPerComAppMatListInfo.append("<input type = \"button\" value =\"삭제하기\" onClick = \"matcomappdel(\'" + bList4.get(i).getRqid() + "\')\" readonly /></td></tr>");
			}         
		}
		inqPerComAppMatListInfo.append("</table>");
		return inqPerComAppMatListInfo.toString();
	}
	// 2 - 5 내가 참가할 확정된 경기를 뿌려주는 메서드
	private String inqFixMatchList(LinkedList<Bean> bList5) {
		StringBuffer inqFixMatchListInfo = new StringBuffer();

		inqFixMatchListInfo.append("<table class = \'table\'><tr><th colspan = \"6\">내가 참가할 경기</th></tr>");
		inqFixMatchListInfo.append("<tr><td>주최자</td><td>경기 종목</td><td>참가인원</td><td>지역</td><td>날짜 & 시간</td><td>자세히</td></tr>");

		for(int i = 0 ; i < bList5.size() ; i++) {
			if((i+1) < bList5.size()) {
				if(!bList5.get(i).getRqid().equals(bList5.get(i+1).getRqid())) {
					inqFixMatchListInfo.append("<tr><td>" + bList5.get(i).getMmid() + "</td><td>" + bList5.get(i).getStname() + "</td><td>" + bList5.get(i).getNownum() + "</td><td>" + bList5.get(i).getLcname() + "</td><td>" + bList5.get(i).getFixdate() + "</td><td>");
					inqFixMatchListInfo.append("<input type = \"button\" value = \"상세정보 보기 \" onClick = \"matchfixpage(\'" + bList5.get(i).getRqid() + "\')\"");
					inqFixMatchListInfo.append("</td></tr>");
				}else {
					inqFixMatchListInfo.append("");
				}
			}else {
				inqFixMatchListInfo.append("<tr><td>" + bList5.get(i).getMmid() + "</td><td>" + bList5.get(i).getStname() + "</td><td>" + bList5.get(i).getNownum() + "</td><td>" + bList5.get(i).getLcname() + "</td><td>" + bList5.get(i).getFixdate() + "</td><td>");
				inqFixMatchListInfo.append("<input type = \"button\" value = \"상세정보 보기 \" onClick = \"matchfixpage(\'" + bList5.get(i).getRqid() + "\')\"");
				inqFixMatchListInfo.append("</td></tr>");
			}         
		}
		inqFixMatchListInfo.append("</table>");
		return inqFixMatchListInfo.toString();
	}
	// 3 (done)경기 생성 페이지 이동
	private ActionForward MatchInsertPage(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();   

		try {
			if(dao.idCheck(b)) {
				request.setAttribute("mmid", b.getMmid());
				forward.setRedirect(false);
				forward.setPage("matchInsertPage.jsp");
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);
				forward.setPage("login.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}
		return forward;
	}
	// 4 (done)경기 생성
	private ActionForward matchInsert(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		try {
			dao.setAutoCommit(false);
			if(dao.idCheck(b)) {
				if(dao.matchInsert(b)) {
					request.setAttribute("message", "경기 생성을 완료했어요.");
					request.setAttribute("mmid", b.getMmid());
					forward.setRedirect(false);
					forward.setPage("MyMatchInfo");
					dao.transactionEnd(true);
				}else {
					request.setAttribute("message", "경기 생성을 완료하지 못 했어요");
					forward = inquireTotalMatchList(b);         
					dao.transactionEnd(false);
				}
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}            
		}catch(Exception e) {
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally{
			dao.closeConnection();
		}
		return forward;
	}
	// 5 (done)내가 생성한 경기에서 신청한 사람 정보 버튼을 누르면 해당 인원의 정보 출력 페이지로 이동
	private ActionForward MatAccMemInfPage(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> bList;
		// 내가 생성한 경기에 신청한 인원의 정보 LinkList
		try {
			if(dao.idCheck(b)) {
				bList = dao.inqPerMatAccInfDao(b);
				request.setAttribute("mmid", b.getMmid());
				request.setAttribute("acceptMemberInfo", inqPerMatAccInf(bList, b));
				System.out.println(b.getRqid() + "페이지");
				forward.setRedirect(false);
				forward.setPage("main_match.jsp");
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}         
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}      
		return forward;
	}
	// 5 - 1 (done) 내가 생성한 경기에 신청한 1인의 정보를 출력
	private String inqPerMatAccInf(LinkedList<Bean> bList, Bean b) {
		StringBuffer matchAccepterInfo = new StringBuffer();
		Dao dao = new Dao();
		try {
			matchAccepterInfo.append("<table class = \'table\'><tr><th colspan=\"4\">경기 신청자 정보</th></tr><tr><td>아이디</td><td>이름</td><td>이메일</td><td>거주지역</td></tr><tr><td>");
			matchAccepterInfo.append(bList.get(0).getAcid()+ "</td><td>" + bList.get(0).getMmname()  + "</td><td>" + bList.get(0).getMmemail() + "</td><td>" + bList.get(0).getLcname());
			matchAccepterInfo.append("</td></tr><tr><td colspan=\"4\"><input type = \"button\" value = \"수락\" onClick = \"matchapplierfix(\'"+ b.getRqid() + ":"+ bList.get(0).getAcid() + "\')\" />");
			matchAccepterInfo.append("<input type = \"button\" value = \"거절\" onClick = \"matchrejectapplier(\'"+ b.getRqid() + ":"+ bList.get(0).getAcid() + "\')\" /></td></tr></table>");
		}catch(Exception e) {
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally {
			dao.closeConnection();
		}
		return matchAccepterInfo.toString();
	}
	// 6 (done) 내가 생성한 경기에 신청한 사람 확정(update)
	private ActionForward matchApplierFix(Bean b)   {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();

		try {
			dao.setAutoCommit(false);
			if(dao.idCheck(b)) {
				if(dao.matchApplierFixDao(b)) {
					request.setAttribute("message", "확정을 완료했어요.");
					request.setAttribute("mmid", b.getMmid());
					forward.setRedirect(false);
					forward.setPage("MyMatchInfo");
					dao.transactionEnd(true);
				}else {
					request.setAttribute("message", "확정을 완료하지 못 했어요.");
					forward = inquireTotalMatchList(b);
					dao.transactionEnd(false);
				}            
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}

		}catch(Exception e) {
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally {
			dao.closeConnection();
		}
		return forward;
	}
	// 7 (done)내가 생성한 경기에 신청한 사람 거절(update)
	private ActionForward matchRejectApplier(Bean b)   {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();

		try {
			dao.setAutoCommit(false);
			if(dao.idCheck(b)) {
				if(dao.matchRejectApplierDao(b)) {
					request.setAttribute("message", "거절 하셨어요.");
					request.setAttribute("mmid", b.getMmid());
					forward.setRedirect(false);
					forward.setPage("MyMatchInfo");
					dao.transactionEnd(true);
				}else {
					request.setAttribute("message", "거절을 완료하지 못 했어요.");
					forward = inquireTotalMatchList(b);
					dao.transactionEnd(false);
				}            
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}

		}catch(Exception e) {
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally {
			dao.closeConnection();
		}
		return forward;
	}
	// 8 (done) 내가 생성한 경기 수정 페이지
	private ActionForward MatchCreateUpdPage(Bean b) {
		ActionForward forward;
		forward = new ActionForward();
		Dao dao = new Dao();

		try {
			if(dao.idCheck(b)) {
				request.setAttribute("rqid", b.getRqid());
				request.setAttribute("mmid", b.getMmid());
				forward.setRedirect(false);
				forward.setPage("matchUpdPage.jsp");            
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}      
		return forward;
	}
	// 9 (done)내가 생성한 경기 수정
	private ActionForward matchCreateUpd(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();

		try {
			dao.setAutoCommit(false);
			if(dao.idCheck(b)) {            
				if(dao.matchCreateUpd(b)) {
					request.setAttribute("message", "경기 신청 내용의 수정을 완료했어요.");
					request.setAttribute("mmid", b.getMmid());
					forward.setRedirect(false);
					forward.setPage("MyMatchInfo");
					dao.transactionEnd(true);
				}else {
					request.setAttribute("message", "경기 신청 내용의 수정을 완료하지 못 했어요.");
					request.setAttribute("mmid", b.getMmid());
					forward.setRedirect(false);
					forward.setPage("main_logined.jsp");
					dao.transactionEnd(false);
				}
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally {
			dao.closeConnection();
		}
		return forward;
	}
	// 10 (done) 내가 생성한 경기 취소(update)
	private ActionForward matchCreateDel(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();

		try {
			dao.setAutoCommit(false);
			if(dao.idCheck(b)) {
				dao.matchCreatedAppDel(b);
					System.out.println("생성한 경기 취소 완료");
					request.setAttribute("message", "경기  취소를 완료했어요.");
					if(dao.requestDel(b)){
						request.setAttribute("mmid", b.getMmid());
						forward.setRedirect(false);
						forward.setPage("MyMatchInfo");
						dao.transactionEnd(true);
					}
			}else {
				System.out.println("생성한 경기 취소 로그인 실패");
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally {
			dao.closeConnection();
		}
		return forward;
	}
	// 11 (done)생성된 경기 신청을 누르면 정보 페이지 이동
	private ActionForward MatchApplyPage(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> bList;
		try {
			bList = dao.inqMatInfDao(b);
			request.setAttribute("mmid", b.getMmid());
			request.setAttribute("matchApplyInfo", inqMatAppInf(bList));
			forward.setRedirect(false);
			forward.setPage("main_match.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}      

		return forward;
	}
	// 11 - 1 (done)생성된 경기 정보 페이지에 정보 출력
	private String inqMatAppInf(LinkedList<Bean> bList) {
		StringBuffer matchInfo = new StringBuffer();

		matchInfo.append("<table class = \'table\'><tr><th colspan=\"7\">경기 상세 정보</th></tr><tr><td>신청자</td><td>경기 종목</td><td>경기 일정</td><td>장소</td><td>인원수<br/>신청 / 제한</td></tr><tr><td>");
		matchInfo.append(bList.get(0).getMmid() + "<br/>" + bList.get(0).getMmname() + "</td>"
				+ "<td>" + bList.get(0).getStname() + "</td>"
				+ "<td>" + bList.get(0).getLcname() + "</td>"
				+ "<td>" + bList.get(0).getFixdate() + "</td>"
				+ "<td>" + bList.get(0).getNownum() + "/" + bList.get(0).getStnumber() + "</td></tr>"
				+ "<tr><td>Kick off 전 한마디</td><td colspan=\"4\">");
		matchInfo.append(bList.get(0).getDescription() + "</td></tr>"
				+ "<tr><td colspan=\"5\">"
				+ "<input type = \"button\" value=\"신청하기\" onClick = \"matchapply(\'"+ bList.get(0).getRqid() +"\')\" >"
				+ "<input type = \"button\" value=\"뒤로 가기\" onClick = \"matchpage()\" >");
		matchInfo.append("</td></tr></table>");
		return matchInfo.toString();
	}
	// 12 (done)생성된 경기 정보 페이지 에서 신청
	private ActionForward matchApply(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		try {
			dao.setAutoCommit(false);
			if(dao.idCheck(b)) {
				if(!dao.matchAcceptSame(b)) {
					if(dao.matchAccept(b)) {
						if(dao.matchAcceptNumInsert(b)) {
							request.setAttribute("message", "경기 신청을 완료 했어요.");
							request.setAttribute("mmid", b.getMmid());
							forward.setRedirect(false);
							forward.setPage("MyMatchInfo");
							dao.transactionEnd(true);
						}else {
							request.setAttribute("message", "경기 신청을 완료하지 못 했어요.");
							request.setAttribute("mmid", b.getMmid());
							forward.setRedirect(false);
							forward.setPage("main_logined.jsp");
							dao.transactionEnd(false);
						}
					}else {
						request.setAttribute("message", "경기 신청을 완료하지 못 했어요.");
						request.setAttribute("mmid", b.getMmid());
						forward.setRedirect(false);
						forward.setPage("main_logined.jsp");
						dao.transactionEnd(false);
					}
				}else {
					request.setAttribute("message", "자신의 의뢰는 수락하실 수 없어요.");
					request.setAttribute("mmid", b.getMmid());
					forward.setRedirect(false);
					forward.setPage("main_logined.jsp");
					dao.transactionEnd(false);
				}
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}
		}catch(Exception e){
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally {
			dao.closeConnection();
		}
		return forward;
	}
	// 13 (done)내가 신청한 경기 취소(update)
	private ActionForward matchApplyDel(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		try {
			dao.setAutoCommit(false);
			if(dao.idCheck(b)) {
				System.out.println("경기 신청 취소 아이디 체크");
				if(dao.matAppDel(b)) {
					System.out.println("경기 신청 취소");
					if(dao.matchAcceptNumDelete(b)) {
						System.out.println("경기 신청 취소 숫자감소");
						System.out.println("서비스");
						request.setAttribute("message", "경기 취소를 성공했어요.");
						request.setAttribute("mmid", b.getMmid());
						forward.setRedirect(false);
						forward.setPage("MyMatchInfo");
						dao.transactionEnd(true);
					}else {
						request.setAttribute("message", "경기 취소를 완료하지 못 했어요.");
						forward = inquireTotalMatchList(b);
						dao.transactionEnd(false);
					}                  
				}else {
					request.setAttribute("message", "경기 취소를 완료하지 못 했어요.");
					forward = inquireTotalMatchList(b);
					dao.transactionEnd(false);
				}
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally {
			dao.closeConnection();
		}
		return forward;
	}
	// 14 (done) 전체 신청 가능한 경기
	private ActionForward TotalInquireMatchList(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> bList;

		try {
			if(dao.idCheck(b)) {
				bList = dao.inqTotAppMatListDao(b);
				Collections.sort(bList, new Comparator<Bean>(){
					@Override
					public int compare(Bean r2, Bean r1){
						return r1.getFixdate().compareTo(r2.getFixdate());
					}
				});
				request.setAttribute("mmid", b.getMmid());
				request.setAttribute("text", "전체 경기 목록");
				request.setAttribute("applicableMatchtotal", totInqAppMatList(bList, b));

				forward.setRedirect(false);
				forward.setPage("main_match.jsp");
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}

		return forward;
	}
	// 14 - 1 (done) 전체 신청 가능한 경기의 태그를 뿌려주는 메서드
	private String totInqAppMatList(LinkedList<Bean> bList, Bean b) {
		StringBuffer totInqAppMatListInfo = new StringBuffer();      

		totInqAppMatListInfo.append("<table class = \'table\'><tr><th colspan = \"6\">신청 가능한 매치</th></tr>");
		totInqAppMatListInfo.append("<tr><td>신청자</td><td>경기종목</td><td>현재 / 필요</td><td>지역</td><td>날짜 & 시간</td><td></td></tr>");
		for(int i = 0 ; i < bList.size() ; i++) {
			if((i+1) < bList.size()) {            
				if(!bList.get(i).getRqid().equals(bList.get(i+1).getRqid())) {
					totInqAppMatListInfo.append("<tr><td>" + bList.get(i).getMmid() +"</td><td>");
					totInqAppMatListInfo.append(bList.get(i).getStname() +"</td><td>" + bList.get(i).getNownum() + "/" + bList.get(i).getStnumber() + "</td><td>" + bList.get(i).getLcname() +"</td><td>" + bList.get(i).getFixdate() +"</td>");
					if(bList.get(i).getAcstatus() != null){
						if(bList.get(i).getAcstatus().equals("D2")) {
							totInqAppMatListInfo.append("<td><input type = \"button\" value=\"거절 됨\" ></td></tr>");
						}else {
							totInqAppMatListInfo.append("<td><input type = \"button\" value=\"신청하기\" onClick = \"matchapplypage(\'" + bList.get(i).getRqid() +"\')\" ></td></tr>");
						}
					}else{
						totInqAppMatListInfo.append("<td><input type = \"button\" value=\"신청하기\" onClick = \"matchapplypage(\'"+ bList.get(i).getRqid() +"\')\" ></td></tr>");
					}
				}else {
					totInqAppMatListInfo.append("");
				}
			}else {
				totInqAppMatListInfo.append("<tr><td>" + bList.get(i).getMmid() +"</td><td>");
				totInqAppMatListInfo.append(bList.get(i).getStname() +"</td><td>" + bList.get(i).getNownum() + "/" + bList.get(i).getStnumber() + "</td><td>" + bList.get(i).getLcname() +"</td><td>" + bList.get(i).getFixdate() +"</td>");
				if(bList.get(i).getAcstatus() != null){
					if(bList.get(i).getAcstatus().equals("D2")) {
						totInqAppMatListInfo.append("<td><input type = \"button\" value=\"거절 됨\" ></td></tr>");
					}else {
						totInqAppMatListInfo.append("<td><input type = \"button\" value=\"신청하기\" onClick = \"matchapplypage(\'" + bList.get(i).getRqid() +"\')\" ></td></tr>");
					}
				}else{
					totInqAppMatListInfo.append("<td><input type = \"button\" value=\"신청하기\" onClick = \"matchapplypage(\'"+ bList.get(i).getRqid() +"\')\" ></td></tr>");
				}
			}
		}
		totInqAppMatListInfo.append("</table>");
		return totInqAppMatListInfo.toString();
	}
	// 15 (done)경기 확정 페이지
	private ActionForward MatchFixPage(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> bList1;
		LinkedList<Bean> bList2;
		try {
			if(dao.idCheck(b)) {
				bList1 = dao.inqMatInfDao(b);
				bList2 = dao.inqMatchApplierInfoDao(b);
				request.setAttribute("mmid", b.getMmid());
				request.setAttribute("matchFix", inqMatchFix(bList1, bList2, b));
				request.setAttribute("text", "경기 확정 페이지");
				forward.setRedirect(false);
				forward.setPage("main_match.jsp");
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}
		return forward;
	}
	// 15 - 1 (done)확정 페이지에 경기 정보, 참가 인원 정보 태그 뿌려주는 메서드
	private String inqMatchFix(LinkedList<Bean> bList1, LinkedList<Bean> bList2, Bean b) {
		StringBuffer inqPerAppMatListInfo = new StringBuffer();
		inqPerAppMatListInfo.append("<table class = \'table\'><tr><th colspan = \"6\">");
		inqPerAppMatListInfo.append("경기 요약</th></tr>");

		inqPerAppMatListInfo.append("<tr><td>경기상태</td><td>경기 생성자</td><td>경기 종목</td><td>지역</td><td>날짜 & 시간</td><td>인원<br/>현재 / 경기 제한</td></tr><tr><td>");
		inqPerAppMatListInfo.append(bList1.get(0).getStatusname() + "</td><td>" + bList1.get(0).getMmid() + "<br/>" + bList1.get(0).getMmname() + "</td>"
				+ "<td>" + bList1.get(0).getStname() + "</td>"
				+ "<td>" + bList1.get(0).getLcname() + "</td>"
				+ "<td>" + bList1.get(0).getFixdate() + "</td>"
				+ "<td>" + bList1.get(0).getNownum() + "/" + bList1.get(0).getStnumber() + "</td></tr>"
				+ "<tr><td>참가 인원 내역</td><td colspan=\"6\"></td></tr>");
		inqPerAppMatListInfo.append("<tr><td>아이디</td><td>이름</td><td>전화번호</td><td>이메일</td><td colspan = \"2\">지역</td></tr>");
		inqPerAppMatListInfo.append("<tr><td>" + bList1.get(0).getMmid() + "</td><td>" + bList1.get(0).getMmname() + "</td><td>" + bList1.get(0).getMmnumber() + "</td><td>" + bList1.get(0).getMmemail() + "</td><td>" + bList1.get(0).getLcname() + "</td></tr>"); 
		for(int i = 0 ; i <bList2.size() ; i++) {         
			inqPerAppMatListInfo.append("<tr><td>" + bList2.get(i).getAcid() + "</td><td>" + bList2.get(i).getMmname() + "</td><td>"+ bList2.get(i).getMmnumber() + "</td><td>"+ bList2.get(i).getMmemail() +  "</td><td colspan =\"2\">" + bList2.get(i).getLcname() + "</td></tr>");
		}
		if (b.getMmid().equals(bList1.get(0).getMmid())) {
			if(!bList1.get(0).getStatus().equals("C4")) {
				inqPerAppMatListInfo.append("<tr><td colspan = \"6\"><input type = \"button\" value = \"확정\" onClick = \"matchfix(\'" + bList1.get(0).getRqid() + "\')\" /></td></tr>");
			}else{
				inqPerAppMatListInfo.append("<tr><td colspan = \"6\"><input type = \"button\" value = \"경기완료\" onClick = \"matchend(\'" + bList1.get(0).getRqid() + "\')\" /></td></tr>");
			}
		}
		inqPerAppMatListInfo.append("</table>");

		return inqPerAppMatListInfo.toString();
	}
	// 16 (done) 경기 확정(update)
	private ActionForward matchFix(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		try {
			dao.setAutoCommit(false);
			if(dao.idCheck(b)) {
				if(dao.matchFixDao(b)) {
					request.setAttribute("message", "경기 확정에 성공했어요.");
					request.setAttribute("mmid", b.getMmid());
					forward.setRedirect(false);
					forward.setPage("MyMatchInfo");
					dao.transactionEnd(true);
				}else {
					request.setAttribute("message", "경기 확정을 완료하지 못 했어요.");
					forward = inquireTotalMatchList(b);
					dao.transactionEnd(false);
				}            
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally {
			dao.closeConnection();
		}
		return forward;
	}
	// 17 경기 완료 matchEnd
	private ActionForward matchEnd(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		try {
			dao.setAutoCommit(false);
			if(dao.idCheck(b)) {
				System.out.println(b.getRqid() + " : rqid ser");
				if(dao.matchEndDao(b)) {
					request.setAttribute("message", "경기 완료에 성공했어요.");
					request.setAttribute("mmid", b.getMmid());
					forward.setRedirect(false);
					forward.setPage("MyMatchInfo");
					dao.transactionEnd(true);
				}else {
					request.setAttribute("message", "경기 완료를 성공하지 못 했어요.");
					forward = inquireTotalMatchList(b);
					dao.transactionEnd(false);
				}            
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally {
			dao.closeConnection();
		}
		return forward;
	}	
	// 18 (done) 완료된 내가 생성한 매치 삭제(update)
	private ActionForward matComCreDel(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		try {
			dao.setAutoCommit(false);
			if(dao.idCheck(b)) {
				if(dao.matComCreDelDao(b)) {
					request.setAttribute("message", "경기 삭제에 성공했어요.");
					request.setAttribute("mmid", b.getMmid());
					forward.setRedirect(false);
					forward.setPage("MyMatchInfo");
					dao.transactionEnd(true);
				}else {
					request.setAttribute("message", "경기 삭제를 완료하지 못 했어요.");
					forward = inquireTotalMatchList(b);
					dao.transactionEnd(false);
				}            
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally {
			dao.closeConnection();
		}
		return forward;
	}   
	// 19 (done) 완료된 내가 신청한 매치 삭제(update)
	private ActionForward matComAppDel(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		try {
			dao.setAutoCommit(false);
			if(dao.idCheck(b)) {
				if(dao.matComAppDelDao(b)) {
					request.setAttribute("message", "경기 삭제에 성공했어요.");
					request.setAttribute("mmid", b.getMmid());
					forward.setRedirect(false);
					forward.setPage("MyMatchInfo");
					dao.transactionEnd(true);
				}else {
					request.setAttribute("message", "경기 삭제를 완료하지 못 했어요.");
					forward = inquireTotalMatchList(b);
					dao.transactionEnd(false);
				}            
			}else {
				request.setAttribute("message", "로그인부터 해주세요.");
				forward.setRedirect(true);      
				forward.setPage("login.jsp");
				dao.transactionEnd(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally {
			dao.closeConnection();
		}
		return forward;
	}
	// 20 검색 페이지
	private ActionForward searchMatch(Bean b) {
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> bList;
		try {
			String keyward = b.getTitle();
			dao.setAutoCommit(false);
			bList = dao.searchMatchDao(b, keyward);
			request.setAttribute("searchInfo", inqSearchInfo(bList));
			request.setAttribute("mmid", b.getMmid());
			request.setAttribute("text", "검색 결과 페이지");
			forward.setRedirect(false);
			forward.setPage("main_match.jsp");
			dao.transactionEnd(true);
		}catch(Exception e) {
			request.setAttribute("message", "검색 결과가 없어요.");
			request.setAttribute("mmid", b.getMmid());
			forward.setRedirect(false);
			forward.setPage("main_match.jsp");
			e.printStackTrace();
			try {dao.transactionEnd(false);}
			catch(Exception e1) {e1.printStackTrace();}
		}finally {
			dao.closeConnection();
		}
		return forward;
	}
	// 20 - 1검색 결과 태그 뿌리기
	private String inqSearchInfo(LinkedList<Bean> bList) {
		StringBuffer inqSearcoListInfo = new StringBuffer();
		inqSearcoListInfo.append("<table class = \'table\'><tr><th colspan = \"7\">검색 결과</th></tr><tr><td>주최자 아이디<br/>이름</td><td>경기 종목</td><td>경기 날짜</td><td>인원수<br/>참가 / 필요</td><td>경기 상태</td><td>경기 지역</td><td></td></tr>");
		System.out.println("여기 인가  태그");
		try{
			for(int i = 0 ; i < bList.size() ; i++) {
				System.out.println("여기 인가 for 1");
				if((i+1) < bList.size()) {
					System.out.println("여기 인가  if 1");
					if(!bList.get(i).getRqid().equals(bList.get(i+1).getRqid())) {
						System.out.println("여기 인가  if 2");
						inqSearcoListInfo.append("<tr><td>" + bList.get(i).getMmid() + "<br/>" + bList.get(i).getMmname() +"</td><td>");
						inqSearcoListInfo.append(bList.get(i).getStname() +"</td><td>" + bList.get(i).getFixdate() +"</td><td>" + bList.get(i).getNownum() + "/" + bList.get(i).getStnumber() + "</td><td>" + bList.get(i).getStatusname() + "</td><td>"  + bList.get(i).getLcname() +"</td><td>");
						inqSearcoListInfo.append("<input type =\"button\" class = \"reqAcc\" value = \"신청 하기\" onClick = \"matchapplypage(\'"+ bList.get(i).getRqid() + "\')\" /></td></tr>");
					}else {
						System.out.println("여기 인가  else 1");
						inqSearcoListInfo.append("");
					}
				}else {
					System.out.println("여기 인가  else 2");
					inqSearcoListInfo.append("<tr><td>" + bList.get(i).getMmid() + "<br/>" + bList.get(i).getMmname() +"</td><td>");
					inqSearcoListInfo.append(bList.get(i).getStname() +"</td><td>" + bList.get(i).getFixdate() +"</td><td>" + bList.get(i).getNownum() + "/" + bList.get(i).getStnumber() + "</td><td>" + bList.get(i).getStatusname() + "</td><td>"  + bList.get(i).getLcname() +"</td><td>");
					inqSearcoListInfo.append("<input type =\"button\" class = \"reqAcc\" value = \"신청 하기\" onClick = \"matchapplypage(\'"+ bList.get(i).getRqid() + "\')\" /></td></tr>");
				}
			}					
		}catch(Exception e){
			System.out.println("여기 인가 catch");
			inqSearcoListInfo.append("<tr><td colspan = \"7\" style=\"color: red;\">검색 결과가 없어요.</td></tr>");
		}finally{
			System.out.println("여기 인가 finally");
			inqSearcoListInfo.append("</table>");
		}
		return inqSearcoListInfo.toString();
	}



}// class 끝

