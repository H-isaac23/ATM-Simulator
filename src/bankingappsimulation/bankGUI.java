/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingappsimulation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author ISAAC
 */
public class bankGUI extends JFrame implements ActionListener {
    
    public ArrayList<String> field = new ArrayList<String>();
    main_buttons bal_button, withdraw, prev_transac_button, deposit, quit, back;
    JTextField curr_bal;
    JLabel curr_bal_label;
    Double balance = 0.00;
    keypad_deposit pad;
	
    public bankGUI(){

        int width = 700, height = 700;
		
        // set container for buttons
        JPanel button_cont = new JPanel();
        button_cont.setLayout(null);
        button_cont.setBackground(new Color(142, 228, 175)); 
        button_cont.setBounds(0, 100, 700, 600);

        // set panel for title
        JPanel title = new JPanel();
        title.setBounds(20, 20, 200, 70);
        title.setBackground(new Color(5, 56, 107));
        title.setLayout(null);

        // set label for the bank name
        JLabel label = new JLabel();
        label.setBounds(30, 0, 170, 70);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(new Color (255, 255, 255));
        label.setText("Test Bank");

        // make instance of main_buttons called bal_button
        bal_button = new main_buttons(100, 50, 300, 100, "Balance");
        bal_button.addActionListener(this);

        // make instance of main_buttons called withdraw
        withdraw = new main_buttons(100, 50, 300, 175, "Withdraw");
        withdraw.addActionListener(this);

        // make instance of main_buttons called deposit
        deposit = new main_buttons(100, 50, 300, 250, "Deposit");
        deposit.addActionListener(this);

        // make instance of main_buttons for previous transactions
        prev_transac_button = new main_buttons(100, 50, 300, 325, "Transaction");
        prev_transac_button.setFont(new Font("Arial", Font.BOLD, 11));
        prev_transac_button.addActionListener(this);

        // make instance of main_buttons called quit
        quit = new main_buttons(100, 40, 300, 400, "Quit");
        quit.addActionListener(this);

        // make a button for the back button
        back = new main_buttons(100, 50, 50, 400, "Back");
        back.addActionListener(this);
        back.setVisible(false);

        // make a text field for the current balance
        curr_bal_label = new JLabel();
        curr_bal_label.setText("Current Balance:");
        curr_bal_label.setBounds(50, 50, 200, 50);
        curr_bal_label.setVisible(false);
        curr_bal_label.setFont(new Font("Arial", Font.BOLD, 15));
        curr_bal = new JTextField();
        curr_bal.setEditable(false);
        curr_bal.setBounds(50, 100, 300, 75);
        curr_bal.setVisible(false);
        curr_bal.setText("Php " + String.format("%.2f", balance));
        curr_bal.setFont(new Font("Arial", Font.PLAIN, 20));

        // make a j-panel for depositing
        pad = new keypad_deposit(field);
        pad.setVisible(false);


        // set window display settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(width, height);
        this.getContentPane().setBackground(new Color(92, 219, 149)); 
        this.setVisible(true);
        this.setTitle("ATM Simulation");

        // add components to frame
        this.add(button_cont);
        this.add(title);
        title.add(label);
        button_cont.add(withdraw);
        button_cont.add(bal_button);
        button_cont.add(deposit);
        button_cont.add(prev_transac_button);
        button_cont.add(quit);
        button_cont.add(curr_bal);
        button_cont.add(curr_bal_label);
        button_cont.add(back);
        button_cont.add(pad);
}

@Override
public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        bal_button.setVisible(false);
        withdraw.setVisible(false);
        deposit.setVisible(false);
        prev_transac_button.setVisible(false);
        quit.setVisible(false);
        back.setVisible(true);

        if(e.getSource() == bal_button) {
                curr_bal.setVisible(true);
                curr_bal_label.setVisible(true);
        }
        if(e.getSource() == back) {
                bal_button.setVisible(true);
                withdraw.setVisible(true);
                deposit.setVisible(true);
                prev_transac_button.setVisible(true);
                quit.setVisible(true);
                back.setVisible(false);
                curr_bal.setVisible(false);
                curr_bal_label.setVisible(false);
                pad.setVisible(false);
        }
        if(e.getSource() == quit) {
                dispose();
        }
        if(e.getSource() == deposit) {
                pad.setVisible(true);
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


class keypad_deposit extends JPanel implements ActionListener{
	
    String field_text = "";
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8 , btn9, btn0, point_btn, ok_btn;
    JTextField deposit_field;

    public keypad_deposit(ArrayList<String> field) {
        this.setLayout(null);
        this.setBounds(250, 100, 210, 300);

        deposit_field = new JTextField();
        deposit_field.setBounds(0, 0, 210, 60);
        deposit_field.setEditable(false);

        btn1 = new JButton();
        btn1.setText("1");
        btn1.setBounds(0, 60, 70, 60);
        btn2 = new JButton();
        btn2.setText("2");
        btn2.setBounds(70, 60, 70, 60);
        btn3 = new JButton();
        btn3.setText("3");
        btn3.setBounds(140, 60, 70, 60);
        btn4 = new JButton();
        btn4.setText("4");
        btn4.setBounds(0, 120, 70, 60);
        btn5 = new JButton();
        btn5.setText("5");
        btn5.setBounds(70, 120, 70, 60);
        btn6 = new JButton();
        btn6.setText("6");
        btn6.setBounds(140, 120, 70, 60);
        btn7 = new JButton();
        btn7.setText("7");
        btn7.setBounds(0, 180, 70, 60);
        btn8 = new JButton();
        btn8.setText("8");
        btn8.setBounds(70, 180, 70, 60);
        btn9 = new JButton();
        btn9.setText("9");
        btn9.setBounds(140, 180, 70, 60);
        btn0 = new JButton();
        btn0.setText("0");
        btn0.setBounds(0, 240, 70, 60);
        point_btn = new JButton();
        point_btn.setText(".");
        point_btn.setBounds(70, 240, 70, 60);
        ok_btn = new JButton();
        ok_btn.setBounds(140, 240, 70, 60);
        ok_btn.setText("OK");

        // add buttons
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);
        this.add(btn5);
        this.add(btn6);
        this.add(btn7);
        this.add(btn8);
        this.add(btn9);
        this.add(btn0);
        this.add(ok_btn);
        this.add(point_btn);
        this.add(deposit_field);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn1) {
                field_text += "1";
        }
        if(e.getSource() == btn2) {
                field_text += "2";
        }
        if(e.getSource() == btn3) {
                field_text += "3";
        }
        if(e.getSource() == btn4) {
                field_text += "4";
        }
        if(e.getSource() == btn5) {
                field_text += "5";
        }
        if(e.getSource() == btn6) {
                field_text += "6";
        }
        if(e.getSource() == btn7) {
                field_text += "7";
        }
        if(e.getSource() == btn8) {
                field_text += "8";
        }
        if(e.getSource() == btn9) {
                field_text += "9";
        }
        if(e.getSource() == btn0) {
                field_text += "0";
        }

    }
	
}
