package me.sheharyar.sparkrelay;

public class Relay {
    private int id;
    private String name;
    private Boolean value;

    public Relay() {}

    public Relay(String name) {
        super();
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
