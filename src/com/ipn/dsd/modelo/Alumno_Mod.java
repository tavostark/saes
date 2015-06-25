/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.saes.entidad.Alumno;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Alumno_Mod extends UnicastRemoteObject implements com.ipn.dsd.saes.interfaces.Alumno_Interface {
    
    public Alumno_Mod() throws RemoteException {
        
    }

    @Override
    public Integer registrar(Alumno alumno) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public Integer modificar(Alumno alumno) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public Integer eliminar(Integer intgr) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public Alumno obtenerAlumno(Integer intgr) throws RemoteException {
        
        Alumno alumno = null;
        
        return alumno;
        
    }

    @Override
    public ArrayList<Alumno> obtenerListaAlumnos(Integer intgr) throws RemoteException {
        
        ArrayList<Alumno> alumnos = null;
        
        return alumnos;
        
    }
    
}
