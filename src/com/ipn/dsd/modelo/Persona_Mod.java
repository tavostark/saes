/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.saes.entidad.Persona;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author marco
 */
public class Persona_Mod extends UnicastRemoteObject implements com.ipn.dsd.saes.interfaces.Persona_Interface {

    public Persona_Mod() throws RemoteException {
        
    }
    
    @Override
    public Integer registrar(Persona prsn) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }
    
}
