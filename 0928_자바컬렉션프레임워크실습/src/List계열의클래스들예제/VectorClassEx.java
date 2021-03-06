package List계열의클래스들예제;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
//Vector는 동기화된 메소드로 구성되어 잇기 때문에 멀티 스레드가 동시에 이 메소드들을 
//실행할 수 없고, 하나의 스레드가 실행을 완료해야만 다른 스레드들이 실행할 수 있다.
//그래서 멀티 스레드 환경에서안전하게 객체를 추가하고 삭제할 수 있다.

//스레드가 1개일때도동기화를 하기 때문에 ArrayList보다 성능이 떨어진다.

public class VectorClassEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] name = {"김진영","최인호","조정래","김흥신","박경리"};
		
	//Vector 객체 생성
		//List<String> list = new Vector<String>();  //기본이 10개인 가변 배열을 생성 (공간이 부족하면 10개씩 더 늘어남)
		List<String> list = new Vector<String>(4, 3);
		
		//Vector 클래스의 주요 메소드 적용
		System.out.println("백터에 저장된 요소의 개수: " + list.size());
			//  --> 0임, 공간만 확보한거라.
		System.out.println("백터의 용량은: " + ((Vector<String>)list).capacity() );
			//  --> 4임, 
		
		for (int i = 0 ; i <name.length ; i++ ){
			list.add(name[i]);
		}
	
		System.out.println("백터에 저장된 요소의 개수: " + list.size());
		System.out.println("백터의 용량은: " + ((Vector<String>)list).capacity() );
		//size도 웹 객체 검색에서 많이 쓰임.
		
		
		System.out.println(list);
		//[김진영, 최인호, 조정래, 김흥신, 박경리]
		
		list.add(2,"공지영");
		System.out.println(list);
		//[김진영, 최인호, 공지영, 조정해, 김흥신, 박경리]
		
	//객체 검색 get() 메소드, contains()
		//get은 index로 접근.
		//contains는 해당 문자열을 포함하는지. True, False를 반환
		System.out.println(list.get(1));
		//최인호
		
		boolean contains_result1 = list.contains("김흥신");
		System.out.println(contains_result1); // true
		
		boolean contains_result2 = list.contains("홍길동");
		System.out.println(contains_result2); // false
		
	//객체 변경 set()메소드
		//"공지영" 객체를 "이문열" 객체로 변경하고자 한다.
		list.set(2, "이문열");
		System.out.println(list);
		//[김진영, 최인호, 이문열, 조정래, 김흥신, 박경리]
		
		
		
	//객체 삭제 remove() 메소드
		list.remove(3);
		System.out.println(list);
		// [김진영, 최인호, 이문열, 김흥신,박경리]
		
		list.remove("김흥신");
		System.out.println(list);
		//[김진영, 최인호, 이문열, 박경리]
		
		System.out.println();//빈칸
	//객체 정렬
		//오름차순
		System.out.println("[객체 오름 차순 정렬]");
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println();  //빈칸
		//내림차순
		System.out.println("[객체 내림 차순 정렬]");
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
		
		
		
		
	}//end of main
}//end of class
