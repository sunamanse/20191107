package co.micol.command.board;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.macol.dto.BoardDto;
import co.micol.common.Command;
import co.micol.dao.BoardDao;

public class BoardWriteOkCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession httpsession = request.getSession();
		String userID = (String) httpsession.getAttribute("id");

		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto();

		dto.setWriter(request.getParameter("writer"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setWdate(Date.valueOf(request.getParameter("date")));
		dto.setUserID(userID); // 세션값 담기 기다료

		int n = dao.insert(dto);
		String path = "null";

		if (n != 0) {
			path = "boardList.do";
			response.sendRedirect(path);
		} else {
			path = "view/boardInsertFail.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);

		}

	}

}
