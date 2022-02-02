package bo;

import dao.UserDAO;
import entity.User;
public class UserdeliteLogic {
 public boolean user1del(User user) {
	 UserDAO userdb=new UserDAO();
	 int delitecnt=userdb.deliterow(user);
	 return delitecnt==1;
	 
 }
}
