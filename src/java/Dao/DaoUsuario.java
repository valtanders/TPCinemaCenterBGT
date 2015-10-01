/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelos.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author microtik
 */
public class DaoUsuario {

    public void agregarUsuario(Usuario u) throws SQLException {
        Conexion oCon = new Conexion();
        String insert = "insert into Usuario(nombre,contrasenia,rol) values(?,?,?)";
        try {
            PreparedStatement sentencia = (PreparedStatement) oCon.getConexion().prepareStatement(insert);
            sentencia.setString(1, u.getNombre());
            sentencia.setString(2, u.getPassword());
            sentencia.setInt(3, u.getRol());
            sentencia.execute();
            sentencia.close();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            oCon.close();
        }
    }

    public Usuario traeUsuario(String nombre, String pass) throws SQLException {
        Usuario u = new Usuario();
        Conexion oCon = new Conexion();
        String consulta = "select * from usuario where Nombre = ? and contrasenia = ?";
        ResultSet rs = null;
        oCon.getConexion();
        try {
            PreparedStatement sentencia = (PreparedStatement) oCon.getConexion().prepareStatement(consulta);
            sentencia.setString(1, nombre);
            sentencia.setString(2, pass);
            rs = sentencia.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setRol(rs.getInt(4));
            }
            rs.close();
            sentencia.close();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            oCon.close();
        }
        return u;
    }

}
