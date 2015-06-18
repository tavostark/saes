
package com.ipn.dsd.saes.daos;

public class Profesor extends Conexion{
    private static  String SQL_PROFESOR = "select id_area,rfc from profesor where id_profesor=";

    public void materia (String id){
         try{
                Conexion con =new Conexion();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_PROFESOR+id);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
}
