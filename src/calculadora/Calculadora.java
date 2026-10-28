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
 * @version 1.0
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
     * @param a  primeiro número
     * @param b  segundo número (não pode ser zero na divisão)
     * @param op operação: "+", "-", "*" ou "/"
     * @return resultado da conta
     * @throws ArithmeticException      se a operação for "/" e {@code b} for zero
     * @throws IllegalArgumentException se a operação for nula ou diferente de "+", "-", "*" e "/"
     */
    public double calc(int a, int b, String op) {
        double r; // guarda o resultado da conta

        // Operação nula não pode ser comparada, então é tratada primeiro
        if (op == null) {
            throw new IllegalArgumentException("Operação inválida!");
        } else if (op.equals("+")) {
            r = a + b;
        } else if (op.equals("-")) {
            r = a - b;
        } else if (op.equals("*")) {
            r = a * b;
        } else if (op.equals("/")) {
            // Impede a divisão por zero
            if (b == 0) {
                throw new ArithmeticException("Não é possível dividir por zero!");
            } else {
                // (double) evita que 7 / 2 dê 3 em vez de 3.5
                r = (double) a / b;
            }
        } else {
            // Qualquer símbolo diferente de +, -, * e / é inválido
            throw new IllegalArgumentException("Operação inválida!");
        }
        return r;
    }
}
