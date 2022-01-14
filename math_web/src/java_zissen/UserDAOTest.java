package java_zissen;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.UserDAO;
import entity.Login;
import entity.User;
class UserDAOTest {

	
	@Test  public	void useraccessSuccess() {//正常系
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
	@Test  public void useraccessFail() //異常系
	{
		UserDAO userlogin=new UserDAO();
		String nickname="minato";
		String password="YuNi1";
		Login login=new Login(nickname,password);
		User user=userlogin.findsingleraw(login);
		assertEquals(null,user);
		try {
		     nickname=user.getNickname();//NullPointerExceptionが発生
		}
		catch(NullPointerException e) {
			return;
		}
	}

}
