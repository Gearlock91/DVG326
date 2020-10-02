package ovn1.del2;

public class Hund {
	
	private String namn;
	public enum Humör {GLAD, HUNGRIG, KISSNÖDIG};
	private Humör humör;
	private String husse;
	
	
	public Hund(String namn, Humör humör, String husse) {
	this.namn = namn;
	this.humör = humör;
	this.husse = husse;
	}
	
	public void äta() {
	humör = Humör.GLAD;
	}
	public void viftaPaSvansen() {
	System.out.print(namn + "viftar på svansen!");
	}
	
	public String getHusse() {
		return this.husse;
	}
	
	public String toString() {
		return "Hey! My name is: " + this.namn +" and I'm " + humör.toString().toLowerCase();
	}
	

}
