package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Alumno_Curso;
import com.ipn.dsd.saes.entidad.Calificacion;
import java.sql.ResultSet;

public class Calificacion_DB_DAO extends Conexion_DB_DAO {

    private static String SQL_CALIFICACION = "select tx_calificacion from calificacion where id_calificacion=";
    private static String SQL_CALIFICACION_INSERT = "INSERT INTO calificacion (tx_calificacion) VALUES('";
    private static String SQL_CALIFICACION_DELETE = "DELETE FROM calificacion WHERE id_calificacion=";
    private static String SQL_CALIFICACION_UPDATE = "UPDATE calificacion SET tx_calificacion='";

    public Calificacion calificacion_select(Integer id) {
        
        Conexion_DB_DAO con = new Conexion_DB_DAO();
        Calificacion calificacion = null;
        
        try {
            
            
            con.crearConexion();
            ResultSet rs = con.ejecutarSQLSelect(SQL_CALIFICACION + id+";");
            
            if(rs.next() == true) {
                calificacion = new Calificacion(id, rs.getString(0));
            }
            
            
        } catch (Exception e) {
            calificacion = null;
            System.out.println("SQLException: " + e.getMessage());
            
        }
        finally {
            con.cerrarConexion();
        }
        
        return calificacion;
    }

    //INSERT, DELETE y UPDATE

    public Integer calificacion_insert(String calificacion) {

        Integer id = null;
        Conexion_DB_DAO con = new Conexion_DB_DAO();
        try {

            con.crearConexion();
            con.ejecutarSQL(SQL_CALIFICACION_INSERT +calificacion+ "');");
            ResultSet rs = con.ejecutarSQLSelect("select last_insert_id();");

            if (rs.next() == true) {
                id = rs.getInt(0);
            } else {
                id = null;
            }

        } catch (Exception e) {
            id = null;
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            con.cerrarConexion();
        }

        return id;

    }

    public Integer calificacion_delete(Integer id_calificacion) {
        
        Conexion_DB_DAO con = new Conexion_DB_DAO();
         boolean rs=false;
         Integer res=null;
        try {

            con.crearConexion();
            rs = con.ejecutarSQL(SQL_CALIFICACION_DELETE + id_calificacion+";");

            if (rs == true) {
                res = 1;
            } else {
                res = null;
            }
        } catch (Exception e) {
            
            System.out.println("SQLException: " + e);
        }
        finally {
            con.cerrarConexion();
        }
        return res;
    }

    public Integer calificacion_update(Integer id_calificacion,String calificacion) {
        
       Conexion_DB_DAO con = new Conexion_DB_DAO();
       Integer result = null;
       boolean rs=false; 
        try {
            
            con.crearConexion();
            rs=con.ejecutarSQL(SQL_CALIFICACION_UPDATE +calificacion+"' WHERE id_calificacion=" +id_calificacion+";");
            if (rs == true) {
                result = 1;
            } else {
                result = null;
            }
            
        } catch (Exception e) {
            result = null;
            System.out.println("SQLException: " + e.getMessage());
        }
        finally {
            con.cerrarConexion();
        }
        
        return result;
        
    }

}
