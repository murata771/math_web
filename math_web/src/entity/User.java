package entity;

import java.io.Serializable;
import java.time.LocalDate;
public class User implements Serializable  {
	private String nickname;
	private String password;
	private String likeThing;
	private String userID;
	private String grade;
	private int age;
	private LocalDate nowDate;
	public User() {}
	public User(String nickname,String password) {
		this.nickname=nickname;
		this.password=password;
	}
	
	public User(String nickname, String password, String likeThing, String userID, String grade, int age,
			LocalDate nowDate) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.likeThing = likeThing;
		this.userID = userID;
		this.grade = grade;
		this.age = age;
		this.nowDate = nowDate;
	}
	public User(String nickname, String password, String likeThing, String userID, String grade, 
			LocalDate nowDate) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.likeThing = likeThing;
		this.userID = userID;
		this.grade = grade;
		
		this.nowDate = nowDate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLikeThing() {
		return likeThing;
	}
	public void setLikeThing(String likeThing) {
		this.likeThing = likeThing;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDate getNowDate() {
		return nowDate;
	}
	public void setNowDate(LocalDate nowDate) {
		this.nowDate = nowDate;
	}
}
