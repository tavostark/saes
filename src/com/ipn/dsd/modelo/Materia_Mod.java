/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.saes.entidad.Alumno_Curso;
import com.ipn.dsd.saes.entidad.Materia;
import com.ipn.dsd.saes.entidad.Periodo;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Materia_Mod extends UnicastRemoteObject implements com.ipn.dsd.saes.interfaces.Materia_Interface {

    public Materia_Mod() throws RemoteException {
    
    }
    
    @Override
    public Integer registro(Materia mtr) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public Integer modificar(Materia mtr) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public Integer eliminar(Integer intgr) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public ArrayList<Materia> obtenerListaMateriasArea(Integer intgr) throws RemoteException {
        
        ArrayList<Materia> materias  = null;
        
        return materias;
        
    }

    @Override
    public ArrayList<Materia> obtenerListaMateriasNivel(Integer intgr) throws RemoteException {
        
        ArrayList<Materia> materias = null;
        
        return materias;
        
    }

    @Override
    public ArrayList<Materia> obtenerListaMaterias(Alumno_Curso ac, Periodo prd) throws RemoteException {
        
        ArrayList<Materia> materias = null;
        
        return materias;
        
    }
    
    
    
}
