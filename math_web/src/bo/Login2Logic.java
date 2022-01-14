package bo;

import dao.UserDAO;
import entity.Login;
import entity.User;

public class Login2Logic {
	public boolean execute(Login login) {
		UserDAO userdao=new UserDAO();
		User user=userdao.findsinglerawlikeThing(login);
		if(user!=null) {
		if(user.getLikeThing().equals(login.getLikeThing()))
		{
			return true;
		}
		}
		
		return false;
		
	}
}
