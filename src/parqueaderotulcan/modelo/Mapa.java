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
public class Mapa {
    private String nombrePuesto;
    private String estado;
    public Mapa(){
        
    }

    public Mapa(String nombrePuesto, String estado) {
        this.nombrePuesto = nombrePuesto;
        this.estado = estado;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
