package org.example.courseworkstore.entities;

public class Category {
    private final String name;
    private String description;

    public Category(String name){
        this.name = name;
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
