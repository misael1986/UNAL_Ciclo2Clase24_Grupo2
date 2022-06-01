/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unal.unal_ciclo2clase24_grupo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class GuardarTenedor {
    public Connection conn;

    public Connection conectar() {
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String username = "admin";
        String password = "Admin123#";

        conn = null;
        // conectar
        try {
            conn = DriverManager.getConnection(
                    dbURL, username, password);
            if (conn != null) {
                //System.out.println(" Conectado ");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    
 //-------------------------------------------------------
    public Integer guardarTenedor(String nombre, String direccion,
            String telefono){
    
    String sql = "INSERT INTO tenedor "
                + "(nombre,direccion,telefono) "
                + "VALUES (?,?,?)";

        Integer rowsInserted = 0;
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, direccion);
            statement.setString(3, telefono);

            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GuardarTenedor.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return rowsInserted;
    
    }
    
}
