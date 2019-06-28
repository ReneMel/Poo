/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bd.Conexion;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author rene
 */
public class Movimiento {
    private int idUsuario;
    private int idCategoria;
    private int idCuenta;
    private int idOperacion;
    
    private int fecha;
    private String desc;
    
    Conexion bd= new Conexion();
    
    public void FirstMove(Usuario su,Cuenta cn){
        
        
        Connection conn = bd.getConnection();
        boolean isSuccess = false;
        String query = "insert into movimiento(id_usuario,id_categoria,id_cuenta,id_operacion,monto,fecha,descripcion) values(?,?,?,?,?,'2019/06/28',?);";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, su.getId());
            pstm.setInt(2, cn.getTipo_cuenta());
            pstm.setInt(3, cn.getId());
            pstm.setInt(4, 1);
            pstm.setInt(5, cn.getMonto());
           //pstm.setString(6,"'2018/12/12'");
            pstm.setString(6 ,"Inicializador de cuenta");
            
            
            
            pstm.execute();
                isSuccess = true;

            
            
            //conn.close();
        }catch(SQLException ex){
            isSuccess = false;
            ex.printStackTrace();
        }

    }
    
    
        public void Ingreso(Usuario su, Cuenta cn,int ing){
        Connection conn = bd.getConnection();
        boolean isSuccess = false;
        int newmonto=cn.getMonto()+ing;
        String query = "insert into movimiento(id_usuario,id_categoria,id_cuenta,id_operacion,monto,fecha,descripcion) values(?,?,?,?,?,'2019/06/28',?);";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, su.getId());
            pstm.setInt(2, cn.getTipo_cuenta());
            pstm.setInt(3, cn.getId());
            pstm.setInt(4, 1);
            pstm.setInt(5, newmonto);
           //pstm.setString(6,"'2018/12/12'");
            pstm.setString(6 ,cn.getDesc());
            
            
            
            pstm.execute();
                isSuccess = true;

            
            
            //conn.close();
        }catch(SQLException ex){
            isSuccess = false;
            ex.printStackTrace();
        }
    }
        
public void Egreso(Usuario su, Cuenta cn,int ing){
        Connection conn = bd.getConnection();
        boolean isSuccess = false;
        int newmonto=cn.getMonto()-ing;
        String query = "insert into movimiento(id_usuario,id_categoria,id_cuenta,id_operacion,monto,fecha,descripcion) values(?,?,?,?,?,'2019/06/28',?);";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, su.getId());
            pstm.setInt(2, cn.getTipo_cuenta());
            pstm.setInt(3, cn.getId());
            pstm.setInt(4, 2);
            pstm.setInt(5, newmonto);
           //pstm.setString(6,"'2018/12/12'");
            pstm.setString(6 ,cn.getDesc());
            
            
            
            pstm.execute();
                isSuccess = true;

            
            
            //conn.close();
        }catch(SQLException ex){
            isSuccess = false;
            ex.printStackTrace();
        }
    }
}
