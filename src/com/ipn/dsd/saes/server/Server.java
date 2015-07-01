/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.saes.server;

import com.ipn.dsd.modelo.AC_Mod;
import com.ipn.dsd.modelo.AlCur_Mod;
import com.ipn.dsd.modelo.Alumno_Mod;
import com.ipn.dsd.modelo.Calificacion_Mod;
import com.ipn.dsd.modelo.Control_Acceso_Mod;
import com.ipn.dsd.modelo.Curso_Mod;
import com.ipn.dsd.modelo.Materia_Mod;
import com.ipn.dsd.modelo.Nivel_Mod;
import com.ipn.dsd.modelo.Periodo_Mod;
import com.ipn.dsd.modelo.Persona_Mod;
import com.ipn.dsd.modelo.Profesor_Mod;
import com.ipn.dsd.saes.interfaces.AC_Interface;
import com.ipn.dsd.saes.interfaces.AlCur_Interface;
import com.ipn.dsd.saes.interfaces.Alumno_Interface;
import com.ipn.dsd.saes.interfaces.Calificacion_Interface;
import com.ipn.dsd.saes.interfaces.Control_Acceso_Interface;
import com.ipn.dsd.saes.interfaces.Curso_Interface;
import com.ipn.dsd.saes.interfaces.Materia_Interface;
import com.ipn.dsd.saes.interfaces.Nivel_Interface;
import com.ipn.dsd.saes.interfaces.Periodo_Interface;
import com.ipn.dsd.saes.interfaces.Persona_Interface;
import com.ipn.dsd.saes.interfaces.Profesor_Interface;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author marco
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            System.setSecurityManager(new RMISecurityManager());
            final Registry registry = LocateRegistry
					.createRegistry(Registry.REGISTRY_PORT);
            
            AC_Interface ac = new AC_Mod();
            AlCur_Interface alcur = new AlCur_Mod();
            Alumno_Interface alumno = new Alumno_Mod();
            Calificacion_Interface calificacion = new Calificacion_Mod();
            Control_Acceso_Interface control = new Control_Acceso_Mod();
            Curso_Interface curso = new Curso_Mod();
            Materia_Interface materia = new Materia_Mod();
            Nivel_Interface nivel = new Nivel_Mod();
            Periodo_Interface periodo = new Periodo_Mod();
            Persona_Interface persona = new Persona_Mod();
            Profesor_Interface profesor = new Profesor_Mod();
            
            registry.rebind("rmi://localhost/AC_Mod", ac);
            registry.rebind("rmi://localhost/AlCur_Mod", alcur);
            registry.rebind("rmi://localhost/Alumno_Mod", alumno);
            registry.rebind("rmi://localhost/Calificacion_Mod", calificacion);
            registry.rebind("rim://localhost/Control_Acceso_Mod", control);
            registry.rebind("rim://localhost/Curso_Mod", curso);
            registry.rebind("rmi://localhsot/Materia_Mod", materia);
            registry.rebind("rmi://localhost/Nivel_Mod", nivel);
            registry.rebind("rmi://localhost/Periodo_Mod", periodo);
            registry.rebind("rmi://localhost/Persona_Mod", persona);
            registry.rebind("rmi://localhost/Profesor_Mod", profesor);
            
            System.out.println("El servidor esta listo para atender peticiones");
            
        }
        catch(Exception ex) {
            System.out.println("El servidor ha fallado por este motivo: "+ex.getMessage());
        }
        
    }
    
}
