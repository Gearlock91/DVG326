package alarmKlocka.lab3.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;

import alarmKlocka.lab2.clock.AlarmClockType;

public class DrawAnalogClock extends JPanel implements ClockTabLayouts{

	private static final long serialVersionUID = 1L;
	
	private double threePiDivideByTwo = (3*Math.PI) / 2;
	
	private double secAngle;
	private double minAngle;
	private double hourAngle;
	
	private AlarmClockType clock;
	
	public DrawAnalogClock(AlarmClockType clock) {
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(150,150));	
		this.clock = clock;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		int width = getWidth();    
		int height = getHeight();    
		int x = width / 2;    
		int y = height / 2;
		
		
		g.setColor(Color.black);
		g.fillOval(0, 0, width, height);
		g.setColor(Color.red);
		g.setFont(new Font("TimesRoman", Font.PLAIN,  30));
		g.drawString(clock.getTime().toString().substring(0,3), 100, 195);
		g.drawString(new SimpleDateFormat("YYYY-MM-dd").format(new Date(System.currentTimeMillis())).toString(),110,250);
		g.setColor(Color.white);
		g.fillRect(x - 5, 0, 10, 40);
		g.fillRect(x - 5, 330, 10, 40);
		g.fillRect(0, y - 5, 40, 10);
		g.fillRect(340, y - 5, 40, 10);  
		
		drawHand(g, 0.5 ,  hourAngle, Color.white);
		drawHand(g, 0.75, minAngle, Color.white);
		drawHand(g, 1.00, secAngle, Color.red);
		
		
	}
	private void drawHand(Graphics g, double length, double vinkel, Color color) {
		int width = getWidth();    
		int height = getHeight();    
		int x = width / 2;    
		int y = height / 2;
		
		double cY = Math.sin(vinkel) * length;
		double cX = Math.cos(vinkel) * length;
		
		g.setColor(color);
		
		g.drawLine(x, y, x + (int) (cX * x), y + (int) (cY * y));
	}

	@Override
	public void reSuperPaint() {
		this.hourAngle  = threePiDivideByTwo + (2*Math.PI)/12 * clock.getTime().getHour();
		this.minAngle 	= threePiDivideByTwo + (2*Math.PI)/60 * clock.getTime().getMinute();
		this.secAngle 	= threePiDivideByTwo + (2*Math.PI)/60 * clock.getTime().getSecond();
		repaint();	
	}
	
	
}


