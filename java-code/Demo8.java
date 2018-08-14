import java.util.*;
import java.util.stream.*;

public class Demo8{
	public static void main(String arg[])
	{
		List<String> data = new ArrayList<>();
		data.add("Mahendra");
		data.add("Devendra");
		data.add("Surendra");
		data.add("Akon");
		data.add("Bkon");
		data.add("Ckon");
		List<String> d1 = FilterOld(data, "endra");
		List<String> d2 = FilterWithStream(data, "kon");

		System.out.println("Data from Old Filter");
		System.out.println(d1);

		System.out.println("Data from New Filter");
		System.out.println(d2);

					
	}
	
	static List<String>  FilterOld(List<String> data, String pattern)
	{
		List<String> temp = new ArrayList<>();
		for(String s :data){
			if(s.endsWith(pattern)){
				temp.add(s);
			}
		} 
		return temp;	
	}
	static List<String> FilterWithStream(List<String> data, String pattern)
	{
		return data.stream().filter((s)->s.endsWith(pattern))
		.collect(Collectors.toCollection(ArrayList::new));		
	}	

}