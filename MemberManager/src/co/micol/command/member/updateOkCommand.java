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

public class updateOkCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession httpsession = request.getSession();
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();

		String id = (String)httpsession.getAttribute("id");
		
		dto.setName(request.getParameter("name"));
		dto.setPw(request.getParameter("pw"));
		dto.setAddr(request.getParameter("addr"));				
		dto.setTel(request.getParameter("tel"));
		dto.setId(id);

		int n = dao.update(dto);		
		
		//request.setAttribute("dto", dto);		
		String path = "null";

		if (n != 0) {
			path = "view/updateOk.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else {
			path = "view/updateFail.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}



	}

}
