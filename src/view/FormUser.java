package view;
import IOFile.IOFileUser;
import controller.UserController;
import input.Input;
import model.User;

import java.awt.*;
import java.util.List;
import java.util.Scanner;


public class FormUser {
    private UserController userController = new UserController();
    private Scanner sc = new Scanner(System.in);
    public void showFormUser(){
        int choice;
        do {
            System.out.println("======== List User ========");
            System.out.println("1. Add user");
            System.out.println("2. Edit user");
            System.out.println("3. Delete user");
            System.out.println("4. Show all user");
            System.out.println("5. Find By Name");
            System.out.println("6.Find By ID");
            System.out.println("7. Back");
            System.out.println("Enter choice");
            choice = Input.getNumber();
            switch (choice){
                case 1:
                    addUser();
                    break;
                case 2:
                    editUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    showAllUser();
                    break;
                case 5:
                    findByUser();
                    break;
                case 6:
                    findByID();
                    break;
                case 7:
                    return;
            }
        }
        while (choice != 0);
    }

    private void findByUser() {
    }

    public void addUser() {
        String regex = ".*[a-zA-Z].*";
        //  kiểm tra xem dữ liệu nhập từ người dùng có chứa ký tự chữ cái hay không
        boolean isValid = true;
        System.out.println("---------- Add User ----------");
        System.out.println("Enter ID:  ");

        int addID = Input.getNumber();
        while (isValid) {
            System.out.println("Enter username: ");
            String addUsername = Input.getString();
            if (addUsername.matches(regex)) {
                System.out.println("Enter password: ");
                String addPassword = Input.getString();
                System.out.println("Enter position: ");
                String addPosition = Input.getString();
                User addUser = new User(addID, addUsername, addPassword, addPosition);
                userController.add(addUser);
                IOFileUser.writeFileUser(userController.findAll());
                System.out.println("Add Success");
                isValid = false;
            } else {
                System.out.println("Username must have alphabetical characters");
            }
        }
    }

    public void editUser() {
        System.out.println("---------- Edit User ----------");
        System.out.println("Enter ID edit: ");
        int editID = Input.getNumber();
        int checkID = userController.findByID(editID);
        if(checkID == -1) {
            System.out.println("Do not have this ID");
        } else {
            System.out.println(userController.findAll().get(checkID));
            System.out.println("Enter username: ");
            String editUsername = Input.getString();
            System.out.println("Enter password: ");
            String editPassword = Input.getString();
            System.out.println("Enter position: ");
            String editPosition = Input.getString();

            User editUser = new User(editID, editUsername, editPassword, editPosition);
            userController.edit(checkID, editUser);
            IOFileUser.writeFileUser(userController.findAll());
            System.out.println("Edit Success");

        }
    }

    public void deleteUser() {
        System.out.println("---------- Delete User ----------");
        System.out.println("Enter ID Delete");
        int deleteID = Input.getNumber();
        int checkID = userController.findByID(deleteID);
        if(checkID == -1) {
            System.out.println("Do not have this ID");
        } else {
            userController.delete(checkID);
            IOFileUser.writeFileUser(userController.findAll());
            System.out.println("Delete Success");
        }
    }

    public void showAllUser() {
        System.out.println("---------- All User ----------");
        List<User> listShowAll = userController.findAll();
        for (User user: listShowAll) {
            System.out.println(user);
        }
    }

    public void findByName() {
        System.out.println("---------- Find User By Username ----------");
        System.out.println("Enter Userame find");
        String findName = Input.getString();
        List<Integer> checkName = userController.findByName(findName);
        if (checkName.size() == 0) {
            System.out.println("Do not have this Name");
        } else {
            for (int i = 0; i < checkName.size(); i++) {
                System.out.println(userController.findAll().get(checkName.get(i)));
            }
        }
    }

    public void findByID() {
        System.out.println("---------- Find User By ID ----------");
        System.out.println("Enter ID find");
        int index = Input.getNumber();
        int checkID = userController.findByID(index);
        if (checkID == -1) {
            System.out.println("Do not have this ID");
        } else {
            System.out.println(userController.findAll().get(checkID));
        }
    }
}

