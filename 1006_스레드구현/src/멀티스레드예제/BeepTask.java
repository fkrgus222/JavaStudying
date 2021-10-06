package 멀티스레드예제;

import java.awt.Toolkit;

public class BeepTask implements Runnable{

	@Override
	public void run() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for ( int i = 0 ; i < 5 ; i ++) {
			toolkit.beep();
			try {
				Thread.sleep(1000);   //1초간 일시 정지
			}catch(Exception e) {}
		}
	}

}
