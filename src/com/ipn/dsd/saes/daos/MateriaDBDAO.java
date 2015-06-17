/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ipn.dsd.saes.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Enrique
 */
public class MateriaDBDAO {

    private static final String SQL_TRANSFERENCIA =
            "{call transferenciaCuenta(?,?,?)}";

    public void transferenciaCuenta(String numeroCuenta1, String numeroCuenta2, double cantidad, Connection cnn)
            throws SQLException{
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = cnn.prepareCall(SQL_TRANSFERENCIA);
            cs.setString(1, numeroCuenta1);
            cs.setString(2, numeroCuenta2);
            cs.setDouble(3, cantidad);
            rs = cs.executeQuery();
        } finally {
            if ( cs != null ){
                cs.close();
            }
            if ( rs != null ){
                rs.close();
            }
        }
    }

    public static void main(String[] args) {
        String user = "root";
        String pwd = "Tanerhenry3514";
        String url = "jdbc:mysql://localhost:3306/bancanet";
        String mySQLDriver = "com.mysql.jdbc.Driver";
        Connection cnn = null;
        try{
            Class.forName(mySQLDriver);
            cnn = DriverManager.getConnection(url, user, pwd);
            String ms = "";
            CallableStatement cs = cnn.prepareCall("{call depositoCuenta('12332',2)}");
            cs.executeQuery();
            System.out.println(ms);
        } catch (ClassNotFoundException ex) {
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

}
