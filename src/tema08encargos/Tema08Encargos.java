/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema08encargos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Tema08Encargos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ClienteParticular clientP;
        ClienteCorporativo clientC;
        Encargo encargo1;
        ArrayList<Cliente> listaCl = new ArrayList<Cliente>();
        int opcion, tipoC;
        double tarjetanumP, valorE;
        Calendar fecha1 = Calendar.getInstance();
        String nombre, direccion, cuentaC;

        do {
            mostrarMenu();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Indique el tipo de cliente 0 para particular y 1 para corporativo");
                    tipoC = teclado.nextInt();
                    if (tipoC == 0) {
                        System.out.println("Introduce nombre de cliente");
                        teclado.nextLine();
                        nombre = teclado.nextLine();
                        System.out.println("Introduce direccion de cliente");
                        direccion = teclado.nextLine();
                        System.out.println("Introduce numero de tarjeta del cliente");
                        tarjetanumP = teclado.nextDouble();
                        clientP = new ClienteParticular(tarjetanumP, nombre, direccion, false);
                        listaCl.add(clientP);
                        imprimirCliente(listaCl);
                    } else if (tipoC == 1) {
                        System.out.println("Introduce nombre de cliente");
                        teclado.nextLine();
                        nombre = teclado.nextLine();
                        System.out.println("Introduce direccion de cliente");
                        direccion = teclado.nextLine();
                        System.out.println("Introduce cuenta del cliente");
                        cuentaC = teclado.nextLine();
                        clientC = new ClienteCorporativo(cuentaC, nombre, direccion, true);
                        listaCl.add(clientC);
                        imprimirCliente(listaCl);
                    } else {
                        System.out.println("Debes introducir 1 o 0");
                    }
                    break;
                case 2:
                    //System.out.println("Introduzca nombre de cliente");
                    System.out.println("A que cliente quieres añadir un encargo? Introduzca nombre");
                    imprimirCliente(listaCl);
                    teclado.nextLine();
                    nombre = teclado.nextLine();
                    if (buscarCliente(listaCl, nombre) != null) {
                        Cliente activo = buscarCliente(listaCl, nombre);
                        System.out.println("Introduzca importe del encargo");
                        valorE = teclado.nextDouble();
                        encargo1 = new Encargo("1", fecha1, valorE);
                        activo.añadirEncargo(encargo1);
                        System.out.println("Añadido exitosamente");
                    } else {
                        System.out.println("El cliente no existe");
                    }

                    break;
                case 3:
                    System.out.println("A que cliente desea informar de su importe a pagar?");
                    imprimirCliente(listaCl);
                    teclado.nextLine();
                    nombre = teclado.nextLine();
                    if (buscarCliente(listaCl, nombre) != null) {
                        Cliente activo = buscarCliente(listaCl, nombre);
                        System.out.println("El total del pedido es "+activo.pago()+"€");
                    } else {
                        System.out.println("El cliente no existe");
                    }
                    break;
                    
                case 4:
                    System.out.println("Se van listando a medida que se modifican o insertan...");
                    break;
            }

        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("1.-Alta de clientes CORPORATIVOS Y PARTICULARES");
        System.out.println("2.-Alta de encargos y añadir a Clientes");
        System.out.println("3.-Pago de Clientes");

    }

    public static void imprimirCliente(ArrayList<Cliente> listaCl) {
        
        for (Cliente cl : listaCl) {
            if(cl.isEsCorporativo()==true){
                System.out.println("El siguiente cliente es COOPERATIVO");
            }else{
                System.out.println("El siguiente cliente es particular");
            }
            System.out.println(cl.toString());
        }

    }

    public static Cliente buscarCliente(ArrayList<Cliente> listaCl, String nombre) {
        for (Cliente cl : listaCl) {
            if (cl.getNombre().equalsIgnoreCase(nombre)) {
                return cl;
            }
        }
        return null;
    }
    

}
