package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bo.UserLogic;
import entity.User;

class UserLogicTest {

	@Test
	void test1() {//正常系
		String nickname="minato";
		UserLogic uslo=new UserLogic();
		User user=uslo.userkensaku(nickname);
		if(user==null) {fail();}
		else{
		String nicknamekennsaku=user.getNickname();
		String password=user.getPassword();
		//String likething=user.getLikeThing();
	
		String userID=user.getUserID();
		assertEquals("minato",nicknamekennsaku);
		assertEquals("YuNi",password);
		assertEquals("00000001",userID);
		}
	}
	@Test
	void test2() {//異常系
		String nickname="minato5555";
		UserLogic uslo=new UserLogic();
		User user=uslo.userkensaku(nickname);
		assertNull(user);
		
	}

}
