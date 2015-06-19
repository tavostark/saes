
package com.ipn.dsd.saes.daos;

public class Alumno_Curso_DB_DAO extends Conexion_DB_DAO{
    private static  String SQL_ALUMNO_CURSO= "select id_alumno,id_periodo,id_materia,id_area,id_profesor,id_calificacion from alumno_curso;";
    private static String SQL_ALUMNO_CURSO_INSERT="INSERT INTO alumno_curso (id_periodo,id_materia,id_area,id_profesor) VALUES(";
    private static String SQL_ALUMNO_CURSO_DELETE="DELETE FROM alumno_curso WHERE ";
    private static String SQL_ALUMNO_CURSO_UPDATE="UPDATE alumno_curso SET ";
    
    public void alumno_curso_select (){
         try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_ALUMNO_CURSO);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
                //INSERT, DELETE y UPDATE
    public void alumno_curso_insert (String id_alumno,String id_periodo,String id_materia,String id_area,String id_profesor,String id_calificacion){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_ALUMNO_CURSO_INSERT+id_alumno+","+id_periodo+","+id_materia+","+id_area+","+id_profesor+","+id_calificacion+");");
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void alumno_curso_delete (String id_alumno,String id_periodo,String id_materia,String id_area,String id_profesor,String id_calificacion){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_ALUMNO_CURSO_DELETE+"id_alumno="+id_alumno+" AND id_periodo="+id_periodo+" AND id_materia="+id_materia+" AND id_area="+id_area+" AND id_profesor="+id_profesor+" AND id_calificacion="+id_calificacion);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
  /*  public void alumno_curso_update (String id_alumno,String id_periodo,String id_materia,String id_area,String id_profesor,String id_calificacion){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_CURSO_UPDATE+id_period,id_materia,id_area,id_profeso+" WHERE \"id_periodo=\"+id_periodo+\"AND id_materia=\"+id_materia+\" AND id_area=\"+id_area+\" AND id_profesor=\"+id_profesor);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }*/
}
