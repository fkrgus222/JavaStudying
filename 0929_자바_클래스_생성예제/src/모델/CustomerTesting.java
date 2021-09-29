package ¸ðµ¨;

public class CustomerTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer customer1 = new Customer(1,"lee");
		Customer customer2 = new GOLDCustomer(2,"Choi");
		Customer customer3 = new VIPCustomer(3,"KIM",5689);
		
		customer1.pay(1500);
		customer2.pay(1500);
		customer3.pay(1500);
		
		customer1.show();
		customer2.show();
		customer3.show();

	}
}
