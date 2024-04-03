package input;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);
    public static int getNumber() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter number");
            }
        }
    }
    public static String getString() {
        return sc.nextLine();
    }
}
