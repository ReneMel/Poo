
package MainProyecto;

import Forms.menu;
import ejemplos.PostgreSqlExample;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 class MainP {


    public static void main(String[] args) {
            
        /*PostgreSqlExample n = new PostgreSqlExample();
        n.connectDatabase();
        Connection conn= n.getcon();
        
         String query = "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, "PEPITO");
            pstm.setString(2, "puto");
            ResultSet rs = pstm.executeQuery();
            System.out.println(pstm.toString());
            System.out.println(rs.toString());
     
            //conn.close();
        }catch(SQLException ex){
        */
        System.out.println("hola mundo");
        menu menu0 = new menu();
        menu0.setTitle("Menu de inicio");
        menu0.setVisible(true);
    //}
}
 }
