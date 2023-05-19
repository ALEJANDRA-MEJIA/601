package paradigma_v2;
import java.util.Scanner;

public class Paradigma_v2 {

    public static void main(String[] args) {
        int n, a, b;
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduce un valor: ");
        n=leer.nextInt();
        a=n%3;
        b=n%5;
        
        if(b==0 && a==0){
            System.out.println("TriFiv");
        }
        else{
            if(a==0){
                System.out.println("Tri");
            }
            else{
                if(b==0){
                    System.out.println("Fiv");
                }
            } 
        }
        if(a>=1 && b>=1){
            System.out.println("El valor " + n + " no es multiplo de 3 y/o 5");
        }
    }   
}

//45, 100, 24, 34
//TriFiv, Fiv, Tri, No hay...