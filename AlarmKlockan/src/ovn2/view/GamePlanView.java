package ovn2.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;

import ovn2.hoover.Hoover;

import javax.swing.JPanel;

public class GamePlanView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Hoover hoover;
	private int delay = 100;
	
	public GamePlanView(Hoover hoover) {
		this.hoover = hoover;
		setBackground(Color.black);
		
		
		Timer timer = new Timer(delay, e -> {
				hoover.moveHooverRight();
				repaint();
			});
		
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		hoover.setxMax(width);
		g.setColor(Color.white);
		g.draw3DRect(hoover.getPosition().getxPos(), hoover.getPosition().getyPos(), 10, 10, true);
	}

}
