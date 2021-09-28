package 주민번호체크;

import java.util.Scanner;

public class JuminRegion {

	public static void main(String[] args) {
		
// 		안내문자 출력과 주빈번호 입력받기

//		Scanner in = new Scanner(System.in);
//		System.out.println("주민번호를 입력하세요>>>");
//		String juminNum = in.next();
		
		String juminNum = "960504-1179033";
		//필요한 변수들 만들기
		int target = Integer.parseInt(juminNum.substring(8,10));
		int[] cities = {8,12,15,25,34,39,47,55,66,80,99};
		String[] cityNames = {"서울","부산","인천","경기도","강원도","충청북도","충청남도","전라북도","전라남도","전라북도","경상남도"};
		int index = -1;
		String answer;

		//지역번호가 속하는 정수배열 index를 사용하여 도시 이름 추출
		for (int i = 0 ; i < cities.length  ; i ++) {
			if (target >= cities[i]) {
				index = i;
			}
		}
		answer = cityNames[index+1];
		System.out.println(answer);		
		
	} // end of main 
} // end of class
