import java.util.Scanner;

public class Exercício06Lista {
    /*
     * Um algoritmo para multiplicação rápida por 11 de números de 2 dígitos
     * funciona assim: para multiplicar 81
     * x 11, some os dígitos do número (8 + 1 = 9) e insira o resultado entre os
     * dígitos (891). Se a soma der maior que 9,
     * incremente o dígito da esquerda (vai-um): 56 x 11 = 616. Escreva um programa
     * que efetue multiplicações por 11
     * usando este algoritmo.
     */

    public static int lerNumero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número de dois dígitos: ");
        int numero = scanner.nextInt();
        return numero;
    }

    public static int extrairDezenas(int numero) {
        return numero / 10;
    }

    public static int extrairUnidades(int numero) {
        return numero % 10;
    }

    public static int somarDigitos(int dezenas, int unidades) {
        return dezenas + unidades;
    }

    public static int multiplicarPor11(int dezenas, int unidades, int soma) {
        if (soma < 10) {
            return (dezenas * 100) + (soma * 10) + unidades;
        } else {
            return ((dezenas + 1) * 100) + ((soma - 10) * 10) + unidades;
        }
    }

    public static void main(String[] args) {
        int numero = lerNumero();

        // Verifica se o número tem dois dígitos
        if (numero < 10 || numero > 99) {
            System.out.println("Por favor, insira um número de dois dígitos.");
        } else {
            int dezenas = extrairDezenas(numero);
            int unidades = extrairUnidades(numero);
            int soma = somarDigitos(dezenas, unidades);

            int resultado = multiplicarPor11(dezenas, unidades, soma);
            System.out.println("Resultado: " + resultado);
        }
    }

}
