package edu.kh.jdbc.member.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.jdbc.member.vo.Member;

public class MemberDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public MemberDAO() {
		
		try {
			prop = new Properties(); // Properties 객체 생성 
			
			prop.loadFromXML(new FileInputStream("member-query.xml"));
			// main-query.xml 파일의 내용을 읽어와 Properties 객체에 저장
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

	public Member selectMyInfo(Connection conn, String memberId, String memberPw) throws Exception {
		
		Member loginMember = null;
		
		try {
			// SQL 얻어오기 member-query
			String sql = prop.getProperty("selectMyInfo");
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// ? 알맞은 값 대입
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			//  SQL(SELECT) 수행 결과(ResultSet) 반환 받기
						rs = pstmt.executeQuery();
						
			//  조회 결과가 있을 경우
			//		컬럼값을 모두 얻어와
			//		Member 객체를 생성해서 loginMember 대입
						
			if(rs.next()) {
							
				loginMember = new Member(rs.getInt("MEMBER_NO"), 
										memberId,
										rs.getString("MEMBER_NM"),
										rs.getString("MEMBER_GENDER"),
										rs.getString("ENROLL_DATE") );
				
			}
						
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		return loginMember;
	}


	public Member updateMember(Connection conn, String memberId, String memberPw) throws Exception {
		
		Member loginMember = null;
		
		try {
			// SQL 얻어오기 member-query
			String sql = prop.getProperty("updateMember");
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// ? 알맞은 값 대입
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			//  SQL(SELECT) 수행 결과(ResultSet) 반환 받기
						rs = pstmt.executeQuery();
						
			//  조회 결과가 있을 경우
			//		컬럼값을 모두 얻어와
			//		Member 객체를 생성해서 loginMember 대입
						
			if(rs.next()) {
							
				loginMember = new Member(rs.getInt("MEMBER_NO"), 
										memberId,
										rs.getString("MEMBER_NM"),
										rs.getString("MEMBER_GENDER"),
										rs.getString("ENROLL_DATE") );
				
			}
						
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		return loginMember;
	}



}
