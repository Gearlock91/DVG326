package lekstugan;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
		
		String hold = JOptionPane.showInputDialog("Set a int");
		
		if(hold != null) {
			Integer.parseInt(hold);
		}
	}

}
