package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bo.Login2Logic;
import entity.Login;

class Login2LogicTest {
	@Test
	void loginTrue() {//正常系_trueを返す

		String likeThing="game";

		Login login=new Login();
		login.setLikeThing(likeThing);
		Login2Logic login2=new Login2Logic();
		boolean loginaccess=login2.execute(login);
		assertSame(true,loginaccess);
	}

	@Test
	void loginFalse() {//異常系_falseを返す

		String likeThing="melon";

		Login login=new Login();
		login.setLikeThing(likeThing);
		Login2Logic login2=new Login2Logic();
		boolean loginaccess=login2.execute(login);
		assertSame(false,loginaccess);
	}

}
