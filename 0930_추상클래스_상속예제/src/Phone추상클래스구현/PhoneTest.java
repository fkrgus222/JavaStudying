package Phone추상클래스구현;

public class PhoneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Phone myPhone = new SmartPhone("Lee","010-8548-9710");
		Phone yourPhone = new TelePhone("Choi","010-1234-5678");
		
		myPhone.run();
		yourPhone.run();
		
	}

}
