package 모델;

public class Customer {
	
	protected int userID;
	protected String userName;
	protected int bonusPoint;
	protected int bonusRate;
	protected String customerGrade;
	
	Customer(){ }
	Customer(int userID, String userName){
		this.userID = userID;
		this.userName = userName;
		this.bonusPoint = 0;
		this.bonusRate = 1;
		this.customerGrade = "GENERAL";
	}
	
	Customer(int userID, String userName, int bonusRate, String customerGrade){
		this.userID = userID;
		this.userName = userName;
		this.bonusPoint = 0;
		this.bonusRate = bonusRate;
		this.customerGrade = customerGrade;
	}
	
	public void pay(int price){
		System.out.println(userName +"님이 지불할 " + price + "의 가격은 : " + Utils.toNumberFormat(price) + " 입니다.");
		bonusPoint += price/100*bonusRate;
	}
	
	public void show() {
		System.out.println("===========================");
		System.out.println("사용자 ID는 : " + userID);
		System.out.println("사용자 이름은 : " + userName);
		System.out.println("사용자 등급은: " + customerGrade);
		System.out.println("사용자가 보유한 보너스 포인트는 : " + bonusPoint);
	
	
	
	}
}
