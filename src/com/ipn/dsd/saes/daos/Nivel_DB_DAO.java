
package com.ipn.dsd.saes.daos;

public class Nivel_DB_DAO extends Conexion_DB_DAO{
    private static  String SQL_NIVEL = "select nb_nivel,nu_materias from nivel where id_nivel=";
    private static String SQL_NIVEL_INSERT="INSERT INTO nivel (id_nivel,nb_nivel,nu_materias) VALUES(";
    private static String SQL_NIVEL_DELETE="DELETE FROM nivel WHERE id_nivel=";
    private static String SQL_NIVEL_UPDATE="UPDATE nivel SET nb_nivel=";
    
    public void nivel_select (String id_nivel){
         try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_NIVEL+id_nivel);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
            //INSERT, DELETE y UPDATE
    public void nivel_insert (String id_nivel,String nb_nivel,String nu_materias){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_NIVEL_INSERT+id_nivel+","+nb_nivel+","+nu_materias+");");
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
        public void nivel_delete (String id_nivel){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_NIVEL_DELETE+id_nivel);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void nivel_update (String id_nivel, String nb_nivel, String nu_materias){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_NIVEL_UPDATE+nb_nivel+",nu_materias="+nu_materias+" WHERE id_nivel="+id_nivel);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
}
