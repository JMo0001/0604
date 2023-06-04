package ingeritance;

public class OverrideingTest1 {
	public static void main(String[] args) {
		Customer customerLee = new Customer(0, null);
		customerLee.setCustomerID(10010);
		customerLee.setCustomerName("이순신");
		customerLee.bonusPoint = 1000;
		System.out.println(customerLee.showCustomerInfo());
		
		VIPCustomer customerKim = new VIPCustomer(0, null, 0);
		customerKim.setCustomerID(10020);
		customerKim.setCustomerName("김유신");
		customerKim.bonusPoint = 10000;
		System.out.println(customerKim.showCustomerInfo());
		
		int price = 10000;
		System.out.println(customerLee.getCustomerName()+" 님이 지불해야 하는 금액은 "
				+customerLee.calcPrice(price)+"원입니다.");
		System.out.println(customerKim.getCustomerName()+" 님이 지불해야 하는 금액은 "
				+customerKim.calcPrice(price)+"원입니다.");

	}

}
