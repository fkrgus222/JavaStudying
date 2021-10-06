package 스트림응용예제;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
 * 회원(Member) 객체에서 '남자' 회원의 평균 나이를람다식과 스트림을 
 * 적용하여 프로그램 작성
 */
public class StreamPipelinesEx {

	public static void main(String[] args) {
		
		List<Member> list = (List)Arrays.asList(new Member("박태호",Member.MALE,  30), 
												new Member("김연경",Member.FEMALE,29),
												new Member("손유일",Member.MALE,  32),
												new Member("안재홍",Member.MALE,  27));
		
		double sum = 0;
		int count = 0;
		//[1방법] 외부 반복자를 적용하여 해결.남자회원의 평균나이 구하기 
		//use Iterator 혹은 for 
		
		//use Iterator
		Iterator<Member> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			Member target = iterator.next();
			if( target.getGender() == Member.MALE) {
				sum += (double)target.getAge();
				count += 1;
			}
		}
		
		System.out.println("남성의 평균 나이는 : " + sum/count);
		
		//use for
		for(int i = 0 ; i < list.size(); i ++) {
			if(list.get(i).getGender() == Member.MALE) {
				sum += list.get(i).getAge();
				count++;
			}
		}
		
		

		//[2방법] 내부 반복자를 적용하여 해결.
		//use Stream

		
		//내가 푼거 
//		int sum2 = 0;
//		int count2 = 0;
//		Stream<Member> stream = list.stream();
//		stream.forEach(target2 ->{
//			if(target2.getGender() == Member.MALE) {
//				sum2 += target2.getAge();
//				count2 += 1;
//			}
//		});
		
		//답안
		double ageAvg = list.stream()       //오리지날 스트림
							.filter(m -> m.getGender() == Member.MALE)  //중간 처리 스트림
							.mapToInt(Member::getAge)					//중간 처리 스트림
							.average()									//최종 처리 스트림
							.getAsDouble();								//

		System.out.println("남성의 평균 나이는 : " + ageAvg);
	
	
	}
}
