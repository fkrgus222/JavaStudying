package 멀티스레드예제;

public class BeepPrintEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);
		
		thread.start();    //이 시점에서 작업 스레드와 메인 스레드가 동시에 실행 
		//Ex01과는 다르게 Beep음과 Console같이 찍힘 --> 멀티쓰레드
		
		
		for (int i = 0 ; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000);   //1초가 일시 정지
			}catch(Exception e) {}
		}

		
	}
}
