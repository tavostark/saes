/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.saes.entidad.Curso;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Curso_Mod extends UnicastRemoteObject implements com.ipn.dsd.saes.interfaces.Curso_Interface {

    public Curso_Mod() throws RemoteException {
        
    }
    
    @Override
    public Integer registrar(Curso curso) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public Integer modificar(Curso curso) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public ArrayList<Curso> obtenerListaCursos() throws RemoteException {
        
        ArrayList<Curso> cursos = null;
        
        return cursos;
        
    }

    @Override
    public ArrayList<Curso> obtenerListaCursosPeriodo(Integer intgr) throws RemoteException {
        
        ArrayList<Curso> cursos = null;
        
        return cursos;
        
    }
    
    
    
}
