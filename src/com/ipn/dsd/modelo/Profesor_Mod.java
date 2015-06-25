/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.saes.entidad.Profesor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Profesor_Mod extends UnicastRemoteObject implements com.ipn.dsd.saes.interfaces.Profesor_Interface {
    
    public Profesor_Mod() throws RemoteException {
        
    }

    @Override
    public Integer registrar(Profesor prfsr) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public Integer modificar(Profesor prfsr) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public Integer eliminar(Integer intgr) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public ArrayList<Profesor> obtenerListaProfesores() throws RemoteException {
        
        ArrayList<Profesor> profesores = null;
        
        return profesores;
        
    }

    @Override
    public ArrayList<Profesor> obtenerListaProfesoresArea(Integer intgr) throws RemoteException {
        
        ArrayList<Profesor> profesores = null;
        
        return profesores;
        
    }
    
}
