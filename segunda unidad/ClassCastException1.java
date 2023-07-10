package excepciones;
public class ClassCastException1 {
    public static void main(String[] args) {
        try {
            
            Object obj = "Hola Mundo";

            
            if (obj instanceof Integer) {
                Integer number = (Integer) obj;
                System.out.println("El número es: " + number);
            } else {
                System.out.println("El objeto no es una instancia de Integer");
            }
        } catch (ClassCastException e) {
            System.out.println("Se ha producido una excepción: ClassCastException");
            e.printStackTrace();
        }
        }
    
}