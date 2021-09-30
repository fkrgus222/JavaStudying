package 모델;

public class VIPCustomer extends Customer{
	
	protected int discountRate;
	protected int agentID; // 상담 직원 ID	
	
	VIPCustomer(int userID, String userName, int agentID){
		super(userID, userName, 5,"VIP");
		this.discountRate = 10;
		this.agentID = agentID;
	}
	
	public void pay(int price) {
		String target = Utils.toNumberFormat( (int)(price/100*(100-discountRate)) );
		System.out.println(userName + "님이 지불할 "+price + "의 가격은 : " + target + " 입니다.");
		bonusPoint +=  (int)(price/100*(100-discountRate))/100*bonusRate;
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
