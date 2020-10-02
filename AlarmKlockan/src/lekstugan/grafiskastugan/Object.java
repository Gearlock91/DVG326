package lekstugan.grafiskastugan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Object extends JPanel{
	private static final long serialVersionUID = 1L;

	public Object() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
	
		g2.fillOval(100, 100, 300, 300);
	}
}
