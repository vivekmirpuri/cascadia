import java.util.Random;

public class WildlifeToken {
    private WildlifeType tokenToDisplay;
    public WildlifeType getRandomWildlifeToken() {
        return WildlifeType.values()[new Random().nextInt(WildlifeType.values().length)];
    }
    public WildlifeToken(){
        this.tokenToDisplay=getRandomWildlifeToken();
    }

    public void setTokenToDisplay(WildlifeType tokenToDisplay) {
        this.tokenToDisplay = tokenToDisplay;
    }

    public WildlifeType getTokenToDisplay() {
        return tokenToDisplay;
    }
}
