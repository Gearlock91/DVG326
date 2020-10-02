package ovn1.del1;


public class Tree {
	
	private int age;
	private String species; 
	
	/**
	 * Constructing a tree with the age and species
	 * 
	 * @author Andreas
	 * @age int
	 * @Species String
	 * */
	
	public Tree(int age, String species) {
		this.age = age;
		this.species = species;
	}
	
	public void setAge(int age) {
		if(0 <= age && age <= 100) 
			this.age = age;
		else {
			System.err.println("Not a valid age.");
		}
		
	}
	
	public int getAge() {
		return this.age;
	}

	public String getSpecies() {
		return this.species;
	}
	/**
	 * Increments the age of the tree by one.
	 * */
	public void ageing() {
		this.age++;
		System.out.println(species + ": I just aged!");
	}
	/**
	 * This method prints the value of age and species
	 * of the tree.
	 * */
	public void printTreeInformation() {
		System.out.println("Age of the tree " + age + " and its species is " + species);
	}

}