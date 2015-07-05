
package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Curso;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Curso_DB_DAO extends Conexion_DB_DAO{
    private static  String SQL_CURSO= "select id_periodo,id_materia,id_area,id_profesor from curso;";
    private static String SQL_CURSO_INSERT="INSERT INTO curso (id_materia,id_area,id_profesor) VALUES(";
    private static String SQL_CURSO_DELETE="DELETE FROM curso WHERE ";
    private static String SQL_CURSO_UPDATE="UPDATE curso SET ";
    
    public ResultSet curso_select(){
        ResultSet rs= null;
         try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                rs=con.ejecutarSQLSelect(SQL_CURSO);
                con.cerrarConexion();
                return rs;
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
                return rs;
          }
    }
                //INSERT, DELETE y UPDATE
    public Integer curso_insert (Curso curso){
        
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        Integer id = null;
        
            try{
                
                con.crearConexion();
                con.ejecutarSQL(SQL_CURSO_INSERT+curso.getId_materia()+","+curso.getId_area()+","+curso.getId_profesor()+");");
                ResultSet rs = con.ejecutarSQLSelect("select last_insert_id();");
                if(rs.next() == true) {
                    id = rs.getInt(1);
                }
                
            }
            catch(Exception e){
                id = null;
                System.out.println("SQLException: " + e.getMessage());
            }
            finally {
                con.cerrarConexion();
            }
            
            return id;
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
    
    public ArrayList<Curso> getCursosPeriodo(Integer idPeriodo) {
        
        ArrayList<Curso>  cursos = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
        try {
            con.crearConexion();
            ResultSet rs = con.ejecutarSQLSelect("select id_periodo,id_materia,id_area,id_profesor from curso where id_periodo="+idPeriodo+";");
            
            while(rs.next()) {
                cursos.add(new Curso(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }
            
        }
        catch(Exception ex) {
            cursos = null;
            System.out.println("SQLException: " + ex.getMessage());
        }
        finally {
            con.cerrarConexion();
        }
        
        
        return cursos;
        
    }
  /*  public void curso_update (String id_periodo, String id_materia, String id_area, String id_profesor){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
          curso      
                con.crearConexion();
                con.ejecutarSQL(SQL_CURSO_UPDATE+id_period,id_materia,id_area,id_profeso+" WHERE \"id_periodo=\"+id_periodo+\"AND id_materia=\"+id_materia+\" AND id_area=\"+id_area+\" AND id_profesor=\"+id_profesor);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }*/
}
