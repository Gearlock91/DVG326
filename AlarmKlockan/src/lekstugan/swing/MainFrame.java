package lekstugan.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WinHandler());
		this.setSize(400, 400);
		this.add(buildComponentlvl1());
		this.setLocationByPlatform(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("MyApp");
		
	}
	
	
	private JPanel buildComponentlvl1() {
		JPanel panel	= new JPanel();
		JTextField field = new JTextField();
		
		panel.setLayout(new BorderLayout());
		panel.add(field, BorderLayout.CENTER);
		panel.add(buildComponentlvl2(), BorderLayout.WEST);
		
		
		return panel;
	}
	
	private JPanel buildComponentlvl2() {
		JPanel panel     = new JPanel();
		JButton button   = new JButton("Klicka på mig!"); 
		
		panel.add(button);
		
		return panel;
	}
	
	class WinHandler extends WindowAdapter{
			
		public void windowClosing(WindowEvent e) {
			
			int exit = JOptionPane.showConfirmDialog(null, "Avsluta?", "Terminerar", JOptionPane.YES_NO_OPTION);
			
			if(exit == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		
	}

}
