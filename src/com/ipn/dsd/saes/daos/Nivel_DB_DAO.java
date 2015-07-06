
package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Nivel;
import com.ipn.dsd.saes.entidad.Persona;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Nivel_DB_DAO extends Conexion_DB_DAO{
    private static  String SQL_NIVEL = "select id_nivel,nb_nivel,nu_materias from nivel;";
    private static String SQL_NIVEL_INSERT="INSERT INTO nivel (id_nivel,nb_nivel,nu_materias) VALUES(";
    private static String SQL_NIVEL_DELETE="DELETE FROM nivel WHERE id_nivel=";
    private static String SQL_NIVEL_UPDATE="UPDATE nivel SET nb_nivel=";
    
    public Nivel nivel_select (Integer id_nivel){
          Nivel nivel= null;
          Conexion_DB_DAO con =new Conexion_DB_DAO();
         
         try{
                con.crearConexion();
                ResultSet rs = con.ejecutarSQLSelect(SQL_NIVEL+id_nivel+";");
                 if(rs.next() == true) {
                    nivel = new Nivel(rs.getInt(0),rs.getString(1),rs.getInt(2));
                }
            }
            catch(Exception e){
                System.out.println("SQLException: " + e);
                
          }
         finally {
                con.cerrarConexion();
            }
            
            return nivel;
    }
            //INSERT, DELETE y UPDATE
    public Integer nivel_insert (Nivel nivel){//String id_nivel,String nb_nivel,String nu_materias
            Conexion_DB_DAO con =new Conexion_DB_DAO();
            Integer res=null;
            boolean result =false;
            
        try{
                con.crearConexion();
                result=con.ejecutarSQL(SQL_NIVEL_INSERT+nivel.getId_nivel()+","+nivel.getNb_nivel()+","+nivel.getNu_materias()+");");
                ResultSet rs = con.ejecutarSQLSelect("select last_insert_id();");
                
                if(rs.next() == true) {
                    res = rs.getInt(0);
                }
           }
        catch(Exception e){
                System.out.println("SQLException: " + e);
        }
        finally {
                con.cerrarConexion();
            }
            
            return res;
    }
    public Integer nivel_delete (Integer id_nivel){
            Conexion_DB_DAO con =new Conexion_DB_DAO();
            Integer res=null;
            boolean rs=false;
            try{
                
                
                con.crearConexion();
                con.ejecutarSQL(SQL_NIVEL_DELETE+id_nivel+";");
                if (rs == true) {
                    res=1;
                } else {
                    res = null;
                }
            }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
            finally {
                con.cerrarConexion();
            }
            
            return res;
    }
    public Integer nivel_update (Nivel nivel){//String id_nivel, String nb_nivel, String nu_materias
           Conexion_DB_DAO con =new Conexion_DB_DAO();
           Integer res=null;
           boolean rs=false;
           try{
                
                
                con.crearConexion();
                rs= con.ejecutarSQL(SQL_NIVEL_UPDATE+nivel.getNb_nivel()+",nu_materias="+nivel.getNu_materias()+" WHERE id_nivel="+nivel.getId_nivel()+";");
                if (rs == true) {
                    res=1;
                } else {
                    res = null;
                }
            }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
           finally {
                con.cerrarConexion();
            }
            
            return res;
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
