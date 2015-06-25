/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.saes.entidad.Alumno_Curso;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author marco
 */
public class AlCur_Mod extends UnicastRemoteObject implements com.ipn.dsd.saes.interfaces.AlCur_Interface {

    public AlCur_Mod() throws RemoteException {
        
    }
    
    @Override
    public Integer registrar(Alumno_Curso ac) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }
    
}
