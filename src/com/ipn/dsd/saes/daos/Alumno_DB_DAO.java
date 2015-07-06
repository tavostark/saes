package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Alumno;
import com.ipn.dsd.saes.entidad.Materia;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    public ArrayList Consultar_materias(Integer id_alumno) {//

         ArrayList Consultar_materias = null;
        ResultSet rs = null;
       
        //Conexion_DB_DAO con = new Conexion_DB_DAO();

        try {

            crearConexion();
            rs = ejecutarSQLSelect("SELECT nb_materia FROM alumno t1 JOIN alumno_curso t2 ON t1.id_alumno=t2.id_alumno join curso t3 ON t2.id_periodo=t3.id_periodo JOIN materia t4 ON t3.id_materia=t4.id_materia where t1.id_alumno="+id_alumno+ ";");
            Consultar_materias  = new ArrayList();
            if(rs.next() == true) {
                 Consultar_materias.add(rs.getInt(0));
                }

        } catch (Exception e) {
            System.out.println("SQLException: " + e);
        } finally {
            cerrarConexion();
        }

        return Consultar_materias;
    } 
    public ArrayList Consultar_Calificaciones(Integer id_alumno) {//

        ArrayList Consultar_Calificaciones = null;
        ResultSet rs = null;
        //Conexion_DB_DAO con = new Conexion_DB_DAO();

        try {

            crearConexion();
           rs = ejecutarSQLSelect("SELECT tx_calificacion FROM alumno t1 JOIN alumno_curso t2 ON t1.id_alumno=t2.id_alumno join calificacion t3 ON t2.id_calificacion=t3.id_calificacion where t1.id_alumno="+id_alumno+ ";");
           Consultar_Calificaciones  = new ArrayList();
            if(rs.next() == true) {
                 Consultar_Calificaciones.add(rs.getInt(0));
            }


        } catch (Exception e) {
            System.out.println("SQLException: " + e);
        } finally {
            cerrarConexion();
        }

        return Consultar_Calificaciones;
    } 
}
