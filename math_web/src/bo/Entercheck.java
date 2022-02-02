package bo;
import java.time.LocalDate;
import java.util.regex.Pattern;

import entity.User;
public class Entercheck {
 public boolean checkchar(User user) {
	  String nickname=user.getNickname();
	  String password=user.getPassword();
	  String likeThing=user.getLikeThing();
	  String userID=user.getUserID();
	  String grade=user.getGrade();
	  LocalDate today=user.getNowDate();//java.sql.Date→LocalDateに変換できる
	  int age=user.getAge();
	  Pattern pattern=Pattern.compile("^[0-9a-zA-Z]{2,}$");
	  
	  if((likeThing==null)||(nickname==null)||(password==null)) {return false;}
	  else{
		  if(likeThing.equals("")) {return false;}
	  }
	  if(!(pattern.matcher(nickname).matches())) {return false;}
	 // else if(userID.length()!=8) {return false;}
	  else if((nickname.length()>10)||(nickname.length()<=1) ){return false;}
	  else if((password.length()<8)||(password.length()>50)) {return false;}
	  else if(isLower(password)) {return false;}
	  else if(isUpper(password)) {return false;}
	  else if(age<=6) {return false;}
	  for(int i=0;i<=password.length();i++) {
		  char charpass=password.charAt(i);
		  if(Character.isDigit(charpass)) {break;}
		  if(i==password.length()) {return false;}
	  }

	  return true;
	 
 }
 public static boolean isLower(String str) {
	 return str.equals(str.toLowerCase());
	 }
public static boolean isUpper(String str) {
	 return str.equals(str.toUpperCase());
	 }
}
