package excepciones;
public class ArrayIndexException {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        try {
            // Intentamos acceder a un índice que está fuera del rango del array
            int value = array[3];
            System.out.println("El valor en el índice 3 es: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Se ha producido una excepción: ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        }
    }
}