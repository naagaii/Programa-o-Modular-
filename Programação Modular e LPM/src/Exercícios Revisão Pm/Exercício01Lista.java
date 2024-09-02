import java.util.Scanner;

public class Exercício01Lista {
    /*
     * Preencha um vetor de 6 números inteiros a partir da entrada do usuário e,
     * depois, inverter as posições dos
     * números do vetor. Por exemplo, se o vetor original era 4-8-15-16-23-42, ao
     * final da execução deve ser
     * apresentado o resultado 42-23-16-15-8-4.
     */

    public static void leVetores(int[] vetor) {
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite o numero" + (i + 1) + ": ");
            vetor[i] = teclado.nextInt();
        }
        teclado.close();
    }

    public static void inverteVetores(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = vetor[i];
            vetor[i] = vetor[n - 1 - i];
            vetor[n - 1 - i] = temp;
        }
    }

    public static void exibeVetor(int[] vetor) {
        System.out.println("Números no vetor:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] vetor = new int[6];
        leVetores(vetor);

        System.out.println("Vetor original:");
        exibeVetor(vetor);

        inverteVetores(vetor);

        System.out.println("Vetor invertido:");
        exibeVetor(vetor);

    }
}
