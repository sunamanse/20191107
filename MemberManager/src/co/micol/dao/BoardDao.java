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

	// 전체리스트 가져오기 or 한개(+댓글)
	public ArrayList<BoardDto> select(int id) { // id =0 ->전체/아이디 값 ->해당아이디+댓글
		list = new ArrayList<BoardDto>();
		String sql = "select * from board ";	//0아니면 전체
		if (id != 0)
			sql = sql + "where b_group=?";	//0아니면 해당아이디

		try {
			pstmt = conn.prepareStatement(sql);
			if(id !=0) {
				pstmt.setInt(1, id);
			}rs=pstmt.executeQuery();
		while(rs.next()) {
			dto=new BoardDto();
		}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int insert(BoardDto dto) {
		int n=0;
		
		return n;
	}
	
	public int UPDATE(BoardDto dto) {
		int n=0;
		
		return n;
	}
	
	//원글삭제 or 댓글삭제 
	public int delete(int id) {
		int n=0;
		
		return n;
	}
	
	
}
