package java_zissen;

public class Account1 {
	  String owner;     // 口座名義人
	  int zandaka;      // 口座残高
	  public void Account1(String owner, int zandaka) {
	    owner = owner;
	    zandaka = zandaka;
	  }
	  public void transfer(Account1 dest, int amount) {
	    dest.zandaka += amount;
	    zandaka -= amount;
	  }
	}
