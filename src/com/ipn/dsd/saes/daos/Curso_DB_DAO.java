
package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Curso;
import com.ipn.dsd.saes.entidad.Profesor;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Curso_DB_DAO extends Conexion_DB_DAO{
    private static  String SQL_CURSO= "select id_periodo,id_materia,id_area,id_profesor from curso;";
    private static String SQL_CURSO_INSERT="INSERT INTO curso (id_materia,id_area,id_profesor) VALUES(";
    private static String SQL_CURSO_DELETE="DELETE FROM curso WHERE ";
    private static String SQL_CURSO_UPDATE="UPDATE curso SET ";
    
    public Curso curso_select(){
        
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        Curso curso=null;
         try{
                
                
                con.crearConexion();
                ResultSet rs=con.ejecutarSQLSelect(SQL_CURSO);
                if(rs.next() == true) {
                 curso = new Curso(rs.getInt(0),rs.getInt(1),rs.getInt(2),rs.getInt(3));
                        
                }
            }
            catch(Exception e){
                System.out.println("SQLException: " + e);
               
          }
         finally {
            con.cerrarConexion();
         }
         return curso;
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
                    id = rs.getInt(0);
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
    
    public Integer curso_delete (Curso curso){//Integer id_periodo,Integer id_materia,Integer id_area,Integer id_profesor
            
            Integer res=null;
            boolean rs=false;
            Conexion_DB_DAO con =new Conexion_DB_DAO();
            try{
                
                
                con.crearConexion();
                rs=con.ejecutarSQL(SQL_CURSO_DELETE+"id_periodo="+curso.getId_periodo()+" AND id_materia="+curso.getId_materia()+" AND id_area="+curso.getId_area()+" AND id_profesor="+curso.getId_profesor()+";");
                if (rs == true) {
                    res=1;
                } else {
                    res = null;
                }
            }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
            finally {
            con.cerrarConexion();
            }

        return res;
    }
    
    public ArrayList<Curso> getCursosPeriodo(Integer idPeriodo) {
        
        ArrayList<Curso>  cursos = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
        try {
            con.crearConexion();
            ResultSet rs = con.ejecutarSQLSelect("select id_periodo,id_materia,id_area,id_profesor from curso where id_periodo="+idPeriodo+";");
            
            while(rs.next()) {
                cursos.add(new Curso(rs.getInt(0), rs.getInt(1), rs.getInt(2), rs.getInt(3)));
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

}
