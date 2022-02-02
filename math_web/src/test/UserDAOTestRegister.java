package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import dao.UserDAO;
import entity.Login;
import entity.User;

class UserDAOTestRegister {

	@Test
	void testFindNick() {//正常系
		UserDAO userlogin=new UserDAO();
		String nick="minato";
	
		//Login login=new Login();
	//	login.setLikeThing(like);
		User user=userlogin.findNick(nick);
		if(user!=null) {
		assertEquals("game",user.getLikeThing());
		assertEquals("minato",user.getNickname());
		assertSame(8,user.getAge());
		}
		else {fail();
		}
		
	}
	@Test
	void testFindNick2() {//異常系
		UserDAO userlogin=new UserDAO();
		String nick="minami";
	
		//Login login=new Login();
	//	login.setLikeThing(like);
		User user=userlogin.findNick(nick);
		assertEquals(null, user);
		
	}	

	@Test
	void testDeliterow() {//正常系
		String nickname="minato";
		String password="YuNi";
		String likething="ichigo";
		int age=8;
		String userID="00000005";
		String grade="2";
		LocalDate nowdate=LocalDate.now();
		User user=new User(nickname,password,likething,userID,grade,age,nowdate);
		UserDAO userlogin=new UserDAO();
		int deliterow=userlogin.deliterow(user);
		assertSame(1,deliterow);
	}
	
	@Test
	void testDeliterow2() {//異常系_削除失敗
		UserDAO userlogin=new UserDAO();
		User user=new User();
		user.setNickname("minami");
		user.setUserID("0000001");
		user.setPassword("yuni1");
		int deliterow=userlogin.deliterow(user);
         assertNotSame(1,deliterow);
	}

	@Test
	void testRegis1() {//正常系
		/*String nickname, String password, String likeThing, String userID, String grade, int age,
		LocalDate nowDate*/
		String nickname="minato";
		String password="YuNi";
		String likething="ichigo";
		int age=8;
		String userID="00000005";
		String grade="2";
		LocalDate nowdate=LocalDate.now();
		User user=new User(nickname,password,likething,userID,grade,age,nowdate);
		
		UserDAO userlogin=new UserDAO();
		int result=userlogin.regis1(user);
		assertSame(1,result);
	}


@Test
void testRegis1_2() {//異常系_登録失敗
	/*String nickname, String password, String likeThing, String userID, String grade, int age,
	LocalDate nowDate*/
	String nickname="minato";
	String password=null;
	String likething=null;
	int age=8;
	String userID="0000005";
	String grade="2";
	LocalDate nowdate=LocalDate.now();
	User user=new User(nickname,password,likething,userID,grade,age,nowdate);
	
	Login login=new Login(nickname,password);
	UserDAO userlogin=new UserDAO();
	int result=userlogin.regis1(user);
	assertNotSame(1,result);
}

}
