/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueaderotulcan.modelo;

/**
 *
 * @author Felipe
 */
import parqueaderotulcan.controlador.GestorConductor;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ServicioServidorUniversidad implements IServicioUniversidad {
   private Socket socket = null;
   private Scanner entradaDecorada;
   private PrintStream salidaDecorada;
   private final String IP_SERVIDOR = "localhost";
   private final int PUERTO = 5000;

   //Se conecta al servidor para buscar las informacion del conductor cuando el vigilante busca la información por cedula.
    
   @Override
   public String datosConductorCedula(String entradaCedula){
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida("informacionConductorCedula",entradaCedula);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;

   } 
   //Se conecta al servidor para buscar las informacion del conductor cuando el vigilante busca la información por codigo
   @Override
   public String datosConductorCodigo(String entradaCodigo){
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida("informacionConductorCodigo",entradaCodigo);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;

   } 
   //Confirma si el usario ingresado en la vista login es vigilante o administrador
   @Override
    public String confirmarLogin(String usuario,String pass){
               String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalidaVigilante("confirmarLogin",usuario,pass);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
   }
    //Se conecta al servidor para buscar y obtener los datos del vigilante cuando ingresa el usuario y la contraseña en la vista login.
   @Override
    public String datosVigilante(String usuario,String pass){
    
                String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalidaVigilante("informacionVigilante",usuario,pass);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    //Se conecta al sevidor para buscar la información en la base de datos del administrativo
     @Override
    public String datosAdministrativo(String usuario,String pass){
        
                String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalidaVigilante("informacionAdministrador",usuario,pass);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    //Se conecta al servidor para buscar en la base de datos la información de los automoviles del conductor, cuado el usuario busca la información del conductor por codigo.
   @Override
    public String datosAutomovilesPorCedula(String entradaCedula){
        String respuesta = null;
        try{
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida("informacionAutomovilConductorCedula",entradaCedula);
            cerrarFlujos();
            desconectar();
        }catch(IOException ex){
            Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    //Se conecta al servidor para buscar en la base de datos la información de los automoviles del conductor, cuado el usuario busca la información del conductor por codigo.
    @Override 
    public String datosAutomovilesPorCodigo(String entradaCodigo){
         String respuesta = null;
        try{
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida("informacionAutomovilConductorCodigo",entradaCodigo);
            cerrarFlujos();
            desconectar();
        }catch(IOException ex){
            Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    //Se conecta al servidor para registrar los datos del conductor en la base de datos.
    @Override
    public void ingresarDatosConductor(String cedula, String codigo,String nombre,String apellido,String rol, String genero , String fechaNacimiento) {
        try{
            conectar(IP_SERVIDOR,PUERTO);
            leerFlujoEntradaSalidadIngresarConductor("ingresarConductor", cedula, codigo, nombre, apellido, rol, genero, fechaNacimiento);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
           Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    @Override
        //Se conecta al servidor para registrar los datos del automovil y asociarlo a un conductor en la base de datos.
    public void ingresarDatosAutomovil(String placa, String marca, String tipo,String cedulaConductor) {
        String respuesta;
        GestorConductor gc;
        try{
            //Busca la información del conductor para confirmar que existe
            conectar(IP_SERVIDOR,PUERTO);
            respuesta = leerFlujoEntradaSalida("informacionConductorCedula",cedulaConductor);
            gc = new GestorConductor();
            Conductor conductor = gc.deserializarConductor(respuesta);
            if(conductor.getCedula() == null){
            JOptionPane.showMessageDialog(null,"El conductor con cedula "+cedulaConductor+" no existe en la bases de datos");
        }else{
            //Una vez confirma que existe el conductor le asocia el vehiculo registrado
            leerFlujoEntradaSalidaIngresarVehiculo("ingresarAutomovil",placa,marca,tipo);
            System.out.println(conductor.getCedula());
            vincularAutomovilConductor(placa,conductor.getCedula(),conductor.getCodigo());
        }
            cerrarFlujos();
            desconectar();
        }catch (IOException ex){
                Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Ingresa en el servidor para vincular un automovil a un conductor en la base de datos
    @Override
    public void vincularAutomovilConductor(String placa, String numeroId,String codigo) {
        try{
            conectar(IP_SERVIDOR,PUERTO);
            leerFlujoEntradaSalidaVincularConductorAutomovil("vicularAutomovilConductor",placa,numeroId,codigo);
            cerrarFlujos();
            desconectar();
        }catch (IOException ex){
                Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    // actualizarMapa() se conecta al servidor para buscar el estado de las bahias, para luego actualizar el mapa.
    @Override
    public String actualizarMapa(){
        String respuesta = null;
        try{
            conectar(IP_SERVIDOR,PUERTO);
            respuesta = leerFlujoEntradaSalida("actualizarMapa",null);
            cerrarFlujos();
            desconectar();
        }catch(IOException ex){
            Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    //Se conecta al servidor para actualizar los estados de las bahias, por ejemplo: cuando se desocupa la bahia
   //se actualiza la información del estado de la bahia en la base de datos 
    @Override 
    public void actualizarBahia(String estado,String nombreBahia){
        try{
            conectar(IP_SERVIDOR,PUERTO);
            leerFlujoEntradaSalidaActualizarBahia("actualizarBahia",estado,nombreBahia);
            cerrarFlujos();
            desconectar();
        
        }catch(IOException ex){
            Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void leerFlujoEntradaSalidaActualizarBahia(String consulta,String estado,String nombreBahia) throws IOException{
         entradaDecorada = new Scanner(socket.getInputStream());
        salidaDecorada = new PrintStream(socket.getOutputStream());
        salidaDecorada.flush();
        salidaDecorada.println(consulta+","+estado+","+nombreBahia);
    }
    
    private void leerFlujoEntradaSalidadIngresarConductor(String consulta,String cedula, String codigo,String nombre,String apellido,String rol, String genero , String fechaNacimiento) throws IOException{
        entradaDecorada = new Scanner(socket.getInputStream());
        salidaDecorada = new PrintStream(socket.getOutputStream());
        salidaDecorada.flush();
        // Usando el protocolo de comunicaciÃ³n
        salidaDecorada.println(consulta+"," + cedula + "," + codigo + "," + nombre + "," + apellido + "," + rol + "," + ","+ genero + "," + fechaNacimiento);
    }
    private void leerFlujoEntradaSalidaIngresarVehiculo(String consulta,String placa,String marca,String tipo) throws IOException{
        entradaDecorada = new Scanner(socket.getInputStream());
        salidaDecorada = new PrintStream(socket.getOutputStream());
        salidaDecorada.flush();
        salidaDecorada.println(consulta+","+placa+","+marca+","+tipo);
    }
    private String leerFlujoEntradaSalida(String consulta,String identificacion) throws IOException {
        String respuesta = "";
        entradaDecorada = new Scanner(socket.getInputStream());
        salidaDecorada = new PrintStream(socket.getOutputStream());
        salidaDecorada.flush();
        // Usando el protocolo de comunicaciÃ³n
        salidaDecorada.println(consulta+"," + identificacion);
        if (entradaDecorada.hasNextLine()) {
            respuesta = entradaDecorada.nextLine();
        }
        return respuesta;
    }
    
    private String leerFlujoEntradaSalidaVigilante(String consulta,String usuario, String pass) throws IOException{
        String respuesta = "";
         entradaDecorada = new Scanner(socket.getInputStream());
        salidaDecorada = new PrintStream(socket.getOutputStream());
        salidaDecorada.flush();
        // Usando el protocolo de comunicaciÃ³n
        salidaDecorada.println(consulta+"," + usuario +","+ pass);
        if (entradaDecorada.hasNextLine()) {
            respuesta = entradaDecorada.nextLine();
        }
        return respuesta;
    }
    private void leerFlujoEntradaSalidaVincularConductorAutomovil(String consulta,String placa,String id,String codigo) throws IOException{
        entradaDecorada = new Scanner(socket.getInputStream());
        salidaDecorada = new PrintStream(socket.getOutputStream());
        salidaDecorada.flush();
        salidaDecorada.println(consulta+","+placa+","+id+","+codigo);
    }
   
    
    private void cerrarFlujos() {
        salidaDecorada.close();
        entradaDecorada.close();
    }
    
    

    private void desconectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void conectar(String address, int port) throws IOException {
        socket = new Socket(address, port);
        System.out.println("Conectado");   
    }



    
   
}
