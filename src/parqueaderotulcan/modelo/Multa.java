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
public class Multa {
    private String cedulaConductor;
    private String horaFecha;
    private String Descripcio;
    
    public Multa(){
        
    }
    
    public Multa(String cedulaConductor, String horaFecha, String Descripcio) {
        this.cedulaConductor = cedulaConductor;
        this.horaFecha = horaFecha;
        this.Descripcio = Descripcio;
    }

    public String getCedulaConductor() {
        return cedulaConductor;
    }

    public void setCedulaConductor(String cedulaConductor) {
        this.cedulaConductor = cedulaConductor;
    }

    public String getHoraFecha() {
        return horaFecha;
    }

    public void setHoraFecha(String horaFecha) {
        this.horaFecha = horaFecha;
    }

    public String getDescripcio() {
        return Descripcio;
    }

    public void setDescripcio(String Descripcio) {
        this.Descripcio = Descripcio;
    }
    
}
