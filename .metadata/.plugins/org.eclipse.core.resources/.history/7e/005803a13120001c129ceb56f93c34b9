package 응용문제_로또;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MakeLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> lotto = new HashSet<Integer>();
		
		//변수 선언
		boolean FLAG = true;
		Random random = new Random();
		
		//삽입 작업
		while (FLAG) {
			int tmp = random.nextInt(45);
			lotto.add(tmp);
			if (lotto.size() == 6) FLAG = false;
		}
		
		//리스트로 변환, Sorting 작업.
		List<Integer> answer = new ArrayList<>(lotto); 
		Collections.sort(answer);
		
		//결과물 출력
		System.out.println(answer);

		
		
	} // end of main
} //end of class
