package roman;

import roman.RomanToArabic.Converter;

import java.util.Scanner;

public class Calculator {
    static Scanner scan = new Scanner(System.in);
 //   static int a, b;
    static char operation;
 //   static int result;

    public static void main(String[] input) {

            Converter converter = new Converter();
            String[] actions = {"+", "-", "/", "*"};
            String[] regexActions = {"\\+", "-", "/", "\\*"};
            Scanner scn = new Scanner(System.in);
            System.out.print("Введите выражение: ");
        String exp = scn.nextLine();

            int actionIndex = -1;
            for (int i = 0; i < actions.length; i++) {
                if (exp.contains(actions[i])) {
                    actionIndex = i;
                    break;
                }
            }
        if (regexActions.length > 2) {
            throw new ArrayIndexOutOfBoundsException("Не более двух значений");
        }

            if (actionIndex == -1) {
                System.out.println("Некорректное выражение");
                return;
            }

            String[] data = exp.split(regexActions[actionIndex]);

            if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                int a, b;

                boolean isRoman = converter.isRoman(data[0]);
                if (isRoman) {

                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);

                } else {

                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }
                if ((a <= 10) & (a > 0) & (b > 0) & (b <= 10)) {

                    int result;
                    switch (actions[actionIndex]) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        default:
                            result = a / b;
                            break;
                    }

                    if (isRoman) {
                        System.out.println(converter.intToRoman(result));
                    } else {
                        System.out.println(result);
                    }

                } else if (b == 0) {
                    System.out.println("0");
                } else {
                    System.out.println("Допустимы входные значения до 10");
                }
            } else {
                System.out.println("Используются одновременно разные системы счисления");
            }
        }
}