package excepciones;
public class ClassNotFoundExceptionExample {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("com.example.NonExistentClass");
            System.out.println("Clase cargada exitosamente: " + cls.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("Se ha producido una excepción: ClassNotFoundException");
            e.printStackTrace();
        }
    }
}