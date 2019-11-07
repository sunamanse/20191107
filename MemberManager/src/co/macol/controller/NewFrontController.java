package co.macol.controller;

import java.io.IOException;

import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.command.IndexCommand;
import co.micol.command.member.LoginCommand;
import co.micol.command.member.LoginOkCommand;
import co.micol.command.member.LogoutCommand;
import co.micol.common.Command;

@WebServlet("/NewFrontController")
public class NewFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> cont = new HashMap<String, Command>();

	public NewFrontController() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		// cont에 url과 실행 class를 정의하는 부분
		cont.put("/index.do", new IndexCommand()); // index.do로 들어오면 뒤에 클래스 실행시켜라
		cont.put("/login.do", new LoginCommand());
		cont.put("/loginOk.do", new LoginOkCommand());
		cont.put("/logout.do", new LogoutCommand());
//		cont.put("/index.do", new IndexCommand());
//		cont.put("/index.do", new IndexCommand());
//		cont.put("/index.do", new IndexCommand());
//		cont.put("/index.do", new IndexCommand());
//		cont.put("/index.do", new IndexCommand());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 실행할 class 객체 찾아주는 부분(get메소드 사용)
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length()); // uri에서 context만큼 잘라내고 다음꺼 실행

		Command commandImpl = cont.get(path); // 실행클래스 선택
		commandImpl.excute(request, response);
		
	}

}
