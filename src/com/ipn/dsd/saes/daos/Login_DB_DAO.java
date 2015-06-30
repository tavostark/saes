
package com.ipn.dsd.saes.daos;

import java.sql.ResultSet;
import java.util.List;

public class Login_DB_DAO {
    
    private static String  IdUsuario;
    
    public boolean Login(String Usuario, String contrasena){
         try{
                ResultSet rs;
                
                Conexion_DB_DAO con =new Conexion_DB_DAO();
                con.crearConexion();
                rs = con.ejecutarSQLSelect("select id from persona where nb_persona="+Usuario+" AND contrasena="+contrasena);
                con.cerrarConexion();
                //verificamos si exite si, si nos vuelve el id
                if(rs.getRow() == 0 ) {
                        System.out.println("Usuario registrado");
                        IdUsuario = rs.getString("id");
                        return true;
                    } else {
                        System.out.println("Usuario o contraseña no válida");
                        
                    }
                
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
          }
         return false;
    }
    public String getId(){
    
         return IdUsuario;
    }
    
}
