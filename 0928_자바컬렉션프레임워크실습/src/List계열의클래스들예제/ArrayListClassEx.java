package List계열의클래스들예제;

import java.util.List;
import java.util.ArrayList;

public class ArrayListClassEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		
		//객체 추가
		list.add(new Integer(90));  // 정수 90을 객체화 시킴! list.add(90) 이것도됨. --> 자동 파싱 ( 자동으로 객체화)
		list.add(new Integer(85));
		list.add(new Integer(100));
		list.add(new Integer(70));
		list.add(new Integer(75));
		
		System.out.println(list);
		//[90,85,100,70,75]
		
		list.add(2,60);
		System.out.println(list);
		//[90,85,60,100,70,75]
		
		
		
		
	}

}
