

package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Area_C;
import java.sql.ResultSet;
import java.util.ArrayList;

public class A_C_DB_DAO extends Conexion_DB_DAO{

    private static String SQL_BUSCAR_AREA_CONOCIMIENTO = "select id_area,nb_area from area_conocimiento;";
    private static String SQL_BUSCAR_AREA_INSERT="INSERT INTO area_conocimiento (id_area,nb_area) VALUES(";
    private static String SQL_BUSCAR_AREA_DELETE="DELETE FROM area_conocimiento WHERE id_area=";
    private static String SQL_BUSCAR_AREA_UPDATE="UPDATE area_conocimiento SET nb_area =";
    //SELECT
    public ResultSet area_select (String id_area){
            ResultSet rs = null;
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                rs=con.ejecutarSQLSelect(SQL_BUSCAR_AREA_CONOCIMIENTO+id_area);
                con.cerrarConexion();
                return rs;
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
                return rs;
            }
            
    }
    //INSERT, DELETE y UPDATE
    public void area_insert (String id_area,String nb_area){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_BUSCAR_AREA_INSERT+id_area+","+nb_area+");");
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
        public void area_delete (String id_area){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_BUSCAR_AREA_DELETE+id_area);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void area_update (String id_area, String nb_area){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_BUSCAR_AREA_UPDATE+nb_area+" WHERE id_area="+id_area);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
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