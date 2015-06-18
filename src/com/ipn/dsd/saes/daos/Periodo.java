
package com.ipn.dsd.saes.daos;

public class Periodo extends Conexion{
    private static  String SQL_PERIODO = "select nb_periodo,fh_inicio,fh_fin,fh_reg_cal_ini,fh_reg_cal_fin from periodo where id_periodo=";

    public void materia (String id){
         try{
                Conexion con =new Conexion();
                
                con.crearConexion();
                con.ejecutarSQLSelect(SQL_PERIODO+id);
                con.cerrarConexion();
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
    }
    
}
