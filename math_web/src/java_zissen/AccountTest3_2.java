package java_zissen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AccountTest3_2 {
	  // 実際にAccountをnewして使ってみるテスト
	  @Test public void intstantiate() {
	    Account3 a = new Account3("ミナト", 30000);
	    assertEquals("ミナト", a.owner);
	    assertEquals(30000, a.zandaka);
	  }
	  @Test public void intstantiate2() {
		    Account3 a = new Account3("ミナト", 30000);
		    String null1=null;
		    null1.length();
		    assertEquals("ミナトman", a.owner);
		    assertEquals(30000.0, a.zandaka);
	  }
	  @Test public void transfer() {
	    /* : */
	  }
	}
