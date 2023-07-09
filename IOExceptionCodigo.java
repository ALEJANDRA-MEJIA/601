package excepciones;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOExceptionCodigo {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            
            reader = new BufferedReader(new FileReader("archivo.txt"));
            String line = reader.readLine();
            System.out.println("Primera línea del archivo: " + line);
        } catch (IOException e) {
            System.out.println("Se ha producido una excepción: IOException");
            e.printStackTrace();
        } finally {
           
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}