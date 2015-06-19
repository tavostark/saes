
package com.ipn.dsd.saes.daos;

public class Profesor_DB_DAO extends Conexion_DB_DAO{
    private static  String SQL_PROFESOR = "select id_area,rfc from profesor where id_profesor=";
    private static String SQL_PROFESOR_INSERT="INSERT INTO profesor (id_profesor,id_area,rfc) VALUES(";
    private static String SQL_PROFESOR_DELETE="DELETE FROM profesor WHERE id_profesor=";
    private static String SQL_PROFESOR_UPDATE="UPDATE profesor SET rfc=";
    
    public void profesor_select (String id_profesor,String id_area){
         try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_PROFESOR+id_profesor+" AND id_area="+id_area);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
                    //INSERT, DELETE y UPDATE
    public void profesor_insert (String id_profesor,String id_area,String rfc){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_PROFESOR_INSERT+id_profesor+","+id_area+","+rfc+");");
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void profesor_delete (String id_profesor,String id_area){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_PROFESOR_DELETE+id_profesor+" AND id_area="+id_area);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void profesor_update (String id_profesor, String id_area,String rfc){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_PROFESOR_UPDATE+rfc+" WHERE id_profesor="+id_profesor+" AND id_area="+id_area);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
}
