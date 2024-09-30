package org.zoo;

public class Horse extends Herbivores{
    public void name() {
        System.out.print("Horse ");
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

