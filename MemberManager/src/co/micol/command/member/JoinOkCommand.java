package co.micol.command.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.macol.dto.MemberDto;
import co.micol.common.Command;
import co.micol.dao.MemberDao;

public class JoinOkCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();

		dto.setId(request.getParameter("id"));
		dto.setName(request.getParameter("name"));
		dto.setPw(request.getParameter("pw"));
		dto.setAddr(request.getParameter("addr"));
		dto.setTel(request.getParameter("tel"));

		int n = dao.insert(dto);

		String path = "view/joinOk.jsp";
		request.setAttribute("pass", n);
		request.setAttribute("id", dto.getId());
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
