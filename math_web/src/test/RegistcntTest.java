package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bo.Registcnt;

class RegistcntTest {

	@Test
	void test() {//正常系
		Integer cnt=0;
		Registcnt regiscnt=new Registcnt();
		boolean ok=regiscnt.count(cnt);
		assertSame(true,ok);
	}
	@Test
	void test2() {//異常系
		Integer cnt=1;
		Registcnt regiscnt=new Registcnt();
		boolean fail=regiscnt.count(cnt);
		assertSame(false,fail);
	}

}
