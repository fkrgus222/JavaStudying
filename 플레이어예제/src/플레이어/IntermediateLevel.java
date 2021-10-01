package 플레이어;

public class IntermediateLevel implements PlayerLevel{

	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("빠르게 달릴 수 있다.");
	}

	
	public void jump(int count) {
		// TODO Auto-generated method stub
		System.out.println(count + "번 높이 점프할 수 있다.");
	}

	
	public void turn() {
		// TODO Auto-generated method stub
		
	}

	
	public void showMessageInfo() {
		// TODO Auto-generated method stub
		System.out.println("턴 할 줄 모른다.");
		System.out.println("===============");
	}

}
