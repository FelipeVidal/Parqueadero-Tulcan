/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author aldai
 */
public class Validacion {
    public Validacion(){
        
    }
    public boolean soloNumeros(char c){
        boolean res=false;
        if(c<'0' || c>'9')
        {
            res=true;
        }
        return res;
    }
}
