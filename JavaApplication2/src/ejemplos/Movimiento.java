/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

/**
 *
 * @author hugo
 */
public class Movimiento {
    private int id_usuario;
    private int id_categoria;
    private int id_cuenta;
    private int id_operacion;
    private float monto;
    private String descripcion;
    
    public Movimiento(){
    
    }

    public Movimiento(int id_usuario, int id_categoria, int id_cuenta, int id_operacion, float monto, String descripcion) {
        this.id_usuario = id_usuario;
        this.id_categoria = id_categoria;
        this.id_cuenta = id_cuenta;
        this.id_operacion = id_operacion;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_operacion() {
        return id_operacion;
    }

    public void setId_operacion(int id_operacion) {
        this.id_operacion = id_operacion;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
