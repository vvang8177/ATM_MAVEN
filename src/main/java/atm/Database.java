/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import static atm.Person.client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Vues
 */
public class Database{
    static String database="jdbc:oracle:thin:@localhost:1521:XE";
    static String username="system";
    static String password="!Appleseed8100";
    static Connection c;
    
        public static Connection connect() throws ClassNotFoundException{
            
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                c = DriverManager.getConnection(database,username,password);
                System.out.println("Connected to database");
                return c;
            }catch(SQLException e){
                System.out.print("Cannot connect to database, error:"+e);
            }
        return null;
        }
        
        public static Connection insert() throws SQLException{
            int rows;
            String sql ="INSERT INTO ATM_USERS (USER_NAME, "
                    + "USER_PASSWORD, USER_FIRST) VALUES (?,?,?)";
            PreparedStatement pStatement = c.prepareStatement(sql);
            
            for(Person p:client){
                pStatement.setString(1, p.getFirstName());
                pStatement.setString(2, p.getPassword());
                pStatement.setString(3, p.getFirstName());
                //pStatement.setString(4, p.getLastName());
                //pStatement.setFloat(5, p.getBalance());                
                //pStatement.setInt(6, p.getCardNum());
                
                rows=pStatement.executeUpdate();
                if(rows>0){
                    System.out.println("Added to sytem");
                }
                pStatement.close();
            }            
            return null;
        }
        
        
}
