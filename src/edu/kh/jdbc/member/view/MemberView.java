package edu.kh.jdbc.member.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.member.vo.Member;

public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	
	// 로그인 회원 정보 저장용 변수
	private Member loginMember = null;
	

	public void memberMenu(Member loginMember) {
		
		// 전달 받은 로그인 회원 정보를 필드에 저장
		this.loginMember = loginMember;
		
		int input = -1;
			
			do {
			
		
				try {
				
					if(loginMember != null) { //if문 안에 로그인이 되었을때로 변경 예정
					
						System.out.println("\n*********** 회원기능 **********\n");
						System.out.println("1. 내정보조회");
						System.out.println("2. 회원 목록 조회");
						System.out.println("3. 내 정보 수정");
						System.out.println("4. 비밀번호 변경");
						System.out.println("5. 회원 탈퇴");
					
						System.out.print("\n메뉴 선택: ");
					
						input = sc.nextInt();
						sc.nextLine();
						System.out.println();
					
						switch(input){
					
						case 1: selectMyInfo(); break; // 내 정보 조회
						case 2: selectAll(); break;  // 회원 목록 조회
						case 3: updateMember(); break;// 내 정보 수정 
						case 4: updatePw(); break; // 비밀번호 변경
						case 5: secession(); break; // 회원 탈퇴
						default: 
							System.out.println("메뉴에 작성된 번호만 입력해주세용");
						
					}	
					
				} /*else {
					System.out.println("로그인을 하신 후 이용해주시기 바랍니다.");
					
				}*/
				
				
			} catch(InputMismatchException e) {
				System.out.println("\n <<입력 형식이 올바르지 않습니다.>>");
				sc.nextLine(); // 입력 버퍼에 남아있는 잘못된 문자열 제거
				
			}
			
		}while(input !=0);
			
		
	}
	
	/**
	 *  내 정보조회 화면
	 */
	private void selectMyInfo() {
		
		try {
			
			System.out.println("<<내 정보 조회>> ");
			System.out.println("아이디: " +loginMember.getMemberId() );
			System.out.println("이름: " + loginMember.getMemberName() );
			System.out.println("성별: " + loginMember.getMemberGender() );


		}catch(Exception e) {
			System.out.println("<<정보조회 중 예외 발생>>");
		}
		
	 
		
	}

	/**
	 * 회원 목록 조회 화면
	 */
	private void selectAll() {
		
		try {
			
			System.out.println("<<회원 목록 조회>>");
		


		}catch(Exception e) {
			System.out.println("<<정보조회 중 예외 발생>>");
		}
		
		
		
	}
	
	/**
	 *  내 정보 수정 화면
	 */
	private void  updateMember() {

		try {
			
			System.out.println("<내 정보 수정 >>");
		


		}catch(Exception e) {
			System.out.println("<<정보조회 중 예외 발생>>");
		}
		
	}
	
	/**
	 *  비밀번호 변경 화면 
	 */
	private void  updatePw() {
		System.out.println("비밀번호 변경창이 나와야함");
		
	}
	
	/**
	 *  회원탈퇴 화면
	 */
	private void  secession() {
		System.out.println("회원탈퇴가 되어야함");
		
	
	
	}
	
}
