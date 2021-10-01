package 실습문제1회;

import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
//		System.out.println("���� �� �ڸ� �Է��ϼ��� : ");
		
		//���ڸ� �Է¹ް� �ش� ������ Int���� ��´�(inputInt).
		char input = in.next().charAt(0);
		
		//inputInt ���� ������ ���� �빮��, �ҹ��ڸ� �Ǵ��Ѵ�
		if (input >= 'A' && input <= 'Z') {
			System.out.println( (char)((int)input + 32) );
		}
		else if (input >= 'a' && input <= 'z') {
			System.out.println( (char)((int)input - 32) );
		}
//		else System.out.println("�����ڰ� �ƴմϴ�.");
		
	}

}
