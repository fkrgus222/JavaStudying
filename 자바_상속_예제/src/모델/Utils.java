package 모델;

import java.text.DecimalFormat;

public class Utils {
	/*
	 * 입력 받은 금액이 천 단위 마다 꼼마 넣기 함수 구현 
	*/
	public static String toNumberFormat(int totalAmount) {
		
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(totalAmount);
		
	}
	
	
}
