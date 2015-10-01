/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Dao.*;
import Modelos.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author microtik
 */
public class ControladoraUsuario{
    DaoUsuario usuarios = new DaoUsuario();
    
    
    public void agregarUsuario(Usuario u) throws SQLException{
        try{
        usuarios.agregarUsuario(u);
        }
        catch (SQLException ex){
            throw ex;
        }
    }
    
    public Usuario traeUsuario(String nombre, String pass) throws SQLException{
        try {
            return usuarios.traeUsuario(nombre, pass);
        } catch (SQLException ex) {
           throw ex;
        }
    }
}
