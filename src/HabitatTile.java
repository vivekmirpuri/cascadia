import java.util.Random;

public class HabitatTile {


    public HabitatType getRandom() {
       return HabitatType.values()[new Random().nextInt(HabitatType.values().length)];
    }




}


