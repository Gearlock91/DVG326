package lekstugan;

public class Person implements PersonType {
	
	private int    age;
	private int    TelNumber;
	protected String name;
	private String sex;
	
	
	public Person(int age, int telNumber, String name, String sex) {
		
		this.age	   = age;
		this.TelNumber = telNumber;
		this.name 	   = name;
		this.sex 	   = sex;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getSex() {
		// TODO Auto-generated method stub
		return sex;
	}

	@Override
	public int getTelNr() {
		// TODO Auto-generated method stub
		return TelNumber;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}
	
	public String toString() {
		return "Hey! My name is " + name;
	}

	
}
