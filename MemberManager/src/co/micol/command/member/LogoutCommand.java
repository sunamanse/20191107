package co.micol.command.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;

public class LogoutCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession httpsession = request.getSession();

		String id = (String) httpsession.getAttribute("id");
		request.setAttribute("id", id);

		if (httpsession != null) {
			httpsession.removeAttribute("id");
			httpsession.removeAttribute("pw");
		}

		String path = "view/logOut.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
