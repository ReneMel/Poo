/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

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
                
                System.out.println(usuario.getId());
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
    
}
