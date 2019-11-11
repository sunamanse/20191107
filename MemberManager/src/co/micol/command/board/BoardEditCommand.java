package co.micol.command.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.macol.dto.BoardDto;
import co.micol.common.Command;
import co.micol.dao.BoardDao;

public class BoardEditCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto();

		int id = dto.getId(); //해당글의 getID

		dto = dao.select(id);
		request.setAttribute("id", dto.getId());
		request.setAttribute("dto", dto);
		String path = "view/boardEdit.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
