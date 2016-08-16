/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sustentacion1;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class producto {
    private String nombre;
    private int cantidad;
    private double precio;
    private Scanner lector = new Scanner(System.in);
    private double vparcial;

    public double getVparcial() {
        return vparcial;
    }

    public void setVparcial(double vparcial) {
        this.vparcial = vparcial;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Scanner getLector() {
        return lector;
    }

    public void setLector(Scanner lector) {
        this.lector = lector;
    }
    
    public int buscar(String a, ArrayList<producto> productos){
        int posicion = 0;
        producto prueba = new producto();
        for (int k=0;k<productos.size();k++){
                        prueba = productos.get(k);
                        if(a.matches(prueba.getNombre())){
                            posicion = k;
                            break;//prueba.g_parciales();
                        }else{
                            //System.out.println("El producto no existe");
                            posicion = 100;
                        }
                    }
        return posicion;
    }
    
    public void Leer_datos(){
        System.out.print("Ingrese el nombre del producto: ");
        nombre = lector.next();
        System.out.print("Ingrese la cantidad: ");
        cantidad = lector.nextInt();
        System.out.print("Ingrese el precio: ");
        precio = lector.nextDouble();
    }
    
    public void g_parciales(){
        System.out.println("Producto: "+nombre+" Cantidad: "+cantidad+" Precio: "+precio);
    }
    
    public void g_totales(){
        System.out.println("Producto: "+nombre+" Cantidad: "+cantidad+" Precio: "+precio+
                " Ganancia: "+vparcial);
    }
}
