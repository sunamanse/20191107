package co.micol.command.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.macol.dto.BoardDto;
import co.micol.common.Command;
import co.micol.dao.BoardDao;

public class BoardListCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();

		list = dao.select();

		request.setAttribute("list", list);

		String path = "view/boardList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
