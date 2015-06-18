
package com.ipn.dsd.saes.daos;

public class Calificacion extends Conexion{
    private static  String SQL_CALIFICACION= "select tx_calificacion from calificacion where id_calificacion=";

    public void materia (String id){
         try{
                Conexion con =new Conexion();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_CALIFICACION+id);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
    
}
