package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bo.UserdeliteLogic;
import entity.User;

class UserdeliteLogicTest {

	@Test
	void test1() {//正常系
		UserdeliteLogic delite=new UserdeliteLogic();
		String nickname="minaki";
		String password="YuNi53";
		//String likething="apple";
		//int age=7;
		String userID="00000033";
		//String grade="2";
		//LocalDate nowdate=LocalDate.now();
		User user=new User();
		user.setUserID(userID);
		user.setPassword(password);
		user.setNickname(nickname);
		boolean deliteTF=delite.user1del(user);
		assertSame(true,deliteTF);
	}
	@Test
	void test2() {//異常系
		UserdeliteLogic delite=new UserdeliteLogic();
		String nickname="minaki";
		String password="Yu";
		//String likething="apple";
		//int age=7;
		String userID="00000033";
		//String grade="2";
		//LocalDate nowdate=LocalDate.now();
		User user=new User();
		user.setUserID(userID);
		user.setPassword(password);
		user.setNickname(nickname);
		boolean deliteTF=delite.user1del(user);
		assertSame(false,deliteTF);
	}

}
