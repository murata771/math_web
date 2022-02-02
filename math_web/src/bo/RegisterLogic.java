package bo;

import dao.UserDAO;
import entity.User;
public class RegisterLogic {
public boolean regis(User user) {
	 UserDAO userdb=new UserDAO();
	 RegischeckLogic checklo=new RegischeckLogic();
	 boolean torokusuuTF=checklo.check(user.getNickname());
	 if(!torokusuuTF) {return false;}
	 int registcnt=userdb.regis1(user);
	 return registcnt==1;
}
}
