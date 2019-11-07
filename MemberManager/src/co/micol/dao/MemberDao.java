/**
 * 
 */
package co.micol.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.macol.dto.MemberDto;

/**
 * @author User
 * 상위 DAO클래스 상속받아 memberDao생성
 */
public class MemberDao extends DAO {
	private MemberDto dto;
	private ArrayList<MemberDto> list;	
	
	public MemberDao() {
		super();
	}
	
	//회원 전체조회
	public ArrayList<MemberDto> select(){
		list = new ArrayList<MemberDto>();
		
		
		close();
		return list;
	}
	
	//한건조회
	public MemberDto select(String id) {
		dto = new MemberDto();
		
		close();
		return dto;
	}
	
	//
	public int insert(MemberDto dto) {
		int n=0;
		
		close();
		return n;
		
	}
	
	//
	public int update(MemberDto dto) {
		int n=0;
		
		close();
		return n;
		
	}
	
	//
	public int delete(String id) {
		int n=0;
		
		close();
		return n;
		
	}
	
	//id중복체크
	public boolean isIdCheck(String id) {
		return false;
	}
	
	//로그인
	public String  loginCheck(String id, String pw) {
		String grant = null;
		String sql ="select MEM_GRANT from member where MEM_ID=? and MEM_PW=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				grant = rs.getString("MEM_GRANT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return grant; //성공하면 권한 넘겨줌		
	}
	
	
}
