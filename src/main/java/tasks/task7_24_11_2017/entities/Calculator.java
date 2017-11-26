package tasks.task7_24_11_2017.entities;

import java.util.Stack;

public class Calculator {

    private static int pos;

    static {
        nullifyInitialValues();
    }

    public static double calculate(String s) throws IllegalArgumentException {
        s = '(' + s + ')';
        Stack<Double> operands = new Stack<Double>();
        Stack<Character> functions = new Stack<Character>();
        Object token;
        Object prevToken = 'Ы';

        do {
            token = getToken(s);

            if (isTokenUnaryPlusOrMinusOperation(token, prevToken))
                operands.push(0.0);

            if (token instanceof Double)
                operands.push((double) token);

            else if (token instanceof Character) {
                if ((char) token == ')') {
                    while (functions.size() > 0 && functions.peek() != '(')
                        popFunction(operands, functions);

                    functions.pop(); // Удаляем саму скобку "("
                } else {
                    while (canPop((char) token, functions))
                        popFunction(operands, functions);

                    functions.push((char) token); // Кидаем новую операцию в стек
                }
            }
            prevToken = token;
        }
        while (token != null);

        if (operands.size() > 1 || functions.size() > 0)
            throw new IllegalArgumentException("Неправильная расстановка операндов и операций.");

        nullifyInitialValues();
        return operands.pop();
    }

    private static void popFunction(Stack<Double> Operands, Stack<Character> Functions) {
        double B = Operands.pop();
        double A = Operands.pop();
        switch (Functions.pop()) {
            case '+':
                Operands.push(A + B);
                break;
            case '-':
                Operands.push(A - B);
                break;
            case '*':
                Operands.push(A * B);
                break;
            case '/':
                Operands.push(A / B);
                break;
        }
    }

    private static boolean canPop(char op1, Stack<Character> Functions) {
        if (Functions.size() == 0)
            return false;

        int p1 = getPriority(op1);
        int p2 = getPriority(Functions.peek());

        return p1 >= 0 && p2 >= 0 && p1 >= p2;
    }

    private static int getPriority(char op) throws IllegalArgumentException {
        switch (op) {
            case '(':
                return -1; // не выталкивает сам и не дает вытолкнуть себя другим
            case '*':
            case '/':
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

    /*Считывает все проблемы*/
    private static void readWhiteSpace(String s) {
        while (pos < s.length() && isWhiteSpace(s.charAt(pos)))
            pos++;
    }

    private static char readFunction(String s) {
        // в данном случае все операции состоят из одного символа
        // но мы можем усложнить код добавив == && || mod div и ещё чегонить
        return s.charAt(pos++);
    }

    public static boolean isTokenUnaryPlusOrMinusOperation(Object token, Object prevToken) {
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
}
