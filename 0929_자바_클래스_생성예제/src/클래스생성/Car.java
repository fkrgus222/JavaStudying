package 클래스생성;

public class Car {
	private int speed; 		   //현재속도
	private String wheelNum;   // 바퀴의 갯수
	private String carName;	   //재동차 이름 
	
	//생성자
	public Car() {
		speed = 10;
		wheelNum = "4";
		carName = "avante";
	}
	public Car(String name) {
		carName = name;
	}
	
	public Car(int velocity) {
		speed = velocity;
	}
	
	public Car(String name, int velocity) {
		carName = name;
		speed = velocity;
	}
	
	//사용자 정의 메소드
	public void speedUp(int velocity) {
		speed = speed + velocity;
	}
	public void speedDown(int velocity) {
		speed = speed - velocity;
		if (speed < 0) {
			speed = 0;
		}
	}
	public void stop() {
		speed = 0;
	}
	public void show() {
		System.out.println("차의 속력은 : " + speed + " 차의 바퀴개수는 : " + wheelNum + " 차 이름은 : " + carName);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car myCar = new Car("제네시스");
		myCar.show();
		
		
	}

}
