package ejemplos;
import ejemplos.prueba;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author hugo
 */
public class metodosSql{
    int i = 4;
    //Statement sentencia = prueba.createStatement();
    public static PreparedStatement sentencia_preparada;
    public static prueba connection = new prueba();
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero =0;
    
    public int guardar(String nombre,String contrasena, int i){
        int resultado = 0;
//        prueba conexion = null;
        String sentencia_guardar = "INSERT INTO usuario(id_usuario,usuario, contrasena) VALUES ( ?,?,? )";
        try{
            System.out.println("llega");
        //connection.connect();
        //PreparedStatement ps = connection.prepareStatement(sentencia_guardar);
        //sentencia_preparada.setInt(1, i);

        sentencia_preparada.setString(2, nombre);
        sentencia_preparada.setString(3, contrasena);
        resultado = sentencia_preparada.executeUpdate();
        sentencia_preparada.close();
              }
       
  catch(Exception e){
            System.out.println(e);
        }
        i = i+1;
    return resultado;
    }
    
    /*public static String busqueda_nombre(String contrasena){
        prueba conexion = new prueba();
        //coneccion();
        String sentencia_buscar ="SELECT id_usuario,usuario FROM USUARIOS WHERE contrasena ='"+contrasena+"'";
        sentencia_preparada = conexion.prepare(sentencia_buscar);
        resultado = sentencia_preparada.executeQuery();
    return null;
    }*/
    
}
