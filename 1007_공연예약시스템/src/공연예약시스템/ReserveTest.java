package 공연예약시스템;

import java.util.Scanner;

public class ReserveTest {

	public static void main(String[] args) {
		SeatType[] aSeatType = new SeatType[4];
		
		aSeatType[0] = new SeatType('R',5); //R석
		aSeatType[1] = new SeatType('S',7); //S석
		aSeatType[2] = new SeatType('A',10); //A석
		aSeatType[3] = new SeatType('B',15); //B석
		
		int choice = 0;
		while(choice != 4) {
			int type;
			System.out.println("==== 메인메뉴 ====");
			System.out.println("다음 중 하나의 메뉴를 선택하세요 >>> ");
			System.out.println("===============");
			System.out.println("1. 예약");
			System.out.println("2. 조회");
			System.out.println("3. 취소");
			System.out.println("4. 종료");
			System.out.println("선택하세요>>> ");
			
			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			
			switch(choice) {
			case 1: //예약
				System.out.println("<좌석 구분>");
				System.out.println("1. R석(5석)");
				System.out.println("2. S석(7석)");
				System.out.println("3. A석(10석)");
				System.out.println("4. B석(15석)");
				System.out.println("선택하세요>>> ");
				type = in.nextInt();
				
				if(type < 1 || type> 4) {
					System.out.println("예약시 잘못된 좌석 타입입니다.");
					break;
				}
				aSeatType[type-1].seatReserve();
				break;

			case 2: //조회
				for(int i = 0;i<aSeatType.length;i++) {
					aSeatType[i].show();
				}
				System.out.println("조회를 완료하였습니다.");
				break;
			case 3: //취소
				System.out.println("<좌석구분>");
				System.out.println("1. R석(5석)");
				System.out.println("2. S석(7석)");
				System.out.println("3. A석(10석)");
				System.out.println("4. B석(15석)");
				System.out.println("선택하세요>>> ");
				type = in.nextInt();
				
				if(type < 1 || type> 4) {
					System.out.println("취소시 잘못된 좌석 타입입니다.");
					break;
				}
				aSeatType[type-1].cancel();
				break;
			case 4: //종료
				break;
			default: 
				System.out.println("메뉴를 잘못 입력했습니다.");
			
				
			
		}
	}

}
}
