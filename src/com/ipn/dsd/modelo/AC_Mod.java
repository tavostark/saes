/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.saes.entidad.Area_C;
import com.ipn.dsd.saes.interfaces.AC_Interface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class AC_Mod extends UnicastRemoteObject implements AC_Interface {

    public AC_Mod() throws RemoteException {
        
    }
    
    @Override
    public ArrayList<Area_C> obtenerAreas() throws RemoteException {
        
        ArrayList<Area_C> areas = null;
        
        return areas;
        
    }
    
}
