package test;

public class Mozitest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int age=0;//ageに一つでも数字以外の文字があれば、ageはuserにセットしない
		String agemozi="86";
		System.out.println("zikken");
		for(int i=0;i<agemozi.length();i++) {
		char mozi=agemozi.charAt(i);
	
		if(!(Character.isDigit(mozi))) {System.out.println("文字を含む");break;}
		int j=i+1;
		if(j==(agemozi.length()+1)) {
			age=Integer.parseInt(agemozi);
		System.out.println(age+"だよ");
		}
	}
	}

}
