package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import entity.Login;
import entity.User;
public class UserDAO {

	 // データベース接続に使用する情報
	  private final String JDBC_URL =
	          "jdbc:mysql://localhost/mathweb";
	  private final String DB_USER = "root";
	  private final String DB_PASS = "Yu583hz5kr3&";
	  //UserDBをLoginを基に検索して、該当行を1行クラスとして戻すメソッド
	  public User findsingleraw(Login login) {
		  //DB接続の型と戻り値を宣言
		  User user=null;
		  Connection con=null;
		  try {
			  //DB接続
			  con=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			  //送信するSQLの設定
String sql1="select userID,password,likeThing,age,nickname,date,grade from User where nickname=? and password=?";
					 
			  PreparedStatement psmt=con.prepareStatement(sql1);
			  psmt.setString(1, login.getNickname());//ひな形に検索に使用するデータを設定
			  psmt.setString(2, login.getPassword());//ひな形に検索に使用するデータを設定
			  //検索した結果を受ケ取って、正常に検索できたかどうかを確認
			  ResultSet result=psmt.executeQuery();
			  if(result.next()) {//検索が上手くいったことを想定
				  String nickname=result.getString("nickname");
				  String password=result.getString("password");
				  String likeThing=result.getString("likeThing");
				  String userID=result.getString("userID");
				  String grade=result.getString("grade");
				  LocalDate today=result.getDate("date").toLocalDate();//java.sql.Date→LocalDateに変換できる
				  int age=result.getInt("age");
				  user=new User(nickname,password,likeThing,userID,grade,age,today);
				  result.close();
				  psmt.close();
				  return user;
			  }
			  else { //検索がnullを想定
				  result.close();
			  		  psmt.close();
				      return user;
				      }
		  }
		  catch(SQLException e) {//DB接続等でエラーが発生した時の処理
			  System.out.println("errorメッセージを表記"+e.getMessage());
			  e.printStackTrace();
			  return null;
		  }finally {
			 if(con!=null) {//DBとの接続を閉じる処理
				 try{
					 con.close();
					 }
				 catch(SQLException e) {
					 e.printStackTrace();
				 }
			}
		  }
		
		  
	  }
	  public User findsinglerawlikeThing(Login login) {
		  //DB接続の型と戻り値を宣言
		  User user=null;
		  Connection con=null;
		  try {
			  //DB接続
			  con=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			  //送信するSQLの設定
String sql1="select userID,password,likeThing,age,nickname,date,grade from User where likeThing=?";
					 
			  PreparedStatement psmt=con.prepareStatement(sql1);
			  psmt.setString(1, login.getLikeThing());//ひな形に検索に使用するデータを設定

			  //検索した結果を受ケ取って、正常に検索できたかどうかを確認
			  ResultSet result=psmt.executeQuery();
			  if(result.next()) {//検索が上手くいったことを想定
				  String nickname=result.getString("nickname");
				  String password=result.getString("password");
				  String likeThing=result.getString("likeThing");
				  String userID=result.getString("userID");
				  String grade=result.getString("grade");
				  LocalDate today=result.getDate("date").toLocalDate();//java.sql.Date→LocalDateに変換できる
				  int age=result.getInt("age");
				  user=new User(nickname,password,likeThing,userID,grade,age,today);
				  result.close();
				  psmt.close();
				  return user;
			  }
			  else { //検索がnullを想定
				  result.close();
			  		  psmt.close();
				      return user;
				      }
		  }
		  catch(SQLException e) {//DB接続等でエラーが発生した時の処理
			  System.out.println("errorメッセージを表記"+e.getMessage());
			  e.printStackTrace();
			  return null;
		  }finally {
			 if(con!=null) {//DBとの接続を閉じる処理
				 try{
					 con.close();
					 }
				 catch(SQLException e) {
					 e.printStackTrace();
				 }
			}
		  }
		
		  
	  }
}
