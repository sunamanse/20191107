package co.micol.command.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.macol.dto.NoticeDto;
import co.micol.common.Command;
import co.micol.dao.NoticeDao;


public class NoticelistCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		NoticeDao dao = new NoticeDao();
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();
		list = dao.select();

		request.setAttribute("list", list);
		String path = "view/noticeList.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
