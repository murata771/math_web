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

import bo.UserLogic;
import entity.Login;
import entity.User;

/**
 * Servlet implementation class UserdeliteServlet
 */
@WebServlet("/UserdeliteServlet")
public class UserdeliteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserdeliteServlet() {
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
		Login login=(Login)session.getAttribute("nickname");
		String nickname="";
		if(login!=null) {
		 nickname=login.getNickname();
		}
		UserLogic userlo=new UserLogic();
		User user=userlo.userkensaku(nickname);
		if(user!=null) {
			session.setAttribute("userInfo", user);
		RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Userdelite.jsp");
		dispach.forward(request,response);
		}
		else {RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/LoginOK.jsp");
		dispach.forward(request,response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
