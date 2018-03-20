/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema08encargos;

import java.util.ArrayList;

/**
 *
 * @author mati
 */
public class Cliente {

    protected String nombre;
    protected String direccion;
    protected ArrayList<Encargo> listaEncargos = new ArrayList<Encargo>();
    protected boolean esCorporativo;

    public Cliente(String nombre, String direccion, boolean esCorporativo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.esCorporativo = esCorporativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Encargo> getListaEncargos() {
        return listaEncargos;
    }

    public void setListaEncargos(ArrayList<Encargo> listaEncargos) {
        this.listaEncargos = listaEncargos;
    }

    public double pago() {
        double suma = 0;
        if (this.listaEncargos.size() > 0) {
            for (int i = 0; i < this.listaEncargos.size(); i++) {
                System.out.println("Este encargo le cuesta " + this.listaEncargos.get(i).getValor()+"€");
                suma = suma + this.listaEncargos.get(i).getValor();
            }
        } else {
            System.out.println("El cliente no tiene productos");
        }
        return suma;
    }

    @Override
    public String toString() {
        return nombre + "\t" + direccion + "\t" + this.esCorporativo;
    }

    public void añadirEncargo(Encargo g) {
        this.listaEncargos.add(g);
    }

    public boolean isEsCorporativo() {
        return esCorporativo;
    }

    public void setEsCorporativo(boolean esCorporativo) {
        this.esCorporativo = esCorporativo;
    }

}
