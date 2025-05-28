import java.util.InputMismatchException;
import java.util.Scanner;

class Calculadora {
    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Erro divisao por zero");
        }
        return a / b;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();

        try {
            System.out.print("Digite a: ");
            double num1 = scanner.nextDouble();

            if (num1 < 0) {
                throw new NumeroNegativo("Erro número negativo");
            }

            System.out.print("Digite b: ");
            double num2 = scanner.nextDouble();

            if (num2 < 0) {
                throw new NumeroNegativo("Erro número negativo.");
            }

            System.out.println("Escolha a operação (+, -, *, /): ");
            String operacao = scanner.next();

            double resultado = 0;

            switch (operacao) {
                case "+":
                    resultado = calc.somar(num1, num2);
                    break;
                case "-":
                    resultado = calc.subtrair(num1, num2);
                    break;
                case "*":
                    resultado = calc.multiplicar(num1, num2);
                    break;
                case "/":
                    resultado = calc.dividir(num1, num2);
                    break;
                default:
                    System.out.println("Operação inválida");
                    return;
            }

            System.out.println("Resultado: " + resultado);

        } catch (NumeroNegativo e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, digite apenas números");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
