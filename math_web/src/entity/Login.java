package entity;
import java.io.Serializable;
public class Login implements Serializable {
	private String nickname;
	private String password;
	private String likeThing;
	public Login() {
		
	}
	public Login(String nickname,String password ) {
		this.nickname=nickname;
		this.password=password;
	}
	public Login(String likeThing ) {
		this.likeThing=likeThing;
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
	
}
