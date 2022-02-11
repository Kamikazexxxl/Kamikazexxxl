package StringCalc;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean isException = ExpetionCheck.findExpetions(input);
        String calculate = calculate(input);
        System.out.println("\"" + calculate + "\"");
        //  "Hi World!" * "World!"
    }

    public static String calculate(String input) throws IOException {
        String[] splitForCalculate = input.split(" " + "(?=([+\\-*/]))");
        String inputOne = splitForCalculate[0].substring(1, splitForCalculate[0].length() - 1);
        String inputTwo = splitForCalculate[1].substring(2);

        if (splitForCalculate[1].length() >= 5)
            inputTwo = splitForCalculate[1].substring(3, splitForCalculate[1].length() - 1);

        String operator = splitForCalculate[1].substring(0, 1);

        if (operator.equals("+"))
            return (inputOne + inputTwo);

        if (operator.equals("-")) {
            int x = inputOne.length() - inputTwo.length();
            int y = inputTwo.length();
            if (inputOne.substring(y - x).equals(inputTwo)) {
                return inputOne.substring(0, y - x);
            } else {
                return inputOne;
            }
        }
        if (operator.equals("*"))
            return inputOne.repeat(Integer.parseInt(inputTwo));

        if (operator.equals("/")) {
            int x = inputOne.length() / Integer.parseInt(inputTwo);
            return inputOne.substring(0, x);
        }
        return "it's ok";
    }

}

class ExpetionCheck {
    static boolean findExpetions(String input) throws Exception {
        String[] splitToCheck = input.split(" " + "(?=([+\\-*/]))");
        String[] oper = {"+", "-", "*", "/"};

        if (splitToCheck[0].length() < 3) throw new IOException();



        if (splitToCheck[1].contains("/")
                && splitToCheck[1].contains("\"")) throw new IOException();

        try {
            if (Integer.parseInt(splitToCheck[1].substring(2)) <= 0
                    || Integer.parseInt(splitToCheck[1].substring(2)) >= 10) throw new IOException("Допустимое число от 1 до 10 включительно");
        } catch (NumberFormatException ignored) {}

        return true;
    }
}
