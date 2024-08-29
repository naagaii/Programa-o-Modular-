import java.util.Scanner;

public class ConversaoTemperatura {
    public static double celsiusParaFahrenheit(int celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }

    public static void mostrarTabela() {
        Scanner scanner = new Scanner(System.in);
        final int LINHAS_POR_TELA = 20;
        int contadorLinhas = 0;

        System.out.println("Tabela de Conversão Celsius para Fahrenheit:");
        System.out.println("-------------------------------------------");
        System.out.println("Celsius " + "   " + " Fahrenheit ");

        for (int celsius = 0; celsius <= 100; celsius++) {
            double fahrenheit = celsiusParaFahrenheit(celsius);
            System.out.println(celsius + "   " + fahrenheit);
            contadorLinhas++;

            if (contadorLinhas == LINHAS_POR_TELA) {
                System.out.print("Pressione Enter para continuar...");
                scanner.nextLine();
                contadorLinhas = 0;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        mostrarTabela();
    }

}
