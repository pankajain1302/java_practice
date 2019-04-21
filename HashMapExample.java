package collections;

import java.util.*;
import java.util.Map.Entry;

public class HashMapExample {
	public static void main(String[] args){
		HashMap<Integer,String> map = new HashMap<>();
		String ret = map.put(13,"Pankaj");
		ret = map.put(14,"Ank");
		ret = map.put(13,"Arun");
		map.put(1,"one");
		map.put(90,"ninety");
		
		//Sorting based on key
		TreeMap<Integer, String> tree = new TreeMap(map);
		System.out.println(tree);
		
		//Based on values
		Set<Entry<Integer,String>> entrySet = map.entrySet();
		List<Entry<Integer,String>> list = new ArrayList(entrySet);
		Collections.sort(list, new Comparator<Entry<Integer, String>>(){
			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2){
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		for(Entry<Integer, String> foo: list){
			System.out.println(foo);
		}
		
		
		
	}
}
