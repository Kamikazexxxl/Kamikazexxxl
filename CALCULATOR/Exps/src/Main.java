import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        // ввод строки через консоль
        String outputString = ArgsOperDefiner.converter(inputString);            // выполнение калькуляяции
        // System.out.println(outputString);                                        // вывод строки на консоль
    }
}

class ArgsOperDefiner {

    public static String converter(String inputString) throws IOException {


        String[] arguments = argumendDefiner(inputString);
        String argOne = arguments[0];
        String argTwo = arguments[1];
        char operator = inputString.charAt(argOne.length() + 3);
        if(ExeptionFinder.isToFind(argOne, argTwo, operator));
        String calculation = Calculation.calculate(argOne, argTwo, operator);
        System.out.println(calculation);
        return inputString;
    }

    public static String[] argumendDefiner(String inputString) {
        String[] array = inputString.split(" \\W ");                        // массив из двух аргументов
        int inputLenght = inputString.length();                                   // длина строки
        int argOneLenght = array[0].length();                                     // длина первой строки
        String firstArgument = inputString.substring(1, argOneLenght - 1);
        String secondArgument = array[1];

        if (array[1].length() > 2)
            secondArgument = inputString.substring(argOneLenght + 4, inputLenght - 1);

        return new String[]{firstArgument, secondArgument};
    }

}

class Calculation {
    public static String calculate(String argOne, String argTwo, char operator) {
        switch (operator) {
            case '+':
                return argOne + argTwo;
            case '-':
                return argOne.replace(argTwo, "");
            case '*':
                return argOne.repeat(Integer.parseInt(argTwo));
            case '/':
                return argOne.substring(argOne.length() / Integer.parseInt(argTwo));
        }
        return null;
    }

}

class ExeptionFinder {

    public static boolean isToFind(String argOne, String argTwo, char operator) throws IOException  {
        String x = String.valueOf(operator);
        if(Integer.parseInt(argTwo) >10 || Integer.parseInt(argTwo) <1) throw new IOException("Введите число от 1 до 10");
//        if()) throw  new IOException("Нельзя умножать на строку");
        return true;
    }
}