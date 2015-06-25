/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.saes.entidad.Alumno_Curso;
import com.ipn.dsd.saes.entidad.Calificacion;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Calificacion_Mod extends UnicastRemoteObject implements com.ipn.dsd.saes.interfaces.Calificacion_Interface {

    public Calificacion_Mod() throws RemoteException {
        
    }
    
    @Override
    public Integer registrar(Calificacion clfcn) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public Integer modificar(Calificacion clfcn) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public Calificacion obtenerCalificacion(Alumno_Curso ac) throws RemoteException {
        
        Calificacion calificacion = null;
        
        return calificacion;
        
    }

    @Override
    public ArrayList<Calificacion> obtenerListaCalificacion(Integer intgr) throws RemoteException {
        
        ArrayList<Calificacion> calificaciones = null;
        
        return calificaciones;
        
    }
    
}
