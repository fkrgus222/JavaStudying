package 플레이어;

public class AdvancedLevel implements PlayerLevel{

	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("아주 빠르게 달리 수 있다.");
	}

	
	public void jump(int count) {
		// TODO Auto-generated method stub
		System.out.println(count + "번 아주 높이 점프할 수 있다.");
	}

	
	public void turn() {
		// TODO Auto-generated method stub
		System.out.println("턴할 수 있다.");
	}

	
	public void showMessageInfo() {
		// TODO Auto-generated method stub
		System.out.println("===============");
	}

}
