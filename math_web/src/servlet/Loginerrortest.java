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

import entity.Errormessage;

/**
 * Servlet implementation class Loginerrortest
 */
@WebServlet("/Loginerrortest")
public class Loginerrortest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginerrortest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=0;
		if(i==1) {
		RequestDispatcher dispach=request.getRequestDispatcher("/LoginError");//どうやらforwardできていないらしい
		dispach.forward(request,response);
		System.out.println("forward失敗");
		}
		else {
			HttpSession session=request.getSession();
			ServletContext app=this.getServletContext();
			
			Errormessage ermesse=new Errormessage();
			Integer logincounter=(Integer)app.getAttribute("logincounter");

		
				ermesse.setErrorflag(1);
				ermesse.setErrormessage("登録した物と一致しません。");
				logincounter++;
				session.setAttribute("errormessage", ermesse);
				app.setAttribute("logincounter", logincounter);
			response.sendRedirect("/math_web/Login2Servlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
