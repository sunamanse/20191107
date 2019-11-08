package co.micol.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.macol.dto.NoticeDto;

public class NoticeDao extends DAO {
	ArrayList<NoticeDto> list;
	NoticeDto dto;

	public NoticeDao() {
		super();
	}

	// 전체리스트 가져오기 or 한개(+댓글)
	public ArrayList<NoticeDto> select() { // id =0 ->전체/아이디 값 ->해당아이디+댓글
		list = new ArrayList<NoticeDto>();
		String sql = "select * from notice "; // 0아니면 전체

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new NoticeDto();
				dto.setnId(rs.getInt("n_id"));
				dto.setnTitle(rs.getString("n_title"));
				dto.setnCon(rs.getString("n_content"));
				dto.setnDate(rs.getDate("n_date"));
				dto.setnHit(rs.getInt("n_hit"));
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 한건조회
	public NoticeDto select(int id) {

		return dto;

	}

	public int insert(NoticeDto dto) {
		int n = 0;

		return n;
	}

	public int UPDATE(NoticeDto dto) {
		int n = 0;

		return n;
	}

	// 원글삭제 or 댓글삭제
	public int delete(int id) {
		int n = 0;

		return n;
	}
}
