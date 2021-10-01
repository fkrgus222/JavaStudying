package this실습;

class Person{
	//멤버변수
	private int juminNum;    //주민번호
	private long millitaryNum;	//군번
	private int birthYear;	//출생년도
	private int birthMonth;	//출생월
	private int birthDay;	//출생일

	public Person(int juminNum,long millitaryNum, int bYear, int bMonth, int bDay) {
		this.juminNum = juminNum;
		this.millitaryNum = millitaryNum;
		birthYear = bYear;
		birthMonth = bMonth;
		birthDay = bDay;
	}
	
	public Person(int juminNum, int bYear, int bMonth, int bDay) {
		this(juminNum, 0, bYear, bMonth, bDay);
	}
	
	public void showInfo() {
		System.out.println("주민번호 : " +juminNum);
		System.out.println("생년월일 : " + birthYear + "/" + birthMonth + "/" + birthDay);
		
		if (millitaryNum != 0) {
			System.out.println("군번: " + millitaryNum + '\n');
		}
		else {
			System.out.println("군과 관계 없음\n");
		}
	}
	
}// class Person


public class ThisEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person man = new Person(961214,880102,1996,12,14);
		Person wman = new Person(961214,1990,11,16);
		
		man.showInfo();
		wman.showInfo();
	}

}
