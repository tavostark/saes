
package com.ipn.dsd.saes.daos;

public class MateriaDBDAO extends Conexion{

    private static String SQL_MATERIA= "select id_area,id_nivel,nb_materia from materia where id_materia=";

    public void materia (String id){
         try{
                Conexion con =new Conexion();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_MATERIA+id);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
}
