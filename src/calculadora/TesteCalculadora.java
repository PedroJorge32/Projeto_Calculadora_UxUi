package calculadora;

/**
 * Testes unitários da classe {@link Calculadora}.
 * <p>
 * Cada teste mostra a entrada utilizada, o resultado esperado, o resultado
 * obtido e se passou ou falhou. No final aparece o total de testes aprovados
 * e reprovados.
 * </p>
 *
 * @author Pedro
 * @version 1.0
 */
public class TesteCalculadora {

    /** Quantidade de testes que passaram. */
    static int passou = 0;

    /** Quantidade de testes que falharam. */
    static int falhou = 0;

    /**
     * Cria a classe de testes.
     */
    public TesteCalculadora() {
        // Os contadores já começam em zero
    }

    /**
     * Executa todos os testes da calculadora.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println("===== TESTES DA CALCULADORA =====");

        // Teste de soma
        testar("Soma", "10 + 5", 15, calc.calc(10, 5, "+"));

        // Teste de subtração
        testar("Subtração", "10 - 5", 5, calc.calc(10, 5, "-"));

        // Teste de multiplicação
        testar("Multiplicação", "4 * 5", 20, calc.calc(4, 5, "*"));

        // Teste de divisão
        testar("Divisão", "10 / 2", 5, calc.calc(10, 2, "/"));
        testar("Divisão decimal", "7 / 2", 3.5, calc.calc(7, 2, "/"));

        // Teste de divisão por zero: deve dar erro
        System.out.println("\nTeste: Divisão por zero");
        System.out.println("Entrada: 10 / 0");
        System.out.println("Esperado: mensagem de erro");
        try {
            double resultado = calc.calc(10, 0, "/");
            // Se chegou aqui, a calculadora não bloqueou a divisão por zero
            System.out.println("Obtido: " + resultado);
            System.out.println("Status: FALHOU");
            falhou++;
        } catch (ArithmeticException e) {
            System.out.println("Obtido: " + e.getMessage());
            System.out.println("Status: PASSOU");
            passou++;
        }

        // Teste de operação inválida: deve dar erro
        System.out.println("\nTeste: Operação inválida");
        System.out.println("Entrada: 10 % 5");
        System.out.println("Esperado: mensagem de erro");
        try {
            double resultado = calc.calc(10, 5, "%");
            // Se chegou aqui, a calculadora aceitou uma operação inválida
            System.out.println("Obtido: " + resultado);
            System.out.println("Status: FALHOU");
            falhou++;
        } catch (IllegalArgumentException e) {
            System.out.println("Obtido: " + e.getMessage());
            System.out.println("Status: PASSOU");
            passou++;
        }

        // Resumo dos testes
        System.out.println("\n===== RESULTADO FINAL =====");
        System.out.println("Passaram: " + passou);
        System.out.println("Falharam: " + falhou);
    }

    /**
     * Compara o resultado esperado com o obtido e mostra na tela.
     *
     * @param nome     nome do teste
     * @param entrada  conta que foi feita
     * @param esperado resultado esperado
     * @param obtido   resultado que a calculadora devolveu
     */
    static void testar(String nome, String entrada, double esperado, double obtido) {
        System.out.println("\nTeste: " + nome);
        System.out.println("Entrada: " + entrada);
        System.out.println("Esperado: " + esperado);
        System.out.println("Obtido: " + obtido);
        if (esperado == obtido) {
            System.out.println("Status: PASSOU");
            passou++;
        } else {
            System.out.println("Status: FALHOU");
            falhou++;
        }
    }
}
