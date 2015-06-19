
package com.ipn.dsd.saes.daos;

public class Curso_DB_DAO extends Conexion_DB_DAO{
    private static  String SQL_CURSO= "select id_periodo,id_materia,id_area,id_profesor from curso;";
    private static String SQL_CURSO_INSERT="INSERT INTO curso (id_periodo,id_materia,id_area,id_profesor) VALUES(";
    private static String SQL_CURSO_DELETE="DELETE FROM curso WHERE ";
    private static String SQL_CURSO_UPDATE="UPDATE curso SET ";
    
    public void curso_select(){
         try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_CURSO);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
                //INSERT, DELETE y UPDATE
    public void curso_insert (String id_periodo, String id_materia, String id_area, String id_profesor){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_CURSO_INSERT+id_periodo+","+id_materia+","+id_area+","+id_profesor+");");
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void curso_delete (String id_periodo, String id_materia, String id_area, String id_profesor){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_CURSO_DELETE+"id_periodo="+id_periodo+" AND id_materia="+id_materia+" AND id_area="+id_area+" AND id_profesor="+id_profesor);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
  /*  public void curso_update (String id_periodo, String id_materia, String id_area, String id_profesor){
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
