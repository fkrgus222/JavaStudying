package 응용문제_로또;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TeacherMakeLotto {
/*
 * TreeSet은 저장할 때 이미 정렬하기 때문에 읽어올 때 따로 정렬할 필요가 없다.
 * TreeSet은 Binary Search Tree의 형태로 데이터를 저장하는 컬렉션이다.
 */
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Set set = new HashSet();   HashSet를 사용(추후 리스트로 변환후 순서정리)
		Set set = new TreeSet();   //TreeSet를 사용, 저장하며 오름차순 정리
		
		for (int i = 0 ; set.size() < 6 ; i ++) {
			Random rnd = new Random();
			int number = rnd.nextInt(45) + 1;   //1 ~ 45까지 난수 발생
			set.add(new Integer(number));
		}
		
		System.out.println("<< 로또번호 보여주기 >>");
//		List list = new ArrayList(set);
//		Collections.sort(list);
//		System.out.println(list);  //list로 바꾼뒤 순서정리
		System.out.println(set);
		
		
	}
}
