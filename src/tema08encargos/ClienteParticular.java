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
public class ClienteParticular extends Cliente{
    private double tarjetaNumero;

    public ClienteParticular(double tarjetaNumero, String nombre, String direccion, boolean esCorporativo) {
        super(nombre, direccion, esCorporativo);
        this.tarjetaNumero = tarjetaNumero;
    }
    
    public double getTarjetaNumero() {
        return tarjetaNumero;
    }

    public void setTarjetaNumero(double tarjetaNumero) {
        this.tarjetaNumero = tarjetaNumero;
    }
     @Override
    public double pago() {
        double suma=0;
        if(this.listaEncargos.size()>0){
            for(int i=0;i<this.listaEncargos.size();i++){
                System.out.println("Este encargo le cuesta " + this.listaEncargos.get(i).getValor()+"€");
                suma=suma+(this.listaEncargos.get(i).getValor()*0.98);
                
            }
        }else{
            System.out.println("El cliente no tiene ningun encargo");
        }
        return suma;

    }
    @Override
    public String toString() {
        return this.nombre+"\t"+this.direccion+"\t"+this.tarjetaNumero+"\t";
    }
    
    
    
}
