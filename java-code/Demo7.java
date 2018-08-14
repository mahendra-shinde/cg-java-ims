class Demo7{
	public static void main(String arg[])
	{
		//Check if number id ODD
		Predicate<Integer> isOdd = (n)-> n%2!=0 ;
		//Check if Password has min 8 characters
		Predicate<String> isStrongPass = (pass) -> {
						pass.trim().length>8
							}

		System.out.println(isOdd.test(17));
		System.out.println(isStrongPass.test("IDontRememberIt");
		

		
	}
}