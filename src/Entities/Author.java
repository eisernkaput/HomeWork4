package Entities;

public class Author extends Entity {

    private String name;

    public Author(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getId() + "." + this.getName() + ";";
    }
}
