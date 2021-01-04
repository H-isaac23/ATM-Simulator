/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingappsimulation;
import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author ISAAC
 */
public class BankingAppSimulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner cs = new Scanner(System.in);
        System.out.print("Please tell us your name: ");
        String name = cs.next();
        System.out.println();
        
        BankAccount bank = new BankAccount(name, "001122");
        bank.show_menu();
        
    }
}

class BankAccount{
    
    int balance = 0;
    int prev_transaction;
    String acct_name;
    String acct_id;
    
    BankAccount(String name, String id){
        acct_name = name;
        acct_id = id;
    }
    
    void deposit(int amount){
        balance += amount;
        prev_transaction = amount;
    }
    
    void withdraw(int amount){
        balance -= amount;
        prev_transaction = -amount;
    }
    
    void show_options(){
        System.out.printf("Welcome to a bank app simulation, %s!\n", acct_name);
        System.out.printf("Your account ID: %s\n", acct_id);
        System.out.println("");
        System.out.println("What would you like to do?");
        System.out.println("[A] Balance");
        System.out.println("[B] Withdraw");
        System.out.println("[C] Deposit");
        System.out.println("[D] Get Previous Transaction");
        System.out.println("[E] Quit");
    }
    
    void show_menu(){
        
        char option = '\0';
        Scanner cs = new Scanner(System.in);
        
        show_options();
        
        while(option !='E'){
           
            System.out.print("Enter an option(Enter 'H' for the options.): ");
            option = cs.next().charAt(0);

            switch(option){
                case 'A':
                    System.out.println("Current balance: " +balance);
                    break;
                case 'B':
                    System.out.print("Put the amount you want to withdraw: ");
                    int withdrawal_amt = cs.nextInt();
                    if(withdrawal_amt > balance){
                        System.out.println("Sorry, you do not have enough balance to make that much withdrawals.");
                    }else{
                        withdraw(withdrawal_amt);
                    }
                    break;
                case 'C':
                    System.out.print("Put the amount you want to deposit: ");
                    int deposit = cs.nextInt();
                    deposit(deposit);
                    break;
                case 'D':
                    if(prev_transaction > 0){
                        System.out.println("Deposited: "+prev_transaction);
                        prev_transaction = 0;
                    }else if(prev_transaction < 0){
                        System.out.println("Withdrawn: " + Math.abs(prev_transaction));
                    }else{
                        System.out.println("You haven't had any transaction in the last options.");
                    }
                    break;
                case 'E':
                    System.out.println("Quitting the program...");
                    break;
                case 'H':
                    show_options();
                    break;
                default:
                    System.out.println("Your choice was not within the available options.");
                    System.out.println("Possible error: Your input might not have been capitalized.");
                    System.out.println("Terminating the program...");
                    System.exit(1);
           }
            System.out.println();
        }
        
        System.out.print("Thanks for using the app!");
    }
    
}