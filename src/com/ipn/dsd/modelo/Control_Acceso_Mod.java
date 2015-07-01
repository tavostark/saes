/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.herramientas.Tools;
import com.ipn.dsd.saes.daos.Login_DB_DAO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author marco
 */
public class Control_Acceso_Mod extends UnicastRemoteObject implements com.ipn.dsd.saes.interfaces.Control_Acceso_Interface {

    public Control_Acceso_Mod() throws RemoteException {
        
    }
    
    /**
     * Este metodo verifica que el usuario se encuentre en la bd
     * si no encuentra un identificador regresa 1
     * si no encuentra el password envia 2
     * si el identificador no tiene la nomenclatura correcta envia 3
     * si encuentra al usuario envia un objeto de tipo profesor, alumno
     * @param identificador
     * @param password
     * @return
     * @throws RemoteException 
     */
    @Override
    public Object login(String identificador, String password) throws RemoteException {
        
        Integer resultado = null;
        Object send = null;
        
        
        if(!identificador.equals("") || !identificador.isEmpty()) {
            
            if(!password.equals("") || !password.isEmpty()){
                
                Tools tools = new Tools();
                resultado = tools.getTipoUsuario(identificador);
                
                if(resultado.equals(1)) {
                    
                    Login_DB_DAO login = new Login_DB_DAO();
                    send = login.loginAlumno(identificador, password);
                    
                }
                else if(resultado.equals(2)) {
                    
                    Login_DB_DAO login = new Login_DB_DAO();
                    send = login.loginProfesor(identificador, password);
                    
                }
                else {
                    send = 3;
                }
                
            }
            else {
                send = 2;
            }
        }
        else {
            send = 1;
        }
        
        return send;
        
    }
    
    
    
}
