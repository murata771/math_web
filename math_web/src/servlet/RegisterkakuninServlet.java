package servlet;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.Entercheck;
import bo.Registcnt;
import entity.Errormessage;
import entity.User;

/**
 * Servlet implementation class RegisterkakuninServlet
 */
@WebServlet("/RegisterkakuninServlet")
public class RegisterkakuninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterkakuninServlet() {
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
		HttpSession session=request.getSession();
		ServletContext app=this.getServletContext();
		Errormessage ermese=(Errormessage)session.getAttribute("ermesse");
		if(ermese==null) {
			ermese=new Errormessage();
		}
		String nickname=request.getParameter("nickname");
		String password=request.getParameter("password");
		String likething=request.getParameter("likething");
		String grade=request.getParameter("grade");
		String agemozi=request.getParameter("age");//数字のみ入力できるようにEntercheckを調整
		int userid=new Random().nextInt(100000000);
		Integer userid2=Integer.valueOf(userid);
		String userID=Integer.toString(userid2);
		User user=new User();

		int age=0;//ageに一つでも数字以外の文字があれば、ageはuserにセットしない
		for(int i=0;i<agemozi.length();i++) {
		char mozi=agemozi.charAt(i);
		int j=i+1;
		if(!(Character.isDigit(mozi)))break;
		if(j==(agemozi.length())) { age=Integer.parseInt(agemozi);
		
		}
	}
		
		user.setAge(age);		
		user.setNickname(nickname);
		user.setPassword(password);
		user.setGrade(grade);
		user.setLikeThing(likething);
		user.setUserID(userID);
		user.setNowDate(LocalDate.now());
		//errorチェック
		Entercheck erch=new Entercheck();
		boolean enterTF=erch.checkchar(user);
		Registcnt cnt=new Registcnt();
		int regiscnt=cnt.count(user);
		if(regiscnt>5) {//その日の登録回数上限
			RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Registcant.jsp");
			dispach.forward(request,response);
		}
		if(enterTF) {
			session.setAttribute("userInfo", user);
			ermese.setErrorflag(0);
			session.setAttribute("ermesse", ermese);
		
		
		RequestDispatcher dispach=request.getRequestDispatcher("/WEB-INF/jsp/Registerkakunin.jsp");
		dispach.forward(request,response);
		}
		else {
			ermese.setErrorflag(1);
			ermese.setErrormessage("入力値が不正です");
			session.setAttribute("ermesse", ermese);
			response.sendRedirect("/math_web/RegisterServlet");
		}
	
	}

}
