package 게임플레이어구현;

public class MainBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Player player = new Player();
		player.play(1);
		System.out.println();
		
		AdvancedLevel aLevela = new AdvancedLevel();
		player.upgradeLevel(aLevela);
		player.play(2);
		System.out.println();
		
		SuperLevel sLevel = new SuperLevel();
		player.upgradeLevel(sLevel);
		player.play(3);
		
		
	}

}
