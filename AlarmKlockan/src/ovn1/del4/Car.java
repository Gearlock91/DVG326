package ovn1.del4;

public class Car {

	private String color;
	
	public Car() {
		
	}
	
	public  Car(String color) {
		this.color = color;
	}
	
	public  String getColor() {
		if(color==null) {
			System.out.println("The color has not been set yet");
		}
		
		return color;
	}
	
}
