package 모델;

public class GOLDCustomer extends Customer{
	
	protected int discountRate;
	
	GOLDCustomer(int userID, String userName){
		super(userID, userName,2);
		this.discountRate = 10;
	}
	
	public void pay(int price) {
		System.out.println(price + "의 가격은 : " + (int)(price*0.9) + " 입니다.");
		bonusPoint += price/100*bonusRate;
	}

	public void show() {
		super.show();
		System.out.println("사용자의 할인율은  : " + discountRate);
	}
	
}
