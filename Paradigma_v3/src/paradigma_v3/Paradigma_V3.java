package paradigma_v3;
import java.util.Scanner;

public class Paradigma_V3 {
    int n, a, b;
    Scanner leer=new Scanner(System.in);
    
    public int Datos(){
        System.out.println("Introduce un valor: ");
        n=leer.nextInt();
        return n;
    }
    
    public void Proceso(int n){
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
    
    public static void main(String[] args) {
        Paradigma_V3 x = new Paradigma_V3();
        int b1 = x.Datos();
        x.Proceso(b1);
    }
}

//45, 100, 24, 34
//TriFiv, Fiv, Tri, No hay...