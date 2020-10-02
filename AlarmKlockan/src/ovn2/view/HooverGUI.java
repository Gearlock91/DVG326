package ovn2.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ovn2.hoover.Hoover;

public class HooverGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private Hoover hoover;
	
	public HooverGUI(Hoover hoover) {
		super("Hoover game");
		this.hoover = hoover;
		setSize(800,800);
		setVisible(true);
		this.add(createPanel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JPanel createPanel() {
		JPanel 	borderPanel = new JPanel(new BorderLayout());
		MoveHooverView mHoover = new MoveHooverView(hoover);
		
		borderPanel.add( new GamePlanView(hoover) 	  , BorderLayout.CENTER);
		borderPanel.add( new JButton("North  Button") , BorderLayout.NORTH);
		borderPanel.add( mHoover	  				  , BorderLayout.SOUTH);
		
		return borderPanel;
	}

}
