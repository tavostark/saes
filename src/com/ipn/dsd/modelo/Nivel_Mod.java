/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.saes.entidad.Nivel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Nivel_Mod extends UnicastRemoteObject implements com.ipn.dsd.saes.interfaces.Nivel_Interface {
    
    public Nivel_Mod() throws RemoteException {
        
    }

    @Override
    public ArrayList<Nivel> obtenerNiveles() throws RemoteException {
        
        ArrayList<Nivel> niveles = null;
        
        return niveles;
        
    }
    
}
