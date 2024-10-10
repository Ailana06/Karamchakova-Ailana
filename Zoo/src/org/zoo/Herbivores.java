package org.zoo;

public class Herbivores extends Eat {
    public void food(){
        eat();
        System.out.println("grass");
    }
}
