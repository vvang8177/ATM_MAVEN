/*
 */
package atm;

import static atm.Menu.fName;
import static atm.Person.client;
import java.util.Scanner;

/**
 *
 * @author Vues
 */
public class Balance {
    
    private float currentBalance;
    private float newBalance;
    private float withdrawAmount;
    private float depositAmount;
    Scanner s = new Scanner(System.in);

    //User can withdraw from their account
    public void withdraw(){
        
        for(Person nP:client){
            if(nP.getUsername().equals(fName)){
                try{
                    
                    //get current balance
                    currentBalance =  nP.getBalance();
        
                    //Ask withdraw amount
                    System.out.println("\nEnter withdraw amount: ");
                    withdrawAmount = s.nextFloat();
                    
                    /*
                    if statement for if balance is less than requested withdraw amount
                    show text. If balance is greater then withdraw amount requested.
                    */
                    if(currentBalance <withdrawAmount){                    
                        System.out.println("Not enough fund");
                    }
                }catch(NumberFormatException e){
                        System.out.println("No letters, numbers only");
                    }
            }
            else if( currentBalance >= withdrawAmount){
                    
                    newBalance = currentBalance - withdrawAmount;
                    nP.setBalance(newBalance); 
                    System.out.print("Withdrew Successfully" + "\n");
                }
        }
    }
    
    
    //User can deposit to their accont
    public void deposit(){
        
        for(Person nP:client){
            if(nP.getUsername().equals(fName)){
                try{
            
                    //get current balance
                    currentBalance =  nP.getBalance();
            
                    //request deposit amount
                    System.out.println("\nEnter deposit amount: ");
                    depositAmount = s.nextFloat();
            
                    //add current balance and requested deposit amount
                    newBalance = currentBalance + depositAmount;
            
                    //store new added balance to correct user.
                    nP.setBalance(newBalance); 
            
                    System.out.print("Deposit Successfully" + "\n");
                }
            
                //allow numbers only
                catch(NumberFormatException e){
                System.out.println("No letters, numbers only");
                }
            }
        }
    }
}
  