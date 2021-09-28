package 변수와자료형;

// 자바_변수의 사용범위 예제
// 변수는 선언된 블록 내에서만 사용이 가능하다.


public class VariableScopeEx {
	
	int var2;
	
	public static void main(String[] args) {
		int var1 = 20;
		
		if(var1 > 10) {
			int var2 = var1 - 10;
		}
		int var3 = var1 + 5;
	

		

	}

}
