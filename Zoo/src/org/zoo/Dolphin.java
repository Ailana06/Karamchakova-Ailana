package org.zoo;

public class Dolphin  extends Predators  {
    public void name() {
        System.out.print("Dolphin ");
    }

    public void nutrition() {
        name();
        fish();
    }

    public void movement() {
        name();
        Waterfowl waterfowl = new Waterfowl();
        waterfowl.swim();
    }
}
