package IOFile;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class IOFileUser {
    private static Scanner sc = new Scanner(System.in);
    private static File fileUser = new File("src/data/myUser.csv");
    public static List<User> readFileUser() {
        List<User> users = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileUser);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println(data[0]);
                User userData = new User(Integer.parseInt(data[0]), data[1], data[2], data[3]);
                users.add(userData);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("IOException Error");
        }
        return users;
    }
    public static void writeFileUser(List<User> fileUserWriter) {
        try {
            FileWriter fileWriter = new FileWriter(fileUser);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = "";
            List<Integer> idUserList = new ArrayList<>();
            for (int i = 0; i < fileUserWriter.size(); i++) {
                idUserList.add(fileUserWriter.get(i).getId());
            }
            idUserList.sort(Comparator.naturalOrder());
            for (User u: fileUserWriter) {
                data += u.getId() + "," + u.getUsername() + "," + u.getPassword() + "," + u.getPosition()  + "\n";
            }
            bufferedWriter.write(data);
            fileWriter.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("IOException error");
        }

    }
}
