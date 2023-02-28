import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Calc.calc(input);
    }
}
class Calc{
    public static void calc(String input){
        String[] nums = input.split("\\+");
        int num1 = Integer.parseInt(nums[0]);
        int num2 = Integer.parseInt(nums[1]);
        System.out.println(num1 + "+" + num2 + "="+ (num1+num2));
    }
}