package me.sheharyar.sparkrelay;

import java.util.LinkedList;
import java.util.List;

public class Core {
    private int id;

    private String name;
    private String token;
    private String identifier;

    private List<Relay> relays = new LinkedList<Relay>();

    public Core(){}

    public Core(String name, String identifier, String token) {
        super();
        this.name = name;
        this.token = token;
        this.identifier = identifier;

        for (int i=1; i<=4; i++)
            relays.add(new Relay("Relay " + i.toString()));

    }
}
