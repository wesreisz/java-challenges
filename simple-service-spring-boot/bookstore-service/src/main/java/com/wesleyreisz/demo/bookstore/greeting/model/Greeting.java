package com.wesleyreisz.demo.bookstore.greeting.model;

/**
 * Created by wesleyreisz on 12/28/16.
 */
public class Greeting {
    private long id;
    private String name;

    public Greeting(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

     public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
