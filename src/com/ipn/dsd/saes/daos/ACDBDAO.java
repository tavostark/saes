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

/**
 *
 * @author Enrique
 */
public class ACDBDAO {

    private static final String SQL_BUSCAR_USUARIO =
            "{call buscarUsuario(?,?)}";
    private static final String SQL_CUENTAS_CLIENTE = "{call buscarCuentasCliente(?)}";
    private static final String SQL_REGISTTRO_CLIENTE =
            "insert into usuario (nick, pass, tipo, nombre, paterno, materno, email, telefono)"
    + " values (?, ?, 'C', ?, ?, ?, ?, ?)";
    public static final String SQL_ELIMINA_CLIENTE =
            "delete from usuario where idUsuario = ?";

    public UsuarioDTO findByNameAndPassword(String nick, String pass, Connection cnn) throws SQLException{
            CallableStatement cs = null;
            ResultSet rs = null;
            try{
                cs = cnn.prepareCall(SQL_BUSCAR_USUARIO);
                cs.setString(1, nick);
                cs.setString(2, pass);
                rs = cs.executeQuery();
                if( rs.next() ){
                    UsuarioDTO c = new UsuarioDTO();
                    c.setIdCliente(rs.getInt("idUsuario"));
                    c.setNick(rs.getString("nick"));
                    c.setPass(rs.getString("pass"));
                    c.setTipo(rs.getString("tipo").charAt(0));
                    c.setNombre(rs.getString("nombre"));
                    c.setPaterno(rs.getString("paterno"));
                    c.setMaterno(rs.getString("materno"));
                    c.setEmail(rs.getString("email"));
                    c.setTelefono(rs.getString("telefono"));
                    return c;
                }
                else return null;
            } finally {
                if (cs != null) cs.close();
                if (rs != null) rs.close();
            }
    }

    public void registroCliente(UsuarioDTO cliente, Connection cnn) throws SQLException{
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareStatement(SQL_REGISTTRO_CLIENTE);
            ps.setString(1, cliente.getNick());
            ps.setString(2, cliente.getPass());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getPaterno());
            ps.setString(5, cliente.getMaterno());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getTelefono());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    public void eliminarCliente(UsuarioDTO cliente, Connection cnn) throws SQLException{
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareStatement(SQL_ELIMINA_CLIENTE);
            ps.setInt(1, cliente.getIdCliente());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    public List buscarCuentasCliente(int idCliente, Connection cnn) throws SQLException{
        CallableStatement cs = null;
        ResultSet rs = null;
        List lista = new ArrayList();
        try {
            cs = (CallableStatement) cnn.prepareCall(SQL_CUENTAS_CLIENTE);
            cs.setInt(1, idCliente);
            rs = cs.executeQuery();
            while (rs.next()) {
                CuentaDTO c = new CuentaDTO();
                c.setIdCuenta(rs.getInt("idCuenta"));
                c.setNumeroCuenta(rs.getString("numeroCuenta"));
                c.setSaldo(rs.getDouble("saldo"));
                lista.add(c);
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

    public static void main(String[] args) throws ClassNotFoundException {
        String user = "root";
        String pwd = "Tanerhenry3514";
        String url = "jdbc:mysql://localhost:3306/bancanet";
        String mySQLDriver = "com.mysql.jdbc.Driver";
        Connection cnn = null;
        try{
            Class.forName(mySQLDriver);
            cnn = DriverManager.getConnection(url, user, pwd);
        }catch(SQLException ex){

        }


        UsuarioDTO c = new UsuarioDTO();
        ACDBDAO dao = new ACDBDAO();
        String nombre = "tanerhenry";
        String clave = "1234";
        try {
            c = dao.findByNameAndPassword(nombre, clave, cnn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(c);
    }

}
