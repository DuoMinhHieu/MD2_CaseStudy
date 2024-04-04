package view;

import controller.UserController;
import IOFile.IOFileUser;
import input.Input;
import model.User;

import java.util.Scanner;

public class FormLogin {
    UserController userController = new UserController();
    FormMenu formMenu = new FormMenu();
    private boolean  check = false;
    public void showFormLogin() {
        do {
            System.out.println("======== Login ========");
            System.out.println("Enter username");
            String usernameCheck = Input.getString();
            System.out.println("Enter password");
            String passwordCheck = Input.getString();
            check = checkLogin(usernameCheck, passwordCheck);
            if (check) {
                formMenu.showFormMenu();
                check = false;
            }
        } while (check != false);
    }
    public boolean checkLogin(String username, String password) {
        for (User user: userController.findAll()){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                FormMenu.currentUser = user;
                return true;
            }
        }
        System.out.println("Wrong username or password");
        return false;
    }
}
