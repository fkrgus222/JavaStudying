package Phone추상클래스구현;

public class SmartPhone extends Phone{

	@Override
	public void canDo() {
		// TODO Auto-generated method stub
		System.out.println("인터넷 검색을 한다.");
	}
	
	SmartPhone(String userName, String phoneNumber){
		super(userName, phoneNumber);
	}
	
}
