package bo;

import java.util.List;

import dao.UserDAO;
import entity.User;

public class Registcnt {
public int count(User user) {
	UserDAO userdao=new UserDAO();
	List<User>users=userdao.findnowdate(user.getNowDate());
	return users.size();
}
}
