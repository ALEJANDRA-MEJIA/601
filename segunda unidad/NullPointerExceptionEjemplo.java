package excepciones;
public class NullPointerExceptionEjemplo {
    public static void main(String[] args) {
        try {
            
            String str = null;
            int length = str.length();

            System.out.println("La longitud de la cadena es: " + length);
        } catch (NullPointerException e) {
            System.out.println("Se ha producido una excepción: NullPointerException");
            e.printStackTrace();
        }
    }
}