/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueaderotulcan.controlador;

import parqueaderotulcan.modelo.ServicioServidorUniversidad;

/**
 *
 * @author Felipe Vidal y Aldair Zemanate
 */
public class GestorMulta {
   public void GestorMulta(){
       
   }
   public void ingresarMulta(String cedulaConductor, String fecha, String descripcion ){
        //Se crea una instancia de ServicioServidorUniversidad registrar la multa

       ServicioServidorUniversidad newServicio = new ServicioServidorUniversidad();
       newServicio.registrarMulta(cedulaConductor, fecha, descripcion);
   }
}
