package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.Bean;

public class Dao {

	public Connection connection = null;
	private Context context = null;
	private DataSource datasource = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	//생성자에 Connection연결
	public Dao(){ 
		try{
			Context context = new InitialContext();
			DataSource datasource = 
					(DataSource)context.lookup("java:comp/env/mompommDB"); 
			// Context.xml의 globalname 과 일치
			connection = datasource.getConnection();
			System.out.println("DB Connect Successfull");
		}catch(Exception ex){
			System.out.println("DB Connect Failure");
			ex.printStackTrace();
		}
	}

	public void closeConnection(){
		try{
			if(connection != null){ connection.close();}
			System.out.println("===== Oracle Disconnection Success =====");
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("===== Oracle Disconnection Failure =====");
		}
	}

	// Transaction의 시작 메소드
	public void setAutoCommit(boolean autoCommit) throws Exception{
		connection.setAutoCommit(autoCommit);
	} // setAutoCommint을 통해 여러 DML 구문을 통제하기 위해 setAutoCommit을 사용

	// Transaction 종료 메소드
	public void transactionEnd(boolean transaction) throws Exception{
		if(transaction){
			connection.commit(); // 묶어서 commit
		}else{
			connection.rollback(); // 아니면 되돌림
		}
	}

	// DBMS에 SQL 구문을 통해 1 또는 0값을 전달하고
	//  true, false를 리턴받아 제어 하기 위한 메소드
	public boolean convertToBoolean(int value){
		return( value >= 1 ) ? true : false;
	}
	public boolean idCheck(Bean b){

		PreparedStatement pstmt = null; // 필수
		ResultSet rs = null; // 선택
		int resultSingle = 0; //
		boolean returnValue = false; // ID CHECK를 통해서 나온값 0 또는 1를 TRUE/FALSE
		// 1. 아이디 사용여부 검사
		String sql = "SELECT COUNT(*) FROM MM "
				+ "WHERE MM_ID= ?";
		try{
			// 2. PreparedStatement와 Connection 과의 연결
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid()); // sql ? 부분에 입력하는 값
			// java 에서는 인덱스 0으로 시작 . 데이터베이스에서는 1 부터 시작


			// 3. Execution
			rs = pstmt.executeQuery();

			// executeQuery 와 executeUpdate 두가지 존재 


			// 4. Data Extraction 

			while(rs.next()){  //rs.next 는 boolean 추출할 레코드가 있니? ( 데이터가 있으면 true 없으면 false ) 일종의 플래그비트
				resultSingle = rs.getInt(1); // rs로 부터 값을 가져옴 카운트였기때문에 Int
			}

			returnValue = convertToBoolean(resultSingle);
		}catch(Exception ex){
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}

