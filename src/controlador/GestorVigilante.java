/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import javax.swing.JOptionPane;
import modelo.servicio.ServicioServidorUniversidad;
import modelo.servicio.Vigilante;
import vista.VistaConsultaConductor;
import vista.VistaLoginVigilante;
import vista.VistaMenu;

/**
 *
 * @author Felipe
 */
public class GestorVigilante {
    public void GestorVigilante(){
        
    }
    public void ConsultarVigilante(String usuario,String pass,VistaLoginVigilante vistaVigilante){
        VistaMenu vistaMenu;
        String vigilanteJsonSerializado;
        Vigilante vigilante;
        ServicioServidorUniversidad newServicio = new ServicioServidorUniversidad();
        vigilanteJsonSerializado = newServicio.datosVigilante(usuario,pass);
        vigilante = new Gson().fromJson(vigilanteJsonSerializado,Vigilante.class);
        if(vigilante.getId() == null){
            JOptionPane.showMessageDialog(null,"El usario no ha sido encontrado.Ingrese nuevamente");
        }else{
            vistaVigilante.setVisible(false);
            vistaMenu= new VistaMenu();
            vistaMenu.infoVigilante(vigilante.getNombre(), vigilante.getApellido(), vigilante.getId(), vigilante.getRol(), vigilante.getEstado());
            vistaMenu.setVisible(true);
        }
    }
  
}
