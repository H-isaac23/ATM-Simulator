package bankingappsimulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bankGUI extends JFrame implements ActionListener {
	
    main_buttons bal_button, withdraw, prev_transac_button, deposit, quit, back;
    JTextField curr_bal, lt_status;
    JLabel curr_bal_label;
    keypad pad, w_pad;
    JPanel lt_panel;

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
        curr_bal.setText("Php " + String.format("%.2f", bal.amt));
        curr_bal.setFont(new Font("Arial", Font.PLAIN, 20));

        // make a j-panel for depositing
        pad = new keypad(this.back, "deposit");
        pad.setVisible(false);

        // make a j-panel for withdrawing
        w_pad = new keypad(this.back, "withdraw");
        w_pad.setVisible(false);

        // make a j-panel for the last previous transaction
        lt_panel = new JPanel();
        lt_panel.setBounds(250, 100, 200, 200);
        lt_panel.setVisible(false);
        lt_panel.setLayout(null);
        lt_panel.setBackground(new Color(92, 219, 149));
        JLabel lt_text = new JLabel();
        lt_text.setText("Previous Transaction:");
        lt_text.setBounds(10, 10, 150, 70);
        lt_text.setFont(new Font("Arial", Font.PLAIN, 15));
        lt_status = new JTextField();
        lt_status.setBounds(0, 100, 200, 60);
        lt_status.setFont(new Font("Arial", Font.PLAIN, 15));
        lt_status.setEditable(false);
        lt_panel.add(lt_text);
        lt_panel.add(lt_status);


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
        button_cont.add(w_pad);
        button_cont.add(lt_panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            
        bal_button.setVisible(false);
        withdraw.setVisible(false);
        deposit.setVisible(false);
        prev_transac_button.setVisible(false);
        quit.setVisible(false);
        back.setVisible(true);

        if(e.getSource() == bal_button) {
            String amt = String.format("%.2f", bal.amt);
            curr_bal.setText("Php " + amt);
            curr_bal.setVisible(true);
            curr_bal_label.setVisible(true);
        }
        if(e.getSource() == back) {

            pad.field_text = "";
            pad.deposit_field.setText(pad.field_text);
            pad.one_point = false;

            w_pad.field_text = "";
            w_pad.deposit_field.setText(w_pad.field_text);
            w_pad.one_point = false;
            w_pad.error_msg.setVisible(false);

            bal_button.setVisible(true);
            withdraw.setVisible(true);
            deposit.setVisible(true);
            prev_transac_button.setVisible(true);
            quit.setVisible(true);


            back.setVisible(false);
            curr_bal.setVisible(false);
            curr_bal_label.setVisible(false);
            pad.setVisible(false);
            w_pad.setVisible(false);
            lt_panel.setVisible(false);

            w_pad.btn0.setVisible(true);
            w_pad.btn9.setVisible(true);
            w_pad.btn8.setVisible(true);
            w_pad.btn7.setVisible(true);
            w_pad.btn6.setVisible(true);
            w_pad.btn5.setVisible(true);
            w_pad.btn4.setVisible(true);
            w_pad.btn3.setVisible(true);
            w_pad.btn2.setVisible(true);
            w_pad.btn1.setVisible(true);
            w_pad.ok_btn.setVisible(true);
            w_pad.point_btn.setVisible(true);
            w_pad.del_btn.setVisible(true);

            pad.btn0.setVisible(true);
            pad.btn9.setVisible(true);
            pad.btn8.setVisible(true);
            pad.btn7.setVisible(true);
            pad.btn6.setVisible(true);
            pad.btn5.setVisible(true);
            pad.btn4.setVisible(true);
            pad.btn3.setVisible(true);
            pad.btn2.setVisible(true);
            pad.btn1.setVisible(true);
            pad.ok_btn.setVisible(true);
            pad.point_btn.setVisible(true);
            pad.del_btn.setVisible(true);

        }
        if(e.getSource() == quit) {
            dispose();
        }
        if(e.getSource() == deposit) {
            pad.setVisible(true);
        }
        if(e.getSource() == withdraw) {
            w_pad.setVisible(true);
        }
        if(e.getSource() == prev_transac_button) {

            if(bal.prev_transac > 0) {
                    lt_status.setText("Deposited: Php " + String.format("%.2f", bal.prev_transac));
            }else if(bal.prev_transac < 0) {
                    lt_status.setText("Withdrawn: Php " + String.format("%.2f", -bal.prev_transac));
            }else {
                    lt_status.setText("No transactions done.");
            }
            lt_panel.setVisible(true);
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

class keypad extends JPanel implements ActionListener{
	
    String field_text = "";
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8 , btn9, btn0, point_btn, ok_btn;
    JButton yes_btn, no_btn, del_btn;
    JTextField deposit_field;
    JPanel error_msg;
    JLabel confirm;
    String type;
    main_buttons main;
    boolean one_point = false;

    public keypad(main_buttons main, String type) {
        this.setLayout(null);
        this.setBounds(250, 100, 210, 300);
        this.main = main;
        this.type = type;

        // error message for greater withdrawal amount than balance
        error_msg = new JPanel();
        error_msg.setBounds(0, 120, 210, 60);
        error_msg.setVisible(false);
        JLabel err_text1 = new JLabel();
        JLabel err_text2 = new JLabel();
        err_text1.setText("Error: The amount is");
        err_text1.setBounds(0, 0, 210, 30);
        err_text2.setText("higher than the balance.");
        err_text2.setBounds(0, 30, 210, 30);
        error_msg.add(err_text1);
        error_msg.add(err_text2);

        // make a text field for the input
        deposit_field = new JTextField();
        deposit_field.setBounds(0, 0, 140, 60);
        deposit_field.setText(field_text);
        deposit_field.setEditable(false);
        deposit_field.setFont(new Font("Arial", Font.BOLD, 15));

        // make a confirmation screen
        confirm = new JLabel();
        String prompt = "Do you wish to proceed?";
        confirm.setText(prompt);
        confirm.setVisible(false);
        confirm.setBounds(10, 80, 210, 60);

        // make buttons for the keypad
        btn1 = new JButton();
        btn1.setText("1");
        btn1.setBounds(0, 60, 70, 60);
        btn1.addActionListener(this);   
        btn2 = new JButton();
        btn2.setText("2");
        btn2.setBounds(70, 60, 70, 60);
        btn2.addActionListener(this);
        btn3 = new JButton();
        btn3.setText("3");
        btn3.setBounds(140, 60, 70, 60);
        btn3.addActionListener(this);
        btn4 = new JButton();
        btn4.setText("4");
        btn4.setBounds(0, 120, 70, 60);
        btn4.addActionListener(this);
        btn5 = new JButton();
        btn5.setText("5");
        btn5.setBounds(70, 120, 70, 60);
        btn5.addActionListener(this);
        btn6 = new JButton();
        btn6.setText("6");
        btn6.setBounds(140, 120, 70, 60);
        btn6.addActionListener(this);
        btn7 = new JButton();
        btn7.setText("7");
        btn7.setBounds(0, 180, 70, 60);
        btn7.addActionListener(this);
        btn8 = new JButton();
        btn8.setText("8");
        btn8.setBounds(70, 180, 70, 60);
        btn8.addActionListener(this);
        btn9 = new JButton();
        btn9.setText("9");
        btn9.setBounds(140, 180, 70, 60);
        btn9.addActionListener(this);
        btn0 = new JButton();
        btn0.setText("0");
        btn0.setBounds(0, 240, 70, 60);
        btn0.addActionListener(this);
        point_btn = new JButton();
        point_btn.setText(".");
        point_btn.setBounds(70, 240, 70, 60);
        point_btn.addActionListener(this);
        ok_btn = new JButton();
        ok_btn.setBounds(140, 240, 70, 60);
        ok_btn.setText("OK");
        ok_btn.addActionListener(this);
        yes_btn = new JButton();
        yes_btn.setText("Yes");
        yes_btn.setBounds(70, 160, 70, 60);
        yes_btn.setVisible(false);
        yes_btn.addActionListener(this);
        no_btn = new JButton();
        no_btn.setText("No");
        no_btn.setBounds(70, 230, 70, 60);
        no_btn.setVisible(false);
        no_btn.addActionListener(this);
        del_btn= new JButton();
        del_btn.setText("Del");
        del_btn.setBounds(140, 0, 70, 60);
        del_btn.addActionListener(this);

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
        this.add(yes_btn);
        this.add(no_btn);
        this.add(confirm);
        this.add(del_btn);
        this.add(error_msg);

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
            if(field_text.equals("")) {
                    field_text += "0";
            }
            else if(field_text.substring(0,1).equals("0")) {
                    if(field_text.length() > 1 && field_text.substring(1,2).equals(".")) {
                            field_text += "0";
                    }
            }else {
                    field_text += "0";
            }
        }
        if(e.getSource() == point_btn) {
            if(one_point == false && !field_text.equals("")) {
                field_text += ".";
                one_point = true;
            }
        }
        if(e.getSource() == ok_btn) {
            btn0.setVisible(false);
            btn9.setVisible(false);
            btn8.setVisible(false);
            btn7.setVisible(false);
            btn6.setVisible(false);
            btn5.setVisible(false);
            btn4.setVisible(false);
            btn3.setVisible(false);
            btn2.setVisible(false);
            btn1.setVisible(false);
            ok_btn.setVisible(false);
            point_btn.setVisible(false);
            del_btn.setVisible(false);
            main.setVisible(false);

            Double amt = Double.parseDouble(field_text);

            if(type.equals("withdraw")) {
                    if(amt <= bal.amt) {
                            yes_btn.setVisible(true);
                            no_btn.setVisible(true);
                            confirm.setVisible(true);
                    }else{
                            error_msg.setVisible(true);
                            main.setVisible(true);
                    }
            }else {
                    yes_btn.setVisible(true);
                    no_btn.setVisible(true);
                    confirm.setVisible(true);
            }
        }
        if(e.getSource() == del_btn) {
            if(!field_text.equals("")) {
                if(field_text.substring(field_text.length()-1).equals(".")) {
                        one_point = false;
                }
                field_text = field_text.substring(0, field_text.length()-1);
            }else {
                field_text = "";
            }
        }
        if(e.getSource() == yes_btn) {

//			btn0.setVisible(true);
//			btn9.setVisible(true);
//			btn8.setVisible(true);
//			btn7.setVisible(true);
//			btn6.setVisible(true);
//			btn5.setVisible(true);
//			btn4.setVisible(true);
//			btn3.setVisible(true);
//			btn2.setVisible(true);
//			btn1.setVisible(true);
//			ok_btn.setVisible(true);
//			point_btn.setVisible(true);
//			del_btn.setVisible(true);
//			
            yes_btn.setVisible(false);
            no_btn.setVisible(false);
            confirm.setVisible(false);

            Double amt = Double.parseDouble(field_text);

            if(type.equals("deposit")) {
                    bal.amt += amt;
                    bal.prev_transac = amt;
            }else if(type.equals("withdraw")) {
                    bal.amt -= amt;
                    bal.prev_transac = -amt;
            }

            one_point = false;
            main.doClick();
        }
        if(e.getSource() == no_btn) {
            btn0.setVisible(true);
            btn9.setVisible(true);
            btn8.setVisible(true);
            btn7.setVisible(true);
            btn6.setVisible(true);
            btn5.setVisible(true);
            btn4.setVisible(true);
            btn3.setVisible(true);
            btn2.setVisible(true);
            btn1.setVisible(true);
            ok_btn.setVisible(true);
            point_btn.setVisible(true);
            del_btn.setVisible(true);
            main.setVisible(true); //checkpoint

            yes_btn.setVisible(false);
            no_btn.setVisible(false);
            confirm.setVisible(false);
        }

        deposit_field.setText(field_text);
    }
	
}

class bal{
	
	public static Double amt = 0.0;
	public static Double prev_transac = 0.0;

}

