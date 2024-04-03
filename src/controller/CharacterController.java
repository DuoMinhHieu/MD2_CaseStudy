package controller;

import IOFile.IOFileCharacter;
import model.ProfileCharacter;

import java.util.ArrayList;
import java.util.List;

public class CharacterController implements IController <ProfileCharacter> {
    private List<ProfileCharacter> list = IOFileCharacter.readFileCharacter();

    @Override
    public void add(ProfileCharacter profileCharacter) {
        list.add(profileCharacter);
    }

    @Override
    public void edit(int index, ProfileCharacter profileCharacter) {
        list.set(index, profileCharacter);
    }

    @Override
    public void delete(int index) {
        list.remove(index);
    }

    @Override
    public List<ProfileCharacter> findAll() {
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
            if(list.get(i).getName().contains(name)) {
                listByName.add(i);
            }
        }
        return listByName;
    }
}
