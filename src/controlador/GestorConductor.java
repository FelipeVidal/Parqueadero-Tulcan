/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import javax.swing.JOptionPane;
import modelo.servicio.Automovil;
import modelo.servicio.Conductor;
import modelo.servicio.ServicioServidorUniversidad;

import vista.VistaConsultaConductor;

/**
 *
 * @author Felipe
 */
public class GestorConductor {

    public GestorConductor() {
    }
    
    public void consultarConductorCedula(String cedula,VistaConsultaConductor vistaConductor){
        String arrayJsonSerializado;
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        arrayJsonSerializado=servicioUniversidad.datosConductorCedula(cedula);
        Conductor conductor = new Gson().fromJson(arrayJsonSerializado, Conductor.class);    
        if(conductor.getCedula() == null){
            JOptionPane.showMessageDialog(null,"El conductor con cedula "+cedula+" no existe en la bases de datos");
            vistaConductor.limpiarDatos();
        }else{
            mostrarConductor(conductor,vistaConductor);
        }
        
    }
    public void consultarConductorCodigo(String codigo,VistaConsultaConductor vistaConductor){
        String arrayJsonSerializado;
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        arrayJsonSerializado=servicioUniversidad.datosConductorCodigo(codigo);
        Conductor conductor = new Gson().fromJson(arrayJsonSerializado, Conductor.class);
        if(conductor.getCodigo() == null){
             JOptionPane.showMessageDialog(null,"El conductor codigo "+codigo+" no existe en la bases de datos");
             vistaConductor.limpiarDatos();
        }else{
           mostrarConductor(conductor,vistaConductor);
        }
    }
    public Automovil[] cosultarAutomovilCedula(String cedula,VistaConsultaConductor vistaConductor ){
        String arrayJsonSerializado;
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        arrayJsonSerializado = servicioUniversidad.datosAutomovilesPorCedula(cedula);
        Automovil [] newAutomoviles = new Gson().fromJson(arrayJsonSerializado, Automovil[].class);
        mostrarAuto(newAutomoviles,vistaConductor);
        return(newAutomoviles);
         
    }
    public Automovil[] cosultarAutomovilCodigo(String codigo,VistaConsultaConductor vistaConductor ){
        String arrayJsonSerializado;
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        arrayJsonSerializado = servicioUniversidad.datosAutomovilesPorCodigo(codigo);
        Automovil [] newAutomoviles = new Gson().fromJson(arrayJsonSerializado, Automovil[].class);
        mostrarAuto(newAutomoviles,vistaConductor);
        return(newAutomoviles);
         
    }
    private void mostrarConductor(Conductor conductor,VistaConsultaConductor vc){
            vc.mostrarConductor(conductor.getNombre(),conductor.getApellido(), conductor.getCedula(),conductor.getCodigo(),conductor.getRol(),conductor.getFecha_nacimiento(),conductor.getGenero());
    }
    private void mostrarAuto(Automovil[] automovil,VistaConsultaConductor vc){
        vc.mostrarAutomovil(automovil);
    }
    public void ingresarConductor(String nombre,String apellido,String rol, String cedula, String codigo,String fechaNacimiento, String genero){
       ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
       servicioUniversidad.ingresarDatosConductor(nombre, apellido, rol, cedula, codigo, fechaNacimiento, genero);
    }
    
    public void ingresarVehiculo(String placa,String marca,String tipo){
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        servicioUniversidad.ingresarDatosAutomovil(placa, marca, tipo);
    }
    
    public void vincularConductorVehiculo(String placa,String id){
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        servicioUniversidad.vincularAutomovilConductor(placa, id);
    }
}
