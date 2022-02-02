package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bo.RegischeckLogic;

class RegischeckLogicTest {

	@Test
	void test1() {//正常系
		RegischeckLogic check=new RegischeckLogic();
		
		 
		 String nickname="testuser1";
		 boolean regischeck=check.check(nickname);
		 assertSame(true,regischeck);
	}
	@Test
	void test2() {//異常系
		RegischeckLogic check=new RegischeckLogic();
		
		 
		 String nickname="minato";
		 boolean regischeck=check.check(nickname);
		 assertSame(false,regischeck);
	}

}
