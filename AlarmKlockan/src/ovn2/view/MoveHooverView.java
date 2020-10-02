package ovn2.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ovn2.hoover.Hoover;

public class MoveHooverView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public MoveHooverView(Hoover hoover) {
		add(this.southSide(hoover));
	}

	public JPanel southSide(Hoover hoover) {
		JPanel 	gridPanel	= new JPanel(new GridLayout(1,2));
		JButton mUp 	 	= new JButton("Move Up");
		JButton mDown		= new JButton("Move Down");
		
		mUp.addActionListener   (e -> hoover.moveHooverUp());
		mDown.addActionListener (e -> hoover.moveHooverDown());
		
		gridPanel.add(mUp);
		gridPanel.add(mDown);
		
		return gridPanel;
	}

}
