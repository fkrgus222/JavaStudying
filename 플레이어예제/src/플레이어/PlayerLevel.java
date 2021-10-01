package 플레이어;

public interface PlayerLevel {
	public void run();
	public void jump(int count);
	public void turn();
	public void showMessageInfo();
	public default void go(int count) {
		run();
		jump(count);
		turn();
		showMessageInfo();
	};
	
}
