package 모델;

import java.util.Random;

public class VIPCustomer extends Customer{
	
	protected int discountRate;
	protected int agentID; // 상담 직원 ID	
	
	VIPCustomer(int userID, String userName, int agentID){
		super(userID, userName, 5);
		this.discountRate = 10;
		this.agentID = agentID;
	}
	
	public void pay(int price) {
		System.out.println(price + "의 가격은 : " + (int)(price*0.9) + " 입니다.");
		bonusPoint += price/100*bonusRate;
	}
	
	public void show() {
		super.show();
		System.out.println("사용자의 할인율은  : " + discountRate);
		System.out.println("상담직원의 ID : " + agentID);
	}
	
	public void getAgentId() {
		System.out.println("상담직원의 ID는 : " + agentID);
	}
}
