@FunctionalInterface
interface MaxFinder{
	int maximum(int num1, int num2);
}
//Without Lambda Expressions and Function Interfaces
class MaxFinderImpl implements MaxFinder{
	public int maximum(int num1, int num2)
	{
		if(num1>num2)
		return num1;
		else
		return num2;
	}

}
class Demo6{
	public static void main(String arg[])
	{
		//Before Lambda expressions
		MaxFinder finder = new MaxFinderImpl();
		int n = finder.maximum(10,12);

		//After Lambda expression
		MaxFinder finder2 = (n1,n2)->{if(n1>n2) return n1; 
						else
						return n2;};
		int k = finder2.maximum(10,12);		


		System.out.println("Before Lambda: "+n);
		System.out.println("After Lambda: "+k);
	}
}