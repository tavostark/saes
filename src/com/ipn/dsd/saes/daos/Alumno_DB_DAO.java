package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Alumno;
import java.sql.ResultSet;

public class Alumno_DB_DAO extends Conexion_DB_DAO {

    private static String SQL_ALUMNO = "select boleta from alumno where id_alumno=";
    private static String SQL_ALUMNO_INSERT = "INSERT INTO alumno (id_alumno,boleta) VALUES(";
    private static String SQL_ALUMNO_DELETE = "DELETE FROM alumno WHERE id_alumno=";
    private static String SQL_ALUMNO_UPDATE = "UPDATE alumno SET boleta='";

    public Alumno alumno_select(Integer id_alumno) {
         
        Alumno alumno = null;
        Conexion_DB_DAO con = new Conexion_DB_DAO();
        
        try {
            
            con.crearConexion();
            ResultSet rs = con.ejecutarSQLSelect(SQL_ALUMNO + id_alumno+";");
            
            if(rs.next() == true) {
                alumno = new Alumno();
                alumno.setBoleta(rs.getString(1));
                alumno.setId_alumno(id_alumno);
            }
            
            
        } catch (Exception e) {
            alumno = null;
            System.out.println("SQLException: " + e.getMessage());
            
        }
        finally {
            con.cerrarConexion();
        }
        
        return alumno;
    }

    //INSERT, DELETE y UPDATE

    public Integer alumno_insert(Integer id_alumno, String boleta) {//Integer id_alumno, String boleta

        Integer resultado = null;
        Conexion_DB_DAO con = new Conexion_DB_DAO();

        try {

            con.crearConexion();
            con.ejecutarSQL(SQL_ALUMNO_INSERT + id_alumno+ ",'" +boleta+ "');");
            resultado = 1;

        } catch (Exception e) {
            resultado = null;
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }

        return resultado;
    }

    public Integer alumno_delete(Integer id_alumno) {

        Integer resultado = null;
        Conexion_DB_DAO con = new Conexion_DB_DAO();
        try {

            con.crearConexion();
            con.ejecutarSQL(SQL_ALUMNO_DELETE + id_alumno);
            resultado=1;
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }

        return resultado;

    }

    public Integer alumno_update(Integer id_alumno, String boleta) {//

        Integer resultado = null;
        Conexion_DB_DAO con = new Conexion_DB_DAO();

        try {

            con.crearConexion();
            con.ejecutarSQL(SQL_ALUMNO_UPDATE + boleta+ "' WHERE id_alumno=" +id_alumno+";");
            resultado = 1;

        } catch (Exception e) {
            resultado = null;
            System.out.println("SQLException: " + e);
        } finally {
            con.cerrarConexion();
        }

        return resultado;

    } 

}
