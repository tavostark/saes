
package com.ipn.dsd.saes.daos;

public class PersonaDBDAO extends Conexion{

    private static  String SQL_PERSONA = "select nb_perona,ap_paterno,ap_materno from persona where id=";

    public void materia (String id){
         try{
                Conexion con =new Conexion();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_PERSONA+id);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
}