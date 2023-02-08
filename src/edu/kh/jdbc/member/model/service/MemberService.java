package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.vo.Member;

public class MemberService {
	private MemberDAO dao = new MemberDAO();
	
	public Member selectMyInfo(String memberId, String memberPw) throws Exception {
		
		// 1. 컨넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출 후 결과 반환 받기
		Member loginMember = dao.selectMyInfo(conn, memberId, memberPw);
		
		
		// 3. 컨넥션 반환 
		close(conn);
		
		// 4. 조회 결과 반환 
		return loginMember;
		
		
		
	}
	
	public Member updateMember(String memberId, String memberPw) throws Exception {
		
		// 1. 컨넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출 후 결과 반환 받기
		Member loginMember = dao. updateMember(conn, memberId, memberPw);
		
		
		// 3. 컨넥션 반환 
		close(conn);
		
		// 4. 조회 결과 반환 
		return loginMember;
		
		
		
	}
	
	
	
	
	
	

}
