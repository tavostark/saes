
package com.ipn.dsd.saes.daos;

public class Calificacion_DB_DAO extends Conexion_DB_DAO{
    private static  String SQL_CALIFICACION= "select tx_calificacion from calificacion where id_calificacion=";
    private static String SQL_CALIFICACION_INSERT="INSERT INTO calificacion (id_calificacion,tx_calificacion) VALUES(";
    private static String SQL_CALIFICACION_DELETE="DELETE FROM calificacion WHERE id_calificacion=";
    private static String SQL_CALIFICACION_UPDATE="UPDATE calificacion SET tx_calificacion=";
    
    public void calificacion_select (String id){
         try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_CALIFICACION+id);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
            //INSERT, DELETE y UPDATE
    public void calificacion_insert (String id_calificacion,String tx_calificacion){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_CALIFICACION_INSERT+id_calificacion+","+tx_calificacion+");");
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void calificacion_delete (String id_calificacion){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_CALIFICACION_DELETE+id_calificacion);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void calificacion_update (String id_calificacion, String tx_calificacion){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_CALIFICACION_UPDATE+tx_calificacion+" WHERE id_calificacion="+id_calificacion);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    
}
