/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueaderotulcan.controlador;

import com.google.gson.Gson;
import parqueaderotulcan.modelo.Administrativo;
import parqueaderotulcan.modelo.ServicioServidorUniversidad;
import parqueaderotulcan.vista.VistaAdministrador;
import parqueaderotulcan.vista.VistaLogin;

/**
 *
 * @author Felipe Vidal y Aldair Zemanate
 */
public class GestorAdministrativo {
     public void ConsultarAdministrativo(String usuario,String pass,VistaLogin vistaLogin){
        String administrativoJsonSerializado;
        Administrativo administrativo;
        //Se crea un objeto de la clase ServicioServidorUniversidad para hacer uso del metodo que busca la 
        //información del administrador en la base de datos.
        ServicioServidorUniversidad newServicio = new ServicioServidorUniversidad();
        administrativoJsonSerializado = newServicio.datosAdministrativo(usuario, pass);
        administrativo = new Gson().fromJson(administrativoJsonSerializado,Administrativo.class);
        vistaLogin.setVisible(false);
        VistaAdministrador va;
        //Se muestra al usuario la vista que contiene la información del administrado y las opciones que dispone como administrativo.
        va = new VistaAdministrador();
        va.infoAdministrador(administrativo.getNombre(),administrativo.getApellido(),administrativo.getGenero(),administrativo.getFechaNacimiento(),administrativo.getId());
        va.setVisible(true);
        
    }
  
}
