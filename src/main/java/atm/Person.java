/*
 */
package atm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vues
 */
public class Person {
    
    public static ArrayList<Person> client = new ArrayList<Person>();
    private String username;
    private float iDeposit;
    private String firstName;
    private String lastName;
    private int cardNum;
    private int cc;
    private float balance;
    private String password;
        
    public Person(){}
        
    public Person(String uName, 
            String fName, 
            String lName,
            String cPassword,
            int cNum, 
            float cbalance){
        username=uName;
        firstName=fName;
        lastName=lName;
        cardNum=cNum;
        balance=cbalance;
        password=cPassword;
    }
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setusername(String username) {
        this.username = username;
    }
    
    /**
     * @return the firstName
    */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the cardNum
     */
    public int getCardNum() {
        return cardNum;
    }

    /**
     * @param cardNum the cardNum to set
     */
    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
    
    /**
     * @return the balance
     */
    public float getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public static String capitalize(String inputString){
        String output = inputString.substring(0,1).toUpperCase();
        return output;
    }
    
    public void account() throws SQLException{
        
        Card c = new Card();
        //Server ser = new Server();
        Scanner s = new Scanner(System.in);
        
        //Request username
        System.out.print("Enter desired Username" + "\n");
        username = s.nextLine();
        
        //Request password
        System.out.print("Enter desired Password" + "\n");
        password = s.nextLine();
            
        //Request First Name
        System.out.print("Enter Your First Name" + "\n");
        firstName=s.nextLine();
            
        //Request Last Name
        System.out.print("Enter Your Last Name" + "\n");
        lastName=s.nextLine();

        //Request initial deposit              
        System.out.print("Enter an initial deposit" + "\n");
        iDeposit = s.nextFloat();
        
        //Generate card number.
        cc = c.card();
        
        //New Person information
        Person p = new Person(username, capitalize(firstName), capitalize(lastName), password, cc, iDeposit);
        
        //Store requested items into server.
        client.add(p);
                
        //Store USER_ID and FIRSTNAME to DATABASE.
        Database.insert();
            
        System.out.println("Thank you for registering " + firstName + " " + lastName);
        System.out.println("Account Successfully Registered");
    }
}
