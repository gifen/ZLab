package com.nefig.lab.general;

import java.util.HashMap;

public class MapTest {

	HashMap<Person, Integer> map = new  HashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MapTest().test();
		
	}
	
	public void test(){
		Person p1 = new Person("a", "b");
		Person p2 = new Person("b", "a");
		
		map.put(p1, 1);
		map.put(p2, 2);
		
		System.out.println(map.size());
		System.out.println(map.get(p1));

		System.out.println(map.get(p2));
		System.out.println(p1.hashCode()+","+p2.hashCode());
	}
		
	
	class Person{
		String name;
		String lastname;
		
		public Person(String s1, String s2){
			name = s1;
			lastname = s1;
		}

		@Override
		public int hashCode() {
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
			Person other = (Person) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (lastname == null) {
				if (other.lastname != null)
					return false;
			} else if (!lastname.equals(other.lastname))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private MapTest getOuterType() {
			return MapTest.this;
		}
		
		
	}

}
