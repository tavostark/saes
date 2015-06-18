
package com.ipn.dsd.saes.daos;

public class Alumno_Curso extends Conexion{
    private static  String SQL_ALUMNO_CURSO= "select id_alumno,id_periodo,id_materia,id_area,id_profesor,id_calificacion from calificacion where id_periodo=";

    public void materia (String id_alumno,String id_periodo,String id_materia,String id_area,String id_profesor,String id_calificacion){
         try{
                Conexion con =new Conexion();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_ALUMNO_CURSO+id_periodo+" OR id_materia="+id_materia+"OR id_area="+id_area+"OR id_profresor="+id_profesor+"OR id_calificacion="+id_calificacion+"OR id_alumnor="+id_alumno);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
    
}
