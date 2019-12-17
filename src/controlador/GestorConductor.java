/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import javax.swing.JOptionPane;
import modelo.servicio.Conductor;
import modelo.servicio.ServicioServidorUniversidad;
import vista.VistaConductor;

/**
 *
 * @author Felipe
 */
public class GestorConductor {

    public GestorConductor() {
    }
    
    public void consultarConductorCedula(String cedula){
        String arrayJsonSerializado;
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        arrayJsonSerializado=servicioUniversidad.datosConductorCedula(cedula);
        Conductor conductor = new Gson().fromJson(arrayJsonSerializado, Conductor.class);    
        if(conductor.getCedula() == null){
            JOptionPane.showMessageDialog(null,"El conductor no existe en la bases de datos");
        }else{
            VistaConductor vistaResultadoConductor;
            vistaResultadoConductor = new VistaConductor();
            vistaResultadoConductor.setVisible(true);
            vistaResultadoConductor.mostrarConductor(conductor.getNombre(),conductor.getApellido(), conductor.getCedula(),conductor.getCodigo(), conductor.getEstado(), conductor.getRol());
        }
        
    }
    public void consultarConductorCodigo(String codigo){
        String arrayJsonSerializado;
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        arrayJsonSerializado=servicioUniversidad.datosConductorCodigo(codigo);
        Conductor conductor = new Gson().fromJson(arrayJsonSerializado, Conductor.class);
        if(conductor.getCodigo() == null){
             JOptionPane.showMessageDialog(null,"El conductor no existe en la bases de datos");
        }else{
            VistaConductor vistaResultadoConductor;
            vistaResultadoConductor = new VistaConductor();
            vistaResultadoConductor.setVisible(true);
            vistaResultadoConductor.mostrarConductor(conductor.getNombre(),conductor.getApellido(), conductor.getCedula(),conductor.getCodigo(), conductor.getEstado(), conductor.getRol());
        }
    }
    
}
