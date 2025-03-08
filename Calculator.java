// A simple GUI Calculator with Java
// Author: Joel Tanko
// Matric No. U23/CS/1043
// Email: 7thogofe@gmail.com

// CalculatorOperations.java
public class Calculator {

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Cannot divide by 0");
            return 0;
        }
        return num1 / num2;
    }

    public static double exponent(double num, double pow) {
        return Math.pow(num, pow);
    }

    public static double evaluateExpression(String expression) {
        // Split the expression into components
        String[] tokens = expression.split(" ");
        if (tokens.length < 3) return 0; // Invalid expression check

        double num1 = Double.parseDouble(tokens[0]);
        double num2 = Double.parseDouble(tokens[2]);
        String operator = tokens[1];

        switch (operator) {
            case "+": return add(num1, num2);
            case "-": return subtract(num1, num2);
            case "*": return multiply(num1, num2);
            case "/": return divide(num1, num2);
            case "^": return exponent(num1, num2);
            default: return 0;
        }
    }
}

