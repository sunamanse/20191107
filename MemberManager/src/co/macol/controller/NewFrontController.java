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
import co.micol.command.board.BoardEditCommand;
import co.micol.command.board.BoardEditOkCommand;
import co.micol.command.board.BoardListCommand;
import co.micol.command.board.BoardReadCommand;
import co.micol.command.board.BoardWriteCommand;
import co.micol.command.board.BoardWriteOkCommand;
import co.micol.command.member.IdCheckCommand;
import co.micol.command.member.JoinFormCommand;
import co.micol.command.member.JoinOkCommand;
import co.micol.command.member.LoginCommand;
import co.micol.command.member.LoginOkCommand;
import co.micol.command.member.LogoutCommand;
import co.micol.command.member.MemberUpdateCommand;
import co.micol.command.member.MemberinfoCommand;
import co.micol.command.member.MemberlistCommand;
import co.micol.command.member.updateOkCommand;
import co.micol.command.notice.NoticelistCommand;
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
		cont.put("/login.do", new LoginCommand());	//로그인폼 호출
		cont.put("/loginOk.do", new LoginOkCommand());	//로그인 성공페이지
		cont.put("/logout.do", new LogoutCommand());	//로그아웃
		cont.put("/joinForm.do", new JoinFormCommand());	//회원가입폼
		cont.put("/idCheck.do", new IdCheckCommand());	//아이디중복체크
		cont.put("/joinOk.do", new JoinOkCommand());	//회원가입성공
		cont.put("/memberinfo.do", new MemberinfoCommand());	//개인정보
		cont.put("/memberlist.do", new MemberlistCommand());	//회원정보
		cont.put("/noticelist.do", new NoticelistCommand());	//공지사항목록
		cont.put("/memberUpdate.do", new MemberUpdateCommand());	//개인정보 수정
		cont.put("/updateOk.do", new updateOkCommand());	//개인정보 수정완료
		cont.put("/boardList.do", new BoardListCommand());	//자유게시판 목록
		cont.put("/boardWrite.do", new BoardWriteCommand());	//자게 글쓰기
		cont.put("/boardRead.do", new BoardReadCommand());	//자게 한건조회
		cont.put("/boardEdit.do", new BoardEditCommand());	//자게 수정
//		cont.put("/boardDelete.do", new BoardDeleteCommand());	//자게 삭제
		cont.put("/boardWriteOk.do", new BoardWriteOkCommand());	//글쓰지 완료
		cont.put("/boardEditOk.do", new BoardEditOkCommand());
		
		
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
