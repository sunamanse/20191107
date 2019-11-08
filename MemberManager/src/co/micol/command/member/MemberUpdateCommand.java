package co.micol.command.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.macol.dto.MemberDto;
import co.micol.common.Command;
import co.micol.dao.MemberDao;

public class MemberUpdateCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		HttpSession httpsession = request.getSession();
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();
		
		String id =(String)httpsession.getAttribute("id");
		dto = dao.select(id);
				
		request.setAttribute("dto", dto);
		String path = "view/memberUpdate.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
