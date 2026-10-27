package calculadora;

/**
 * Calculadora simples do aplicativo FinançApp.
 * Faz as operações de soma, subtração, multiplicação e divisão.
 *
 */
public class Calculadora {

    /**
     * Cria uma nova calculadora.
     */
    public Calculadora() {
    }

    /**
     * Faz a conta entre dois números de acordo com a operação escolhida.
     *
     * @param numero1  primeiro número
     * @param numero2  segundo número
     * @param operacao "+", "-", "*" ou "/"
     * @return resultado da conta
     * @throws ArithmeticException      se tentar dividir por zero
     * @throws IllegalArgumentException se a operação não for "+", "-", "*" ou "/"
     */
    public double calc(int numero1, int numero2, String operacao) {
        // Cada operação chama o seu próprio método
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
     * @param numero1 primeiro número
     * @param numero2 segundo número
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
     * @param numero1 dividendo
     * @param numero2 divisor (não pode ser zero)
     * @return resultado da divisão com casas decimais
     * @throws ArithmeticException se o divisor for zero
     */
    public double dividir(int numero1, int numero2) {
        if (numero2 == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        // (double) evita que 7 / 2 dê 3 em vez de 3.5
        return (double) numero1 / numero2;
    }
}