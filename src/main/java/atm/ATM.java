/*
 */
package atm;

import java.sql.SQLException;

/**
 *
 * @author Vues
 */
public class ATM {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        Menu m = new Menu();
        m.mainMenu();        
    }
}
