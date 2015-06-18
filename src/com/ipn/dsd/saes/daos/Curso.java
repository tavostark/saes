
package com.ipn.dsd.saes.daos;

public class Curso extends Conexion{
    private static  String SQL_CURSO= "select id_periodo,id_materia,id_area,id_profesor from calificacion where id_periodo=";

    public void materia (String id_periodo,String id_materia,String id_area,String id_profesor){
         try{
                Conexion con =new Conexion();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_CURSO+id_periodo+" OR id_materia="+id_materia+"OR id_area="+id_area+"OR id_profresor="+id_profesor);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
    
}
