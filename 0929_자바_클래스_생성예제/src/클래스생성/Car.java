package 클래스생성;

/*
 * Car 클래스 => 부모(상위) 클래스  
 * 
 */

public class Car {
	protected int speed; 		   //현재속도
	protected String wheelNum;   // 바퀴의 갯수
	protected String carName;	   //재동차 이름 
	
	//생성자
	public Car() {
		
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
	
	

}
