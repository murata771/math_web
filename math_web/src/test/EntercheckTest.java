package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import bo.Entercheck;
import entity.User;

class EntercheckTest {

	@Test
	void test1() {//正常系
		String nickname="minaki";
		String password="YuNi53tiejhthie";
		String likething="apple";
		int age=7;
		String userID="00000033";
		String grade="2";
		LocalDate nowdate=LocalDate.now();
		User user=new User(nickname,password,likething,userID,grade,age,nowdate);
		Entercheck check=new Entercheck();
	boolean error=	check.checkchar(user);
	assertSame(true,error);
	}
	@Test
	void test2() {//異常系1nickname
		String nickname="minaki感じ";
		String password="YuNi53tiejhthie";
		String likething="apple";
		int age=7;
		String userID="00000033";
		String grade="2";
		LocalDate nowdate=LocalDate.now();
		User user=new User(nickname,password,likething,userID,grade,age,nowdate);
		Entercheck check=new Entercheck();
	boolean error=	check.checkchar(user);
	assertSame(false,error);
	}
	@Test
	void test3() {//異常系2password
		String nickname="minaki";
		String password="YuN";
		String likething="apple";
		int age=7;
		String userID="00000033";
		String grade="2";
		LocalDate nowdate=LocalDate.now();
		User user=new User(nickname,password,likething,userID,grade,age,nowdate);
		Entercheck check=new Entercheck();
	boolean error=	check.checkchar(user);
	assertSame(false,error);
	}
	@Test
	void test4() {//異常系3年齢
		String nickname="minaki";
		String password="YuN";
		String likething="apple";
		
		String userID="00000033";
		String grade="2";
		LocalDate nowdate=LocalDate.now();
		int age=0;
		User user=new User(nickname,password,likething,userID,grade,age,nowdate);
		Entercheck check=new Entercheck();
	boolean error=	check.checkchar(user);
	assertSame(false,error);
	}

}
