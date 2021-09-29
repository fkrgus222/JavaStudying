package 모델;

public class Customer {
	
	protected int userID;
	protected String userName;
	protected int bonusPoint;
	protected int bonusRate;
	
	Customer(){ }
	Customer(int userID, String userName){
		this.userID = userID;
		this.userName = userName;
		this.bonusPoint = 0;
		this.bonusRate = 1;
	}
	
	Customer(int userID, String userName, int bonusRate){
		this.userID = userID;
		this.userName = userName;
		this.bonusPoint = 0;
		this.bonusRate = bonusRate;
	}
	
	public void pay(int price){
		System.out.println(price + "의 가격은 : " + price + " 입니다.");
		bonusPoint += price/100*bonusRate;
	}
	
	public void show() {
		System.out.println("사용자 ID는 : " + userID);
		System.out.println("사용자 이름은 : " + userName);
		System.out.println("사용자가 보유한 보너스 포인트는 : " + bonusPoint);
	}
	
	
}
