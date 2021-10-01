package suepr½Ç½À;

public class SupersonicAirplaneEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SupersonicAirplane sa = new SupersonicAirplane();
		
		sa.takeOff();
		sa.fly();
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();
		
		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly();
		sa.land();
		
		
	}

}
