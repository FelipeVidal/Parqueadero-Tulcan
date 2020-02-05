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
    public String datosAutomovilesPorCedula(String entradaCedula);
    public String datosAutomovilesPorCodigo(String entradaCodigo);
    public String datosVigilante(String usuario,String pass);
    public void ingresarDatosConductor(String cedula, String codigo,String nombre,String apellido,String rol, String genero , String fechaNacimiento);
    public void ingresarDatosAutomovil(String placa,String marca,String tipo);
    public void vincularAutomovilConductor(String placa,String numeroId);
    
}
