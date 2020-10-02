package ovn1.del2;

import ovn1.del2.Hund.Humör;

public class Main {

	public static void main(String[] args) {
		
		Hund milo = new Hund("Milo", Humör.KISSNÖDIG,"TinTin");
		
		System.out.println(milo);
		
		milo.äta();
		
		System.out.println(milo);

	}

}
