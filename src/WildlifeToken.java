import java.lang.reflect.Array;
import java.util.Random;

public class WildlifeToken {
    private WildlifeType tokenToDisplay;
    private char charToDisplay;
    public WildlifeType getRandomWildlifeToken() {
        return WildlifeType.values()[new Random().nextInt(WildlifeType.values().length)];
    }
    public WildlifeToken(){
        setTokenToDisplay(getRandomWildlifeToken());
    }

    public void setTokenToDisplay(WildlifeType tokenToDisplay) {
        this.tokenToDisplay = tokenToDisplay;
    }

    public WildlifeType getTokenToDisplay() {
        return tokenToDisplay;
    }

    public char getCharToDisplay() {
        return charToDisplay;
    }

    public void setCharToDisplay(char charToDisplay) {
        this.charToDisplay = charToDisplay;
    }

    public char getFirstChar(){
        if (this.tokenToDisplay == WildlifeType.ELK){
            setCharToDisplay('E');

        } else if (this.tokenToDisplay == WildlifeType.FOX) {
            setCharToDisplay('F');

        }else if (this.tokenToDisplay == WildlifeType.HAWK) {
            setCharToDisplay('H');

        }else if (this.tokenToDisplay == WildlifeType.SALMON) {
            setCharToDisplay('S');
        }else{ //BEAR
            setCharToDisplay('B');
        }
        return this.charToDisplay;

    }
}
