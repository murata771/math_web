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

import bo.UserdeliteLogic;
import entity.User;

/**
 * Servlet implementation class DeliteServlet
 */
@WebServlet("/DeliteServlet")
public class DeliteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				HttpSession session=request.getSession();
				ServletContext app=this.getServletContext();
				User user=(User)session.getAttribute("userInfo");
				UserdeliteLogic delite=new UserdeliteLogic();
				Integer logincnt=(Integer)app.getAttribute("logincounter");
				try {
				if(user!=null) {
				boolean deliteTF=delite.user1del(user);
				if(deliteTF) {
					logincnt=0;
					app.setAttribute("logincounter", logincnt);
		RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Delitesuc.jsp");
		dispach.forward(request,response);
				}
				else {
					app.setAttribute("logincounter", logincnt);
		RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Delitefail.jsp");
		dispach.forward(request,response);
				}
				}
				}
				catch(NullPointerException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					RequestDispatcher dispach=request.getRequestDispatcher("/LoginError");
					dispach.forward(request,response);
							}
				}
				
	}


