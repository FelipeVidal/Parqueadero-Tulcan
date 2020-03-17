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
public class Vigilante extends Persona{
    private String empresa;
    public Vigilante(){

    }
    public Vigilante(String id, String nombre, String apellido,String fechaNacimiento,String genero,String empresa){
       super(id,nombre,apellido,fechaNacimiento,genero);
       this.empresa=empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
}
