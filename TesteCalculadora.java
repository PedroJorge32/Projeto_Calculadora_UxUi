package calculadora;

// Testes da classe Calculadora: mostra entrada, resultado esperado e resultado obtido
public class TesteCalculadora {

    // Calculadora usada em todos os testes
    static Calculadora calculadora = new Calculadora();

    // Contadores de testes
    static int passou = 0;
    static int falhou = 0;

    public static void main(String[] args) {
        System.out.println("===== TESTES DA CALCULADORA =====");

        // Testes que devem dar certo
        testar("Soma", "10 + 5", 15, calculadora.calc(10, 5, "+"));
        testar("Subtração", "10 - 5", 5, calculadora.calc(10, 5, "-"));
        testar("Multiplicação", "4 * 5", 20, calculadora.calc(4, 5, "*"));
        testar("Divisão", "10 / 2", 5, calculadora.calc(10, 2, "/"));
        testar("Divisão decimal", "7 / 2", 3.5, calculadora.calc(7, 2, "/"));

        // Testes que devem dar erro
        testarErro("Divisão por zero", 10, 0, "/");
        testarErro("Operação inválida", 10, 5, "%");

        mostrarResumo();
    }

    // Compara o resultado esperado com o obtido
    static void testar(String nome, String entrada, double esperado, double obtido) {
        mostrarCabecalho(nome, entrada, String.valueOf(esperado));
        System.out.println("Obtido: " + obtido);
        registrar(esperado == obtido);
    }

    // Executa uma conta que deve ser bloqueada e confere se a mensagem de erro apareceu
    static void testarErro(String nome, int numero1, int numero2, String operacao) {
        mostrarCabecalho(nome, numero1 + " " + operacao + " " + numero2, "mensagem de erro");
        try {
            double obtido = calculadora.calc(numero1, numero2, operacao);
            System.out.println("Obtido: " + obtido);
            registrar(false); // não deu erro, então o teste falhou
        } catch (RuntimeException erro) {
            System.out.println("Obtido: " + erro.getMessage());
            registrar(true); // deu erro, como esperado
        }
    }

    // Mostra o nome, a entrada e o resultado esperado do teste
    static void mostrarCabecalho(String nome, String entrada, String esperado) {
        System.out.println("\nTeste: " + nome);
        System.out.println("Entrada: " + entrada);
        System.out.println("Esperado: " + esperado);
    }

    // Mostra se o teste passou e atualiza os contadores
    static void registrar(boolean ok) {
        if (ok) {
            System.out.println("Status: PASSOU");
            passou++;
        } else {
            System.out.println("Status: FALHOU");
            falhou++;
        }
    }

    // Mostra o total de testes que passaram e falharam
    static void mostrarResumo() {
        System.out.println("\n===== RESULTADO FINAL =====");
        System.out.println("Passaram: " + passou);
        System.out.println("Falharam: " + falhou);
    }
}