/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.servicio;

/**
 *
 * @author Felipe
 */
public interface IServicioUniversidad {
    public String datosConductorCedula(String entradaCedula);
    public String datosConductorCodigo(String entradaCodigo);
    public String datosVigilante(String cedula);
}
