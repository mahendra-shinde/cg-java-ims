class Demo4{

	public static void main(String arg[]){
		Account ac1 = new SavingsAccount();
		SavingsAccount ac2 = new SavingsAccount();
		Object ac3 = new SavingsAccount();

		System.out.println(ac3 instanceof Account);
		System.out.println(ac1 instanceof SavingsAccount);
	}
}

abstract class Account{
	protected String name;
	protected String accNo;
	protected double balance;

}

class SavingsAccount extends Account{
	private double rateOfInterest;

}