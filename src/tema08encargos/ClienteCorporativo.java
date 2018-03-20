/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema08encargos;

/**
 *
 * @author mati
 */
public class ClienteCorporativo extends Cliente {

    private String cuenta;

    public ClienteCorporativo(String cuenta, String nombre, String direccion, boolean esCorporativo) {
        super(nombre, direccion, esCorporativo);
        this.cuenta = cuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
   
    @Override
    public double pago() {
        double suma=0;
        if(this.listaEncargos.size()>0){
            for(int i=0;i<this.listaEncargos.size();i++){
                System.out.println("Este encargo le cuesta " + this.listaEncargos.get(i).getValor()+"€");
                suma=suma+(this.listaEncargos.get(i).getValor()*1.05);
                
            }
        }else{
            System.out.println("El cliente no tiene ningun encargo");
        }
        return suma;

    }

    @Override
    public String toString() {
        return this.nombre+"\t"+this.direccion+"\t"+this.cuenta+"\t";
    }
    
    
    

}
