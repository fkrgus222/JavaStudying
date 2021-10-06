package 요소처리를위한람다식예제;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Customer> list = (List)Arrays.asList(new Customer("박태호",1500), new Customer("오수철",700));
		
		/*
		 * [중요]컬렉션으로부터 스트림 얻기 => List 컬렉션의 참조변수를 통해서
		 */
		
		Stream<Customer> stream = list.stream();
		stream.forEach(s -> {
			String name = s.getName();
			int score = s.getPoint_score();
			
			System.out.println(name + " => 포인트 점수 : " + score + "점");
		});
		
		
	}

}
