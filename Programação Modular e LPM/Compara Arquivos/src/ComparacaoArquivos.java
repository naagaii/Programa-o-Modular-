
import java.io.FileInputStream;
import java.io.IOException;

public class ComparacaoArquivos {
    public static void main(String[] args) {
        String caminhoArquivo1 = "Exercícios Revisão Pm/src/ComparaArquivos/arquivo1.txt";
        String caminhoArquivo2 = "Exercícios Revisão Pm/src/ComparaArquivos/arquivo2.txt";

        try {
            compararArquivos(caminhoArquivo1, caminhoArquivo2);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler os arquivos: " + e.getMessage());
        }
    }

    public static void compararArquivos(String caminhoArquivo1, String caminhoArquivo2) throws IOException {
        try (FileInputStream file1 = new FileInputStream(caminhoArquivo1);
                FileInputStream file2 = new FileInputStream(caminhoArquivo2)) {

            int byte1, byte2;
            int posicao = 0;

            while ((byte1 = file1.read()) != -1) {
                posicao++;
                if ((byte2 = file2.read()) == -1) {
                    System.out.println(
                            "Os arquivos têm tamanhos diferentes. Diferença encontrada na posição: " + posicao);
                    return;
                }
                if (byte1 != byte2) {
                    System.out.println("Os arquivos diferem no byte de posição: " + posicao);
                    return;
                }
            }

            if (file2.read() != -1) {

                System.out.println("Os arquivos têm tamanhos diferentes.");
            } else {

                System.out.println("Os arquivos são idênticos.");
            }
        }
    }
}
