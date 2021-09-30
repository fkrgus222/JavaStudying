package 모델;

public class GOLDCustomer extends Customer{
	
	protected int discountRate;
	
	GOLDCustomer(int userID, String userName){
		super(userID, userName,2, "GOLD");
		this.discountRate = 10;
	}
	
	public void pay(int price) {
		String target = Utils.toNumberFormat( (int)(price/100*(100-discountRate)) );
		System.out.println(userName + "님이 지불할 "+price + "의 가격은 : " + target + " 입니다.");
		bonusPoint += (int)(price/100*(100-discountRate))/100*bonusRate;
	}

	public void show() {
		super.show();
		System.out.println("사용자의 할인율은  : " + discountRate);
	}
	
}
