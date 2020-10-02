package alarmKlocka.lab3.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;

import alarmKlocka.lab2.clock.AlarmClockType;

public class DrawDigitalClock extends JPanel implements ClockTabLayouts{
	private static final long serialVersionUID = 1L;

	private AlarmClockType clock;
	
	public DrawDigitalClock(AlarmClockType clock) {
		this.clock = clock;
		this.setBackground(Color.black);
	}
	
	public void paintClock() {
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int y = getHeight() /2;
		
		g.setColor(Color.red);
		g.setFont(new Font("TimesRoman", Font.PLAIN,  30)); // Tagen utifrån exemplet http://www.java2s.com/Tutorials/Java/java.awt/Graphics/Java_Graphics_setFont_Font_font_.htm 
		g.drawString(new SimpleDateFormat("YYYY-MM-dd").format(new Date(System.currentTimeMillis())).toString(),110,y);
		g.drawString(clock.getTime().toString(), 108, y - 40);
	}
	
}
