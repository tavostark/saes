
package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Curso;
import com.ipn.dsd.saes.entidad.Materia;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Materia_DB_DAO extends Conexion_DB_DAO{

    private static String SQL_MATERIA= "select id_area,id_nivel,nb_materia from materia where id_materia=";
    private static String SQL_MATERIA_INSERT="INSERT INTO materia (id_area,id_nivel,nb_materia) VALUES(";
    private static String SQL_MATERIA_DELETE="DELETE FROM materia WHERE id_area=";
    private static String SQL_MATERIA_UPDATE="UPDATE materia SET nb_materia=";
    private static String GET_ID="select last_insert_id()";
    
    public Materia materia_select (Integer id_materia){
        
         Conexion_DB_DAO con =new Conexion_DB_DAO();
         Materia materia =null;
            try{
                
                
                con.crearConexion();
                ResultSet rs=con.ejecutarSQLSelect(SQL_MATERIA+id_materia+";");
                if(rs.next() == true) {
                   materia = new Materia(id_materia,rs.getInt(0),rs.getInt(1),rs.getString(2));
                          
                }
            }
            catch(Exception e){
                System.out.println("SQLException: " + e);
                
          }
            return materia;
    }
    //INSERT, DELETE y UPDATE
    public Integer materia_insert (Materia materia){
        
        Integer resultado = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
            try{
                
                
                con.crearConexion();
                con.ejecutarSQL(SQL_MATERIA_INSERT+materia.getId_area()+","+materia.getId_nivel()+",'"+materia.getNb_materia()+"');");
                ResultSet rs = con.ejecutarSQLSelect(GET_ID);
                
                if(rs.next() == true) {
                    resultado = rs.getInt(1);
                }
                
           }
            catch(Exception e){
                resultado = null;
                System.out.println("SQLException: " + e);
            }
            finally {
                con.cerrarConexion();
            }
            
            return resultado;
    }
    
    public Integer materia_delete (Integer id_area){
        Integer resultado = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        boolean rs=false;
        try{
                
                con.crearConexion();
                rs=con.ejecutarSQL(SQL_MATERIA_DELETE+id_area);
                if (rs == true) {
                    resultado=1;
                } else {
                    resultado = null;
                }
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
            finally {
                con.cerrarConexion();
            }
            
            return resultado;
    }
    public Integer materia_update (Integer id_area,Integer id_nivel,String nb_materia){
           Conexion_DB_DAO con =new Conexion_DB_DAO();
           Integer res=null;
           boolean rs=false;
            try{
                
                
                con.crearConexion();
                rs=con.ejecutarSQL(SQL_MATERIA_UPDATE+nb_materia+" WHERE id_area="+id_area+"AND id_nivel="+id_nivel);
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
    
    public ArrayList<Materia> getListaMateriasArea(Integer idArea) {
     
        ArrayList<Materia> materias = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
        try {
            
            con.crearConexion();
            ResultSet rs = con.ejecutarSQLSelect("select id_materia, id_area, id_nivel, nb_materia from materia where id_area ="+idArea+";");
            materias  = new ArrayList<Materia>();
            
            while(rs.next()) {
                Materia materia = new Materia(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
                materias.add(materia);
            }
            
            
        }
        catch(Exception ex) {
            materias = null;
            System.out.println("SQLException: " + ex.getMessage());
        }
        finally {
            con.cerrarConexion();
        }
        
        return materias;
        
    }
    
    public ArrayList<Materia> getListaMateriasNivel(Integer idNivel) {
        
        ArrayList<Materia> materias = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
        try {
            
            con.crearConexion();
            ResultSet rs = con.ejecutarSQLSelect("select id_materia, id_area, id_nivel, nb_materia from materia where id_nivel ="+idNivel+";");
            materias  = new ArrayList<Materia>();
            
            while(rs.next()) {
                Materia materia = new Materia(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
                materias.add(materia);
            }
            
            
        }
        catch(Exception ex) {
            materias = null;
            System.out.println("SQLException: " + ex.getMessage());
        }
        finally {
            con.cerrarConexion();
        }
        
        return materias;
        
    }
    
}
