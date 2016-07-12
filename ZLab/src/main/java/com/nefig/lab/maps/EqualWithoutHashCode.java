package com.nefig.lab.maps;

import java.util.HashMap;
import java.util.Map;

public class EqualWithoutHashCode {
	
	private Map<TempObject, String> map = new HashMap<>();	
	TempObject t1 = new TempObject("1","2");
	TempObject t2 = new TempObject("1","2");
	TempObject t3 = new TempObject("1","2");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new EqualWithoutHashCode().putHashMap();
	}
	
	public void putHashMap(){
		map.put(t1, "one");
		map.put(t2, "two");

		TempObject t3 = new TempObject("1","2");
		map.put(t3, "three");
		printHashMap();
		
	}
	
	public void printHashMap(){
		System.out.println("Map content count = " +map.size());
		System.out.println("T1 content - "+ map.get(t1));
		System.out.println("T2 content - "+ map.get(t2));
		System.out.println("T3 content - "+ map.get(t3));
	}

}

class TempObject{
	
	private String key1;
	private String key2;
	public TempObject(String k1, String k2){
		key1= k1;
		key2=k2;
	}
	
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	@Override
	public int hashCode(){
		//return super.hashCode();
		return 1;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempObject other = (TempObject) obj;
		if (key1 == null) {
			if (other.key1 != null)
				return false;
		} else if (!key1.equals(other.key1))
			return false;
		if (key2 == null) {
			if (other.key2 != null)
				return false;
		} else if (!key2.equals(other.key2))
			return false;
		return true;
	}
	
	
	
	
}