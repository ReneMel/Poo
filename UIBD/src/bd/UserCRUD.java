/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import Entidades.Cuenta;
import Entidades.Usuario;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class UserCRUD {
    public Conexion bd;

    public UserCRUD() {
        bd = new Conexion();
    }
    
    public Usuario login(String username,String password) throws SQLException{
        boolean flag = false;
        Connection conn = bd.getConnection();
        Usuario usuario = new Usuario();
        String query = "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                usuario.setUsername(rs.getString("usuario"));
                usuario.setPassword(rs.getString("contrasena"));
                usuario.setId(rs.getInt("id_usuario"));
                
                System.out.println(usuario.getId()+"Vea que funciona");
                flag = true;
            }
            if(!flag) usuario = null;
            //conn.close();
        }catch(SQLException ex){
            usuario = null;
            ex.printStackTrace();
        }
        return usuario;
    }
    public boolean signUp(String username, String password) throws SQLException{
        Connection conn = bd.getConnection();
        boolean isSuccess = false;
        String query = "INSERT INTO usuario (usuario,contrasena) VALUES (?,?)";
        String query2 = "SELECT * FROM usuario WHERE usuario= ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            PreparedStatement pstm2 = conn.prepareStatement(query2);
            pstm.setString(1, username);
            pstm.setString(2, password);
            
            
            pstm2.setString(1, username);
            if(!pstm2.executeQuery().isFirst()){
                pstm.execute();
                isSuccess = true;
            }
            //conn.close();
        }catch(SQLException ex){
            isSuccess = false;
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public List<Cuenta> getCuentas(Usuario su, int cat){
        Connection conn = bd.getConnection();
        List<Cuenta> cuentas = new ArrayList();
        String query = "SELECT cu.id_cuenta,cu.nombre, mov.monto, id_categoria\n" +
                        "FROM movimiento mov, usuario u, cuenta cu\n" +
                        "WHERE mov.id_usuario=? and mov.id_categoria=?\n" +
                        "order by mov.fecha desc\n" +
                        "limit 1";
        
        try{
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, su.getId());
            stm.setInt(2, cat);
            
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Cuenta cu = new Cuenta();
                cu.setId(rs.getInt("id_cuenta"));
                cu.setName(rs.getString("nombre"));
                cu.setTipo_cuenta(rs.getInt("id_categoria"));
                cu.setMonto(rs.getInt("monto"));
                cuentas.add(cu);
            }
            //conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return cuentas;
    }

    
}
