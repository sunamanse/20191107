/**
 * 
 */
package co.micol.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.macol.dto.MemberDto;

/**
 * @author User 상위 DAO클래스 상속받아 memberDao생성
 */
public class MemberDao extends DAO {
	private MemberDto dto;
	private ArrayList<MemberDto> list;

	public MemberDao() {
		super();
	}

	// 회원 전체조회
	public ArrayList<MemberDto> select() {
		list = new ArrayList<MemberDto>();
		String sql = "select * from member";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getString("mem_id"));
				dto.setName(rs.getString("mem_name"));
				dto.setPw(rs.getString("mem_pw"));
				dto.seteDate(rs.getDate("ENTER_DATE"));
				dto.setAddr(rs.getString("mem_addr"));
				dto.setTel(rs.getString("mem_tel"));
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		close();
		return list;
	}

	// 한건조회
	public MemberDto select(String id) {
		dto = new MemberDto();
		String sql = "select * from member where mem_id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {		
				dto.setId(rs.getString("mem_id"));
				dto.setName(rs.getString("mem_name"));
				dto.setPw(rs.getString("mem_pw"));
				dto.seteDate(rs.getDate("ENTER_DATE"));
				dto.setAddr(rs.getString("mem_addr"));
				dto.setTel(rs.getString("mem_tel"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		close();
		return dto;
	}

	//
	public int insert(MemberDto dto) {
		int n = 0;
		int cnt = 0;
		String sql = "insert into member (MEM_ID,MEM_NAME,MEM_PW,MEM_ADDR,MEM_TEL)" + "values(?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(cnt++, dto.getId());
			pstmt.setString(cnt++, dto.getName());
			pstmt.setString(cnt++, dto.getPw());
			pstmt.setString(cnt++, dto.getAddr());
			pstmt.setString(cnt++, dto.getTel());

			n = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;

	}

	//
	public int update(MemberDto dto) {
		int n = 0;
		int cnt = 0;
		String sql = "UPDATE member set MEM_NAME =?,mem_pw =?',mem_addr=?, mem_tel=?" + "where mem_id =?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(cnt++, dto.getName());
			pstmt.setString(cnt++, dto.getPw());
			pstmt.setString(cnt++, dto.getAddr());
			pstmt.setString(cnt++, dto.getTel());
			pstmt.setString(cnt++, dto.getId());

			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		close();
		return n;

	}

	//
	public int delete(String id) {
		int n = 0;

		close();
		return n;

	}

	// id중복체크
	public boolean isIdCheck(String id) {
		String sql = "select MEM_ID from member where MEM_ID=?";
		boolean a = true;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("MEM_ID").equals(id)) {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

	// 로그인
	public String loginCheck(String id, String pw) {
		String grant = null;
		String sql = "select MEM_GRANT from member where MEM_ID=? and MEM_PW=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				grant = rs.getString("MEM_GRANT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		close();
		return grant; // 성공하면 권한 넘겨줌
	}

}
