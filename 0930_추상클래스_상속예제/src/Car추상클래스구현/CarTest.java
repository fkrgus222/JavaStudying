package Car추상클래스구현;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("<<<자율주행 자동차 테스트>>>");
		Car myCar = new AICar();
		myCar.run();
		System.out.println();
		
		System.out.println("<<<사람이 운전하는 자동차>>>");
		Car hisCar = new ManualCar();
		hisCar.run();
		
	}

}
