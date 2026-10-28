package calculadora;

// Classe que faz as contas da calculadora do FinançApp
public class Calculadora {

    // Recebe dois números e a operação (+, -, * ou /) e devolve o resultado
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

    // Soma dois números
    public double somar(int numero1, int numero2) {
        return numero1 + numero2;
    }

    // Subtrai o segundo número do primeiro
    public double subtrair(int numero1, int numero2) {
        return numero1 - numero2;
    }

    // Multiplica dois números
    public double multiplicar(int numero1, int numero2) {
        return numero1 * numero2;
    }

    // Divide o primeiro número pelo segundo, sem permitir divisão por zero
    public double dividir(int numero1, int numero2) {
        if (numero2 == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        // (double) evita que 7 / 2 dê 3 em vez de 3.5
        return (double) numero1 / numero2;
    }
}
