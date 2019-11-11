/**
 * 
 */
package co.micol.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.macol.dto.BoardDto;

/**
 * @author User
 *
 */
public class BoardDao extends DAO {
	private BoardDto dto;
	private ArrayList<BoardDto> list;

	public BoardDao() {
		super(); // =엄마생성자 내가물려받겠다
	}

	public ArrayList<BoardDto> select() {
		list = new ArrayList<BoardDto>();
		String sql = "select * from mvc_board";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new BoardDto();
				dto.setId(rs.getInt("B_ID"));
				dto.setWriter(rs.getString("B_NAME"));
				dto.setTitle(rs.getString("B_TITLE"));
				dto.setContent(rs.getString("B_CONTENT"));
				dto.setWdate(rs.getDate("B_DATE"));
				dto.setHit(rs.getInt("B_HIT"));
				dto.setGroup(rs.getInt("B_GROUP"));
				dto.setStep(rs.getInt("B_STEP"));
				dto.setIndent(rs.getInt("B_INDENT"));
				dto.setUserID(rs.getString("USER_ID"));
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		close();
		return list;
	}

	// 전체리스트 가져오기 or 한개(+댓글)
	public BoardDto select(int id) { // id =0 ->전체/아이디 값 ->해당아이디+댓글
		BoardDto dto = new BoardDto();

		String sql = "select * from MVC_board where b_group=?"; // 0아니면 해당아이디

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new BoardDto();
				dto.setId(rs.getInt("B_ID"));
				dto.setWriter(rs.getString("B_NAME"));
				dto.setTitle(rs.getString("B_TITLE"));
				dto.setContent(rs.getString("B_CONTENT"));
				dto.setWdate(rs.getDate("B_DATE"));
				dto.setHit(rs.getInt("B_HIT"));
				dto.setGroup(rs.getInt("B_GROUP"));
				dto.setStep(rs.getInt("B_STEP"));
				dto.setIndent(rs.getInt("B_INDENT"));
				dto.setUserID(rs.getString("USER_ID"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		close();
		return dto;
	}

	public int insert(BoardDto dto) {
		int n = 0;
		int cnt = 1;
		String sql = "INSERT INTO mvc_board(B_ID, B_NAME, B_TITLE, B_CONTENT, B_DATE, B_GROUP, B_STEP, B_INDENT,USER_ID) "
				+ "VALUES(b_num.nextval, ?, ?, ?, ?, b_num.currval, 0, 0,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(cnt++, dto.getWriter());
			pstmt.setString(cnt++, dto.getTitle());
			pstmt.setString(cnt++, dto.getContent());
			pstmt.setDate(cnt++, dto.getWdate());
			pstmt.setString(cnt++, dto.getUserID());
			n = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();

		return n;
	}

	public int UPDATE(BoardDto dto) {
		int n = 0;

		return n;
	}

	// 원글삭제 or 댓글삭제
	public int delete(int id) {
		int n = 0;

		return n;
	}

}
