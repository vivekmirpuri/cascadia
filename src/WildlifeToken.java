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
        getFirstChar();
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
        } else if (this.tokenToDisplay == WildlifeType.BEAR) {
            setCharToDisplay('B');
        } else {
            setCharToDisplay('?');
        }
        return this.charToDisplay;

    }
}
