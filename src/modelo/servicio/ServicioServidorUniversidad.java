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
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicioServidorUniversidad implements IServicioUniversidad {
   private Socket socket = null;
   private Scanner entradaDecorada;
   private PrintStream salidaDecorada;
   private final String IP_SERVIDOR = "localhost";
   private final int PUERTO = 5000;

    
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
    public void ingresarDatosAutomovil(String placa, String marca, String tipo) {
        try{
            conectar(IP_SERVIDOR,PUERTO);
            leerFlujoEntradaSalidaIngresarVehiculo("ingresarAutomovil",placa,marca,tipo);
            cerrarFlujos();
            desconectar();
        }catch (IOException ex){
                Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void vincularAutomovilConductor(String placa, String numeroId) {
        try{
            conectar(IP_SERVIDOR,PUERTO);
            leerFlujoEntradaSalidaVincularConductorAutomovil("vicularAutomovilConductor",placa,numeroId);
            cerrarFlujos();
            desconectar();
        }catch (IOException ex){
                Logger.getLogger(ServicioServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void leerFlujoEntradaSalidaVincularConductorAutomovil(String consulta,String placa,String id) throws IOException{
        entradaDecorada = new Scanner(socket.getInputStream());
        salidaDecorada = new PrintStream(socket.getOutputStream());
        salidaDecorada.flush();
        salidaDecorada.println(consulta+","+placa+","+id);
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
