
class Automovel {
    private String placa;
    private double consumoKmPorLitro;
    private ArrayList<Double> rotas;

    public Automovel(String placa, double consumoKmPorLitro) {
        this.placa = placa;
        this.consumoKmPorLitro = consumoKmPorLitro;
        this.rotas = new ArrayList<>();
    }

    public String getPlaca() {
        return placa;
    }

    public double getConsumoKmPorLitro() {
        return consumoKmPorLitro;
    }

    public void adicionarRota(double km) {
        rotas.add(km);
    }

    public double getTotalKmPercorridos() {
        double totalKm = 0;
        for (double km : rotas) {
            totalKm += km;
        }
        return totalKm;
    }

    public double getTotalCombustivelConsumido() {
        return getTotalKmPercorridos() / consumoKmPorLitro;
    }

    public double getCustoCombustivel(double precoLitro) {
        return getTotalCombustivelConsumido() * precoLitro;
    }
}

public class GestaoLogistica {
    private static final double PRECO_LITRO = 6.19;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Automovel> frota = new HashMap<>();

    public static void main(String[] args) {
        inicializarFrota();
        registrarRotas();
        relatorio();
    }

    private static void inicializarFrota() {
        frota.put("ABC1234", new Automovel("ABC1234", 12.0));
        frota.put("XYZ5678", new Automovel("XYZ5678", 10.0));
        frota.put("LMN9101", new Automovel("LMN9101", 14.0));
        frota.put("JKL3456", new Automovel("JKL3456", 11.0));
        frota.put("OPQ7890", new Automovel("OPQ7890", 9.0));
    }

    private static void registrarRotas() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Digite a placa do automóvel (ou 'sair' para encerrar): ");
            String placa = scanner.nextLine();
            if (placa.equalsIgnoreCase("sair")) {
                continuar = false;
                break;
            }

            Automovel automovel = frota.get(placa);
            if (automovel == null) {
                System.out.println("Automóvel não encontrado.");
                continue;
            }

            System.out.println("Digite a quilometragem da rota: ");
            double km = scanner.nextDouble();
            scanner.nextLine();  // Consome a nova linha

            automovel.adicionarRota(km);
            System.out.println("Rota registrada com sucesso.");
        }
    }

    private static void relatorio() {
        double totalGasto = 0;
        double somaKm = 0;
        double somaConsumo = 0;
        double maiorKm = 0;
        double maiorConsumo = 0;
        String placaMaisKm = "";
        String placaMaisConsumo = "";
        int automoveisAcimaDaMedia = 0;

        for (Automovel automovel : frota.values()) {
            double km = automovel.getTotalKmPercorridos();
            double consumo = automovel.getTotalCombustivelConsumido();
            double custo = automovel.getCustoCombustivel(PRECO_LITRO);

            somaKm += km;
            somaConsumo += consumo;
            totalGasto += custo;

            if (km > maiorKm) {
                maiorKm = km;
                placaMaisKm = automovel.getPlaca();
            }

            if (consumo > maiorConsumo) {
                maiorConsumo = consumo;
                placaMaisConsumo = automovel.getPlaca();
            }
        }

        double mediaConsumo = somaConsumo / frota.size();

        for (Automovel automovel : frota.values()) {
            if (automovel.getTotalCombustivelConsumido() > mediaConsumo) {
                automoveisAcimaDaMedia++;
            }
        }

        System.out.println("Automóvel que percorreu mais quilômetros: " + placaMaisKm);
        System.out.println("Automóvel que consumiu mais combustível: " + placaMaisConsumo);
        System.out.println("Valor total gasto com combustível: R$ " + String.format("%.2f", totalGasto));
        System.out.println("Número de automóveis gastando mais do que a média da frota: " + automoveisAcimaDaMedia);
    }
}
