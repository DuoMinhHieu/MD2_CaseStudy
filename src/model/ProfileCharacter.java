package model;

public class ProfileCharacter {
    private int id;
    private String name;
    private int age;
    private String address;
    private String description;

    public ProfileCharacter() {
    }

    public ProfileCharacter(int id, String name, int age, String address, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}