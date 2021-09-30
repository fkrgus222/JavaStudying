package 실습문제1회;

import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("문자 한 자를 입력하세요 : ");
		
		//문자를 입력받고 해당 문자의 Int값을 얻는다(inputInt).
		char input = in.next().charAt(0);
		
		//inputInt 값의 범위에 따라 대문자, 소문자를 판단한다
		if (input >= 'A' && input <= 'Z') {
			System.out.println( (char)((int)input + 32) );
		}
		else if (input >= 'a' && input <= 'z') {
			System.out.println( (char)((int)input - 32) );
		}
		else System.out.println("영문자가 아닙니다.");
		
	}

}
