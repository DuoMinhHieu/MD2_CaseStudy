package view;

import controller.UserController;
import IOFile.IOFileUser;
import input.Input;
import model.User;

public class FormSignup {
    FormStart formStart = new FormStart();
    UserController userController = new UserController();
    private boolean check = false;
    public void showFormSignup() {
        boolean isValid = true;
        String regex = ".*[a-zA-Z].*";
        //  kiểm tra xem dữ liệu nhập từ người dùng có chứa ký tự chữ cái hay không
        do {
            while (isValid) {
                System.out.println("======== Sign Up ========");
                System.out.println("Enter ID");
                int idCheck = Input.getNumber();
                System.out.println("Enter username");
                String usernameCheck = Input.getString();
                if (usernameCheck.matches(regex)) {
                    System.out.println("Enter password");
                    String passwordCheck = Input.getString();
                    System.out.println("Default position is Customer");
                    String positionCheck = "customer";
                    check = checkSignup(idCheck, usernameCheck, passwordCheck, positionCheck);
                    if (check) {
                        formStart.showFormStart();
                        check = false;
                    } else {
                        System.err.println("Duplicate username or id");
                        return;
                    }
                    isValid = false;
                } else {
                    System.err.println("Username must have alphabetical characters");
                }
            }
        } while (check == false);
    }
    public boolean checkSignup(int idCheck, String usernameCheck, String passwordCheck, String positionCheck) {
        for (User user: userController.findAll()){
            if (user.getUsername().equals(usernameCheck) || user.getId() == idCheck) {
                return false;
            }
        }
        User userSignup = new User(idCheck, usernameCheck, passwordCheck, positionCheck);
        userController.add(userSignup);
        IOFileUser.writeFileUser(userController.findAll());
        System.out.println("Sign up Success");
        return true;
    }
}
