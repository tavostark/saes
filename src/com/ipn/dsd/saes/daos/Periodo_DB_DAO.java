
package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Periodo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class Periodo_DB_DAO extends Conexion_DB_DAO{
    private static String SQL_PERIODO = "select id_periodo,nb_periodo,fh_inicio,fh_fin,fh_reg_cal_ini,fh_reg_cal_fin from periodo;";
    private static String SQL_PERIODO_INSERT="INSERT INTO periodo (nb_periodo,fh_inicio,fh_fin,fh_reg_cal_ini,fh_reg_cal_fin) VALUES('";
    private static String SQL_PERIODO_DELETE="DELETE FROM periodo WHERE id_periodo=";
    private static String SQL_PERIODO_UPDATE="UPDATE periodo SET nb_periodo='";
    
    public Periodo periodo_select (Date fecha){
        
        Periodo periodo = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
         try{
                
                con.crearConexion();
                ResultSet rs=con.ejecutarSQLSelect("select id_periodo,nb_periodo,fh_inicio,fh_fin,fh_reg_cal_ini,fh_reg_cal_fin from periodo where fh_inicio='"+fecha.toString()+"';");
                periodo = new Periodo();
                
                if(rs.next() == true) {
                    periodo.setId_periodo(rs.getInt(0));
                    periodo.setNb_periodo(rs.getString(1));
                    periodo.setFh_inicio(rs.getDate(2));
                    periodo.setFh_fin(rs.getDate(3));
                    periodo.setFh_reg_cal_ini(rs.getDate(4));
                    periodo.setFh_reg_cat_fin(rs.getDate(5));
                }
                
                
        }
        catch(Exception e){
            periodo = null;
            System.out.println("SQLException: " + e.getMessage());        
        }
        finally {
             con.cerrarConexion();
         }
         
         return periodo;
    }
                //INSERT, DELETE y UPDATE
    public Integer periodo_insert (Periodo periodo){
        
        Integer resultado = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
        try{
                
                con.crearConexion();
                con.ejecutarSQL(SQL_PERIODO_INSERT+periodo.getNb_periodo()+"','"+periodo.getFh_inicio().toString()+"','"+periodo.getFh_fin().toString()+"','"+periodo.getFh_reg_cal_ini().toString()+"','"+periodo.getFh_reg_cat_fin().toString()+"');");
                ResultSet rs = con.ejecutarSQLSelect("select last_insert_id();");
                
                if(rs.next() == true) {
                    resultado = rs.getInt(0);
                }
                
        }
        catch(Exception e){
            resultado = null;
            System.out.println("SQLException: " + e.getMessage());
        }
        finally {
            con.cerrarConexion();
        }
        
        return resultado;
    }
    
    
    public Integer periodo_delete (Integer id_periodo){
        Integer resultado = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        boolean rs=false;
            try{
                
                con.crearConexion();
                con.ejecutarSQL(SQL_PERIODO_DELETE+id_periodo);
                 if (rs == true) {
                    resultado=1;
                } else {
                    resultado = null;
                }
            }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
            finally {
            con.cerrarConexion();
            }
        
        return resultado;
    }
    
    public Integer periodo_update (Periodo periodo){
           
        Integer resultado = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
        try{
                  
            con.crearConexion();
            con.ejecutarSQL(SQL_PERIODO_UPDATE+periodo.getNb_periodo()+",fh_inicio='"+periodo.getFh_inicio().toString()+"',fh_fin='"+periodo.getFh_fin().toString()+"',fh_reg_cal_ini='"+periodo.getFh_reg_cal_ini().toString()+"',fh_reg_cal_fin='"+periodo.getFh_reg_cat_fin().toString()+"' WHERE id_periodo="+periodo.getId_periodo());
            resultado = 1; 
            
        }
        catch(Exception e){
            resultado = null;
            System.out.println("SQLException: " + e.getMessage());
        }
        finally {
            con.cerrarConexion();
        }
        
        return resultado;
        
    }
    
    public ArrayList<Periodo> getListaPeriodos() {
        
        ArrayList<Periodo> periodos = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
        try {
            
            con.crearConexion();
            ResultSet rs = con.ejecutarSQLSelect(SQL_PERIODO);
            periodos = new ArrayList<Periodo>();
            while(rs.next()) {
                periodos.add( new Periodo(rs.getInt(0), rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getDate(5)));
            }
            
        }
        catch(Exception ex) {
            periodos = null;
            System.out.println("SQLException: " + ex.getMessage());
        }
        finally {
            con.cerrarConexion();
        }
        
        return periodos;
        
    }
    
}
