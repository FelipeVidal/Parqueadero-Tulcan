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
public class Vigilante extends Persona{
    private String empresa;
    private String usuario;
    private String contrasenia;
    public Vigilante(){

    }
    public Vigilante(String id, String nombre, String apellido,String fechaNacimiento,String genero,String empresa,String usuario,String contrasenia){
       super(id,nombre,apellido,fechaNacimiento,genero);
       this.empresa=empresa;
       this.usuario=usuario;
       this.contrasenia=contrasenia;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}
