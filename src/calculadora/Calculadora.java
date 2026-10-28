package calculadora;

public class Calculadora {

    public double calc(int a, int b, String op) {
        double r;
        if (op == null) {
            throw new IllegalArgumentException("Operação inválida!");
        } else if (op.equals("+")) {
            r = a + b;
        } else if (op.equals("-")) {
            r = a - b;
        } else if (op.equals("*")) {
            r = a * b;
        } else if (op.equals("/")) {
            if (b == 0) {
                throw new ArithmeticException("Não é possível dividir por zero!");
            } else {
                r = (double) a / b;
            }
        } else {
            throw new IllegalArgumentException("Operação inválida!");
        }
        return r;
    }
}
