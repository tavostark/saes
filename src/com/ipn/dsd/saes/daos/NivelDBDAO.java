
package com.ipn.dsd.saes.daos;

public class NivelDBDAO extends Conexion{
    private static  String SQL_NIVEL = "select nb_nivel,nu_materias from nivel where id_nivel=";

    public void materia (String id){
         try{
                Conexion con =new Conexion();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_NIVEL+id);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
}
