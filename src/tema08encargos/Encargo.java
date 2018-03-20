/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema08encargos;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mati
 */
public class Encargo {
    private String IDencargo;
    private Calendar fecha;
    private double valor;

    public Encargo(String IDencargo, Calendar fecha, double valor) {
        this.IDencargo = IDencargo;
        this.fecha = fecha;
        this.valor = valor;
    }

    
    Encargo(){}

    public String getIDencargo() {
        return IDencargo;
    }

    public void setIDencargo(String IDencargo) {
        this.IDencargo = IDencargo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
    
    

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}


