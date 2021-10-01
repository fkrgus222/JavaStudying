package 게임플레이어구현;

public class AdvancedLevel extends PlayerLevel{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("빨리 달린다.");
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("높이 jump 한다.");
	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub
		System.out.println("Turn 할 줄 모른다.");
	}

	@Override
	public void showLevelMessage() {
		// TODO Auto-generated method stub
		System.out.println("<<< 중급자 레벨 입니다. >>>");
	}

}
