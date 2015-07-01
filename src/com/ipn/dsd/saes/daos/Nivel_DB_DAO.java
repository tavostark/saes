
package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Nivel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Nivel_DB_DAO extends Conexion_DB_DAO{
    private static  String SQL_NIVEL = "select id_nivel,nb_nivel,nu_materias from nivel;";
    private static String SQL_NIVEL_INSERT="INSERT INTO nivel (id_nivel,nb_nivel,nu_materias) VALUES(";
    private static String SQL_NIVEL_DELETE="DELETE FROM nivel WHERE id_nivel=";
    private static String SQL_NIVEL_UPDATE="UPDATE nivel SET nb_nivel=";
    
    public ResultSet nivel_select (String id_nivel){
        ResultSet rs= null;
         try{
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                
                con.crearConexion();
                rs = con.ejecutarSQLSelect(SQL_NIVEL+id_nivel);
                con.cerrarConexion();
                return rs;
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
                return rs;
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
    
    public ArrayList<Nivel> getListaNiveles() {
           
        ArrayList<Nivel> niveles = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
        try {
            
            con.crearConexion();
            ResultSet rs = con.ejecutarSQLSelect(SQL_NIVEL);
            niveles = new ArrayList<Nivel>();
            
            while(rs.next()) {
                niveles.add( new Nivel(rs.getInt(0), rs.getString(1), rs.getInt(2)));
            }
            
        }
        catch(Exception ex) {
            niveles = null;
            System.out.println("SQLException: " + ex.getMessage());
        }
        finally {
            con.cerrarConexion();
        }
        
        return niveles;
        
    }
    
}
