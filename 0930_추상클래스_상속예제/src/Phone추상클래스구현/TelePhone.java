package Phone추상클래스구현;

public class TelePhone extends Phone{

	@Override
	public void canDo() {
		// TODO Auto-generated method stub
		System.out.println("자동 응답을 한다.");
	}
	
	TelePhone(String userName, String phoneNumber){
		super(userName, phoneNumber);
	}
	
}
