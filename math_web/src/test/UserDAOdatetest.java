package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.UserDAO;
import entity.User;

class UserDAOdatetest {

	@Test
	void test1() {//正常系
		UserDAO userlogin=new UserDAO();
		LocalDate date=LocalDate.now();
		List<User> users=userlogin.findnowdate(date);
		int count=users.size();
		assertSame(1,count);
		//Login login=new Login();
	//	login.setLikeThing(like);
		
	}
	@Test
	void test2() {//異常系1
		UserDAO userlogin=new UserDAO();
		LocalDate date=LocalDate.now();
		List<User> users=userlogin.findnowdate(date);
		int count=users.size();
		int delitecnt=userlogin.deliterow(users.get(0));
		 users=userlogin.findnowdate(date);
		count=users.size();//取り出した情報の最初を消して、2と一致しないことをテスト
		assertNotSame(1,count);
		//Login login=new Login();
	//	login.setLikeThing(like);
		
	}

}