		return returnValue;
	}

	public boolean memberInsert(Bean b){
		// 2. 회원 테이블에 Insert


		PreparedStatement pstmt = null; // 필수
		int resultSingle = 0; 
		boolean returnValue = false; // ID CHECK를 통해서 나온값 0 또는 1를 TRUE/FALSE

		String sql = "INSERT INTO MM(MM_ID, MM_PW, MM_NAME, MM_EMAIL, MM_NUMBER, MM_LCCODE)"
				+ " VALUES (?,?,?,?,?,?)"; 
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());
			pstmt.setString(2, b.getMmpw());
			pstmt.setString(3, b.getMmname());
			pstmt.setString(4, b.getMmemail());
			pstmt.setString(5, b.getMmnumber());
			pstmt.setString(6, b.getLccode());


			resultSingle = pstmt.executeUpdate();
			returnValue = convertToBoolean(resultSingle);


		}catch(Exception ex){ 
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return returnValue;
	}
	public boolean passwordCheck(Bean b){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultSingle = 0;
		boolean returnValue = false;

		/*1. Create Query*/
		String sql = "SELECT COUNT(*) FROM MM "
				+ "WHERE MM_ID = ? AND MM_PW = ?";
		try{
			/*2. PreparedStatement와 Connection 과의 연결*/
			pstmt = connection.prepareStatement(sql); 
			pstmt.setString(1, b.getMmid());
			pstmt.setString(2, b.getMmpw());

			/*3. Execution*/
			rs = pstmt.executeQuery();

			/*4. Data Extraction*/
			while(rs.next()){
				resultSingle = rs.getInt(1);
			}
			returnValue = convertToBoolean(resultSingle);
		}catch(Exception ex){
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}

		return returnValue;
	}

	public boolean historyInsert(Bean b, int type){
		PreparedStatement pstmt = null;
		int resultSingle = 0;
		boolean returnValue = false;

		/*1. Create Query*/
		String sql = "INSERT INTO HI VALUES(?, DEFAULT, ?)";

		try{
			/*2. PreparedStatement와 Connection 과의 연결*/
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());
			pstmt.setInt(2, type);

			resultSingle = pstmt.executeUpdate();
			returnValue = convertToBoolean(resultSingle);

		}catch(Exception ex){
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return returnValue;
	}

	public boolean memberStatus(Bean b){
		/* ResultSet Or[And] ResultSingle And PreparedStatement*/
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultSingle = 0;
		boolean returnValue = false;

		/*1. Create Query*/		
		String sql = "SELECT SUM(HI_TYPE) FROM HI "
				+ "WHERE HI_MMID = ?";
		try{
			/*2. PreparedStatement와 Connection 과의 연결*/
			pstmt = connection.prepareStatement(sql); 
			pstmt.setString(1, b.getMmid());

			/*3. Execution*/
			rs = pstmt.executeQuery();

			/*4. Data Extraction*/
			while(rs.next()){
				resultSingle = rs.getInt(1);
			}
			returnValue = convertToBoolean(resultSingle);
		}catch(Exception ex){
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}

		return returnValue; // TRUE : 로그인상태
	}

	public boolean isRecord(Bean b, int type){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultSingle = 0;
		boolean returnValue = false;

		String sql = "SELECT COUNT(*) FROM";
		switch(type){
		case 1:
			sql += " MM WHERE MM_ID = ?";
			break;
		case 2:
			sql += " HI WHERE HI_MMID = ?";
			break;
		case 3:
			sql += " HI WHERE HI_MMID = ?";
			break;
		case 4:
			sql += " ME WHERE ME_MMID = ?";
			break;
		case 5:
			sql += " ME WHERE ME_MMIDA = ?";
			break;
		case 6:
			sql += " RQ WHERE RQ_MMID = ?";
			break;
		case 7:
			sql += " RQA WHERE RQA_ACID = ?";
			break;
		}try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());

			/*3. Execution*/
			rs = pstmt.executeQuery();

			/*4. Data Extraction*/
			while(rs.next()){
				resultSingle = rs.getInt(1);
			}
			resultSingle = (resultSingle>=1)? 1: 0;
			returnValue = convertToBoolean(resultSingle);
		}catch(Exception ex){
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return returnValue;
	}

	public boolean recodeDelete(Bean b, int type){
		PreparedStatement pstmt = null;
		int resultSingle = 0;
		boolean returnValue = false;

		String sql = "DELETE FROM";
		switch(type){
		case 1:
			sql += " MM WHERE MM_ID = ?";
			break;
		case 2:
			sql += " HI WHERE HI_MMID = ?";
			break;
		case 3:
			sql += " HI WHERE HI_MMID = ?";
			break;
		case 4:
			sql += " ME WHERE ME_MMID = ?";
			break;
		case 5:
			sql += " ME WHERE ME_MMIDA = ?";
			break;
		case 6:
			sql += " RQ WHERE RQ_MMID = ?";
			break;
		case 7:
			sql += " RQA WHERE RQA_ACID = ?";
			break;
			
		}

		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());


			resultSingle = pstmt.executeUpdate();
			resultSingle = (resultSingle>=1)? 1: 0;
			returnValue = convertToBoolean(resultSingle);

		}catch(Exception ex){
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return returnValue;
	}

	public LinkedList<Bean> myInfo(Bean b){
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		LinkedList<Bean> memberList = 
				new LinkedList<Bean>();

		String sql = "SELECT * FROM MYINFO WHERE MMID = ?"; // MYINFO 는 VIEW
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());
			rs = pstmt.executeQuery();

			System.out.println(b.getMmid());
			while(rs.next()){
				b = new Bean();
				b.setMmid(rs.getNString("MMID"));
				b.setMmname(rs.getNString("MMNAME"));
				b.setMmemail(rs.getNString("MMEMAIL"));
				b.setMmnumber(rs.getNString("MMNUMBER"));
				b.setLcname(rs.getNString("LCNAME"));
				b.setLccode(rs.getNString("LCCODE")); // VIEW AS 와 같게 설정
				memberList.add(b);  // arrayList에 최종적으로 저장.	
			}

		}catch(Exception ex){

		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
			if(rs != null){try{rs.close();}catch(Exception ex){}}
		}

		return memberList;
	}


	public LinkedList<Bean> locationInfo(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Bean locationInfo;
		LinkedList<Bean> locationList = 
				new LinkedList<Bean>();

		String sql = "SELECT LC_CODE, LC_NAME FROM LC";
		try{
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				locationInfo = new Bean();
				locationInfo.setLccode(rs.getNString("LC_CODE"));
				locationInfo.setLcname(rs.getNString("LC_NAME"));
				locationList.add(locationInfo);
			}
		}catch(Exception ex){

		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
			if(rs != null){try{rs.close();}catch(Exception ex){}}
		}
		return locationList;
	}

	public LinkedList<Bean> historyInfo(Bean mb){
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Bean historyInfo;
		LinkedList<Bean> historyList = 
				new LinkedList<Bean>();

		String sql = "SELECT  HI_MMID AS HIMMID, "
				+ "TO_CHAR(HI_DATE, 'YYYY-MM-DD HH24:MI:SS') AS HIDATE, "
				+ "HI_TYPE AS HITYPE "
				+ "FROM HI WHERE HI_MMID = ? "
				+ "ORDER BY HI_DATE DESC";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, mb.getMmid());
			rs = pstmt.executeQuery();

			while(rs.next()){
				historyInfo = new Bean();
				historyInfo.setMmid(rs.getNString("HIMMID"));
				historyInfo.setDate(rs.getNString("HIDATE"));
				historyInfo.setType(rs.getInt("HITYPE"));
				historyList.add(historyInfo);
			}

		}catch(Exception ex){

		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
			if(rs != null){try{rs.close();}catch(Exception ex){}}
		}
		return historyList;
	}




	public boolean isMemberLcUpdate(Bean b){
		PreparedStatement pstmt = null;
		int resultSingle = 0;
		boolean returnValue = false;

		String sql = "UPDATE MM SET MM_LCCODE = ? WHERE MM_ID = ?";

		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getLccode());
			pstmt.setString(2, b.getMmid());

			resultSingle = pstmt.executeUpdate();
			// resultSingle = (resultSingle>=1)? 1: 0;  // 하나의 업데이트만 존재하니까 필요하지않다고 생각. 
			returnValue = convertToBoolean(resultSingle);

		}catch(Exception ex){
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}

		return returnValue; 
	}

	public boolean mbIdFind(Bean b){
		boolean returnValue = false;

		return returnValue;
	}

	public boolean mbPwFind(Bean b){
		boolean returnValue = false;

		return returnValue;
	}


	public boolean msSend(Bean b){
		PreparedStatement pstmt = null; // 필수
		int resultSingle = 0; 
		boolean returnValue = false; // ID CHECK를 통해서 나온값 0 또는 1를 TRUE/FALSE

		String sql = "INSERT INTO ME VALUES (?,?,DEFAULT,?)"; 
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());
			pstmt.setString(2, b.getRemmid());
			pstmt.setString(3, b.getText());

			resultSingle = pstmt.executeUpdate();
			returnValue = convertToBoolean(resultSingle);

		}catch(Exception ex){
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return returnValue;
	}


	public LinkedList<Bean> messageInfo(Bean message){
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		LinkedList<Bean> messageList = 
				new LinkedList<Bean>();

		String sql = "SELECT ME_MMID AS MEMMID, "
				+ "ME_MMIDA AS MEMMIDA, "
				+ "ME_DATE AS MEDATE, "
				+ "ME_TEXT AS METEXT "
				+ "FROM ME WHERE ME_MMID = ?";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, message.getMmid());
			rs = pstmt.executeQuery();
			//System.out.println(rs);

			while(rs.next()){
				//System.out.println(message.getMmid() + ":");
				message = new Bean();
				message.setMmid(rs.getNString("MEMMID"));
				message.setRemmid(rs.getNString("MEMMIDA"));
				message.setMedate(rs.getNString("MEDATE"));
				message.setText(rs.getNString("METEXT"));
				//System.out.println(rs.getNString("MEMMIDA"));
				messageList.add(message);  // arrayList에 최종적으로 저장.   
			}
		}catch(Exception ex){

		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
			if(rs != null){try{rs.close();}catch(Exception ex){}}
		}
		//System.out.println(messageList.size());
		return messageList;
	}

	public LinkedList<Bean> messageResceiveInfo(Bean message){
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		LinkedList<Bean> messageList = 
				new LinkedList<Bean>();

		String sql = "SELECT ME_MMID AS MEMMID, "
				+ "ME_MMIDA AS MEMMIDA, "
				+ "ME_DATE AS MEDATE, "
				+ "ME_TEXT AS METEXT "
				+ "FROM ME WHERE ME_MMIDA = ?";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, message.getMmid());
			rs = pstmt.executeQuery();
			//System.out.println(rs);

			
			while(rs.next()){
				/*System.out.println("dao 확인 받는사람");*/
				message = new Bean();
				message.setMmid(rs.getNString("MEMMID"));
				message.setRemmid(rs.getNString("MEMMIDA"));
				message.setMedate(rs.getNString("MEDATE"));
				message.setText(rs.getNString("METEXT"));
				/*System.out.println(rs.getNString("MEMMIDA"));*/
				messageList.add(message);  // arrayList에 최종적으로 저장.
				
			}
		}catch(Exception ex){

		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
			if(rs != null){try{rs.close();}catch(Exception ex){}}
		}
		//System.out.println(messageList.size());
		return messageList;
	}


	public boolean typeCheck(Bean b){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int i = 0;
		boolean returnValue = false;

		String sql = "SELECT COUNT(*) FROM MM WHERE MM_ID = ? AND MM_MTCODE = 'A1'";

		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());

			rs = pstmt.executeQuery();
			while(rs.next()){
				i = rs.getInt(1);
			}
			System.out.println(i);
			returnValue = convertToBoolean(i);

		}catch(Exception ex){
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return returnValue;
	}

	// email 용 이름확인
	public boolean idCheckfind(Bean b){
		/* ResultSet Or[And] ResultSingle And PreparedStatement*/
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultSingle = 0;
		boolean returnValue = false;
System.out.println("id check find 확인 ");
		/*1. Create Query*/      
		String sql = "SELECT COUNT(*) FROM MM WHERE MM_NAME = ?";
		try{
			/*2. PreparedStatement와 Connection 과의 연결*/
			pstmt = connection.prepareStatement(sql); 
			pstmt.setString(1, b.getMmname());

			/*3. Execution*/
			rs = pstmt.executeQuery();

			/*4. Data Extraction*/
			while(rs.next()){
				resultSingle = rs.getInt(1);
			}
			System.out.println(b.getMmid());
			returnValue = convertToBoolean(resultSingle);
		}catch(Exception ex){
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return returnValue;
	}

	//이메일 확인
	public boolean emailfind(Bean b){
		/* ResultSet Or[And] ResultSingle And PreparedStatement*/
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultSingle = 0;
		boolean returnValue = false;

		/*1. Create Query*/      
		String sql = "SELECT COUNT(*) FROM MM WHERE MM_EMAIL = ?";
		System.out.println("EMAIL check");
		try{
			/*2. PreparedStatement와 Connection 과의 연결*/
			pstmt = connection.prepareStatement(sql); 
			pstmt.setString(1, b.getMmemail());

			/*3. Execution*/
			rs = pstmt.executeQuery();

			/*4. Data Extraction*/
			while(rs.next()){
				resultSingle = rs.getInt(1);
			}
			System.out.println(b.getMmid());
			returnValue = convertToBoolean(resultSingle);
		}catch(Exception ex){
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return returnValue;
	}

	public boolean pwdUpdate(Bean b, String password){
		PreparedStatement pstmt = null;
		int resultSingle = 0;
		boolean returnValue = false;

		/*1. Create Query*/
		String sql = "UPDATE MM SET MM_PW = ? WHERE MM_ID = ?";

		try{
			/*2. PreparedStatement와 Connection 과의 연결*/
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, b.getMmid());

			resultSingle = pstmt.executeUpdate();
			returnValue = convertToBoolean(resultSingle);

		}catch(Exception ex){
			ex.printStackTrace();
			returnValue = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return returnValue;
	}

// 이하 경기 매칭 관련 dao

	// 신청 가능한 전체 경기 정보를 list에 저장 하기(blist1)
	public LinkedList<Bean> inqTotAppMatListDao(Bean b){
		LinkedList<Bean> bList = new LinkedList<Bean>();
		String sql = "SELECT * FROM RA WHERE STATUS = 'C1'";
		try{
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				b = new Bean();
				b.setRqid(rs.getString(1));
				b.setMmid(rs.getString(2));
				b.setMmname(rs.getString(3));
				b.setDescription(rs.getString(3));
				b.setWrdate(rs.getString(5));
				b.setAcid(rs.getString(6));
				b.setAcdate(rs.getString(7));
				b.setNownum(rs.getString(8));
				b.setFixdate(rs.getString(9));
				b.setStcode(rs.getString(10));
				b.setStname(rs.getString(11));
				b.setStnumber(rs.getString(12));
				b.setLccode(rs.getString(13));
				b.setLcname(rs.getString(14));
				b.setStatus(rs.getString(15));
				b.setStatusname(rs.getString(16));
	            b.setAcstatus(rs.getString(17));
				
				bList.add(b);
			}
			System.out.println(bList.get(0).getMmid() + "dao");
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return bList;
	}
	// 최근 완료된 전체 경기 정보를 list에 저장 하기(blist2)
	public LinkedList<Bean> inqTotComMatListDao(Bean b){
		LinkedList<Bean> bList2 = new LinkedList<Bean>();
		String sql = "SELECT * FROM RA WHERE STATUS = 'C2'";
		try{
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				b = new Bean();
				b.setRqid(rs.getString(1));
				b.setMmid(rs.getString(2));
				b.setMmname(rs.getString(3));
				b.setDescription(rs.getString(4));
				b.setWrdate(rs.getString(5));
				b.setAcid(rs.getString(6));
				b.setAcdate(rs.getString(7));
				b.setNownum(rs.getString(8));
				b.setFixdate(rs.getString(9));
				b.setStcode(rs.getString(10));
				b.setStname(rs.getString(11));
				b.setStnumber(rs.getString(12));
				b.setLccode(rs.getString(13));
				b.setLcname(rs.getString(14));
				b.setStatus(rs.getString(15));
				b.setStatusname(rs.getString(16));
	            b.setAcstatus(rs.getString(17));
				bList2.add(b);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}

		return bList2;
	}
	// 내가 생성한 경기 정보를 list에 저장 하기(bList1)
	public LinkedList<Bean> inqPerCreMatListDao(Bean b){
		LinkedList<Bean> bList1 = new LinkedList<Bean>();
		String sql = "SELECT * FROM RA WHERE RQMMID = ? AND STATUS = 'C1'";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());
			rs = pstmt.executeQuery();
			while(rs.next()){
				b = new Bean();
				b.setRqid(rs.getString(1));
				b.setMmid(rs.getString(2));
				b.setMmname(rs.getString(3));
				b.setDescription(rs.getString(4));
				b.setWrdate(rs.getString(5));
				b.setAcid(rs.getString(6));
				b.setAcdate(rs.getString(7));
				b.setNownum(rs.getString(8));
				b.setFixdate(rs.getString(9));
				b.setStcode(rs.getString(10));
				b.setStname(rs.getString(11));
				b.setStnumber(rs.getString(12));
				b.setLccode(rs.getString(13));
				b.setLcname(rs.getString(14));
				b.setStatus(rs.getString(15));
				b.setStatusname(rs.getString(16));
	            b.setAcstatus(rs.getString(17));
				bList1.add(b);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return bList1;
	}
	// 내가 생성한 경기에 신청한 회원을 list저장 하기
	public LinkedList<Bean> inqPerCreMatAccepterDao(String rqid) {
		LinkedList<Bean> bList1 = new LinkedList<Bean>();
		String sql = "SELECT * FROM RA WHERE RQID = ? AND RQASTATUS IN ('D1','D5')";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, rqid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Bean b = new Bean();
				b.setRqid(rs.getString(1));
				b.setAcid(rs.getString(6));
				b.setAcstatus(rs.getString(17));
				bList1.add(b);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return bList1;
	}
	// 내가 신청한 경기 정보를 list에 저장 하기(bList2)
	public LinkedList<Bean> inqPerAppMatListDao(Bean b){
		LinkedList<Bean> bList2 = new LinkedList<Bean>();
		String sql = "SELECT * FROM RA WHERE RQACID = ? AND RQASTATUS NOT IN ('D3','D4')";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());
			rs = pstmt.executeQuery();
			while(rs.next()){
				b = new Bean();
				b.setRqid(rs.getString(1));
				b.setMmid(rs.getString(2));
				b.setMmname(rs.getString(3));
				b.setDescription(rs.getString(3));
				b.setWrdate(rs.getString(5));
				b.setAcid(rs.getString(6));
				b.setAcdate(rs.getString(7));
				b.setNownum(rs.getString(8));
				b.setFixdate(rs.getString(9));
				b.setStcode(rs.getString(10));
				b.setStname(rs.getString(11));
				b.setStnumber(rs.getString(12));
				b.setLccode(rs.getString(13));
				b.setLcname(rs.getString(14));
				b.setStatus(rs.getString(15));
				b.setStatusname(rs.getString(16));
	            b.setAcstatus(rs.getString(17));
				bList2.add(b);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return bList2;
	}
	// 완료된 내가 생성한 경기 정보를 list에 저장 하기(bList3)
	public LinkedList<Bean> inqPerComCreMatListDao(Bean b){
		LinkedList<Bean> bList3 = new LinkedList<Bean>();
		String sql = "SELECT * FROM RA WHERE RQMMID = ? AND (STATUS = 'C2' OR STATUS = 'C3')";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());
			rs = pstmt.executeQuery();
			while(rs.next()){
				b = new Bean();
				b.setRqid(rs.getString(1));
				b.setMmid(rs.getString(2));
				b.setMmname(rs.getString(3));
				b.setDescription(rs.getString(3));
				b.setWrdate(rs.getString(5));
				b.setAcid(rs.getString(6));
				b.setAcdate(rs.getString(7));
				b.setNownum(rs.getString(8));
				b.setFixdate(rs.getString(9));
				b.setStcode(rs.getString(10));
				b.setStname(rs.getString(11));
				b.setStnumber(rs.getString(12));
				b.setLccode(rs.getString(13));
				b.setLcname(rs.getString(14));
				b.setStatus(rs.getString(15));
				b.setStatusname(rs.getString(16));
	            b.setAcstatus(rs.getString(17));
				bList3.add(b);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return bList3;
	}
	// 완료된 내가 신청한 경기 정보를 list에 저장 하기(bList4)
	public LinkedList<Bean> inqPerComAppMatListDao(Bean b){
		LinkedList<Bean> bList2 = new LinkedList<Bean>();
		String sql = "SELECT * FROM RA WHERE RQACID = ? AND (STATUS = 'C2' OR STATUS = 'C3' OR RQASTATUS = 'D3') AND RQASTATUS NOT IN ('D4')";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());
			rs = pstmt.executeQuery();
			while(rs.next()){
				b = new Bean();
				b.setRqid(rs.getString(1));
				b.setMmid(rs.getString(2));
				b.setMmname(rs.getString(3));
				b.setDescription(rs.getString(3));
				b.setWrdate(rs.getString(5));
				b.setAcid(rs.getString(6));
				b.setAcdate(rs.getString(7));
				b.setNownum(rs.getString(8));
				b.setFixdate(rs.getString(9));
				b.setStcode(rs.getString(10));
				b.setStname(rs.getString(11));
				b.setStnumber(rs.getString(12));
				b.setLccode(rs.getString(13));
				b.setLcname(rs.getString(14));
				b.setStatus(rs.getString(15));
				b.setStatusname(rs.getString(16));
	            b.setAcstatus(rs.getString(17));
				bList2.add(b);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return bList2;
	}
	// 확정된 내가 참가할 경기 정보를 list에 저장 하기(bList5)
	public LinkedList<Bean>inqFixMatchListDao(Bean b){
		LinkedList<Bean> bList2 = new LinkedList<Bean>();
		String sql = "SELECT * FROM RA WHERE (RQACID = ? OR RQMMID = ?) AND STATUS = 'C4'";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());
			pstmt.setString(2, b.getMmid());
			rs = pstmt.executeQuery();
			while(rs.next()){
				b = new Bean();
				b.setRqid(rs.getString(1));
				b.setMmid(rs.getString(2));
				b.setMmname(rs.getString(3));
				b.setDescription(rs.getString(3));
				b.setWrdate(rs.getString(5));
				b.setAcid(rs.getString(6));
				b.setAcdate(rs.getString(7));
				b.setNownum(rs.getString(8));
				b.setFixdate(rs.getString(9));
				b.setStcode(rs.getString(10));
				b.setStname(rs.getString(11));
				b.setStnumber(rs.getString(12));
				b.setLccode(rs.getString(13));
				b.setLcname(rs.getString(14));
				b.setStatus(rs.getString(15));
				b.setStatusname(rs.getString(16));
	            b.setAcstatus(rs.getString(17));		
				bList2.add(b);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return bList2;
	}
	// 경기 생성하기(insert)
	public boolean matchInsert(Bean b) {
		boolean result = false;
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO REQUEST (RQ_ID, RQ_MMID, RQ_DESCRIPTION, RQ_FIXDATE, RQ_LCCODE, RQ_STATUS, RQ_STCODE) "
					+ "VALUES (RQ_ID_SEQ.NEXTVAL, ?, ?, TO_DATE(?, 'YYYYMMDDHH24MISS'), ?, 'C1', ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());
			pstmt.setString(2, b.getDescription());
			pstmt.setString(3, b.getFixdate());
			pstmt.setString(4, b.getLccode());
			pstmt.setString(5, b.getStcode());

			result = convertToBoolean(pstmt.executeUpdate());	

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null){try{pstmt.close();}catch(Exception e){}}
		}		
		return result;
	}
	// 내가 생성한 경기 수정(update)
	public boolean matchCreateUpd(Bean b) {
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			String sql = "UPDATE RQ SET RQ_WRDATE = DEFAULT, RQ_DESCRIPTION = ?, RQ_FIXDATE = TO_DATE(?, 'YYYYMMDDHH24MISS'), RQ_LCCODE = ?, RQ_STCODE = ? WHERE RQ_ID = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getDescription());
			pstmt.setString(2, b.getFixdate());
			pstmt.setString(3, b.getLccode());
			pstmt.setString(4, b.getStcode());
			pstmt.setString(5, b.getRqid());
			System.out.println(b.getRqid() + " : rqid");
			result = convertToBoolean(pstmt.executeUpdate());

		}catch(Exception ex){
			ex.printStackTrace();
			result = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}		
		return result;
	}	
	// 내가 생성한 경기에 신청한 회원 정보를 list에 저장하기
	public LinkedList<Bean> inqPerMatAccInfDao(Bean b){
		LinkedList<Bean> bList = new LinkedList<Bean>();
		try {
			String sql = "SELECT * FROM MYINFO WHERE MMID = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getAcid());
			rs = pstmt.executeQuery();
			while(rs.next()){
				b = new Bean();
				b.setAcid(rs.getString(1));
				b.setMmname(rs.getString(2));
				b.setMmemail(rs.getString(3));
				b.setMmnumber(rs.getString(4));
				b.setLcname(rs.getString(5));
				bList.add(b);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}		
		return bList;
	}	
	// 내가 생성한 경기에 신청한 회원 전체 삭제(update)
	public boolean matchCreatedAppDel(Bean b) {
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			String sql = "UPDATE RQA SET RQA_STATUS = 'D6', RQA_ACDATE = SYSDATE WHERE RQA_RQID = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getRqid());
			System.out.println(b.getRqid() + " : Dao");
			result = convertToBoolean(pstmt.executeUpdate());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
		}		
		return result;
	}
	// 내가 생성한 경기 취소(update)
	public boolean requestDel(Bean b) {
		int resultSingle = 0;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			String sql = "UPDATE RQ SET RQ_STATUS = 'D3' WHERE RQ_ID = ? AND RQ_MMID = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getRqid());	
			pstmt.setString(2, b.getMmid());
			resultSingle = pstmt.executeUpdate();
			resultSingle = (resultSingle>=1)? 1: 0;
			result = convertToBoolean(resultSingle);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
		}		
		return result;
	}
	// 신청할 경기 정보를 list에 저장 하기
	public LinkedList<Bean> inqMatInfDao(Bean b){
		LinkedList<Bean> bList = new LinkedList<Bean>();
		String sql = "SELECT * FROM RA WHERE RQID = ?";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getRqid());	
			rs = pstmt.executeQuery();

			while(rs.next()){
				b = new Bean();
				b.setRqid(rs.getString(1));
				b.setMmid(rs.getString(2));
				b.setMmname(rs.getString(3));
				b.setDescription(rs.getString(3));
				b.setWrdate(rs.getString(5));
				b.setAcid(rs.getString(6));
				b.setAcdate(rs.getString(7));
				b.setNownum(rs.getString(8));
				b.setFixdate(rs.getString(9));
				b.setStcode(rs.getString(10));
				b.setStname(rs.getString(11));
				b.setStnumber(rs.getString(12));
				b.setLccode(rs.getString(13));
				b.setLcname(rs.getString(14));
				b.setStatus(rs.getString(15));
				b.setStatusname(rs.getString(16));
	            b.setAcstatus(rs.getString(17));
	            b.setMmemail(rs.getString(18));
	            b.setMmnumber(rs.getString(19));
				bList.add(b);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return bList;
	}
	// 생성된 경기에 신청(insert)
	public boolean matchAccept(Bean b) {
		boolean result = false;
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO RQA (RQA_RQID, RQA_ACID, RQA_ACDATE) VALUES (?, ?, SYSDATE)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getRqid());
			pstmt.setString(2, b.getMmid());

			result = convertToBoolean(pstmt.executeUpdate());	

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null){try{pstmt.close();}catch(Exception e){}}
		}		
		return result;
	}
	// 경기를 생성한 회원과 신청한 회원이 동일한지 비교(select)/같으면 true 리턴
	public boolean matchAcceptSame(Bean b) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			String sql = "SELECT COUNT(*) AS CNT FROM RA WHERE RQMMID = ? AND RQID = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMmid());
			pstmt.setString(2, b.getRqid());

			rs = pstmt.executeQuery();

			while(rs.next()){
				result = convertToBoolean(rs.getInt(1));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return result;
	}
	// 생성된 경기에 신청하면 RQ 테이블에 신청인원이 추가(update)
	public boolean matchAcceptNumInsert(Bean b) {
		PreparedStatement pstmt = null;
		boolean result = false;	

		try {
			String sql = "UPDATE RQ SET RQ_NOWNUM = RQ_NOWNUM + 1 WHERE RQ_ID = ?";
			/*경기 수락을 하면 1씩 증가시키는 SQL*/
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getRqid());

			result = convertToBoolean(pstmt.executeUpdate());

		}catch(Exception ex){
			ex.printStackTrace();
			result = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}		
		return result;
	}
	// 신청한 경기를 취소(update)
	public boolean matAppDel(Bean b) {
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			String sql = "UPDATE RQA SET RQA_STATUS = 'D3' WHERE RQA_RQID = ? AND RQA_ACID = ?";
			pstmt = connection.prepareStatement(sql);
			System.out.println(b.getRqid() + ": rqid");
			System.out.println(b.getMmid() + ": mmid");
			pstmt.setString(1, b.getRqid());	
			pstmt.setString(2, b.getMmid());

			result = convertToBoolean(pstmt.executeUpdate());

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
		}		
		return result;
	}
	// 신청 취소 하면 인원이 1씩 감소(update)
	public boolean matchAcceptNumDelete(Bean b) {
		PreparedStatement pstmt = null;
		boolean result = false;	

		try {
			String sql = "UPDATE RQ SET RQ_NOWNUM = RQ_NOWNUM - 1 WHERE RQ_ID = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getRqid());

			result = convertToBoolean(pstmt.executeUpdate());

		}catch(Exception ex){
			ex.printStackTrace();
			result = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}		
		return result;
	}
	// 내가 생성한 경기에 신청한 사람을 거절(update)
	public boolean matchRejectApplierDao(Bean b) {
		PreparedStatement pstmt = null;
		boolean result = false;	

		try {
			String sql = "UPDATE RQA SET RQA_STATUS = 'D2' WHERE RQA_ACID = ? AND RQA_RQID = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getAcid());
			pstmt.setString(2, b.getRqid());

			result = convertToBoolean(pstmt.executeUpdate());

		}catch(Exception ex){
			ex.printStackTrace();
			result = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}		
		return result;
	}
	// 내가 생성한 경기에 신청한 사람을 수락(update)
	public boolean matchApplierFixDao(Bean b) {
		PreparedStatement pstmt = null;
		boolean result = false;	

		try {
			System.out.println(b.getAcid() + " : acid 수락 시도");
			String sql = "UPDATE RQA SET RQA_STATUS = 'D1' WHERE RQA_ACID = ? AND RQA_RQID = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getAcid());
			pstmt.setString(2, b.getRqid());

			result = convertToBoolean(pstmt.executeUpdate());

		}catch(Exception ex){
			System.out.println(b.getAcid() + " : acid 수락 dao 실패");
			ex.printStackTrace();
			result = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}		
		return result;
	}
	// 내가 생성한 경기에 신청한 사람들의 정보를 list에 저장 하기
	public LinkedList<Bean> inqMatchApplierInfoDao(Bean b) {
		LinkedList<Bean> bList2 = new LinkedList<Bean>();
		try {
			String sql = "SELECT * FROM RQAINFO WHERE RQID = ? AND RQASTATUS = 'D1'";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getRqid());
			rs = pstmt.executeQuery();
			while(rs.next()){
				b = new Bean();
				b.setRqid(rs.getString(1));
				b.setAcid(rs.getString(2));
				b.setMmname(rs.getString(3));
				b.setMmnumber(rs.getString(4));
				b.setMmemail(rs.getString(5));
				b.setLcname(rs.getString(6));
				b.setStatus(rs.getString(7));
				b.setStatusname(rs.getString(8));
				bList2.add(b);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}		
		return bList2;
	}
	// 경기 확정(update)
	public boolean matchFixDao(Bean b) {
		PreparedStatement pstmt = null;
		boolean result = false;	

		try {
			String sql = "UPDATE RQ SET RQ_STATUS = 'C4' WHERE RQ_ID = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getRqid());

			result = convertToBoolean(pstmt.executeUpdate());

		}catch(Exception ex){
			ex.printStackTrace();
			result = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}		
		return result;
	}
	// 경기 완료(update)
		public boolean matchEndDao(Bean b) {
			PreparedStatement pstmt = null;
			boolean result = false;	

			try {
				String sql = "UPDATE RQ SET RQ_STATUS = 'C2' WHERE RQ_ID = ?";
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, b.getRqid());

				result = convertToBoolean(pstmt.executeUpdate());

			}catch(Exception ex){
				ex.printStackTrace();
				result = false;
			}finally{
				if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
			}		
			return result;
		}
	// 완료된 내가 생성한 매치 삭제(update)
	public boolean matComCreDelDao(Bean b) {
		PreparedStatement pstmt = null;
		boolean result = false;	

		try {
			String sql = "UPDATE RQ SET RQ_STATUS = 'C5' WHERE RQ_ID = ? AND RQ_MMID = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getRqid());
			pstmt.setString(2, b.getMmid());
			result = convertToBoolean(pstmt.executeUpdate());

		}catch(Exception ex){
			ex.printStackTrace();
			result = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}		
		return result;
	}
	// 완료된 내가 신청한 매치 삭제(update)
	public boolean matComAppDelDao(Bean b) {
		PreparedStatement pstmt = null;
		boolean result = false;	

		try {
			String sql = "UPDATE RQA SET RQA_STATUS = 'D4' WHERE RQA_ACID = ? AND RQA_RQID = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getAcid());
			pstmt.setString(2, b.getRqid());

			result = convertToBoolean(pstmt.executeUpdate());

		}catch(Exception ex){
			ex.printStackTrace();
			result = false;
		}finally{
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}		
		return result;
	}
	
	public LinkedList<Bean> searchMatchDao(Bean b, String keyword){
	      LinkedList<Bean> bList = new LinkedList<Bean>();
	      try {

	         String sql = "SELECT * FROM RA WHERE " + keyword + " LIKE '%' || ? || '%'";

	         pstmt = connection.prepareStatement(sql);
	         pstmt.setString(1, b.getDescription());
	         rs = pstmt.executeQuery();
	         while(rs.next()){
	            b = new Bean();
	            b.setRqid(rs.getString(1));
	            b.setMmid(rs.getString(2));
	            b.setMmname(rs.getString(3));
	            b.setDescription(rs.getString(3));
	            b.setWrdate(rs.getString(5));
	            b.setAcid(rs.getString(6));
	            b.setAcdate(rs.getString(7));
	            b.setNownum(rs.getString(8));
	            b.setFixdate(rs.getString(9));
	            b.setStcode(rs.getString(10));
	            b.setStname(rs.getString(11));
	            b.setStnumber(rs.getString(12));
	            b.setLccode(rs.getString(13));
	            b.setLcname(rs.getString(14));
	            b.setStatus(rs.getString(15));
	            b.setStatusname(rs.getString(16));
	            b.setAcstatus(rs.getString(17));
	            bList.add(b);
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         if(rs != null){try{rs.close();}catch(Exception ex){}}
	         if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
	      }      
	      return bList;
	   }

// 이상 경기 매칭 관련 dao

	// 관리자 경기 전체 조건별 조회
	public LinkedList<Bean> adminInqTotalMacthDao(Bean b, String type, String keyword, String updown){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<Bean> bList = new LinkedList<Bean>();

		try{
			String sql = "SELECT * FROM RA";
			switch(type){
			case "0":
				sql += "";
				break;
				
			case "1":
				sql += " WHERE RQMMID LIKE '%' || ? || '%' ORDER BY " + keyword + " "+ updown;
				break;
				
			case "2" :
				sql += " WHERE RQACID LIKE '%' || ? || '%' ORDER BY " + keyword + " "+ updown;
				break;
				
			case "3" :
				sql += " WHERE STNAME LIKE '%' || ? || '%' ORDER BY " + keyword + " "+ updown;
				break;
							
			case "4" :
				sql += " WHERE LCNAME LIKE '%' || ? || '%' ORDER BY " + keyword + " "+ updown;
				break;
				
			case "5" :
				sql += " WHERE STATUS LIKE '%' || ? || '%' ORDER BY " + keyword + " "+ updown;
				break;
			}
			System.out.println(sql + "  :  sql 확인");
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, b.getMetitle());

			rs = pstmt.executeQuery();

			while(rs.next()){
				b = new Bean();
				b.setRqid(rs.getString(1));
				b.setMmid(rs.getString(2));
				b.setMmname(rs.getString(3));
				b.setDescription(rs.getString(4));
				b.setWrdate(rs.getString(5));
				b.setAcid(rs.getString(6));
				b.setAcdate(rs.getString(7));
				b.setNownum(rs.getString(8));
				b.setFixdate(rs.getString(9));
				b.setStcode(rs.getString(10));
				b.setStname(rs.getString(11));
				b.setStnumber(rs.getString(12));
				b.setLccode(rs.getString(13));
				b.setLcname(rs.getString(14));
				b.setStatus(rs.getString(15));
				b.setStatusname(rs.getString(16));
				b.setAcstatus(rs.getString(17));
				b.setMmemail(rs.getString(18));
				b.setMmnumber(rs.getString(19));
				bList.add(b);
			}			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return bList;
	}
	// 관리자가 경기 신청한 사람 조회하는 Dao
	public LinkedList<Bean> admininqCreMatAccepterDao(String rqid) {
		LinkedList<Bean> bList1 = new LinkedList<Bean>();
		String sql = "SELECT * FROM RA WHERE RQID = ?";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, rqid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Bean b = new Bean();
				b.setRqid(rs.getString(1));
				b.setAcid(rs.getString(6));
				b.setAcstatus(rs.getString(17));
				bList1.add(b);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){try{rs.close();}catch(Exception ex){}}
			if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
		}
		return bList1;
	}
	// 관리자 회원 전체 조회
	public LinkedList<Bean> memberTotalList(){
	      Bean b;
	      LinkedList<Bean> adminList = new LinkedList<Bean>();
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      /*1. Create Query*/      
	      String sql = "SELECT * FROM MYINFO";

	      try{
	         pstmt = connection.prepareStatement(sql);

	         rs = pstmt.executeQuery();

	         while(rs.next()){
	            b = new Bean();
	            b.setMmid(rs.getNString(1));
	            b.setMmname(rs.getNString(2));
	            b.setMmemail(rs.getNString(3));
	            b.setMmnumber(rs.getNString(4));
	            b.setLcname(rs.getNString(5));
	            adminList.add(b);
	         }
	      }
	      catch(Exception ex){
	         System.out.println("회원정보를 못가져왔습니다.");
	      }
	      finally{
	         if(rs != null){try{rs.close();}catch(Exception ex){}}
	         if(pstmt != null){try{pstmt.close();}catch(Exception ex){}}
	      }
	      return  adminList;
	   }
}
