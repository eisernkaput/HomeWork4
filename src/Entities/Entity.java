package Entities;

import java.io.Serializable;

public abstract class Entity implements Serializable,Comparable<Entity> {

    private String id;

    public Entity(String id) {
        super();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Entity e) {
        return this.getId().compareTo(e.getId());
    }
}
