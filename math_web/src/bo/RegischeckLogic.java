package bo;

import dao.UserDAO;
import entity.User;
public class RegischeckLogic {
public boolean check(String nickname) {
	 UserDAO userdb=new UserDAO();
	 User user=userdb.findNick(nickname);
	 return user==null;
}
}
