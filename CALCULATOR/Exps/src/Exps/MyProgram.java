package Exps;
import java.util.Scanner;


class MyProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    //"Hi World!" - "World!"
        String input = sc.nextLine();
        String[] arrayInput = input.split("(?=([+\\-*/]))");
         int arrayLenght = arrayInput.length;
         String a = arrayInput[0];
         String b = arrayInput[1];
         int f = b.length();
         String c = b.substring(0,1);
         String e =b.substring(2, f);

        System.out.println(c);
        System.out.println(e);
    }

}