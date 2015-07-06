
package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.*;
import java.sql.ResultSet;

public class Profesor_DB_DAO extends Conexion_DB_DAO{
    private static  String SQL_PROFESOR = "select rfc from profesor where id_profesor=";
    private static String SQL_PROFESOR_INSERT="INSERT INTO profesor (id_profesor,id_area,rfc) VALUES(";
    private static String SQL_PROFESOR_DELETE="DELETE FROM profesor WHERE id_profesor=";
    private static String SQL_PROFESOR_UPDATE="UPDATE profesor SET rfc=";
    
    public Profesor profesor_select (Integer id_profesor,Integer id_area){
         Conexion_DB_DAO con =new Conexion_DB_DAO();
         Profesor prof=null;
        
         try{
                con.crearConexion();
                ResultSet rs=con.ejecutarSQLSelect(SQL_PROFESOR+id_profesor+" AND id_area="+id_area+";");
                
                if(rs.next() == true) {
                 prof= new Profesor(id_profesor, id_area, rs.getString(0));
                }
                
            }
            catch(Exception e){
                System.out.println("SQLException: " + e);
               
            }
         finally {
            con.cerrarConexion();
         }
        
        return prof;
    }
                    //INSERT, DELETE y UPDATE
    public Integer profesor_insert (Profesor profesor){//Integer id_profesor,Integer id_area,String rfc
        
            Conexion_DB_DAO con =new Conexion_DB_DAO();
            Integer id=null;
            boolean rs=false;
            
            try{
                
                con.crearConexion();
                rs=con.ejecutarSQL(SQL_PROFESOR_INSERT+profesor.getId_profesor()+","+profesor.getId_area()+","+profesor.getRfc()+");");
                ResultSet result = con.ejecutarSQLSelect("select last_insert_id();");

            if (result.next() == true) {
                id = result.getInt(0);
            } else {
                id = null;
            }
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
            finally {
            con.cerrarConexion();
            }

        return id;
    }
    public Integer profesor_delete (Profesor profesor){//String id_profesor,String id_area
           
            Conexion_DB_DAO con =new Conexion_DB_DAO();
           Integer res =null;
           boolean rs=false;
        try{
                con.crearConexion();
                rs = con.ejecutarSQL(SQL_PROFESOR_DELETE+profesor.getId_profesor()+" AND id_area="+profesor.getId_area()+";");
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
    public Integer profesor_update (Profesor profesor){//String id_profesor, String id_area,String rfc
            
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        Integer res=null;
        boolean rs= false;
            try{
                
                
                con.crearConexion();
                rs=con.ejecutarSQL(SQL_PROFESOR_UPDATE+profesor.getRfc()+" WHERE id_profesor="+profesor.getId_profesor()+" AND id_area="+profesor.getId_area()+";");
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
}
