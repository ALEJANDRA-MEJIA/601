
package v4trifiv;
import Funciones.funcionMultiplo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class V4TRIFIV {

    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        BufferedReader bufEntrada=new BufferedReader(new InputStreamReader(System.in));
        int numero;
        //creo Objeto
        funcionMultiplo mult = new funcionMultiplo();
        //Entrada de datos
        System.out.println("Dame el numero");
        
        numero = Integer.parseInt(bufEntrada.readLine());
        //Salida
        System.out.println(mult.retornaMultiplo(numero));
    }
    
}
