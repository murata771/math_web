package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bo.Login1Logic;
import entity.Login;
class Login1LogicTest {

	@Test
	void loginTrue() {//正常系_trueを返す

		String nickname="minato";
		String password="YuNi";
		Login login=new Login(nickname,password);
		Login1Logic login1=new Login1Logic();
		boolean loginaccess=login1.execute(login);
		assertEquals(true,loginaccess);
	}

	@Test
	void loginFalse() {//異常系_falseを返す

		String nickname="minato1";
		String password="YuNi";
		Login login=new Login(nickname,password);
		Login1Logic login1=new Login1Logic();
		boolean loginaccess=login1.execute(login);
		assertEquals(false,loginaccess);
	}

}
