package view;

import input.Input;
import controller.CharacterController;
import controller.ListCharController;
import IOFile.IOFileCharacter;
import model.ListChar;
import model.ProfileCharacter;
import model.User;

import java.util.List;
import java.util.Scanner;

public class FormListChar {
    private ListCharController listCharController = new ListCharController();
    private CharacterController characterController = new CharacterController();
    private Scanner sc = new Scanner(System.in);
    public void showFormListChar() {
        User currentUser = FormMenu.currentUser;
        int choice;
        do {
            System.out.println("======== List Character Menu ========");
            System.out.println("1.Add character of list");
            System.out.println("2.Edit character of list");
            System.out.println("3.Delete character of list");
            System.out.println("4.Show all character of list");
            System.out.println("5.Find By Name of list");
            System.out.println("6.Find By ID of list");
            System.out.println("7.Back");
            System.out.println("Enter choice: ");
            choice = Input.getNumber();
            switch (choice) {
                case 1:
                    addCharacterList();
                    break;
                case 2:
                    editCharacterList();
                    break;
                case 3:
                    deleteCharacterList();
                    break;
                case 4:
                    showAllCharacterList();
                    break;
                case 5:
                    findByNameList();
                    break;
                case 6:
                    findByIDList();
                    break;
                case 7:
                    return;
            }
        } while (choice != 0);
    }
    public void addCharacterList() {
        System.out.println("---------- Add Character ----------");
        System.out.println("Enter name: ");
        String addName = Input.getString();
        for (ProfileCharacter character: characterController.findAll()) {
            if (addName.equals(character.getName())) {

            }
        }
//            ListChar addListChar = new ProfileCharacter(addID, addName, addAge, addAddress, addDescription);
//            characterController.add(addCharacter);
//            IOFileCharacter.writeFileCharacter(characterController.findAll());
//            System.out.println("Add Success");
    }
    public void editCharacterList() {
        System.out.println("---------- Edit Character ----------");
        System.out.println("Enter ID edit: ");
        int editID = Input.getNumber();
        int checkID = characterController.findByID(editID);
        if(checkID == -1) {
            System.out.println("Do not have this ID");
        } else {
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
    public void deleteCharacterList() {
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
    public void showAllCharacterList() {
        System.out.println("---------- All Character ----------");
        List<ProfileCharacter> listShowAll = characterController.findAll();
        for (ProfileCharacter profileCharacter: listShowAll) {
            System.out.println(profileCharacter);
        }
    }
    public void findByNameList() {
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
    public void findByIDList() {
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

