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
public class Administrativo extends Persona{
    public Administrativo(){
    
    }  
    public Administrativo(String id, String nombre, String apellido,String fechaNacimiento,String genero){
        super(id,nombre,apellido,fechaNacimiento,genero);
    }
}
