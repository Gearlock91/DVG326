package ovn1.del1;

public class Main {
	
		public static void main(String[] args) {

		Tree first_tree = new Tree(11, "Björk");
		Tree second_tree = new Tree(1,"Asp");
		
		first_tree.printTreeInformation();
		second_tree.printTreeInformation();
		
		first_tree.ageing();
		second_tree.ageing();
		
		System.out.println("Björks ålder: " + first_tree.getAge());
		System.out.println("Björks ålder: " + first_tree.getAge());
		
		first_tree.setAge(50);
		
		System.out.println(first_tree.getSpecies() + " ålder: " + first_tree.getAge());
		
	}

}
