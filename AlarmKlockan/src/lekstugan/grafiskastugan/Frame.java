package lekstugan.grafiskastugan;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;

	public Frame() {

		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(panel());
	}
	
	public JPanel panel() {
		
		Object obj = new Object();
		
		JPanel pan = new JPanel();
		pan.setBackground(Color.black);
		
		pan.add(obj);
		return pan;
	}

}
