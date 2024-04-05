package IOFile;

import model.ProfileCharacter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOFileCharacter {
    private static Scanner sc = new Scanner(System.in);
    private static File fileCharacter = new File("src/data/ProfileCharacter.csv");
    public static List<ProfileCharacter> readFileCharacter() {
        List<ProfileCharacter> profileCharacterList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileCharacter);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                ProfileCharacter profileCharacterData = new ProfileCharacter(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), data[3], data[4]);
                profileCharacterList.add(profileCharacterData);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("IOException Error");
        }
        return profileCharacterList;
    }
    public static void writeFileCharacter(List<ProfileCharacter> fileCharacterWriter) {
        try {
            FileWriter fileWriter = new FileWriter(fileCharacter);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = "";
            for (ProfileCharacter c: fileCharacterWriter) {
                data += c.getId() + "," + c.getName() + "," + c.getAge() + "," + c.getAddress() + "," + c.getDescription() + "\n";
            }
            bufferedWriter.write(data);
            fileWriter.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("IOException error");
        }

    }
}
