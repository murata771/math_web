package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.Registcnt;
import bo.RegisterLogic;
import entity.Errormessage;
import entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String noerror=request.getParameter("noerror");
		HttpSession session=request.getSession();
		ServletContext app=this.getServletContext();
		Errormessage ermese=(Errormessage)session.getAttribute("ermesse");
		Integer registcounter=(Integer)app.getAttribute("registcounter");
		if(ermese==null) {
			ermese=new Errormessage();
			ermese.setErrorflag(0);
			session.setAttribute("ermesse", ermese);
		}
		if(noerror!=null) {
		if(noerror.equals("no")) {//入力不正を一度おこなってしまったあと、(user登録)のflag=1のままになるのを回避する
			ermese.setErrorflag(0);
			session.setAttribute("ermesse", ermese);
		}
		}
		
		Registcnt cnt=new Registcnt();
		boolean cntTF=cnt.count(registcounter);
		if(cntTF) {
		RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Registerbegin.jsp");
		dispach.forward(request,response);
		}
		else {
		RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Registcant.jsp");
		dispach.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		ServletContext app=this.getServletContext();
		Integer registcounter=(Integer)app.getAttribute("registcounter");
		Errormessage ermese=(Errormessage)session.getAttribute("ermesse");
		if(ermese==null) {
			ermese=new Errormessage();
		}
		User user=(User)session.getAttribute("userInfo");
		if(user==null) {//この時点で失敗画面へ
			RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Registerfail.jsp");
			dispach.forward(request,response);
		}
		RegisterLogic register=new RegisterLogic();
		boolean regisTF=register.regis(user);
		if(regisTF) {//このままだと初めて来たユーザのみが1アカウントだけ登録できる状況に。
			registcounter=1;
			app.setAttribute("registcounter", registcounter);
		RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Registersuc.jsp");
		dispach.forward(request,response);
		}
		else {RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Registerfail.jsp");
		dispach.forward(request,response);
		}
	}

}
