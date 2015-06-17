/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.saes.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.CuentaDTO;
import modelo.DTO.OperacionDTO;

/**
 *
 * @author Enrique
 */
public class PersonaDBDAO {

    private static final String SQL_HISTORIAL_OP_CUENTA = "{call historialOperacionesCuenta(?)}";
    private static final String SQL_BUSCAR_CUENTA_ID = "{call buscarCuentaById(?)}";
    private static final String SQL_RETIRO_CUENTA = "{call retiroCuenta(?,?)}";
    private static final String SQL_DEPOSITO_CUENTA = "{call depositoCuenta(?,?)}";

    public List historialOperacionesCuenta(String numeroCuenta, Connection cnn) throws SQLException {
        CallableStatement cs = null;
        ResultSet rs = null;
        List lista = new ArrayList();
        try {
            cs = cnn.prepareCall(SQL_HISTORIAL_OP_CUENTA);
            cs.setString(1, numeroCuenta);
            rs = cs.executeQuery();
            while (rs.next()) {
                OperacionDTO dto = new OperacionDTO();
                dto.setCantidad(rs.getDouble("cantidad"));
                dto.setFecha(rs.getTimestamp("fecha"));
                dto.setSaldoFinal(rs.getDouble("saldoFinal"));
                dto.setTipo(rs.getString("tipo").charAt(0));
                lista.add(dto);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
        }
        return lista;
    }

    public CuentaDTO buscarCuentaById(int idCuenta,Connection cnn) throws SQLException{
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = cnn.prepareCall(SQL_BUSCAR_CUENTA_ID);
            cs.setInt(1, idCuenta);
            rs = cs.executeQuery();
            if ( rs.next() ){
                CuentaDTO c = new CuentaDTO();
                c.setIdCuenta(rs.getInt("idCuenta"));
                c.setNumeroCuenta(rs.getString("numeroCuenta"));
                c.setSaldo(rs.getDouble("saldo"));
                return c;
            } else
                return null;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
        }
    }
    
    public void depositoCuenta(String numeroCuenta, double cantidad, Connection cnn) throws SQLException{
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = cnn.prepareCall(SQL_DEPOSITO_CUENTA);
            cs.setString(1, numeroCuenta);
            cs.setDouble(2, cantidad);
            rs = cs.executeQuery();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
        }
    }
    
    public void retiroCuenta(String numeroCuenta, double cantidad, Connection cnn) throws SQLException{
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = cnn.prepareCall(SQL_RETIRO_CUENTA);
            cs.setString(1, numeroCuenta);
            cs.setDouble(2, cantidad);
            rs = cs.executeQuery();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
        }
    }

    public static void main(String[] args) {
        String user = "root";
        String pwd = "Tanerhenry3514";
        String url = "jdbc:mysql://localhost:3306/bancanet";
        String mySQLDriver = "com.mysql.jdbc.Driver";
        Connection cnn = null;
        List lista = null;
        try{
            Class.forName(mySQLDriver);
            cnn = DriverManager.getConnection(url, user, pwd);
            PersonaDBDAO dao = new PersonaDBDAO();
            lista = dao.historialOperacionesCuenta("1111222233334444",cnn);
            for (Object o : lista ) {
                OperacionDTO op = (OperacionDTO) o;
                System.out.println(op);
            }
        } catch (ClassNotFoundException ex) {
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}