
package IOFile;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class IOFileUser {
    private static Scanner sc = new Scanner(System.in);
    private static File fileUser = new File();
    public static List<User> readFileUser() {
        List<User> users = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileUser);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                User userData = new User(Integer.parseInt(data[0]), data[1], data[2], data[3]);
                users.add(userData);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("IOException Error");
        }
        return users;

    }

    public static void writeFileUser(List<User> list) {
    }
}
