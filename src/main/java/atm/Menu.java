/*
 */
package atm;
import static atm.Person.client;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author Vues
 */
public class Menu {
    
    public static String fName;
    private static String uPassword;
    private int counter=1;
    private int picked;
    private int picked2;
    private final boolean b = true;
    private boolean inLoop = true;
    
    public void mainMenu() throws SQLException, ClassNotFoundException{
        Person p = new Person();
        Balance bal = new Balance();
        Database db = new Database();
        
        //User options always active until terminated. 
        while(b == true){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" );
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" );
        System.out.println("Welcome Please Login or Register an Account");  
        System.out.println("Enter 1 to Register an Account");  
        System.out.println("Enter 2 to Login");
        System.out.println("Enter 3 Check All Clients in HashMap");
        System.out.println("Enter 4 Stop Program");
        db.connect();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" );
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" );
        Scanner s = new Scanner(System.in);
        picked = s.nextInt();
        fName = s.nextLine();
        
        
        //Avaiable options when picked based from above loop
        //If picked 1 called Person class and run name method.
        if(picked == 1){
            p.account();             
        }
        
        /*
        If picked 2, match entered username with server. If server has entered name
        user can choose to withdraw, deposit, or logout.
        */        
        else if(picked == 2){
            inLoop = true;
            System.out.println("Enter Your Username: ");
            fName = s.nextLine();
            System.out.println("Enter Your Password: ");
            uPassword = s.nextLine();
            
            for(Person nP:client){
                if(nP.getUsername().equals(fName)&&nP.getPassword().equals(uPassword)){
                    
                    
                    while(inLoop == true){
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" );
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" );
                    System.out.println("Welcome " + nP.getFirstName()+ " "+nP.getLastName());
                    System.out.printf("Current balance: $%.2f", nP.getBalance());
                    System.out.println("");
                    System.out.println("1. Withdraw ");
                    System.out.println("2. Deposit ");
                    System.out.println("3. Logout ");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" );
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" );
                    
                    picked2 = s.nextInt();
                
                    switch(picked2){
                        case 1:
                            //Allows user to withdraw
                            System.out.printf("Current balance: $%.2f", nP.getBalance());
                            bal.withdraw();
                            break;
                        case 2:
                            //Allows user to deposit
                            System.out.printf("Current balance: $%.2f", nP.getBalance());
                            bal.deposit();
                            break;
                        case 3:
                            //Set loop to false to go back to main menu
                            inLoop = false;
                            System.out.print("\n");
                            break;
                        }
             
                    }
                }
                
                else{
                    //If entered username doesnt match system. Display this message.
                    System.out.println("\nThe System can not find your account or incorrect password\n");
                }
            }
        }
            
        else if(picked == 3){
            //Shows current users in server.
            for(Person nP:client){
                System.out.println("\n"+"Client "+counter+"\n"+
                        "Username: " + nP.getUsername() +"\n" 
                        + "First Name: " + nP.getFirstName() +"\n" 
                        + "Last Name: " + nP.getLastName() +"\n" 
                        + "Password: " + nP.getPassword() +"\n" 
                        + "Card Number: " + nP.getCardNum());
                System.out.printf("Current balance: $%.2f", nP.getBalance());
                System.out.println("\n");
                counter++;
            }
        }
        
        else if(picked == 4){
            //Terminate program.
            System.exit(0);
        }
        }
    }
}
