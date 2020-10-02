package ovn2.application;

import javax.swing.SwingUtilities;

import ovn2.hoover.Hoover;
import ovn2.view.HooverGUI;

public class HooverApp {

	public static void main(String[] args) {
		
		Hoover player = new Hoover();
		
		SwingUtilities.invokeLater(() -> new HooverGUI(player));
	}

}
