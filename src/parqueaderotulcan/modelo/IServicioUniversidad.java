/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueaderotulcan.modelo;

/**
 *
 * @author Felipe Vidal y Aldair Zemanate
 */
public interface IServicioUniversidad {
    public String datosConductorCedula(String entradaCedula);
    public String datosConductorCodigo(String entradaCodigo);
    public String datosAutomovilesPorCedula(String entradaCedula);
    public String datosAutomovilesPorCodigo(String entradaCodigo);
    public String datosVigilante(String usuario,String pass);
    public String confirmarLogin(String usuario,String pass);
    public String datosAdministrativo(String usuario,String pass);
    public String actualizarMapa();
    public void actualizarBahia(String nombreBahia,String estado);
    public void ingresarDatosConductor(String cedula, String codigo,String nombre,String apellido,String rol, String genero , String fechaNacimiento);
    public void ingresarDatosAutomovil(String placa,String marca,String tipo,String cedulaConductor);
    public void vincularAutomovilConductor(String placa,String numeroId,String codigo);
    public void ingresarDatosVigilante(String id, String nombre,String apellido,String fecha_nacimiento,String genero ,String empresa,String usuario,String contrasenia);
    public void registrarMulta(String cedulaConductor, String fecha, String descripcion );
}
