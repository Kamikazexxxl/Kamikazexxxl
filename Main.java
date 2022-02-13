// Строковый калькулятор
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String inputString = ExceptionFinder.isToFind(sc.nextLine());
        String outputString = Preparer.converter(inputString);
        System.out.println("\"" + outputString + "\"");
    }
}

class ExceptionFinder {

    static String isToFind(String inputString) throws IOException {
        String[] array = inputString.split(" \\W ");
        int x = array[0].length();
        int y = array[1].length();
        String operator = inputString.substring(x + 1, x + 2);
        if (!array[0].startsWith("\"") || !array[0].endsWith("\"")) throw new IOException();
        if (x > 12 || y > 12) throw new IOException();
        try {
            if (Integer.parseInt(array[1]) > 10 || Integer.parseInt(array[1]) < 1) throw new IOException();
        } catch (NumberFormatException ignored) {
        }
        if (!array[1].startsWith("\"") && !array[1].endsWith("\"") && operator.equals("-"))
            throw new IOException();
        if (!array[1].startsWith("\"") && !array[1].endsWith("\"") && operator.equals("+"))
            throw new IOException();
        if (operator.equals("/") && y > 2) throw new IOException();
        if (operator.equals("*") && y > 2) throw new IOException();
        return inputString;

    }
}
class Preparer {

    static String converter(String inputString) {
        String[] array = inputString.split(" \\W ");
        int argOneLenght = array[0].length(), argTwoLenght = array[1].length();
        String argOne = array[0].substring(1, argOneLenght - 1);
        String argTwo = array[1];
        if (argTwoLenght > 2) argTwo = array[1].substring(1, argTwoLenght - 1);
        String operator = inputString.substring(argOneLenght + 1, argOneLenght + 2);
        String answer = Calculation.calculate(argOne, argTwo, operator);
        if (answer.length() >= 40) answer = (answer.substring(0, 40) + "...");

        return answer;
    }

}

class Calculation {
    static String calculate(String argOne, String argTwo, String operator) {
        switch (operator) {
            case "+":
                return argOne + argTwo;
            case "-":
                if (argOne.endsWith(argTwo)) {
                    return argOne.replaceAll(argTwo, "");
                } else return argOne;
            case "*":
                return argOne.repeat(Integer.parseInt(argTwo));
            case "/":
                return argOne.substring(0, argOne.length() / Integer.parseInt(argTwo));
        }
        return null;
    }

}
