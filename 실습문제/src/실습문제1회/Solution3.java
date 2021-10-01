package 실습문제1회;

import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("연도를 입력하세요>>");
		int year = in.nextInt();
		String answer = "";
		
//		if (year%4 == 0) {
//			answer = "윤년";
//			if (year%100 == 0 && year%400 != 0) answer = "평년";
//		}
//		else answer = "평년";
		
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) {
			answer = "윤년";
		}
		else answer = "평년";
		
		
		
		
		System.out.println(answer + "입니다.");
	}

}
