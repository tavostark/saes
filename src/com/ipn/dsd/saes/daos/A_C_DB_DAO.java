

package com.ipn.dsd.saes.daos;

public class A_C_DB_DAO extends Conexion_DB_DAO{

    private static String SQL_BUSCAR_AREA_CONOCIMIENTO = "select nb_area from area_conocimiento where id_area=";
    private static String SQL_BUSCAR_AREA_INSERT="INSERT INTO area_conocimiento (id_area,nb_area) VALUES(";
    private static String SQL_BUSCAR_AREA_DELETE="DELETE FROM area_conocimiento WHERE id_area=";
    private static String SQL_BUSCAR_AREA_UPDATE="UPDATE area_conocimiento SET nb_area =";
    //SELECT
    public void area_select (String id_area){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_BUSCAR_AREA_CONOCIMIENTO+id_area);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
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
}