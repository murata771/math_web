package java_zissen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Bank1Test {
	  // (1)正常系：「ミヤビ」をセットできるか
	  @Test public void setName() {
	    Bank1 b = new Bank1();
	    b.setName("ミヤビ");
	  }

	  // (2)異常系：nullをセットしようとしたら例外が起きるべき
	  @Test public void getNameWithNull() {
	    try {
	      Bank1 b = new Bank1();
	      b.setName(null);
	    } catch (NullPointerException e) {
	      return;
	    }
	    fail();
	  }
	  
	  // (3)異常系：２文字をセットしようとしたら例外が起こるべき
	  @Test
	  public void throwsExceptionWithTwoName() {
	    Bank1 b = new Bank1();
	    assertThrows(IllegalArgumentException.class, () -> { b.setName("ミヤ");});
	  }
	}

