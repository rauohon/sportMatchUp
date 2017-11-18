package services;

import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;


import beans.*;
import dao.*;
import controller.ActionForward;
import controller.IActionForward;


public class MemberService implements IActionForward {
	private HttpServletRequest request = null;
	private Bean b;

	public MemberService(HttpServletRequest request){
		// Controller로부터 전달받은 request는 잡 실행 메서드에서 사용
		this.request = request;
	}

	public ActionForward entrance(char serviceCode, Object obj){
		ActionForward forward = null;
		/* DownCast : Object >> OwnerBean */


		b = (Bean)obj;

		switch(serviceCode){
		case 'A':
			/* 회원가입 */
			forward = access(b);
			break;

		case 'B':
			/* 로그인 */
			forward = signUp(b);
			break;

		case 'C':
			/* 회원정보 수정 */
			forward = accessOut(b);
			break;

		case 'D':
			/* 회원정보 수정 */
			forward = memberInfo(b);
			break;

		case 'E':
			/* 회원삭제 */
			forward = memberDrop(b);
			break;

		case 'F':
			/* 회원 업데이트 */
			forward = memberLcUpdate(b);
			break;

		case 'G':
			forward = messageSendPage(b);
			break;

		case 'H':
			forward = sendMessage(b);
			break;

		case 'I':
			forward = messageInfo(b);
			break;	

		case 'J':
			forward = messageReceiveInfo(b);
			break;

		case 'N':
			forward = goToMain(b);
			break;

		case 'L':
			forward = messageSent(b);
			break;

		case 'M':
			forward = memberInfoProfile(b);
			break;
			
		
		case 'P':
			forward = findPassword();
			break;

		case 'X':
			forward = memberLcUpdatePage(b);
			break;
		case 'Y':
			forward = pwCheckPage(b);
			break;

		case 'Z':
			forward = pwCheck(b);
			break;
		}
		return forward;
	}

