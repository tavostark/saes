
package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Persona;
import java.sql.ResultSet;

public class Persona_DB_DAO extends Conexion_DB_DAO{

    private static  String SQL_PERSONA = "select nb_persona,ap_paterno,ap_materno from persona where id=";
    private static String SQL_PERSONA_INSERT="INSERT INTO persona (nb_persona,ap_paterno,ap_materno,contrasena) VALUES('";
    private static String SQL_PERSONA_DELETE="DELETE FROM persona WHERE id=";
    private static String SQL_PERSONA_UPDATE="UPDATE persona SET nb_persona='";
    private static String GET_ID="select last_insert_id()";
    
    public Persona persona_select (Integer id){
        
        Persona persona = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
         try{
                
                con.crearConexion();
                ResultSet rs=con.ejecutarSQLSelect(SQL_PERSONA+id+";");
               
                if(rs.next() == true) {
                    persona = new Persona();
                    persona.setNb_persona(rs.getString(0));
                    persona.setAp_paterno(rs.getString(1));
                    persona.setAp_materno(rs.getString(2));
                }
                
                
                }
            catch(Exception e){
                persona = null;
                System.out.println("SQLException: " + e.getMessage());
                
          }
         finally {
              con.cerrarConexion();
         }
         
         return persona;
         
    }
        //INSERT, DELETE y UPDATE
    public Integer persona_insert (Persona persona){
        
        Integer id = null;
        
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
            try{
                
                ResultSet rs = null;     
                con.crearConexion();
                con.ejecutarSQL(SQL_PERSONA_INSERT+persona.getNb_persona()+"','"+persona.getAp_paterno()+"','"+persona.getAp_materno()+"','"+persona.getPassword()+"');");
                rs = con.ejecutarSQLSelect(GET_ID);
                
                if(rs.next() == true) {
                    id = rs.getInt(1);
                }
                
            }
            catch(Exception e){
                System.out.println("SQLException: " + e.getMessage());
            }
            finally {
                con.cerrarConexion();
            }
           
        return id;
            
    }
        
    public Integer persona_delete (Integer id){
        
        Integer resultado = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        
            try{
                
                con.crearConexion();
                con.ejecutarSQL(SQL_PERSONA_DELETE+id);
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
    public Integer persona_update (Persona persona){
            
        Integer resultado = null;
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        try{
                
            con.crearConexion();
            con.ejecutarSQL(SQL_PERSONA_UPDATE+persona.getNb_persona()+"',ap_paterno='"+persona.getAp_paterno()+"',ap_materno='"+persona.getAp_materno()+"',contrasena='"+persona.getPassword()+"' WHERE id_persona="+persona.getId());
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
}
