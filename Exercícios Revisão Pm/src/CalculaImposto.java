import java.util.Scanner;

public class CalculaImposto {

    public static double leValor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor: ");
        double valorBase = scanner.nextDouble();
        scanner.close();
        return valorBase;
        
    }

    public static double calcularImposto(double valorBase) {
        double imposto = 0;
        if (valorBase <= 1200) {
            imposto = 0;
        } else if (valorBase >= 1201 && valorBase <= 2500) {
            imposto = valorBase * 0.10;
        } else if (valorBase >= 2501 && valorBase <= 5000) {
            imposto = valorBase * 0.15;
        } else {
            imposto = valorBase * 0.20;
        }
        return imposto;
    }

    public static void main(String[] args) {
        double valorBase = leValor();

        double imposto = calcularImposto(valorBase);
        System.out.printf("O valor do imposto a pagar é: R$ %.2f%n", imposto);

    }
}
