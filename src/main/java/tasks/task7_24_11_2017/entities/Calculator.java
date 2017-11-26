package tasks.task7_24_11_2017.entities;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {

    private static int pos;
    private static Map<String, String> operations;

    static {
        nullifyInitialValues();
        initializeOperations();
    }

    public static double calculate(String s) throws IllegalArgumentException, EmptyStackException {

        s = handleAdditionalOperations(s);

        s = '(' + s + ')';
        Stack<Double> operands = new Stack<Double>();
        Stack<Character> operations = new Stack<Character>();
        Object token;
        Object prevToken = 'X';

        do {
            token = getToken(s);

            if (isTokenUnaryPlusOrMinusOperation(token, prevToken))
                operands.push(0.0);

            if (token instanceof Double)
                operands.push((double) token);

            else if (token instanceof Character) {
                if ((char) token == ')') {
                    while (operations.size() > 0 && operations.peek() != '(')
                        popOperation(operands, operations);

                    operations.pop(); // Удаляем саму скобку "("
                } else {
                    while (canPop((char) token, operations))
                        popOperation(operands, operations);

                    operations.push((char) token); // Кидаем новую операцию в стек
                }
            }
            prevToken = token;
        }
        while (token != null);

        if (operands.size() > 1 || operations.size() > 0)
            throw new IllegalArgumentException("Неправильная расстановка операндов и операций.");

        nullifyInitialValues();
        return operands.pop();
    }

    private static void popOperation(Stack<Double> operands, Stack<Character> functions) {
        double b = operands.pop();
        double a;
        switch (functions.pop()) {
            case '+':
                a = operands.pop();
                operands.push(a + b);
                break;
            case '-':
                a = operands.pop();
                operands.push(a - b);
                break;
            case '*':
                a = operands.pop();
                operands.push(a * b);
                break;
            case '/':
                a = operands.pop();
                operands.push(a / b);
                break;
            case 's':
                operands.push(Math.sin(b));
                break;
            case 'c':
                operands.push(Math.cos(b));
                break;
        }
    }

    private static boolean canPop(char op1, Stack<Character> functions) {
        if (functions.size() == 0)
            return false;

        int p1 = getPriority(op1);
        int p2 = getPriority(functions.peek());

        return p1 >= 0 && p2 >= 0 && p1 >= p2;
    }

    private static int getPriority(char op) throws IllegalArgumentException {
        switch (op) {
            case '(':
                return -1; // не выталкивает сам и не дает вытолкнуть себя другим
            case '*':
            case '/':
            case 's':
            case 'c':
                return 1;
            case '+':
            case '-':
                return 2;
            default:
                throw new IllegalArgumentException("недопустимая операция");
        }
    }

    private static Object getToken(String s) {
        readWhiteSpace(s);

        if (pos == s.length()) // конец строки
            return null;
        if (Character.isDigit(s.charAt(pos)))
            return Double.parseDouble(readDouble(s));
        else
            return readFunction(s);
    }

    private static String readDouble(String s) {
        String res = "";
        while (pos < s.length() && (Character.isDigit(s.charAt(pos)) || s.charAt(pos) == '.'))
            res += s.charAt(pos++);

        return res;
    }

    /*Считывает все пробелы*/
    private static void readWhiteSpace(String s) {
        while (pos < s.length() && isWhiteSpace(s.charAt(pos)))
            pos++;
    }

    private static char readFunction(String s) {
        return s.charAt(pos++);
    }

    static boolean isTokenUnaryPlusOrMinusOperation(Object token, Object prevToken) {
        return (token instanceof Character &&
                prevToken instanceof Character &&
                (char) prevToken == '(' &&
                ((char) token == '+' || (char) token == '-'));
    }

    private static boolean isWhiteSpace(char c) {
        return c == ' ';
    }

    private static void nullifyInitialValues() {
        pos = 0;
    }

    private static void initializeOperations() {
        operations = new HashMap<>();
        operations.put("sin", "s");
        operations.put("cos", "c");
    }

    private static String handleAdditionalOperations(String s) {
        for (String key : operations.keySet())
            s = s.replace(key, operations.get(key));

        return s;
    }
}
