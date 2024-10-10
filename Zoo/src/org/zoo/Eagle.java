package org.zoo;

public class Eagle extends Predators{
    public void name() {
        System.out.print("Eagle ");
    }

    public void nutrition() {
        name();
        meat();
    }

    public void movement() {
        name();
        Flying flying = new Flying();
        flying.fly();
    }
}
