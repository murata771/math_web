package bo;
import dao.UserDAO;
import entity.Login;
import entity.User;
public class Login1Logic {
	public boolean execute(Login login) {
		UserDAO userdao=new UserDAO();
		User user=userdao.findsingleraw(login);
		if(user!=null)
		if((user.getNickname().equals(login.getNickname()))&&(user.getPassword().equals(login.getPassword())))
		{
			return true;
		}
		
		return false;
		
	}
}
