package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.UserDAO;
import entity.Login;
import entity.User;
class UserDAOTest {

	
	@Test  public	void useraccessSuccess() {//正常系_nickname
		UserDAO userlogin=new UserDAO();
		String nickname="minato";
		String password="YuNi";
		Login login=new Login(nickname,password);
		User user=userlogin.findsingleraw(login);
		if(user!=null) {
		assertEquals("minato",user.getNickname());
		assertEquals("YuNi",user.getPassword());
		}
		else {fail();
		}
		
	}
	@Test  public void useraccessFail() //異常系_niciname
	{
		UserDAO userlogin=new UserDAO();
		String nickname="minato";
		String password="YuNi1";
		Login login=new Login(nickname,password);
		User user=userlogin.findsingleraw(login);
		assertEquals(null,user);
		
	}
	@Test public void useraccessFail2() //異常系2_nullpointerについて_nickname検索
	{
		UserDAO userlogin=new UserDAO();
		String nickname="minato";
		String password="YuNi1";
		Login login=new Login(nickname,password);
		User user=userlogin.findsingleraw(login);
		try {
		     nickname=user.getNickname();//NullPointerExceptionが発生
		}
		catch(NullPointerException e) {
			return;
		}
		fail();
	}
	@Test  public	void useraccessSuccess2() {//正常系_likething
		UserDAO userlogin=new UserDAO();
		String like="apple";
	
		Login login=new Login();
		login.setLikeThing(like);
		login.setNickname("minato");
		login.setPassword("YuNi5511M");
		User user=userlogin.findsinglerawlikeThing(login);
		if(user!=null) {
		assertEquals("apple",user.getLikeThing());
		assertEquals("minato",user.getNickname());
		assertEquals("YuNi5511M",user.getPassword());
		}
		else {fail();
		}
		
	}
	@Test  public void useraccessFail3() //異常系_likething検索、likethingのみの検索
	{
		UserDAO userlogin=new UserDAO();
		String like="game1";
		
		Login login=new Login();
		login.setLikeThing(like);
		User user=userlogin.findsinglerawlikeThing(login);
		assertEquals(null,user);
		
	}
	@Test public void useraccessFail4() //異常系2_nullpointerについて_likething検索
	{
		UserDAO userlogin=new UserDAO();
	    String like="game1";
		
		Login login=new Login();
		login.setLikeThing(like);
		User user=userlogin.findsinglerawlikeThing(login);
		   try {  like=user.getLikeThing();//NullPointerExceptionが発生
		}
		catch(NullPointerException e) {
			return;
		}
		fail();
	}
}
