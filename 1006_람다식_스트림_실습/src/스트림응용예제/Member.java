package 스트림응용예제;

public class Member {
	
	public static int MALE = 0;    //남자
	public static int FEMALE = 1;  //여자
	
	private String name;   //이름
	private int gender;    //성별
	private int age;       //나이
	
	//생성자
	public Member(String name, int gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	
	//getter 메소드만 구현
	public String getName() {
		return name;
	}

	public int getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}
	
	 
	
	
	
	
}
