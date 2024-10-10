package org.zoo;

public class Tiger extends Predators {
    public void name() {
        System.out.print("Tiger ");
    }

    public void nutrition() {
        name();
        beef();
    }

    public void movement() {
        name();
        Land land = new Land();
        land.walk();
    }
}

