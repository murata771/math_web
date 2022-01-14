package java_zissen;

public class Account3 {
	  String owner;     // 口座名義人
	  int zandaka;      // 口座残高
	  public Account3(String owner, int zandaka) {
	   this.owner = owner;
	   this.zandaka = zandaka;
	  }
	  public void transfer(Account3 dest, int amount) {
	    dest.zandaka += amount;
	    zandaka -= amount;
	  }
	}
	  