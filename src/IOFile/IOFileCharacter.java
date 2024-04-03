package IOFile;

import model.ProfileCharacter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOFileCharacter {
    private static Scanner sc = new Scanner(System.in);
    private static File fileCharacter = new File();
    public static List<ProfileCharacter> readFileCharacter() {
        List<ProfileCharacter> profileCharacterList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileCharacter);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("IOException Error");
        }
        return profileCharacterList;
    }
}
