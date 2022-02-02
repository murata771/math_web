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

import bo.Login2Logic;
import entity.Errormessage;
import entity.Login;

/**
 * Servlet implementation class Login2Servlet
 */
@WebServlet("/Login2Servlet")
public class Login2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*HttpSession session=request.getSession();
		Errormessage ermesse=new Errormessage();
		ermesse.setErrormessage("登録した物と一致しません");
		ermesse.setErrorflag(1);
		session.setAttribute("errormessage",ermesse);
		RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Login2.jsp");
		dispach.forward(request,response);*/
		//上のプログラムは遷移のみのプログラム
		HttpSession session=request.getSession();
		ServletContext app=this.getServletContext();
		
		Errormessage ermesse=(Errormessage)session.getAttribute("ermesse");
		Integer logincounter=(Integer)app.getAttribute("logincounter");

	
			ermesse.setErrorflag(1);
			ermesse.setErrormessage("登録した物と一致しません。");
			logincounter++;
			session.setAttribute("ermesse", ermesse);
			app.setAttribute("logincounter", logincounter);
			RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Login2.jsp");
			dispach.forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*HttpSession session=request.getSession();
		Errormessage ermesse=new Errormessage();
		ermesse.setErrorflag(0);
		session.setAttribute("errormessage",ermesse);
		RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/LoginOK.jsp");
		dispach.forward(request,response);*/
		//上のプログラムは遷移のみの時
		request.setCharacterEncoding("UTF-8");
		String likething=request.getParameter("likething");
		String deliteno=request.getParameter("deliteno");
		HttpSession session=request.getSession();
		ServletContext app=this.getServletContext();
		Errormessage ermesse=(Errormessage)session.getAttribute("ermesse");
		Integer logincounter=(Integer)app.getAttribute("logincounter");
		Login login=new Login(likething);
		//User user=null;
		Login2Logic loginlogic2=new Login2Logic();
		if(logincounter==4) 
		{
			RequestDispatcher dispach=request.getRequestDispatcher("/LoginError");
			dispach.forward(request,response);
		}
		boolean loginkahi=loginlogic2.execute(login);
		if(logincounter>=3){
			RequestDispatcher dispach=request.getRequestDispatcher("/LoginError");
			dispach.forward(request,response);
		}
		else if((loginkahi )|| (deliteno.equals("back")))
		{
			ermesse.setErrorflag(0);
			session.setAttribute("ermesse", ermesse);
			session.setAttribute("likething", login);
			RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/LoginOK.jsp");
			dispach.forward(request,response);
		}

			else{
			
				
			
			ermesse.setErrorflag(1);
			session.setAttribute("ermesse", ermesse);
			
		response.sendRedirect("/math_web/Login2Servlet");
		}
	}

}
