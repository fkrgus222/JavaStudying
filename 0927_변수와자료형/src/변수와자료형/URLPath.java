package 변수와자료형;

public class URLPath {

	public static void main(String[] args) {

		String url = "http://localhost:8080/Model2_Board/login.do";
		
		System.out.println(url.lastIndexOf('/'));
		String filepath = url.substring(url.lastIndexOf('/')+1);
		
		System.out.println(filepath);
		
		
		

	}

}
