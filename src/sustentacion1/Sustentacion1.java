/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sustentacion1;
import java.util.Scanner;
import java.util.ArrayList; 

/**
 *
 * @author Daniel
 */
public class Sustentacion1 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int opcion;
        int i = 0;
        ArrayList<producto> productos = new ArrayList<producto>();
        
        do{
            System.out.println("=========Menú========");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Realizar ventas");
            System.out.println("6. Mostrar ganancias totales");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = lector.nextInt();
            
            switch(opcion){
                
                case 0:
                    System.out.println("Hasta luego");
                    break;
                    
                case 1:
                    producto producto1 = new producto();
                    producto1.Leer_datos();
                    productos.add(i,producto1);
                    i++;
                    break;
                case 2: 
                    int posicion = 0;
                    producto prueba = new producto();
                    System.out.print("Ingrese el producto a buscar: ");
                    String a = lector.next();
                    posicion = prueba.buscar(a, productos);
                    if (posicion != 100){
                        prueba = productos.get(posicion);
                        prueba.g_parciales();
                    }else{
                        System.out.println("El producto no existe");
                    }
                    break;
                    
                case 3:
                    producto prueba2 = new producto();
                    System.out.print("Ingrese el nombre del producto a borrar: ");
                    String b = lector.next();
                    posicion = prueba2.buscar(b, productos);
                    if (posicion != 100){
                        prueba2 = productos.get(posicion);
                        productos.remove(posicion);
                        i = productos.size();
                    }else{
                        System.out.println("El producto no existe");
                    }
                    
                    break;
                
                case 4:
                    producto prueba3 = new producto();
                    for(int k=0;k<productos.size();k++){
                       prueba3 = productos.get(k);
                       prueba3.g_parciales();
                    }
                    break;
                    
                case 5:
                    int queda = 0;
                    producto prueba4 = new producto();
                    System.out.print("Ingrese el nombre del producto a vender: ");
                    String c = lector.next();
                    posicion = prueba4.buscar(c, productos);
                    if (posicion != 100){
                        System.out.print("Ingrese la cantidad a vender: ");
                        int cant = lector.nextInt();
                        prueba4 = productos.get(posicion);
                        //Actualizar cantidad en inventario
                        queda = (prueba4.getCantidad()) - cant;
                        prueba4.setCantidad(queda);
                        //Calcular ganancia
                        prueba4.setVparcial(cant*(prueba4.getPrecio()));
                    }else{
                        System.out.println("El producto no existe");
                    }
                    break;
                    
                case 6:
                    double suma = 0;
                    producto prueba5 = new producto();
                    for(int k=0;k<productos.size();k++){
                       prueba3 = productos.get(k);
                       prueba3.g_totales();
                       suma = suma + prueba3.getVparcial();
                       
                    }
                    System.out.println("Total: "+suma);
                    break;
  
                default:
                    System.out.println("No es una opción!");
                    break;
            }
        }while(opcion != 0);
    }  
}
