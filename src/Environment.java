import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class Environment {

    int i = 0;
    int j = 0;
    private final int  columns =18;
    private final int rows = 6;
    char[][] environmentTile = new char[rows][columns];

    HabitatTile tileToAdd;
    WildlifeToken tokenToAdd;

/*
    private List<Player> playerList;
*/

    public Environment(HabitatTile tileToAdd, WildlifeToken tokenToAdd){
        this.tileToAdd = tileToAdd;
        this.tokenToAdd = tokenToAdd;
        fillTile();
    }

    public void fillTile(){
        for (int n = 0; n < rows; n++) {
            if (n==0||n == 5){
                addLine(3, 5,n);
            }
            else if (n==1||n == 4) {
                addLine(1, 14, n);
            } else{
                addLine(0, 16,n);
            }
        }
    }


    public void addLine(int margin, int stars, int line){
        for (int i =0; i<columns; i++){

            for (int j =0; j<margin; i++){
                this.environmentTile[line][getI()] = ' ';
                increaseI();
            }
            for (int j =0; j<(stars-margin); i++){
                if (line == 3){
                    if (getI() == 7){
                        this.environmentTile[line][getI()] = Array.getChar(this.tileToAdd, 0);
                        increaseI();
                    }else {
                        this.environmentTile[line][getI()] = '*';
                        increaseI();
                    }

                }else {
                    this.environmentTile[line][getI()] = '*';
                    increaseI();
                }

            }
            for (int j =0; j<margin; i++){
                this.environmentTile[line][getI()] = ' ';
                increaseI();
            }
            increaseJ();
        }
    }

    private void setI(int i) {
        this.i = i;
    }

    private void increaseJ(){
        int temp = getJ();
        temp += 1;
        setJ(temp);
    }
    private void increaseI(){
        int temp = getI();
        temp += 1;
        setI(temp);
    }
    public int getI() {
        return i%18;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getJ() {
        return j%6;
    }


}
