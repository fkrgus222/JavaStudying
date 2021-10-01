package 플레이어;

public class PlayerLevelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PlayerLevel p1 = new BeginnerLevel();
		PlayerLevel p2 = new IntermediateLevel();
		PlayerLevel p3 = new AdvancedLevel();
		
		p1.go(3);
		p2.go(3);
		p3.go(3);

		System.out.println( p1.getClass()   );
		
		
	}

}
