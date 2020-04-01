/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueaderotulcan.controlador;

import com.google.gson.Gson;
import javax.swing.JOptionPane;
import parqueaderotulcan.modelo.Automovil;
import parqueaderotulcan.modelo.Conductor;
import parqueaderotulcan.modelo.ServicioServidorUniversidad;

/**
 *
 * @author Felipe Vidal y Aldair Zemanate
 */
public class GestorConductor {

    public GestorConductor() {
        
    }
    
    public Conductor consultarConductorCedula(String cedula){
        String arrayJsonSerializado;
        //Se crea una instancia de ServicioServidorUniversidad para poder consultar la informacion del conductor por cedula
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        arrayJsonSerializado=servicioUniversidad.datosConductorCedula(cedula);
        Conductor conductor = deserializarConductor(arrayJsonSerializado);
        //Si el servidor no retorno la infomación basica del conductor, se entiene que no se encuentra registrado en la
        //base de datos
        return conductor;
        
    }
    public Conductor consultarConductorCodigo(String codigo){
        String arrayJsonSerializado;
        //Se crea una instancia de ServicioServidorUniversidad para poder consultar la informacion del conductor por codigo 
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        arrayJsonSerializado=servicioUniversidad.datosConductorCodigo(codigo);
        Conductor conductor = new Gson().fromJson(arrayJsonSerializado, Conductor.class);
        //Si el servidor no retorno la infomación basica (el codigo en este caso) del conductor, se entiene que no se encuentra registrado en la
        //base de datos 
        if(conductor.getCodigo() == null){
             JOptionPane.showMessageDialog(null,"El conductor codigo "+codigo+" no existe en la bases de datos");
        }else{
           return conductor;
        }
        return null;
    }
    public Automovil[] cosultarAutomovilCedula(String cedula){
        String arrayJsonSerializado;
        //Se crea una instancia de ServicioServidorUniversidad para poder consultar la informacion de los automoviles del 
        //conductor por cedula. 

        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        arrayJsonSerializado = servicioUniversidad.datosAutomovilesPorCedula(cedula);
        //Los datos del automovil se deserializan y si guardan en un arreglo de tipo Automovil
        Automovil [] newAutomoviles = new Gson().fromJson(arrayJsonSerializado, Automovil[].class);
        return(newAutomoviles);    
    }
    public Automovil[] cosultarAutomovilCodigo(String codigo){
        String arrayJsonSerializado;
        //Se crea una instancia de ServicioServidorUniversidad para poder consultar la informacion de los automoviles del 
        //conductor por codigo. 
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        arrayJsonSerializado = servicioUniversidad.datosAutomovilesPorCodigo(codigo);
        Automovil [] newAutomoviles = new Gson().fromJson(arrayJsonSerializado, Automovil[].class);
        return(newAutomoviles);
         
    }
    public void ingresarConductor(String nombre,String apellido,String rol, String cedula, String codigo,String fechaNacimiento, String genero){
       //Se crea una instancia de ServicioServidorUniversidad para poder registrar la informacion de un conductor 
       ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
       servicioUniversidad.ingresarDatosConductor(nombre, apellido, rol, cedula, codigo, fechaNacimiento, genero);
    }
    
    public void ingresarVehiculo(String placa,String marca,String tipo,String cedulaConductor){
      //Se crea una instancia de ServicioServidorUniversidad para poder registrar la informacion de un vehiculo 
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        servicioUniversidad.ingresarDatosAutomovil(placa, marca, tipo, cedulaConductor);
    }
    
    public void vincularConductorVehiculo(String placa,String id){
        //Se crea una instancia de ServicioServidorUniversidad para poder vincular la informacion un conductor con un vehiculo 
        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        servicioUniversidad.vincularAutomovilConductor(placa, id,null);
    }
    
    public Conductor deserializarConductor(String arrayJsonSerializado ){
        //Codigo para poder deserializar y convertir en una en objeto de tipo conductor la cadena String que recibo del servidor
        Conductor conductor = new Gson().fromJson(arrayJsonSerializado, Conductor.class); 
        return conductor;
    }
}
