/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Usuario {
    private String username;
    private String password;
    private int id;
    
    ArrayList<Cuenta> cuentas = new ArrayList();
    
    


    public Usuario() {
    }

    public Usuario(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public void setCuentas(Cuenta cd) {
        cuentas.add(cd);
    }
    
    

}
