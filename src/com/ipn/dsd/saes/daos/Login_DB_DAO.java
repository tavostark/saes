
package com.ipn.dsd.saes.daos;

import com.ipn.dsd.saes.entidad.Alumno;
import com.ipn.dsd.saes.entidad.Persona;
import com.ipn.dsd.saes.entidad.Profesor;
import java.sql.ResultSet;

public class Login_DB_DAO {
    
    public Alumno loginAlumno(String boleta, String contrasena) {
        
        Alumno alumno = null;
        Persona persona = null;
        
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        try{
                ResultSet rs;
                
               
                con.crearConexion();
                rs = con.ejecutarSQLSelect("select p.nb_persona, p.contrasena from persona p join alumno a on a.id_alumno=p.id where a.boleta='"+boleta+"' and contrasena='"+contrasena+"';");
                
                //verificamos si exite si, si nos vuelve el id
                
                        
                if(rs.next()== true ) {
                    
                    persona = new Persona();
                    persona.setNb_persona(rs.getString(0));
                    persona.setPassword(rs.getString(1));
                    alumno = new Alumno(boleta, persona);
                } 
                else {
                    alumno = null;  
                }
                
                }
            catch(Exception e){
               
                System.out.println("SQLException: " + e.getMessage());
               
            }
            finally {
            
                con.cerrarConexion();
                
            }
        
        return alumno;
        
    }
    
    public Profesor loginProfesor(String rfc, String contrasena) {
        
        Profesor profesor = null;
        Persona persona = null;
        
        Conexion_DB_DAO con =new Conexion_DB_DAO();
        try{
                ResultSet rs;
                
                
                con.crearConexion();
                rs = con.ejecutarSQLSelect("select p.nb_persona,p.contrasena from persona p join profesor o on p.id=o.id_profesor where o.rfc='"+rfc+"' and p.contrasena='"+contrasena+"';");
                
                //verificamos si exite si, si nos vuelve el id
                
                        
                if(rs.next()== true ) {
                    persona = new Persona();
                    persona.setNb_persona(rs.getString(0));
                    persona.setPassword(rs.getString(1));
                    
                    profesor = new Profesor(rfc, persona);
                } 
                else {
                    profesor = null;  
                }
                
                }
            catch(Exception e){
               
                System.out.println("SQLException: " + e.getMessage());
               
            }
            finally {
            
                con.cerrarConexion();
                
            }
        
        return profesor;
        
    }
    
}
