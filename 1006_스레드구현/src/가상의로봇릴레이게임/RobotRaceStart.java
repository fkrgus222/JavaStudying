package 가상의로봇릴레이게임;

class RobotRace extends Thread{
	
	public RobotRace(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		//가상 로봇 100m 릴레이 => 10m씩 전진.
		for (int i = 0 ; i <= 10 ; i ++) {
			System.out.println(getName() + "가 " + i*10 + "m전진");
			try {
				sleep(1000);  //1초 일시 정지
			}catch(InterruptedException e) {
				System.out.println(e.toString());
			}
		}
		
	}
	
}


public class RobotRaceStart extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotRace robotA = new RobotRace("로봇-A");
		RobotRace robotB = new RobotRace("로봇-B");
		RobotRace robotC = new RobotRace("로봇-C");
		
		robotA.start();
		robotB.start();
		robotC.start();
		
	}

}
