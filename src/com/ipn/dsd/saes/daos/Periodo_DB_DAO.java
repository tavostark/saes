
package com.ipn.dsd.saes.daos;

import java.sql.ResultSet;

public class Periodo_DB_DAO extends Conexion_DB_DAO{
    private static String SQL_PERIODO = "select nb_periodo,fh_inicio,fh_fin,fh_reg_cal_ini,fh_reg_cal_fin from periodo where id_periodo=";
    private static String SQL_PERIODO_INSERT="INSERT INTO periodo (id_periodo,nb_periodo,fh_inicio,fh_fin,fh_reg_cal_ini,fh_reg_cal_fin) VALUES(";
    private static String SQL_PERIODO_DELETE="DELETE FROM periodo WHERE id_periodo=";
    private static String SQL_PERIODO_UPDATE="UPDATE periodo SET nb_periodo=";
    
    public ResultSet periodo_select (String id_periodo){
        ResultSet rs = null;
         try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                rs=con.ejecutarSQLSelect(SQL_PERIODO+id_periodo);
                con.cerrarConexion();
                return rs;
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
                return rs;
          }
    }
                //INSERT, DELETE y UPDATE
    public void periodo_insert (String id_periodo,String nb_periodo,String fh_inicio,String fh_fin,String fh_reg_cal_ini,String fh_reg_cal_fin){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_PERIODO_INSERT+id_periodo+","+nb_periodo+","+fh_inicio+","+fh_fin+","+fh_reg_cal_ini+","+fh_reg_cal_fin+");");
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void periodo_delete (String id_periodo){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_PERIODO_DELETE+id_periodo);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
    public void periodo_update (String id_periodo, String nb_periodo,String fh_inicio,String fh_fin,String fh_reg_cal_ini,String fh_reg_cal_fin){
            try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                con.ejecutarSQL(SQL_PERIODO_UPDATE+nb_periodo+",fh_inicio="+fh_inicio+",fh_fin="+fh_fin+",fh_reg_cal_ini="+fh_reg_cal_ini+",fh_reg_cal_fin="+fh_reg_cal_fin+" WHERE id_periodo="+id_periodo);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
    }
}
