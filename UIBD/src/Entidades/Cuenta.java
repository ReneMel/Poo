/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Connection;
import bd.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rene
 */
public class Cuenta {
    private String name;
    private String desc;
    private int tipo_cuenta;
    private int id;
    
    public Connection cn;
    Conexion bd = new Conexion();

    public Cuenta() {
        this.name=null;
        this.desc=null;
        cn=bd.getConnection();
    }

    public Cuenta(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public int getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(int tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
 public boolean CrearEnDb() throws SQLException{
        Connection conn = bd.getConnection();
        boolean isSuccess = false;
        String query = "INSERT INTO cuenta (nombre,descripcion) VALUES (?,?)";
        String query2 = "SELECT * FROM cuenta WHERE nombre= ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            PreparedStatement pstm2 = conn.prepareStatement(query2);
            pstm.setString(1, this.name);
            pstm.setString(2, this.desc);
            
            
            pstm2.setString(1, this.name);
            
            
            
            
            if(!pstm2.executeQuery().isFirst()){
                pstm.execute();
                isSuccess = true;
            }
            ResultSet rs = pstm2.executeQuery();
            while(rs.next()){
                this.setId(rs.getInt("id_cuenta"));
                System.out.println("Id_cuenta: "+id);
            }
            
            
            //conn.close();
        }catch(SQLException ex){
            isSuccess = false;
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
}
