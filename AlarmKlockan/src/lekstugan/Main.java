package lekstugan;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		PersonType [] persons = new PersonType[4];
		
		List<PersonType> minLista = new ArrayList<PersonType>();
		
		minLista.add(new Person(22, 00000, "Max", "Female"));
		
		
		Person gun = new Person (10, 000, "Gunnar", "Male") {
			public String toString() {
				return "Hej mitt namn är " + name;
			}
		};
		
		gun.name = "Cesar";
		
		System.out.println(minLista.isEmpty());
		
		System.out.println(minLista.get(0));

	}

}
