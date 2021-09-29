package Map계열의클래스들예제;

import java.util.Enumeration;
import java.util.Properties;

/*
 * Properties 클래스는 주로 스프링 MVC 기반의 게시판 구현 시 사용
 * 스프링 환경 설정 파일 (applicationContext.xml) 생성할 때 주로 사용 
 */

public class PropertiesClassEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//객체 생성
		Properties prop = new Properties();
		
		//객체에 key 와 value 저장
		prop.setProperty("name", "박태호");
		prop.setProperty("email", "parkk345@naver.com");
		prop.setProperty("HP", "010-2315-1234");
		
		//객체 가져오기
		Enumeration enu = prop.propertyNames();
			//propertyNames = Returns an enumeration of all the keys in this property list, 
			//including distinct keys in the default property list if a key of the same name 
			//has not already been found from the main properties list.
		
		
		while(enu.hasMoreElements()) {
			String ele = (String) enu.nextElement();
			System.out.println(ele + " : " + prop.getProperty(ele));
		}
		
		
	}
}
