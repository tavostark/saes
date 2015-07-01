/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.saes.daos.Alumno_DB_DAO;
import com.ipn.dsd.saes.daos.Persona_DB_DAO;
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
        
        if(!alumno.getBoleta().isEmpty() || !alumno.getBoleta().equals("")){
            
            Persona_Mod personaMod = new Persona_Mod();
            Integer id = personaMod.registrar(alumno.getPersona());
            
            if(id != null) {
                Alumno_DB_DAO alumnoDB = new Alumno_DB_DAO();
                resultado = alumnoDB.alumno_insert(id, alumno.getBoleta());
            }
            else {
                resultado = null;
            }
            
        }
        else {
            resultado = -1;
        }
        
        
        return resultado;
        
    }

    @Override
    public Integer modificar(Alumno alumno) throws RemoteException {
        
        Integer resultado = null;
        
        Persona_Mod personaMod = new Persona_Mod();
        
        Integer id = personaMod.modificar(alumno.getPersona());
        
        if(id != null) {
            Alumno_DB_DAO alumnoDB = new Alumno_DB_DAO();
            resultado = alumnoDB.alumno_update(alumno.getId_alumno(), alumno.getBoleta());
        }
        else {
            resultado = -1;
        }
        
        return resultado;
        
    }

    @Override
    public Integer eliminar(Integer id_alumno) throws RemoteException {
        
        Integer resultado = null;
        
        return resultado;
        
    }

    @Override
    public Alumno obtenerAlumno(Integer id_alumno) throws RemoteException {
        
        Alumno alumno = null;
        
        Alumno_DB_DAO alumnoDB = new Alumno_DB_DAO();
        alumno = alumnoDB.alumno_select(id_alumno);
        
        if(alumno != null) {
            Persona_DB_DAO personaDB = new Persona_DB_DAO();
            alumno.setPersona(personaDB.persona_select(id_alumno));
        }
        
        return alumno;
        
    }

    @Override
    public ArrayList<Alumno> obtenerListaAlumnos(Integer intgr) throws RemoteException {
        
        ArrayList<Alumno> alumnos = null;
        
        return alumnos;
        
    }
    
}
