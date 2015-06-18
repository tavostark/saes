
package com.ipn.dsd.saes.daos;


public class Alumno extends Conexion{
    private static  String SQL_ALUMNO = "select boleta from alumno where id_alumno=";

    public void materia (String id){
         try{
                Conexion con =new Conexion();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_ALUMNO+id);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
    
}
