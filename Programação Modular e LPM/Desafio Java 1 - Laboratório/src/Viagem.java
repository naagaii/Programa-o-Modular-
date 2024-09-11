
import java.util.Scanner;

public class Viagem {
    final static double rendimentoMoto = 23.0;
    final static double precoGasolina = 6.28;
    final static double custo200km = 120.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a distância da viagem:");
        double distanciaViagem = scanner.nextDouble();

        double litrosNecessarios = calcularLitrosNecessarios(distanciaViagem);
        double customanutencao = calcularCustoManutencao(distanciaViagem);
        double custoTotal = calcularCustoTotal(distanciaViagem, distanciaViagem);
        double custoGasolina = calcularCustoCombustivel(litrosNecessarios);
        exibirResultados(litrosNecessarios, customanutencao, custoTotal);

        scanner.close();
    }

    public static double calcularLitrosNecessarios(double distanciaViagem) {
        return distanciaViagem / rendimentoMoto;
    }

    public static double calcularCustoCombustivel(double litrosNecessarios) {
        return litrosNecessarios * precoGasolina;
    }

    public static double calcularCustoManutencao(double distanciaViagem) {
        return (distanciaViagem / 200) * custo200km;
    }

    public static double calcularCustoTotal(double custoGasolina, double custoManutencao) {
        return custoGasolina + custoManutencao;
    }

    public static void exibirResultados(double litrosNecessarios, double custoGasolina, double custoTotal) {
        System.out.printf("Quantidade de litros de gasolina necessários: %.2f litros\n", litrosNecessarios);
        System.out.printf("Custo da gasolina: R$ %.2f\n", custoGasolina);
        System.out.printf("Custo total com manutenção: R$ %.2f\n", custoTotal);
    }
}
