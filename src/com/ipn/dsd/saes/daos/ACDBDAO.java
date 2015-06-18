

package com.ipn.dsd.saes.daos;

public class ACDBDAO extends Conexion{

    private static String SQL_BUSCAR_AREA_CONOCIMIENTO = "select nb_area from area_conocimiento where id_area=";
   
    public void area (String id){
            try{
                Conexion con =new Conexion();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_BUSCAR_AREA_CONOCIMIENTO+id);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
}