class Demo{

	public static void main(String arg[]){
		int var1 = 5;
		int var2 = 5;
		System.out.println(var1==var2);

		Integer nvar1 = new Integer(5);
		Integer nvar2 = new Integer(5);
		System.out.println(nvar1==nvar2);

		System.out.println(nvar1.equals(nvar2));

		System.out.println(nvar1.getClass());	
		System.out.println(nvar1.hashCode());
	}
}