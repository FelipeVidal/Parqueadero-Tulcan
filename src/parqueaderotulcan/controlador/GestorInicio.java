/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueaderotulcan.controlador;

import parqueaderotulcan.modelo.ServicioServidorUniversidad;

/**
 *
 * @author Felipe Vidal y Aldair Zemanate
 */
public class GestorInicio {
    public String confirmarLogin(String usuario,String pass){
        //Se crea una instancia de ServicioServidorUniversidad para poder confirmar la informacion cuando un usuario quiere ingresar
        //como administrador o vigilante

        ServicioServidorUniversidad newServicio = new ServicioServidorUniversidad();
        String resultado;
        resultado=newServicio.confirmarLogin(usuario, pass);
        return resultado;
    }
}
