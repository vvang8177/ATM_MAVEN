/*
 */
package atm;
import java.util.Random;

/**
 *
 * @author Vues
 */
public class Card {
    
    private static int cardNum;
    
    public int card(){
        
        /*
        This class randomly generates a 4 digit card number to apply to each
        new user.
        */
        Random r = new Random();
        cardNum = r.nextInt(9999);
        System.out.println("Your card number is " + cardNum + "\n");
        return cardNum;
    }
    
}
