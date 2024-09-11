import java.util.Scanner;

public class AloPadawan {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String nome;

        System.out.print("Qual é o seu nome, jovem Padawan?");
        nome = leitor.nextLine();
        System.out.printf("Bem vindo ao lado Java da força, %s \n", nome);

        leitor.close();
    }
}
