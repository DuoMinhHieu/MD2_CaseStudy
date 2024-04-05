package view;

import input.Input;
import java.util.Scanner;

    public class FormStart {
    private Scanner sc = new Scanner(System.in);
    public void showFormStart() {
        FormLogin formLogin = new FormLogin();
        FormSignup formSignup = new FormSignup();
        int choice;
        do {
            System.out.println("|======== Start ========|");
            System.out.println("|1.Login");
            System.out.println("|2.Sign Up");
            System.out.println("|0.Exit");
            System.out.println("|Enter choice: ");
            choice = Input.getNumber();
            switch (choice) {
                case 1:
                    formLogin.showFormLogin();
                    break;
                case 2:
                    formSignup.showFormSignup();
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
        sc.close();
    }
}

