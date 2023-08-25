import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HabitatTile {
    public static final String FOREST_DARK_GREEN = "\u001B[2m";
    public static final String WETLAND_LIGHT_GREEN = "\u001B[32m";
    public static final String RIVER_BLUE = "\u001B[34m";
    public static final String MOUNTAIN_GREY = "\u001B[90m";
    public static final String PRAIRIE_YELLOW = "\u001B[33m";

    // Wildlife Token Colours and ANSI Codes
    public static final String HAWK_BLUE = "\u001B[34m";
    public static final String BEAR_BROWN = "\u001B[96m";
    public static final String ELK_BLACK = "\u001B[30m";
    public static final String SALMON_PINK_RED = "\u001B[31m";
    public static final String FOX_ORANGE = "\u001B[38;5;214m";
    HabitatType habitatType1;
    HabitatType habitatType2;

    List<String> colors= new ArrayList<String>(Arrays.asList());
    List<Character> chars= new ArrayList<Character>(Arrays.asList());


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
        setChars();

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
    



    public char getAvailableWildlifeType(){
    	if(this.numberOfWildlife==1) {
    		if (this.wildlifeType1 == WildlifeType.ELK){
                setCharsToDisplay('E');

            } else if (this.wildlifeType1 == WildlifeType.FOX) {
                setCharsToDisplay('F');

            }else if (this.wildlifeType1 == WildlifeType.HAWK) {
                setCharsToDisplay('H');

            }else if (this.wildlifeType1 == WildlifeType.SALMON) {
                setCharsToDisplay('S');
            } else if (this.wildlifeType1 == WildlifeType.BEAR) {
                setCharsToDisplay('B');
            } else {
                setCharsToDisplay('?');
            }

    
    	}else if (this.numberOfWildlife ==2) {
    		
    	}else {
    		
    	}
        return this.charToDisplay;

    }
    public void setChars(){

        if (numberOfHabitats == 2){
            if (this.habitatType1 == HabitatType.FOREST){
                this.colors.add(FOREST_DARK_GREEN);
            } else if (this.habitatType1 == HabitatType.GRASSLAND) {
                this.colors.add(RIVER_BLUE);
            } else if (this.habitatType1 == HabitatType.MOUNTAIN) {
                this.colors.add(MOUNTAIN_GREY);
            } else if (this.habitatType1 == HabitatType.WETLAND) {
                this.colors.add(WETLAND_LIGHT_GREEN);
            } else if (this.habitatType1 == HabitatType.PRAIRIE) {
                this.colors.add(PRAIRIE_YELLOW);
            }
            if (this.habitatType2 == HabitatType.FOREST){
                this.colors.add(FOREST_DARK_GREEN);
            } else if (this.habitatType2 == HabitatType.GRASSLAND) {
                this.colors.add(RIVER_BLUE);
            } else if (this.habitatType2 == HabitatType.MOUNTAIN) {
                this.colors.add(MOUNTAIN_GREY);
            } else if (this.habitatType2 == HabitatType.WETLAND) {
                this.colors.add(WETLAND_LIGHT_GREEN);
            } else if (this.habitatType2 == HabitatType.PRAIRIE) {
                this.colors.add(PRAIRIE_YELLOW);
            }
        }else {
            if (this.habitatType1 == HabitatType.FOREST){
                this.colors.add(FOREST_DARK_GREEN);
            } else if (this.habitatType1 == HabitatType.GRASSLAND) {
                this.colors.add(RIVER_BLUE);
            } else if (this.habitatType1 == HabitatType.MOUNTAIN) {
                this.colors.add(MOUNTAIN_GREY);
            } else if (this.habitatType1 == HabitatType.WETLAND) {
                this.colors.add(WETLAND_LIGHT_GREEN);
            } else if (this.habitatType1 == HabitatType.PRAIRIE) {
                this.colors.add(PRAIRIE_YELLOW);
            }
        }
    }
    public void setCharsToDisplay(char character) {
        this.charToDisplay = character;
    }
    public char getCharToDisplay() {
        return this.charToDisplay;
    }

    
}


