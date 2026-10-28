package calculadora;

/**
 * Calculadora do aplicativo FinançApp.
 * <p>
 * Faz as quatro operações básicas (soma, subtração, multiplicação e divisão)
 * usadas em funções como orçamento mensal, divisão de despesas e projeção de
 * economia. Divisão por zero e operações inválidas são bloqueadas com uma
 * exceção que traz uma mensagem explicando o erro.
 * </p>
 *
 * @author Pedro
 * @version 2.0
 */
public class Calculadora {

    /**
     * Cria uma nova calculadora.
     */
    public Calculadora() {
        // Não há nada para inicializar
    }

    /**
     * Faz a conta entre dois números de acordo com a operação escolhida.
     *
     * @param numero1  primeiro número
     * @param numero2  segundo número (não pode ser zero na divisão)
     * @param operacao operação: "+", "-", "*" ou "/"
     * @return resultado da conta
     * @throws ArithmeticException      se a operação for "/" e {@code numero2} for zero
     * @throws IllegalArgumentException se a operação for nula ou diferente de "+", "-", "*" e "/"
     */
    public double calc(int numero1, int numero2, String operacao) {
        // Cada operação chama o seu próprio método.
        // "+".equals(operacao) não dá erro quando operacao é null.
        if ("+".equals(operacao)) {
            return somar(numero1, numero2);
        }
        if ("-".equals(operacao)) {
            return subtrair(numero1, numero2);
        }
        if ("*".equals(operacao)) {
            return multiplicar(numero1, numero2);
        }
        if ("/".equals(operacao)) {
            return dividir(numero1, numero2);
        }
        // Se chegou aqui, a operação não existe
        throw new IllegalArgumentException("Operação inválida!");
    }

    /**
     * Soma dois números.
     *
     * @param numero1 primeiro número
     * @param numero2 segundo número
     * @return soma dos números
     */
    public double somar(int numero1, int numero2) {
        return numero1 + numero2;
    }

    /**
     * Subtrai o segundo número do primeiro.
     *
     * @param numero1 número do qual se subtrai
     * @param numero2 número que será subtraído
     * @return diferença entre os números
     */
    public double subtrair(int numero1, int numero2) {
        return numero1 - numero2;
    }

    /**
     * Multiplica dois números.
     *
     * @param numero1 primeiro número
     * @param numero2 segundo número
     * @return produto dos números
     */
    public double multiplicar(int numero1, int numero2) {
        return numero1 * numero2;
    }

    /**
     * Divide o primeiro número pelo segundo.
     *
     * @param numero1 número que será dividido
     * @param numero2 divisor (não pode ser zero)
     * @return resultado da divisão com casas decimais (ex.: 7 / 2 = 3.5)
     * @throws ArithmeticException se {@code numero2} for zero
     */
    public double dividir(int numero1, int numero2) {
        // Impede a divisão por zero
        if (numero2 == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        // (double) evita que 7 / 2 dê 3 em vez de 3.5
        return (double) numero1 / numero2;
    }
}
