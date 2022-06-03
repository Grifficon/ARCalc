import java.util.InputMismatchException;
import java.util.Scanner;

public class ARCalc {
    static Scanner scan = new Scanner(System.in);
    static int number1, number2, result, AR=1;
    static char operation;

    public static void main(String[] args) {
        System.out.println("Input 1-10 or I-X + Enter");
        String userInput = scan.nextLine();
        char[] userChar = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            userChar[i] = userInput.charAt(i);
            if (userChar[i] == '+') { operation = '+'; }
            if (userChar[i] == '-') { operation = '-'; }
            if (userChar[i] == '*') { operation = '*'; }
            if (userChar[i] == '/') { operation = '/'; }
        }
        String userCharString = String.valueOf(userChar);
        String[] numb = userCharString.split("[-+*/]");
        String numb1 = numb[0];
        String numb2 = numb[1];
        String numb3 = numb2.trim();
        number1 = romanToNumber(numb1);
        number2 = romanToNumber(numb3);
        if (number1 < 0 && number2 < 0) { result=0; }
        else {
            result = calculated(number1, number2, operation);
            System.out.println("Result");
            String resultRoman = convertNumToRoman(result);
            System.out.println(resultRoman);
            AR=0;
        }
        if (AR>0) {
            number1 = Integer.parseInt(numb1);
            number2 = Integer.parseInt(numb3);
            result = calculated(number1, number2, operation);
            System.out.println("Result");
            System.out.println(result);
        }
        if (AR==2) {
         System.out.println("Result");
         System.out.println("Incorrect input");
        }
    }
    private static String convertNumToRoman (int numArabian) {
        String[] romanNumb = {
                "O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return romanNumb[numArabian];
    }
    private static int romanToNumber (String roman) {
        return switch (roman) {
            case "0" -> 0;
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }
    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+': result = num1 + num2;
                break;
            case '-': result = num1 - num2;
                break;
            case '*': result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                }
                catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.err.println("Only integer non-zero parameters allowed");
                    break;
                }
                break;
        }
        return result;
    }
}