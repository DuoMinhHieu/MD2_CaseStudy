import view.*;
import controller.CharacterController;
import IOFile.IOFileCharacter;
import view.FormMenu;


public class Main {
    public static void main(String[] args) {
        FormStart formStart = new FormStart();
        formStart.showFormStart();

        FormMenu formMenu = new FormMenu();
        formMenu.showFormMenu();

        FormCharacter formCharacter = new FormCharacter();
        formCharacter.addCharacter();

        FormLogin formLogin = new FormLogin();
        formLogin.showFormLogin();
    }
}