/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.saes.entidad.Periodo;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author marco
 */
public class Periodo_Mod extends UnicastRemoteObject implements com.ipn.dsd.saes.interfaces.Periodo_Interface {
    
    public Periodo_Mod() throws RemoteException {
        
    }

    @Override
    public Integer registrar(Periodo prd) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public Integer modificar(Periodo prd) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public ArrayList<Periodo> obtenerListaPeriodos() throws RemoteException {
        
        ArrayList<Periodo> periodos = null;
        
        return periodos;
        
    }

    @Override
    public Periodo obtenerPeriodo(Date date) throws RemoteException {
        
        Periodo periodo = null;
        
        return periodo;
        
    }
    
}
