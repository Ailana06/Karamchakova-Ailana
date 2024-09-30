import org.zoo.Horse;
import org.zoo.Tiger;
import org.zoo.Dolphin;
import org.zoo.Camel;
import org.zoo.Eagle;

public class Main {
    public static void main(String[] args) {
        Horse horse = new Horse();
        horse.nutrition();
        horse.movement();

        Dolphin dolphin = new Dolphin();
        dolphin.nutrition();
        dolphin.movement();

        Eagle eagle = new Eagle();
        eagle.nutrition();
        eagle.movement();

    }
}
