import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Conversor de temperatura CLI.
 * Lê um valor em Celsius e mostra o equivalente em Fahrenheit e Kelvin.
 */
public class ConversorTemperatura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Força o ponto como separador decimal (25.5), independente do idioma do sistema.
        scanner.useLocale(Locale.US);

        try {
            double celsius = lerCelsius(scanner);

            double fahrenheit = celsiusParaFahrenheit(celsius);
            System.out.printf(Locale.US, "%.2f°C equivale a %.2f°F%n", celsius, fahrenheit);

            try {
                double kelvin = celsiusParaKelvin(celsius);
                System.out.printf(Locale.US, "%.2f°C equivale a %.2fK%n", celsius, kelvin);
            } catch (IllegalArgumentException e) {
                System.out.println("Não foi possível converter para Kelvin: " + e.getMessage());
            }
        } catch (NoSuchElementException e) {
            // Entrada encerrada (Ctrl+D / Ctrl+Z) antes de digitar um número válido.
            System.out.println("\nEntrada encerrada sem um valor válido.");
        } finally {
            scanner.close();
        }
    }

    /**
     * Pede repetidamente um valor até o usuário digitar um número válido.
     */
    private static double lerCelsius(Scanner scanner) {
        while (true) {
            System.out.print("Digite a temperatura em Celsius: ");
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número (ex: 25.5).");
                scanner.next(); // descarta o token inválido para não travar o loop
            }
        }
    }

    public static double celsiusParaFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }

    public static double celsiusParaKelvin(double celsius) {
        double kelvin = celsius + 273.15;
        // Kelvin não pode ser negativo (zero absoluto = -273.15°C)
        if (kelvin < 0) {
            throw new IllegalArgumentException("Temperatura abaixo do zero absoluto.");
        }
        return kelvin;
    }
}
