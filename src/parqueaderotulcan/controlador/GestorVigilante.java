/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueaderotulcan.controlador;

import com.google.gson.Gson;
import javax.swing.JOptionPane;
import parqueaderotulcan.modelo.ServicioServidorUniversidad;
import parqueaderotulcan.modelo.Persona;
import parqueaderotulcan.modelo.Vigilante;
import parqueaderotulcan.vista.VistaLogin;
import parqueaderotulcan.vista.VistaVigilante;

/**
 *
 * @author Felipe
 */
public class GestorVigilante {
    public void GestorVigilante(){
        
    }
    public void ConsultarVigilante(String usuario,String pass,VistaLogin vistaLogin){
        VistaVigilante vistaVigilante;
        String vigilanteJsonSerializado;
        Vigilante vigilante;
        //Se crea una instancia de ServicioServidorUniversidad para poder buscar la informacion de un vigilante 
        ServicioServidorUniversidad newServicio = new ServicioServidorUniversidad();
        vigilanteJsonSerializado = newServicio.datosVigilante(usuario,pass);
        vigilante = new Gson().fromJson(vigilanteJsonSerializado,Vigilante.class);
        //Si el servidor no envia la información basica del vigilante, se entiende que no se encuentra registrado en la 
        //base de datos
        if(vigilante.getId() == null){
            JOptionPane.showMessageDialog(null,"El usario no ha sido encontrado.Ingrese nuevamente");
        }else{
            vistaLogin.setVisible(false);
            vistaVigilante = new VistaVigilante();
            vistaVigilante.infoVigilante(vigilante.getNombre(), vigilante.getApellido(), vigilante.getId(), vigilante.getFechaNacimiento(), vigilante.getGenero(),vigilante.getEmpresa());
            vistaVigilante.setVisible(true);
        }
    }
  
}
