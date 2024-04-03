package controller;

import IOFile.IOFileUser;
import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserController implements controller.IController<User> {
    List<User> list = IOFileUser.readFileUser();
    @Override
    public void add(User user) {
        IOFileUser.writeFileUser(list);
        list.add(user);
    }

    @Override
    public void edit(int index, User user) {
        IOFileUser.writeFileUser(list);
        list.set(index, user);
    }

    @Override
    public void delete(int index) {
        IOFileUser.writeFileUser(list);
        list.remove(index);
    }

    @Override
    public List<User> findAll() {
        return list;
    }

    @Override
    public int findByID(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(id == list.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List findByName(String name) {
        List<Integer> listByName = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getUsername().contains(name)) {
                listByName.add(i);
            }
        }
        return listByName;
    }
    public String findByUsername(String username) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getUsername().equals(username)) {
                return username;
            }
        }
        return "-1";
    }
}
