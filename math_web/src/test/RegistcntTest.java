package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bo.Registcnt;
import dao.UserDAO;
import entity.User;

class RegistcntTest {

	@Test
	void test() {//正常系
		Integer cnt=0;
		Registcnt regiscnt=new Registcnt();
		
		User user=new UserDAO().findNick("minato");
		int num=regiscnt.count(user);
		assertSame(2,num);
	}
	@Test
	void test2() {//異常系
		Integer cnt=0;
		Registcnt regiscnt=new Registcnt();
		
		User user=new UserDAO().findNick("minato");
		int num=regiscnt.count(user);
		assertNotSame(2,num);
	}

}
