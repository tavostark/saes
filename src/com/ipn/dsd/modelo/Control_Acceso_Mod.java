/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author marco
 */
public class Control_Acceso_Mod extends UnicastRemoteObject implements com.ipn.dsd.saes.interfaces.Control_Acceso_Interface {

    public Control_Acceso_Mod() throws RemoteException {
        
    }
    
    @Override
    public Integer login(String identificador, String password) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }
    
    
    
}
