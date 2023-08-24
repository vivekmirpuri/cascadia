import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HabitatTile {
    HabitatType habitatType1;

    HabitatType habitatType2;

    WildlifeType wildlifeType1;
    WildlifeType wildlifeType2;

    WildlifeType wildlifeType3;

    private final int numberOfHabitats;
    private final int numberOfWildlife;
    private char charToDisplay;

    HabitatTile(){
        this.numberOfWildlife = 1 + (int)(Math.random() * ((3 - 1) + 1));
        this.numberOfHabitats = 1 + (int)(Math.random() * ((2 - 1) + 1));
      if (numberOfHabitats == 2){
          setHabitatType1(getRandomHabitat());
          setHabitatType2(getRandomHabitat());
      }else {
          setHabitatType1(getRandomHabitat());
      }
      if (numberOfWildlife == 3){
          setWildlifeType1(getRandomWildlife());
          setWildlifeType2((getRandomWildlife()));
          setWildlifeType3(getRandomWildlife());
      } else if (numberOfWildlife== 2) {
          setWildlifeType1(getRandomWildlife());
          setWildlifeType2((getRandomWildlife()));
      }else{
          setWildlifeType1(getRandomWildlife());
      }
        getFirstCharForHabitat();

    }

    public HabitatType getHabitatType1() {
        return habitatType1;
    }

    public HabitatType getHabitatType2() {
        return habitatType2;
    }
    public WildlifeType getWildlifeType3() {
        return wildlifeType3;
    }

    public int getNumberOfHabitats() {
        return numberOfHabitats;
    }

    public int getNumberOfWildlife() {
        return numberOfWildlife;
    }

    public void setHabitatType1(HabitatType habitatType1) {
        this.habitatType1 = habitatType1;
    }

    public void setHabitatType2(HabitatType habitatType2) {
        this.habitatType2 = habitatType2;
    }

    public HabitatType getRandomHabitat() {
       return HabitatType.values()[new Random().nextInt(HabitatType.values().length)];
    }
    public WildlifeType getRandomWildlife() {
        return WildlifeType.values()[new Random().nextInt(WildlifeType.values().length)];
    }


    public void setWildlifeType1(WildlifeType wildlifeType1) {
        this.wildlifeType1 = wildlifeType1;
    }

    public void setWildlifeType2(WildlifeType wildlifeType2) {
        this.wildlifeType2 = wildlifeType2;
    }

    public void setWildlifeType3(WildlifeType wildlifeType3) {
        this.wildlifeType3 = wildlifeType3;
    }


    public void getFirstCharForHabitat(){
        if (this.habitatType1 == HabitatType.FOREST){
            setCharToDisplay('F');
        } else if (this.habitatType1 == HabitatType.GRASSLAND) {
            setCharToDisplay('G');
        } else if (this.habitatType1 == HabitatType.MOUNTAIN) {
            setCharToDisplay('M');
        } else if (this.habitatType1 == HabitatType.WETLAND) {
            setCharToDisplay('W');
        } else if (this.habitatType1 == HabitatType.PRAIRIE) {
            setCharToDisplay('P');
        } else {
            setCharToDisplay('?');
        }

    }
    public void setCharToDisplay(char character) {
        this.charToDisplay = character;
    }

    public char getCharToDisplay() {
        return this.charToDisplay;
    }
}


