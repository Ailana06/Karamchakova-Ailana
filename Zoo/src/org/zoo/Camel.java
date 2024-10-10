package org.zoo;

public class Camel extends Herbivores {
    public void name() {
        System.out.print("Camel ");
    }

    public void nutrition() {
        name();
        food();
    }

    public void movement() {
        name();
        Land land = new Land();
        land.walk();
    }
}
