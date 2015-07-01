/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.dsd.herramientas;

import java.util.regex.Pattern;

/**
 *
 * @author marco
 */
public class Tools {
    
    
    public Tools() {
        
    }
    
    /**
     * Metodo en el cual identifica que tipo de usuario 
     * se esta logeando
     * regresando un integer para identificarlo
     * @param identificador
     * @return 
     */
    public Integer getTipoUsuario(String identificador) {
        
        Integer result = null;
        
        Pattern alumno = Pattern.compile("[0-9]{10}");
        Pattern profesor = Pattern.compile("[a-zA-Z]{4}[0-9]{6}[a-zA-Z0-9]{3}");
        
        if(alumno.matcher(identificador).matches()) {
            result = 1;
        }
        else if(profesor.matcher(identificador).matches()) {
            result = 2;
        }
        else {
            result = 3;
        }
        
        return result;
        
    }
    
}
