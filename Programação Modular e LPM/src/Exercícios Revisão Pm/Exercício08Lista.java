import java.util.Scanner;

public class Exercício08Lista {
    /*
     * Sabendo que 1º de janeiro de 2024 foi uma segunda feira, escreva um método
     * que receba uma data e diga
     * em qual dia da semana esta data acontecerá em 2024. Escreva um programa
     * principal para testar seu método.
     */

     public static String determinarDiaDaSemana(int dia, int mes) {
        // Array que armazena o número de dias de cada mês em 2024 (ano bissexto)
        int[] diasPorMes = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // Calcular o número total de dias desde o início do ano até a data fornecida
        int totalDias = dia; // Começa com os dias do mês atual
        for (int i = 0; i < mes - 1; i++) {
            totalDias += diasPorMes[i];
        }

        // Sabemos que 1º de janeiro de 2024 foi uma segunda-feira (índice 1)
        // Calcular o índice do dia da semana (0 = Domingo, 1 = Segunda, ..., 6 =
        // Sábado)
        int diaDaSemanaIndice = (totalDias + 1) % 7;

        // Array com os dias da semana
        String[] diasDaSemana = { "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira",
                "Sexta-feira", "Sábado" };

        return diasDaSemana[diaDaSemanaIndice];
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o dia: ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês: ");
        int mes = scanner.nextInt();

        String diaDaSemana = determinarDiaDaSemana(dia, mes);
        System.out.println("A data " + dia + "/" + mes + "/2024 cairá em um(a) " + diaDaSemana + ".");

        scanner.close();
    }

    
}