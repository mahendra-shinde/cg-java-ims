import java.util.*;

public class Demo5{
	public static void main(String arg[])
	{
		List<String> data = new ArrayList<>();
		data.add("Mahendra");
		data.add(10000);
		data.add("Devendra");
		data.add("Surendra");
		data.add("Mahendra");
		data.add("Narendra");
		data.add("Gajendra");
		data.add("Rajendra");
		data.add("Upendra");
		data.add("Amarendra");
		System.out.println("List Demo");		
		Iterator it = data.iterator();
		while(it.hasNext()){
		Object obj = it.next();
		System.out.println(obj);
		}
	System.out.println("Set Demo");
		Set data2 = new HashSet();
		data2.addAll(data);
		Iterator it2 = data2.iterator();
		while(it2.hasNext()){
		Object obj = it2.next();
		System.out.println(obj);
		}
		System.out.println("Size of List"+data.size());
		System.out.println("Size of Set"+data2.size());

	}
	

}