	private ActionForward signUp(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		/*forward = new ActionForward();*/
		try{
			/*Connection & Transaction 시작*/
			dao.setAutoCommit(false);

			//회원가입
			//  1. 아이디 사용여부 검사
			if (!dao.idCheck(b)){  
				//  2. 회원 테이블에 Insert
				if (dao.memberInsert(b)){
					System.out.println("회원가입 성공");
					this.request.setAttribute("mmid", b.getMmid());
					this.request.setAttribute("signup", "회원가입을 축하드립니다. 로그인해주세요.");
					forward.setRedirect(false); // Dispatcher 
					forward.setPage("login.jsp");


				}else{
					// 회원가입 실패
					System.out.println("회원가입 실패");
					forward.setRedirect(false); // Dispatcher 
					forward.setPage("login.jsp");
				}
			}else{
				System.out.println("이미 사용되고 있는 아이디");
				/*this.request.setAttribute("message", "이미 사용되고 있는 아이디입니다.");*/
				forward.setRedirect(false); // Dispatcher 
				forward.setPage("login.jsp");
			}
			/*3. 회원가입 성공 여부 확인 -- 의미없음*/
			/*4. Transaction 종료 : commit */
			dao.transactionEnd(true);
		} catch (Exception e){
			e.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} 
			catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}
		return forward;
	}


	private ActionForward access(Bean b){
		ActionForward forward = null;
		forward = new ActionForward();
		Dao dao = new Dao();

		try{
			/*Connection & Transaction 시작*/
			dao.setAutoCommit(false);
			/*회원 로그인
	         1. 아이디 유효성 check*/
			if(dao.idCheck(b)){
				if(dao.passwordCheck(b)){
					if(dao.historyInsert(b, 1)){
						if(dao.typeCheck(b)){//회원 페이지
							this.request.setAttribute("mmid", b.getMmid());
							forward.setRedirect(false);
							forward.setPage("main_logined.jsp");
							dao.transactionEnd(true);
						}else{//관리자 페이지
							this.request.setAttribute("mmid", b.getMmid());
							forward.setRedirect(false);
							forward.setPage("adminpage.jsp");
							dao.transactionEnd(true);
						}
					}else{
						System.out.println("네트워크 에러");
						forward.setRedirect(false); // Dispatcher 
						forward.setPage("login.jsp"); 

						/*Transaction 종료 : Commit */
						dao.transactionEnd(false);
					}
				}else{
					System.out.println("패스워드를 다시 확인해 주세요.");
					this.request.setAttribute("message", "비밀번호를 잘못입력하셨습니당.");
					forward.setRedirect(false); // Dispatcher 
					forward.setPage("login.jsp");
				}
			}else{
				System.out.println("아이디를 다시 확인해 주세요.");
				this.request.setAttribute("message", "아이디를 잘못입력하셨습니당.");
				forward.setRedirect(false); // Dispatcher 
				forward.setPage("login.jsp");
			}      

		}catch (Exception e){
			e.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} 
			catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}

		return forward;
	}

	private ActionForward accessOut(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		try{
			/*Connection & Transaction 시작*/
			dao.setAutoCommit(false);

			/*로그아웃*/
			/*1. 아이디 존재여부 검사*/		
			if(dao.idCheck(b)){
				/*2.현재 계정 상태 검사*/
				if(dao.memberStatus(b)){
					/*3.히스토리 테이블에 레코드 삽입*/
					if(dao.historyInsert(b, -1)){
						System.out.println("정상 로그아웃");
						String message = URLEncoder.encode("정상적으로 로그아웃 되었습니다.", "UTF-8");
						forward.setPage("login.jsp?message="+ message);
						forward.setRedirect(true);

						/*Transaction 종료 : Commit */
						dao.transactionEnd(true);
					}else{
						System.out.println("네트워크 에러");
						String message = URLEncoder.encode("네트워크 에러", "UTF-8");
						forward.setPage("login.jsp?message="+ message);
						forward.setRedirect(true);

						/*Transaction 종료 : Commit */
						dao.transactionEnd(false);
					}
				}else{
					/* 이미 로그아웃된 상태 */
					System.out.println("이미 로그아웃");
					String message = URLEncoder.encode("이미 로그아웃이 되었습니다.","UTF-8");
					forward.setPage("login.jsp?message="+ message);
					forward.setRedirect(true);


					/*Transaction 종료 : Commit */
					dao.transactionEnd(false);
				}
			}else{
				/* ID 불일치 */
				System.out.println("불일치");
				String message = URLEncoder.encode("올바른 접근이 아닙니다.", "UTF-8");
				forward.setPage("login.jsp?message="+ message);
				forward.setRedirect(true);

				/*Transaction 종료 : Commit */
				dao.transactionEnd(false);
			}			

		}catch(Exception ex){
			ex.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} 
			catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}
		return forward;
	}




	private ActionForward memberDrop(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		try{
			/*Connection & Transaction 시작*/
			dao.setAutoCommit(false);
			boolean transaction = true;
			/*레코드 삭제*/
			/*아이디 존재여부 검사*/		
			if(dao.idCheck(b)){

				for(int i=7; i>0; i--){
					if(dao.isRecord(b, i)){
						transaction = dao.recodeDelete(b, i);

					}
					if(!transaction){break;}

				}
				dao.transactionEnd(transaction);


				if(transaction){
					String message = URLEncoder.encode("회원탈퇴가 정상적으로 이루어졌습니다.", "UTF-8");
					forward.setPage("login.jsp?message="+ message);
					forward.setRedirect(true); // Dispatcher
				}else{
					String message = URLEncoder.encode("잠시 후 다시 이용해 주세요", "UTF-8");
					forward.setPage("login.jsp?message="+ message);
					forward.setRedirect(true); // Dispatcher
				}
			}else{
				/* ID 불일치 */
				String message = URLEncoder.encode("올바른 접근이 아닙니다.", "UTF-8");
				forward.setPage("login.jsp?message="+ message);
				forward.setRedirect(true); // Dispatcher

				/*Transaction 종료 : rollback */
				dao.transactionEnd(false);
			}			

		}catch(Exception ex){
			ex.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}


		return forward;
	}

	private ActionForward memberInfo(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> memberList;
		LinkedList<Bean> locationList;
		LinkedList<Bean> historyList;
		LinkedList<Bean> matchlist;
		LinkedList<Bean> commentList;

		try{
			/* myInfo */
			if(dao.idCheck(b)){
				if(dao.memberStatus(b)){

					System.out.println("MemberInfo : 정상적으로 실행 1");
					memberList = dao.myInfo(b);
					System.out.println(b.getLcname());

					for(Bean mb : memberList){
						request.setAttribute("mmid", mb.getMmid());
						request.setAttribute("mmname", mb.getMmname());
						request.setAttribute("mmemail", mb.getMmemail());
						request.setAttribute("mmnumber", mb.getMmnumber());
						request.setAttribute("lcname", mb.getLcname());

					}
					StringBuffer option = new StringBuffer();
					for(Bean lb : dao.locationInfo()){

						option.append("<option value=" + lb.getLccode() + ">" +
								lb.getLcname() + "</option>");
					}
					request.setAttribute("lcoption", option.toString());


					/*	 history Info */
					
					
					
					StringBuffer history = new StringBuffer();
					history.append("<table class = \'table\'><thead>");
					history.append("<tr><th colspan=2>일시</th><th colspan=2>상태</th></tr></thead>");
					for(Bean hb : dao.historyInfo(b)){
						history.append("<tr>");
						history.append("<td>" + hb.getDate() + "<td>");
						history.append("<td>" + ((hb.getType()==1)? "로그인":"로그아웃") + "<td>");
						history.append("</tr>");

						request.setAttribute("historylog", history.toString());
					}
					history.append("</table>");

					/* comment check 
					StringBuffer comment = new StringBuffer();
					comment.append("<table class ='table table-responsive'>");
					comment.append("<thead><tr><th>번호</th><th>일시</th><th>내용</th></tr>");
					for(Bean cb : dao.commentList(b)){
						comment.append("<tr>");
						comment.append("<td>" + cb.getCtcode() + "<td>");
						comment.append("<td>" + cb.getDate() + "<td>");
						comment.append("<td>" + cb.getText() + "<td>");
						comment.append("</tr>");

						request.setAttribute("message", comment.toString());
					}
					comment.append("</table>");*/
					forward.setPage("myinfo.jsp");
					forward.setRedirect(false); // Dispatcher

				}else{
					/* 이미 로그아웃인 상태 */
					System.out.println("MemberInfo -- 이미 로그아웃된 상태");
					String message = URLEncoder.encode("로그아웃된 상태입니다. 먼저 로그인해주세요", "UTF-8");
					forward.setPage("login.jsp?message="+ message);
					forward.setRedirect(true);
				}
			}else{
				System.out.println("MemberInfo -- 아이디 無");
				/*String message = URLEncoder.encode("올바른 접근이 아닙니다.", "UTF-8");
			map.put("page", "login.jsp?message="+ message);*/
				// 아이디가 없는 경우
				String message = URLEncoder.encode("아이디가 존재하지 않습니다. 회원가입해주세요", "UTF-8");
				forward.setPage("login.jsp?message="+ message);
				forward.setRedirect(true);

			}


		}catch(Exception ex){
			ex.printStackTrace();

		}finally{
			dao.closeConnection();

		}
		return forward;


	}
	private ActionForward memberLcUpdate(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> memberList;

		boolean transaction = false;

		try{
			/*Connection & Transaction 시작*/
			dao.setAutoCommit(false);

			/*아이디 존재여부 검사*/
			if(dao.idCheck(b)){
				if(dao.isMemberLcUpdate(b)){
				memberList = dao.myInfo(b);
				System.out.println(b.getLcname());

				for(Bean mb : memberList){
					request.setAttribute("lcname", mb.getLcname());
					request.setAttribute("lccode", mb.getLccode());
				}
				StringBuffer option = new StringBuffer();
				for(Bean lb : dao.locationInfo()){

					option.append("<option value=" + lb.getLccode() + ">" +
							lb.getLcname() + "</option>");
				}
				request.setAttribute("lcoption", option.toString());

				transaction = true;
				this.request.setAttribute("mmid", b.getMmid());
				this.request.setAttribute("lccode", b.getLccode());
				this.request.setAttribute("mmpw", b.getMmpw());
				/*String message = URLEncoder.encode("회원정보가 정상적으로 수정되었습니다.", "UTF-8");*/
				System.out.println("회원정보 정보 수정 완료 ");
				this.request.setAttribute("lo_message", "성공적으로 지역변경이 되었습니다");
				forward.setRedirect(false); // Dispatcher 
				forward.setPage("MemberInfo");
				
				}else{
					this.request.setAttribute("message", "다시 시도해 주세요");
					forward.setPage("MemberLcUpdatePage");
					forward.setRedirect(false);
				}			

			}else{
				/* ID 불일치 */
				String message = URLEncoder.encode("올바른 접근이 아닙니다.", "UTF-8");
				forward.setPage("login.jsp?message="+ message);
				forward.setRedirect(true);
			}			

			/*Transaction 종료 : rollback */
			dao.transactionEnd(transaction);

		}catch(Exception ex){
			ex.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}

		return forward;
	}




	private ActionForward messageSendPage(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();

		boolean transaction = false;
		try{   /*Connection & Transaction 시작*/
			dao.setAutoCommit(false);

			this.request.setAttribute("mmid", b.getMmid());
			forward.setPage("messagesend.jsp");
			forward.setRedirect(false);


			/*Transaction 종료 : rollback */
			dao.transactionEnd(transaction);

		}catch(Exception ex){
			ex.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}
		return forward;
	}

	private ActionForward memberInfoProfile(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();

		boolean transaction = false;
		try{   /*Connection & Transaction 시작*/
			dao.setAutoCommit(false);

			this.request.setAttribute("mmid", b.getMmid());
			forward.setPage("myinfo_profile.jsp");
			forward.setRedirect(false);


			/*Transaction 종료 : rollback */
			dao.transactionEnd(transaction);

		}catch(Exception ex){
			ex.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}

		return forward;
	}



	private ActionForward pwCheckPage(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();

		boolean transaction = false;
		try{   /*Connection & Transaction 시작*/
			dao.setAutoCommit(false);

			this.request.setAttribute("mmid", b.getMmid());
			forward.setPage("myinfo_pwcheck.jsp");
			forward.setRedirect(false);


			/*Transaction 종료 : rollback */
			dao.transactionEnd(transaction);

		}catch(Exception ex){
			ex.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}

		return forward;
	}

	private ActionForward memberLcUpdatePage(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> memberList;
		System.out.println("멤버서비스 lcupdatepage");
		boolean transaction = false;
		try{   /*Connection & Transaction 시작*/
			dao.setAutoCommit(false);
			if(dao.idCheck(b)){
				memberList = dao.myInfo(b);
				System.out.println(b.getLcname());

				for(Bean mb : memberList){
					this.request.setAttribute("lcname", mb.getLcname());
					System.out.println(mb.getLcname());

					StringBuffer option = new StringBuffer();
					for(Bean lb : dao.locationInfo()){

						option.append("<option value=" + lb.getLccode() + ">" +
								lb.getLcname() + "</option>");
					}

					this.request.setAttribute("lcoption", option.toString());
					this.request.setAttribute("mmid", b.getMmid());
					
					forward.setPage("memberlcupdate.jsp");
					forward.setRedirect(false);


				}
			}else{
				/* ID 불일치 */
				String message = URLEncoder.encode("올바른 접근이 아닙니다.", "UTF-8");
				forward.setPage("login.jsp?message="+ message);
				forward.setRedirect(true);
			}	
			/*Transaction 종료 : rollback */
			dao.transactionEnd(transaction);

		}catch(Exception ex){
			ex.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}

		return forward;
	}

	private ActionForward goToMain(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();

		boolean transaction = false;
		try{   /*Connection & Transaction 시작*/
			dao.setAutoCommit(false);

			this.request.setAttribute("mmid", b.getMmid());
			forward.setPage("main_logined.jsp");
			forward.setRedirect(false);


			/*Transaction 종료 : rollback */
			dao.transactionEnd(transaction);

		}catch(Exception ex){
			ex.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}

		return forward;
	}
	private ActionForward messageSent(Bean b){

		ActionForward forward = new ActionForward();
		Dao dao = new Dao();

		boolean transaction = false;
		try{   /*Connection & Transaction 시작*/
			dao.setAutoCommit(false);

			this.request.setAttribute("mmid", b.getMmid());
			forward.setPage("messagesent.jsp");
			forward.setRedirect(false);


			/*Transaction 종료 : rollback */
			dao.transactionEnd(transaction);

		}catch(Exception ex){
			ex.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}

		return forward;
	}
	//메시지 보내기
	private ActionForward sendMessage(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();

		boolean transaction = false;
		try{   /*Connection & Transaction 시작*/
			dao.setAutoCommit(false);

			if(dao.idCheck(b)){
				if(dao.msSend(b)){
					this.request.setAttribute("mmid", b.getMmid());
					this.request.setAttribute("remmid", b.getRemmid());
					this.request.setAttribute("text", b.getText());

					
					
					forward.setPage("MessageReceiveInfo");
					forward.setRedirect(false);
					System.out.println("메시지 보냄여");
					transaction = true;
				}else{
					transaction = false;
					System.out.println("메시지를 보낼 수 없습니다.");
					forward.setRedirect(false); // Dispatcher 
					forward.setPage("messagesend.jsp");
				}
			}else{
				transaction = false;
				System.out.println("보내는 사람 아이디가 존재하지 않습니다.");
				this.request.setAttribute("mmid", b.getMmid());
				this.request.setAttribute("message", "보내는 사람 아이디를 확인해주세여");
				forward.setRedirect(false); // Dispatcher 
				forward.setPage("messagesend.jsp");
			}

			/*Transaction 종료 : rollback */
			dao.transactionEnd(transaction);

		}catch(Exception ex){
			ex.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}

		return forward;
	}
	//보낸 메시지
	private ActionForward messageInfo(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> messageList;

		try{
			/* messageInfo */
			dao.setAutoCommit(false);

			if(dao.idCheck(b)){
				if(dao.memberStatus(b)){

					System.out.println("messageInfo : 정상적으로 실행 1");
					messageList = dao.messageInfo(b);

					
					Collections.sort(messageList, new Comparator<Bean>(){
			            @Override
			            public int compare(Bean r1, Bean r2){
			               return r2.getMedate().compareTo(r1.getMedate());
			            }
			         });
					
					
					//System.out.println(b.getMmid());
					StringBuffer sb = new StringBuffer();
					sb.append("<table class = \'table\'>");
					for(Bean msb : messageList){
						request.setAttribute("mmid", msb.getMmid());
						request.setAttribute("remmid", msb.getRemmid());
						request.setAttribute("medate", msb.getMedate());
						request.setAttribute("text", msb.getText());
						System.out.println(msb.getText());

						sb.append("<tr>");
						sb.append("<td>" + msb.getRemmid() + "</td>");
						sb.append("<td>" + msb.getText() + "</td>");
						sb.append("<td>" + msb.getMedate() + "</td>");
						sb.append("</tr>");
					}
					sb.append("</table>");

					forward.setPage("messagesent.jsp");
					request.setAttribute("messagelist", sb.toString());
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
	//받은 메시지
	private ActionForward messageReceiveInfo(Bean b){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		LinkedList<Bean> messageList;

		try{
			/* messageInfo */
			dao.setAutoCommit(false);

			if(dao.idCheck(b)){
				if(dao.memberStatus(b)){

					System.out.println("messageInfo : 정상적으로 실행 1");
					messageList = dao.messageResceiveInfo(b);

					
					Collections.sort(messageList, new Comparator<Bean>(){
			            @Override
			            public int compare(Bean r1, Bean r2){
			               return r2.getMedate().compareTo(r1.getMedate());
			            }
			         });
					
					//System.out.println(b.getMmid());
					StringBuffer sb = new StringBuffer();
					sb.append("<table class = \'table\'>");
					sb.append("<tr>");
					// sb.append("<td>받은사람</td><td>내용</td><td>날짜</td>");
					sb.append("</tr>");
					for(Bean msb : messageList){
						request.setAttribute("mmid", msb.getMmid());
						request.setAttribute("remmid", msb.getRemmid());
						request.setAttribute("medate", msb.getMedate());
						request.setAttribute("text", msb.getText());
						System.out.println(msb.getMmid()); //보낸사람
						System.out.println(msb.getRemmid());
						sb.append("<tr>");
						sb.append("<td>" + msb.getMmid() + "</td>");
						sb.append("<td>" + msb.getText() + "</td>");
						sb.append("<td>" + msb.getMedate() + "</td>");
						sb.append("</tr>");
					}
					sb.append("</table>");
					request.setAttribute("mmid", b.getMmid());
					forward.setPage("message.jsp");
					request.setAttribute("messageReceivelist", sb.toString());
					forward.setRedirect(false); // Dispatcher

				}else{
					/* 이미 로그아웃인 상태 */
					System.out.println("MemberInfo -- 이미 로그아웃된 상태");
					String message = URLEncoder.encode("로그아웃된 상태입니다. 먼저 로그인해주세요", "UTF-8");
					forward.setPage("login.jsp?message="+ b);
					forward.setRedirect(true);
				}
			}else{
				System.out.println("MemberInfo -- 아이디 無");
				// 아이디가 없는 경우
				String message = URLEncoder.encode("아이디가 존재하지 않습니다. 회원가입해주세요", "UTF-8");
				forward.setPage("login.jsp?message="+ b);
				forward.setRedirect(true);
			}
		}catch(Exception ex){
			ex.printStackTrace();

		}finally{
			dao.closeConnection();
		}
		return forward;
	}

	// 비밀번호 찾기
	private ActionForward findPassword(){
		ActionForward forward = new ActionForward();
		Dao dao = new Dao();
		EmailService sendmail = new EmailService();
		int d =0;
		int e = (int)(Math.random()*90)+10;
		d = (int)(Math.random()*26)+70;
		char a = (char)d;
		d = (int)(Math.random()*26)+70;
		char x = (char)d;
		d = (int)(Math.random()*26)+70;
		char c = (char)d;

		String password = a+""+d+""+x+""+e+""+c+"";   
	



		try{
			dao.setAutoCommit(false);
			if(dao.idCheck(b)){
				System.out.println("idcheck");
				System.out.println(request.getParameter("mmid"));
				if(dao.idCheckfind(b)){
					System.out.println("이름 확인");
					System.out.println(request.getParameter("mmname"));
					if(dao.emailfind(b)){
						System.out.println("이메일확인");
						System.out.println(request.getParameter("mmemail"));
						System.out.println("send");
						if(dao.pwdUpdate(b, password)){
							System.out.println(password);
							sendmail.Sendmail(request, password);         
							dao.transactionEnd(true);
						}
						request.setAttribute("email", "메일로 임시패스워드를 전송하였습니다");
						forward.setRedirect(false);
						forward.setPage("login.jsp");
					}else{
						System.out.println("이메일 오류 ");
						request.setAttribute("message", "정보를 확인해주세요");
						forward.setRedirect(true);
						forward.setPage("login.jsp");
					}
				}else{
					System.out.println("이름오류");
					request.setAttribute("message", "정보를 확인해주세요");
					forward.setRedirect(true);
					forward.setPage("login.jsp");
				}
			}else{
				System.out.println("아이디오류 ");
				request.setAttribute("message", "아이디를 확인해주세요");
				forward.setRedirect(true);
				forward.setPage("login.jsp");
			}

		}catch(Exception ex){
			ex.printStackTrace();
		forward.setRedirect(true);	
		forward.setPage("login.jsp");
		
		}finally{
			dao.closeConnection();
		}


		return forward;
	}

	private ActionForward pwCheck(Bean b){
		ActionForward forward = null;
		forward = new ActionForward();
		Dao dao = new Dao();

		try{
			/*Connection & Transaction 시작*/
			dao.setAutoCommit(false);
			/*회원 로그인
		         1. 아이디 유효성 check*/
			if(dao.idCheck(b)){
				if(dao.passwordCheck(b)){
					this.request.setAttribute("mmid", b.getMmid());
					forward.setRedirect(false);
					forward.setPage("MemberInfo");
					dao.transactionEnd(true);
				}else{
					System.out.println("패스워드를 다시 확인해 주세요.");
					System.out.println("여긴가?");
					this.request.setAttribute("mmid", b.getMmid());
					this.request.setAttribute("message", "비밀번호를 잘못입력하셨습니당.");
					forward.setRedirect(false); // Dispatcher 
					forward.setPage("myinfo_pwcheck.jsp");
				}
			}else{
				System.out.println("아이디를 다시 확인해 주세요.");
				this.request.setAttribute("mmid", b.getMmid());
				this.request.setAttribute("message", "아이디를 잘못입력하셨습니당.");
				forward.setRedirect(false); // Dispatcher 
				forward.setPage("login.jsp");
			}      

		}catch (Exception e){
			e.printStackTrace();
			/*4. Transaction 종료 : rollback*/
			try {dao.transactionEnd(false);} 
			catch (Exception e1) {e1.printStackTrace();}
		} finally{
			/*5. Connection 종료*/
			dao.closeConnection();
		}

		return forward;
	}
}
