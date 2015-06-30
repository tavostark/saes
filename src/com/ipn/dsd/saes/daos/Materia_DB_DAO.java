
package com.ipn.dsd.saes.daos;

import java.sql.ResultSet;

public class Materia_DB_DAO extends Conexion_DB_DAO{

    private static String SQL_MATERIA= "select id_area,id_nivel,nb_materia from materia where id_materia=";
    private static String SQL_MATERIA_INSERT="INSERT INTO materia (id_area,id_nivel,nb_materia) VALUES(";
    private static String SQL_MATERIA_DELETE="DELETE FROM materia WHERE id_area=";
    private static String SQL_MATERIA_UPDATE="UPDATE materia SET nb_materia=";
    
    public ResultSet materia_select (String id_area){
        ResultSet rs= null;
         try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                rs=con.ejecutarSQLSelect(SQL_MATERIA+id_area);
                con.cerrarConexion();
                return rs;
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
                return rs;
          }
    }
    //INSERT, DELETE y UPDATE
    public void materia_insert (String id_area,String id_nivel,String nb_materia){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_MATERIA_INSERT+id_area+","+id_nivel+","+nb_materia+");");
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
        public void materia_delete (String id_area){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_MATERIA_DELETE+id_area);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void materia_update (String id_area, String id_nivel, String nb_materia){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_MATERIA_UPDATE+nb_materia+" WHERE id_area="+id_area+"AND id_nivel="+id_nivel);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
}
