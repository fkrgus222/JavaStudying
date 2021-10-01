package 실습문제1회;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {rdm
		
		int[] arr = {0,0,0,0,0,0,0,0};       //각 돈의 단위가 몇개씩 필요한지를 저장할 배열
		int[] arr2 = {50000,10000,5000,1000,500,100,50,10};  //각 돈의 단위의 Int형태
		String[] arr3 = {"오만원권","만원권","오천원권","천원권","오백원","백원","오십원","십원"};  //출력을 위한 각 돈의 단위의 문자열 형태 배열 
		
		System.out.println("금액을 입력해 주세요 : ");
		Scanner in = new Scanner(System.in);
		int money = in.nextInt();   //입력받는 금액
		
		System.out.println(); //개행
		for ( int i = 0 ; i < arr.length ; i ++) {
			arr[i] = money/arr2[i];			//현재 단위의 갯수를 구한다.
			money = money%arr2[i]; 			//현재 단위만큼 가지고 남는 나머지
			
			if (arr[i] == 0)continue;	//0매 혹은 0개일 경우 출력하지 않는다.
			
			if (arr2[i] <= 500)		System.out.println(arr3[i] + " " + arr[i] + "개"); //단위가 '개'일 경우
			else					System.out.println(arr3[i] + " " + arr[i] + "매"); //단위가 '매'일 경우
		}
		
		
		
		
		
	}
}
