package model;

public class ListChar {
    private int id;
    private String username;
    private String listC;

    public ListChar() {
    }

    public ListChar(int id, String username, String listC) {
        this.id = id;
        this.username = username;
        this.listC = listC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getListC() {
        return listC;
    }

    public void setListC(String listC) {
        this.listC = listC;
    }

    @Override
    public String toString() {
        return "ListChar{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", listC='" + listC + '\'' +
                '}';
    }
}
