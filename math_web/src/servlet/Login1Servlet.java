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

import bo.Login1Logic;
import entity.Errormessage;
import entity.Login;

/**
 * Servlet implementation class Login1Servlet
 */
@WebServlet("/Login1Servlet")
public class Login1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		ServletContext app=this.getServletContext();
		request.setCharacterEncoding("UTF-8");
		String back =request.getParameter("hoge");
		
		Errormessage ermesse=(Errormessage)session.getAttribute("ermesse");
		Integer logincounter=(Integer)app.getAttribute("logincounter");
		//System.out.println(back);
		//System.out.println(logincounter+"kaime");
		//System.out.println(ermesse==null);
		if(ermesse==null)
		{
			 ermesse=new Errormessage();
			 ermesse.setErrorflag(0);
			 session.setAttribute("ermesse", ermesse);
				//System.out.println(ermesse.getErrorflag()+"errorflag");
		}
		if(ermesse.getErrorflag()==0) {
			session.setAttribute("ermesse", ermesse);
			app.setAttribute("logincounter", logincounter);
			RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Login1.jsp");
			dispach.forward(request,response);
		}
		else {//
			
			ermesse.setErrorflag(1);
			ermesse.setErrormessage("ニックネームまたはパスワードが違います");
			logincounter++;
			session.setAttribute("ermesse", ermesse);
			app.setAttribute("logincounter", logincounter);
			if(back!=null) {
			if(back.equals("back")) {
				//System.out.println("back==");
				logincounter--;
				ermesse.setErrorflag(0);
				ermesse.setErrormessage("");
				session.setAttribute("ermesse", ermesse);
				app.setAttribute("logincounter", logincounter);
			}
			}
			RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Login1.jsp");
			dispach.forward(request,response);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=0;
		request.setCharacterEncoding("UTF-8");
		String nickname=request.getParameter("nickname");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		ServletContext app=this.getServletContext();
		Errormessage ermesse=(Errormessage)session.getAttribute("ermesse");
		Integer logincounter=(Integer)app.getAttribute("logincounter");
		//System.out.println(logincounter+"kaime_post");//zikken
		//System.out.println(ermesse.getErrorflag()+"post");//zikken
		//System.out.println(ermesse.getErrormessage()+"post");//zikken
		Login login=new Login(nickname,password);
		//User user=null;
		Login1Logic loginlogic1=new Login1Logic();
		if(logincounter==4) 
		{
			//System.out.println("4回目");

			RequestDispatcher dispach=request.getRequestDispatcher("/LoginError");//どうやらforwardできていないらしい
			dispach.forward(request,response);
		}
		boolean loginkahi=loginlogic1.execute(login);
		if(logincounter>=3){//試行錯誤により、doPost()からのforwardはdoPostにいく
			//System.out.println("3回目をコンソール画面に出力");
			
				RequestDispatcher dispach=request.getRequestDispatcher("/LoginError");
				dispach.forward(request,response);
		}
		else if(loginkahi)
		{
			ermesse.setErrorflag(0);
			session.setAttribute("ermesse", ermesse);
			session.setAttribute("nickname", login);
			RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Login2.jsp");
			dispach.forward(request,response);
		}
	
		else {
			 i++;
			//System.out.println(i+"回目_i");
			ermesse.setErrorflag(1);
			session.setAttribute("ermesse", ermesse);
			
		response.sendRedirect("/math_web/Login1Servlet");
		}

	}


}
