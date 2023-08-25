import java.lang.reflect.Array;
import java.util.Random;

public class WildlifeToken {
    private WildlifeType typeToDisplay;

    private char charToDisplay;
    public WildlifeType getRandomWildlifeToken() {
        return WildlifeType.values()[new Random().nextInt(WildlifeType.values().length)];
    }
    public WildlifeToken(){
        setTypeToDisplay(getRandomWildlifeToken());
        getFirstChar();
    }


    public void setTypeToDisplay(WildlifeType typeToDisplay) {
        this.typeToDisplay = typeToDisplay;
    }


    public WildlifeType getTypeToDisplay() {
        return typeToDisplay;
    }

    public char getCharToDisplay() {
        return charToDisplay;
    }

    public void setCharToDisplay(char charToDisplay) {
        this.charToDisplay = charToDisplay;
    }

    public char getFirstChar(){
        if (this.typeToDisplay == WildlifeType.ELK){
            setCharToDisplay('E');

        } else if (this.typeToDisplay == WildlifeType.FOX) {
            setCharToDisplay('F');

        }else if (this.typeToDisplay == WildlifeType.HAWK) {
            setCharToDisplay('H');

        }else if (this.typeToDisplay == WildlifeType.SALMON) {
            setCharToDisplay('S');
        } else if (this.typeToDisplay == WildlifeType.BEAR) {
            setCharToDisplay('B');
        } else {
            setCharToDisplay('?');
        }
        return this.charToDisplay;

    }
}
