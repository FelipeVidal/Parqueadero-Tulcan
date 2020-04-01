/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueaderotulcan.controlador;

import com.google.gson.Gson;
import parqueaderotulcan.modelo.Mapa;
import parqueaderotulcan.modelo.ServicioServidorUniversidad;

/**
 *
 * @author Felipe Vidal y Aldair Zemanate
 */
public class GestorMapa {
    public Mapa[] actualizarMapa(){
        String arrayJsonSerializado;
        //Se crea una instancia de ServicioServidorUniversidad para buscar la información de los estados
        //de las bahias. Con la informacion obtenida se actuliza el mapa.

        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        arrayJsonSerializado = servicioUniversidad.actualizarMapa();
        Mapa [] newMapa = new Gson().fromJson(arrayJsonSerializado, Mapa[].class);
       
        return newMapa;
    }
    public void actulizarBahia(String estado, String nombreBahia){
       //Se crea una instancia de ServicioServidorUniversidad cuando se desea actualizar el estado de
       //una bahia a ocupado o disponible

        ServicioServidorUniversidad servicioUniversidad = new ServicioServidorUniversidad();
        servicioUniversidad.actualizarBahia(estado, nombreBahia);
    }
}
