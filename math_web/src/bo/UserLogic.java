package bo;

import dao.UserDAO;
import entity.User;
public class UserLogic {
	public User  userkensaku(String nickname) {
		UserDAO userdb=new UserDAO();
		User user=userdb.findNick(nickname);
		return user;
		
	}
	}
