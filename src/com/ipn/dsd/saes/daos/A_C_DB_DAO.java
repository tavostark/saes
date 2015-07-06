

package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Area_C;
import com.ipn.dsd.saes.entidad.Calificacion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class A_C_DB_DAO extends Conexion_DB_DAO{

    private static String SQL_BUSCAR_AREA_CONOCIMIENTO = "select nb_area from area_conocimiento where id_area=;";
    private static String SQL_BUSCAR_AREA_INSERT="INSERT INTO area_conocimiento (id_area,nb_area) VALUES(";
    private static String SQL_BUSCAR_AREA_DELETE="DELETE FROM area_conocimiento WHERE id_area=";
    private static String SQL_BUSCAR_AREA_UPDATE="UPDATE area_conocimiento SET nb_area =";
    //SELECT
    public Area_C area_select (Integer id_area){
             Area_C area= null;
             Conexion_DB_DAO con =new Conexion_DB_DAO();
            try{
                
                
                con.crearConexion();
                ResultSet rs = con.ejecutarSQLSelect(SQL_BUSCAR_AREA_CONOCIMIENTO+id_area+";");
                if(rs.next() == true) {
                area = new Area_C(id_area,rs.getString(0));
                } 
            }
            catch(Exception e){
                System.out.println("SQLException: " + e);
               
            }finally {
            con.cerrarConexion();
        }
        
        return area;
            
    }
    //INSERT, DELETE y UPDATE
    public Integer area_insert (Integer id_area,String nb_area){
            Integer res=null;
            boolean rs=false;
            Conexion_DB_DAO con =new Conexion_DB_DAO();
            try{
                con.crearConexion();
                rs=con.ejecutarSQL(SQL_BUSCAR_AREA_INSERT+id_area+","+nb_area+");");
                if (rs == true) {
                res = 1;
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
    public Integer area_delete (Integer id_area){
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        Integer res=null;
        boolean rs=false;
        
            try{
                con.crearConexion();
                rs=con.ejecutarSQL(SQL_BUSCAR_AREA_DELETE+id_area+";");
                if (rs == true) {
                res = 1;
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
    public Integer area_update (Integer id_area, Integer nb_area){
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        Integer res=null;
        boolean rs=false;
            try{
                con.crearConexion();
                rs=con.ejecutarSQL(SQL_BUSCAR_AREA_UPDATE+nb_area+" WHERE id_area="+id_area+";");
                if (rs == true) {
                res = 1;
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
    
    public ArrayList<Area_C> getListaAreas() {
        
        ArrayList<Area_C> areas = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
        try {
            
            con.crearConexion();
            ResultSet rs = con.ejecutarSQLSelect(SQL_BUSCAR_AREA_CONOCIMIENTO);
            areas = new ArrayList<Area_C>();
            
            while(rs.next()) {
                areas.add( new Area_C(rs.getInt(0), rs.getString(1)));
            }
            
        }
        catch(Exception ex) {
            areas = null;
            System.out.println("SQLException: " + ex.getMessage());
        }
        finally {
            con.cerrarConexion();
        }
        
        return areas;
        
    }
    
}