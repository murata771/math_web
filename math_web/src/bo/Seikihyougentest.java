package bo;

import java.util.regex.Pattern;

public class Seikihyougentest {
	public static void main(String[] args) {
  Pattern pattern=Pattern.compile("[0-9a-zA-Z]");
  Pattern pattern2=Pattern.compile("^[0-9a-zA-Z]{4,}$");
	  String nickname="tiehieie";
	  String nickname2="53u797859793ffff&";
	  String str="aaaaaute9uoe";
	  if(pattern.matcher(nickname).matches()) {System.out.println("正規表現成功");}
	  if(pattern.matcher(str).matches()) {System.out.println("正規表現成功4");}
	  if(pattern2.matcher(str).matches()) {System.out.println("正規表現成功3");}
	
	  if(pattern2.matcher(nickname2).matches()) {System.out.println("正規表現成功2");}
	  String nickfail="nickfail";
	  if(!(pattern2.matcher(nickfail).matches())) {System.out.println("正規表現失敗検証が成功2");}
	}
}
