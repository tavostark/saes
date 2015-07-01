/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.modelo;

import com.ipn.dsd.saes.daos.Periodo_DB_DAO;
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
    public Integer registrar(Periodo periodo) throws RemoteException {
        
        Integer resultado = null;
        
        if(!periodo.getNb_periodo().equals("") || !periodo.getNb_periodo().isEmpty()) {
            if(periodo.getFh_inicio() != null) {
                if(periodo.getFh_fin() != null) {
                    if(periodo.getFh_reg_cal_ini() != null) {
                        if(periodo.getFh_reg_cat_fin() != null){
                            Periodo_DB_DAO  periodoDB = new Periodo_DB_DAO();
                            resultado = periodoDB.periodo_insert(periodo);
                        }
                        else {
                            resultado = -5;
                        }
                    }
                    else{
                        resultado = -4;
                    }
                }
                else {
                    resultado = -3;
                }
            }
            else {
                resultado = -2;
            }
        }
        else{
            resultado = -1;
        }
        
        return resultado;
        
    }

    @Override
    public Integer modificar(Periodo periodo) throws RemoteException {
        
        Integer resultado = null;
        
        if(!periodo.getNb_periodo().equals("") || !periodo.getNb_periodo().isEmpty()) {
            if(periodo.getFh_inicio() != null) {
                if(periodo.getFh_fin() != null) {
                    if(periodo.getFh_reg_cal_ini() != null) {
                        if(periodo.getFh_reg_cat_fin() != null){
                            Periodo_DB_DAO  periodoDB = new Periodo_DB_DAO();
                            resultado = periodoDB.periodo_update(periodo);
                        }
                        else {
                            resultado = -5;
                        }
                    }
                    else{
                        resultado = -4;
                    }
                }
                else {
                    resultado = -3;
                }
            }
            else {
                resultado = -2;
            }
        }
        else{
            resultado = -1;
        }
        
        return resultado;
        
    }

    @Override
    public ArrayList<Periodo> obtenerListaPeriodos() throws RemoteException {
        
        ArrayList<Periodo> periodos = null;
        
        Periodo_DB_DAO periodoDB = new Periodo_DB_DAO();
        periodos = periodoDB.getListaPeriodos();
        
        return periodos;
        
    }

    @Override
    public Periodo obtenerPeriodo(Date date) throws RemoteException {
        
        Periodo periodo = null;
        
        Periodo_DB_DAO periodoDB = new Periodo_DB_DAO();
        
        periodo = periodoDB.periodo_select(date);
        
        return periodo;
        
    }
    
}
