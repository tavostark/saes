
package com.ipn.dsd.saes.daos;

public class Persona_DB_DAO extends Conexion_DB_DAO{

    private static  String SQL_PERSONA = "select nb_perona,ap_paterno,ap_materno from persona where id=";
    private static String SQL_PERSONA_INSERT="INSERT INTO persona (id,nb_persona,ap_paterno,ap_materno) VALUES(";
    private static String SQL_PERSONA_DELETE="DELETE FROM persona WHERE id=";
    private static String SQL_PERSONA_UPDATE="UPDATE persona SET nb_persona=";
    
    public void persona_select (String id){
         try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_PERSONA+id);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
        //INSERT, DELETE y UPDATE
    public void persona_insert (String id,String nb_persona,String ap_paterno,String ap_materno){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_PERSONA_INSERT+id+","+nb_persona+","+ap_paterno+","+ap_materno+");");
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
        public void persona_delete (String id){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_PERSONA_DELETE+id);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void persona_update (String id, String nb_persona, String ap_paterno,String ap_materno){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_PERSONA_UPDATE+nb_persona+",ap_paterno="+ap_paterno+",ap_materno="+ap_materno+" WHERE id_persona="+id);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
}