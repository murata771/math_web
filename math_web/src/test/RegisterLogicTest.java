package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import bo.RegisterLogic;
import entity.User;

class RegisterLogicTest {

	@Test
	void test1() {//正常系
		RegisterLogic register=new RegisterLogic();
		String nickname="murase";
		String password="YuNi531";
		String likething="apple";
		int age=7;
		String userID="00000033";
		String grade="2";
		LocalDate nowdate=LocalDate.now();
		User user=new User(nickname,password,likething,userID,grade,age,nowdate);
	boolean pass=register.regis(user);
	assertSame(true,pass);
	}
	@Test
	void test2() {//異常系
		RegisterLogic register=new RegisterLogic();
		String nickname="minaki";
		String password=null;
		String likething="apple";
		int age=7;
		String userID=null;
		String grade="2";
		LocalDate nowdate=LocalDate.now();
		User user=new User(nickname,password,likething,userID,grade,age,nowdate);
	boolean pass=register.regis(user);
	assertSame(false,pass);
	
	}
	@Test
	void test3() {//異常系2_主キーデータ被り
		RegisterLogic register=new RegisterLogic();
		String nickname="minato";
		String password="YuNi";
		String likething="apple";
		int age=7;
		String userID="00001111";
		String grade="2";
		LocalDate nowdate=LocalDate.now();
		User user=new User(nickname,password,likething,userID,grade,age,nowdate);
	boolean pass=register.regis(user);
	assertSame(false,pass);
	
	}
}
