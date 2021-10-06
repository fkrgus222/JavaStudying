package 람다식예제;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx01 {

	public static void main(String[] args) {
/*
 * 자바 7 이전까지는 List<Integer> 컬렉션에서 요소를 순차적으로
 * 처리하기 위해 Iterator 오비ㅡ 반복자를 사용해왔다.
 * Iterator --> 외부 반복자.
 * 외부반복자를 사용하면 계속 hasNext호출해야해서 코드도 복잡하고 효율도 별로.
 * 람다식과 스트림이 코드만 간단해지는게 아니라 효율도 훨 좋음.
 */
//		List<Integer> list = (List)Arrays.asList(10,20,30,40,50);
//		Iterator<Integer> iterator = list.iterator();
//		
//		while(iterator.hasNext()) {
//			Integer value = iterator.next();
//			System.out.print(value + " ");
//		}
	
		/*
		 * 자바8의 람다식과 스트림(내부 반복자)를 적용하여 코딩.
		 * [결론] Stream 내부 반복자는 컬렉션 내부에서 요소들을 반복시키고,
		 * 개발자는 요소당 처리해야 할 코드만 제공하는 코드 패턴을 말한다
		 */
		
		List<Integer> list = (List)Arrays.asList(10,20,30,40,50);
		Stream<Integer> stream = list.stream();
		
		stream.forEach(value -> System.out.print(value +" "));
		
		
		
	}

}
