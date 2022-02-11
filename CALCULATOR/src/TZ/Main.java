package TZ;
import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

class Main {
    public static void main(String args) {
        Scanner scanner = new Scanner (System.in);
        String inputFromConsole = scanner.nextLine();
        String x = calc(inputFromConsole);
        System.out.println(x);
    }

    public static String calc(String inputString) throws NumberFormatException {

        String[] romNum = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] oper = {"+", "-", "*", "/"};

        String[] input = inputString.split(" ");

        if (input.length > 3){
            throw new IllegalArgumentException("ошибочка");
        }


        boolean isoper = (Arrays.asList(oper).contains(input[1]));
        boolean isRom1 = (Arrays.asList(romNum).contains(input[0]));
        boolean isRom2 = (Arrays.asList(romNum).contains(input[2]));
        boolean isArab1 = (Arrays.asList(arabNum).contains(input[0]));
        boolean isArab2 = (Arrays.asList(arabNum).contains(input[2]));

        if ((isArab1 && isArab2 && isoper && input[1].equals("+"))) {
            int z = ((Integer.parseInt(input[0])) + (Integer.parseInt(input[2])));
            return String.valueOf(z);
        }
        if ((isArab1 && isArab2 && isoper && input[1].equals("-"))) {
            int z = ((Integer.parseInt(input[0])) - (Integer.parseInt(input[2])));
            return String.valueOf(z);
        }
        if ((isArab1 && isArab2 && isoper && input[1].equals("*"))) {
            int z = ((Integer.parseInt(input[0])) * (Integer.parseInt(input[2])));
            return String.valueOf(z);
        }
        if ((isArab1 && isArab2 && isoper && input[1].equals("/"))) {
            int z = ((Integer.parseInt(input[0])) / (Integer.parseInt(input[2])));
            return String.valueOf(z);
        }
        if ((isRom1 && isRom2 && isoper && input[1].equals("+"))) {
            int x = roman2Decimal(input[0]);
            int y = roman2Decimal(input[2]);
            return integerToRoman(x + y);
        }
        if ((isRom1 && isRom2 && isoper && input[1].equals("-"))) {
            int x = roman2Decimal(input[0]);
            int y = roman2Decimal(input[2]);
            return integerToRoman(x - y);
        }
        if ((isRom1 && isRom2 && isoper && input[1].equals("/"))) {
            int x = roman2Decimal(input[0]);
            int y = roman2Decimal(input[2]);
            return integerToRoman(x / y);
        }
        if ((isRom1 && isRom2 && isoper && input[1].equals("*"))) {
            int x = roman2Decimal(input[0]);
            int y = roman2Decimal(input[2]);
            return integerToRoman(x * y);
        }
        else {
            throw new IllegalArgumentException("ошибочка");
        }
    }
    public static int roman2Decimal(String s){
        int result = 0;

        int prev = 0;
        for (int i = s.length() -1; i>= 0; i--){
            int curr = letterToNumber(s.charAt(i));
            if(curr < prev){
                result -=curr;
            }
            else {
                result += curr;
            }
            prev = curr;

        }
        return result;
    }
    private static int letterToNumber(char letter){
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'D':  return 500;
            case 'M':  return 1000;
            default:   return -1;
        }
    }
    static String integerToRoman(int num) {

        int[] values = {100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }
}



