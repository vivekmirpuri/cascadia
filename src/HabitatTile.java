import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HabitatTile {
    HabitatType habitatType1;
    HabitatType habitatType2;
    String color1;
    String color2;
    

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
    public void getFirstCharForHabitat(){
        if (this.habitatType1 == HabitatType.FOREST){
        	setColorsToDisplay('F');
        } else if (this.habitatType1 == HabitatType.GRASSLAND) {
        	setColorsToDisplay('G');
        } else if (this.habitatType1 == HabitatType.MOUNTAIN) {
        	setColorsToDisplay('M');
        } else if (this.habitatType1 == HabitatType.WETLAND) {
        	setColorsToDisplay('W');
        } else if (this.habitatType1 == HabitatType.PRAIRIE) {
        	setColorsToDisplay('P');
        } else {
        	setColorsToDisplay('?');
        }

    }
    public void setCharsToDisplay(char character) {
        this.charToDisplay = character;
    }
    public void setColorsToDisplay(char letter) {
    	
    	StartHabitat colors = new StartHabitat();
    	switch(letter) {
    	case 'F':
    		
    		
    	}
    	
    }

    public char getCharToDisplay() {
        return this.charToDisplay;
    }
}


