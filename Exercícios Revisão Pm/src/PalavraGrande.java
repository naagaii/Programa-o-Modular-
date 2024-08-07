public class PalavraGrande {
    public static void main(String[] args) {
        // Tamanho das caixas e espaço entre elas
        int larguraCaixa = 8;
        int alturaCaixa = 7;
        int espacoEntreCaixas = 2;

        // Linhas da tela
        for (int linha = 0; linha < alturaCaixa * 2 + 1; linha++) {
            // Primeira caixa
            if (linha < alturaCaixa) {
                imprimirCaixa(larguraCaixa);
                imprimirEspacos(espacoEntreCaixas);
            } else {
                imprimirEspacos(larguraCaixa + espacoEntreCaixas);
            }

            // Segunda caixa
            if (linha == 0 || linha == alturaCaixa || linha == alturaCaixa * 2) {
                imprimirCaixa(larguraCaixa);
            } else {
                imprimirEspacos(larguraCaixa);
            }
            imprimirEspacos(espacoEntreCaixas);

            // Terceira caixa
            if (linha < alturaCaixa) {
                imprimirEspacos(larguraCaixa + espacoEntreCaixas);
            } else {
                imprimirCaixa(larguraCaixa);
            }

            System.out.println();
        }
    }

    public static void imprimirCaixa(int largura) {
        for (int i = 0; i < largura; i++) {
            System.out.print("*");
        }
    }

    public static void imprimirEspacos(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }
}
