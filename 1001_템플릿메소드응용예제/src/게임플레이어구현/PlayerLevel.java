package 게임플레이어구현;

public abstract class PlayerLevel {

	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	
	final public void ho(int count) {
		
		run();
		
		for(int i = 0 ; i < count; i ++) {
			jump();
		}
		
		turn();
	}
}
