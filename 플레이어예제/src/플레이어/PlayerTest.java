package 플레이어;

public class PlayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1 = new Player("Lee");
		Player p2 = new Player("Choi","AdvancedLevel");
		Player p3 = new Player("Kim","BeginnerLevel");
		
		p1.showInfo(5);
		p1.levelUp();
		p1.showInfo(5);
		p1.levelUp();
		p1.showInfo(5);
		
		
		p2.showInfo(43);
		p2.levelUp();
		p3.showInfo(25);
		
	}

}
