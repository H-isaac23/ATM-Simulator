/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingappsimulation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author ISAAC
 */
public class bankGUI extends JFrame implements ActionListener {
    
    main_buttons bal_button, withdraw, prev_transac_button, deposit, quit;
	int balance = 0;
	
	public bankGUI(){
		
		int width = 700, height = 700;
		
		// set container for buttons
		JPanel button_cont = new JPanel();
		button_cont.setLayout(null);
		button_cont.setBackground(new Color(142, 228, 175)); 
		button_cont.setBounds(0, 100, 700, 600);
		
		JPanel title = new JPanel();
		title.setBounds(20, 20, 200, 70);
		title.setBackground(new Color(5, 56, 107));
		title.setLayout(null);
		
		JLabel label = new JLabel();
		label.setBounds(30, 0, 170, 70);
		label.setFont(new Font("Arial", Font.BOLD, 24));
		label.setForeground(new Color (255, 255, 255));
		label.setText("Test Bank");
                
                
		// buttons
		bal_button = new main_buttons(100, 50, 300, 100, "Balance");
		withdraw = new main_buttons(100, 50, 300, 175, "Withdraw");
		deposit = new main_buttons(100, 50, 300, 250, "Deposit");
		
		prev_transac_button = new main_buttons(100, 50, 300, 325, "Transaction");
		prev_transac_button.setFont(new Font("Arial", Font.BOLD, 11));
		
		quit = new main_buttons(100, 40, 300, 400, "Quit");
		
                // Adds action listener
                bal_button.addActionListener(this);
                withdraw.addActionListener(this);
                deposit.addActionListener(this);
                prev_transac_button.addActionListener(this);
                quit.addActionListener(this);
                
		// set window display settings
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(width, height);
		this.getContentPane().setBackground(new Color(92, 219, 149)); 
		this.setVisible(true);
		this.setTitle("Banking App Simulation");
		
		this.add(button_cont);
		this.add(title);
		title.add(label);
		button_cont.add(withdraw);
		button_cont.add(bal_button);
		button_cont.add(deposit);
		button_cont.add(prev_transac_button);
		button_cont.add(quit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bal_button) {
			System.out.println("HIIIIIIIIIIIIII");
		}
	}
}

class main_buttons extends JButton{
	
	int width;
	int height;
	int x_pos;
	int y_pos;
	String button_text;
	
	public main_buttons(int width, int height, int x_pos, int y_pos, String button_text) {
		this.button_text = button_text;
		this.width = width;
		this.height = height;
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		
		this.setBounds(x_pos, y_pos, width, height);
		this.setBackground(new Color(55, 150, 131));
		this.setForeground(new Color(237, 245, 225));
		this.setText(button_text);
		this.setFocusable(false);
		
	}
    
}
