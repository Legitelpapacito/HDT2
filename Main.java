import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        IStack<Integer> stack = new VectorStack<>();
        IPostfixCalculator calculator = new PostfixCalculator(stack);

        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                int result = calculator.evaluate(line);
                System.out.println("Resultado: " + result);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }
}
