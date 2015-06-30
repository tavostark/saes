
package com.ipn.dsd.saes.daos;

import java.sql.ResultSet;


public class Alumno_DB_DAO extends Conexion_DB_DAO{
    private static  String SQL_ALUMNO = "select boleta from alumno where id_alumno=";
    private static String SQL_ALUMNO_INSERT="INSERT INTO alumno (id_alumno,boleta) VALUES(";
    private static String SQL_ALUMNO_DELETE="DELETE FROM alumno WHERE id_alumno=";
    private static String SQL_ALUMNO_UPDATE="UPDATE alumno SET boleta=";

    public ResultSet alumno_select (String id_alumno){
        ResultSet rs = null;
         try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                rs=con.ejecutarSQLSelect(SQL_ALUMNO+id_alumno);
                con.cerrarConexion();
                return rs;
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
                return rs;
          }
    }
                        //INSERT, DELETE y UPDATE
    public void alumno_insert (String id_alumno,String boleta){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_ALUMNO_INSERT+id_alumno+","+boleta+");");
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void alumno_delete (String id_alumno){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_ALUMNO_DELETE+id_alumno);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void alumno_update (String id_alumno, String boleta){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_ALUMNO_UPDATE+boleta+" WHERE id_alumno="+id_alumno);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    
}
