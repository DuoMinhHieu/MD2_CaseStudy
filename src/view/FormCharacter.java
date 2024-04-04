package view;

import input.Input;
import controller.CharacterController;
import IOFile.IOFileCharacter;
import model.ProfileCharacter;

import java.util.List;
import java.util.Scanner;

public class FormCharacter {
    private CharacterController characterController = new CharacterController();
    private Scanner sc = new Scanner(System.in);
    public void showFormCharacter() {
        int choice;
        do {
            System.out.println("======== Profile Character ========");
            System.out.println("1.Add character");
            System.out.println("2.Edit character");
            System.out.println("3.Delete character");
            System.out.println("4.Show all character");
            System.out.println("5.Find By Name");
            System.out.println("6.Find By ID");
            System.out.println("7.Back");
            System.out.println("Enter choice: ");
            choice = Input.getNumber();
            switch (choice) {
                case 1:
                    addCharacter();
                    break;
                case 2:
                    editCharacter();
                    break;
                case 3:
                    deleteCharacter();
                    break;
                case 4:
                    showAllCharacter();
                    break;
                case 5:
                    findByName();
                    break;
                case 6:
                    findByID();
                    break;
                case 7:
                    return;
            }
        } while (choice != 0);
    }
    public void addCharacter() {
        System.out.println("---------- Add Character ----------");
        System.out.println("Enter id: ");
        int addID = Input.getNumber();
        System.out.println("Enter name: ");
        String addName = Input.getString();
        System.out.println("Enter age");
        int addAge = Input.getNumber();
        System.out.println("Enter address: ");
        String addAddress = Input.getString();
        System.out.println("Enter description: ");
        String addDescription = Input.getString();
        ProfileCharacter addCharacter = new ProfileCharacter(addID, addName, addAge, addAddress, addDescription);
        characterController.add(addCharacter);
        IOFileCharacter.writeFileCharacter(characterController.findAll());
        System.out.println("Add Success");
    }
    public void editCharacter() {
        System.out.println("---------- Edit Character ----------");
        System.out.println("Enter ID edit: ");
        int editID = Input.getNumber();
        int checkID = characterController.findByID(editID);
        if(checkID == -1) {
            System.out.println("Do not have this ID");
        } else {
            System.out.println(characterController.findAll().get(checkID));
            System.out.println("Enter name: ");
            String editName = Input.getString();
            System.out.println("Enter age");
            int editAge = Input.getNumber();
            System.out.println("Enter address: ");
            String editAddress = Input.getString();
            System.out.println("Enter description: ");
            String editDescription = Input.getString();
            ProfileCharacter editCharacter = new ProfileCharacter(editID, editName, editAge, editAddress, editDescription);
            characterController.edit(checkID, editCharacter);
            IOFileCharacter.writeFileCharacter(characterController.findAll());
            System.out.println("Edit Success");
        }
    }
    public void deleteCharacter() {
        System.out.println("---------- Delete Character ----------");
        System.out.println("Enter ID Delete");
        int deleteID = Input.getNumber();
        int checkID = characterController.findByID(deleteID);
        if(checkID == -1) {
            System.out.println("Do not have this ID");
        } else {
            characterController.delete(checkID);
            IOFileCharacter.writeFileCharacter(characterController.findAll());
            System.out.println("Delete Success");
        }
    }
    public void showAllCharacter() {
        System.out.println("---------- All Character ----------");
        List<ProfileCharacter> listShowAll = characterController.findAll();
        for (ProfileCharacter profileCharacter: listShowAll) {
            System.out.println(profileCharacter);
        }
    }
    public void findByName() {
        System.out.println("---------- Find Character By Name ----------");
        System.out.println("Enter Name find");
        String findName = Input.getString();
        List<Integer> checkName = characterController.findByName(findName);
        if (checkName.size() == 0) {
            System.out.println("Do not have this Name");
        } else {
            for (int i = 0; i < checkName.size(); i++) {
                System.out.println(characterController.findAll().get(checkName.get(i)));
            }
        }
    }
    public void findByID() {
        System.out.println("---------- Find Product By ID ----------");
        System.out.println("Enter ID find");
        int index = Input.getNumber();
        int checkID = characterController.findByID(index);
        if (checkID == -1) {
            System.out.println("Do not have this ID");
        } else {
            System.out.println(characterController.findAll().get(checkID));
        }
    }
}