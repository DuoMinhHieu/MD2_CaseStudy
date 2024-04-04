package controller;

import IOFile.IOFileListChar;
import model.ListChar;

import java.util.ArrayList;
import java.util.List;

public class ListCharController implements IController<ListChar>{
    List<ListChar> list = IOFileListChar.readFileListChar();
    @Override
    public void add(ListChar listChar) {
        list.add(listChar);
    }

    @Override
    public void edit(int index, ListChar listChar) {
        list.set(index, listChar);
    }

    @Override
    public void delete(int index) {
        list.remove(index);
    }

    @Override
    public List<ListChar> findAll() {
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