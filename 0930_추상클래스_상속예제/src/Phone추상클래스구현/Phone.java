package Phone추상클래스구현;

public abstract class Phone {

	protected String userName;
	protected String phoneNumber;
	
	public abstract void canDo();
	
	public void turnOn() {
		System.out.println("폰을 켠다.");
	}
	public void turnOff() {
		System.out.println("폰을 켠다.");
	}
//	public void show() {
//		System.out.println("사용자 이름은 : " + userName + "핸드폰 번호는 : " + phoneNumber);
//	}
	
	
	final public void run() {
//		show();
		turnOn();
		canDo();
		turnOff();
		System.out.println("=================");
	}
	
	public Phone() {}
	public Phone(String userName, String PhoneNumber) {
		this.userName = userName;
		this.phoneNumber = PhoneNumber;
	}
	
	
	
}
