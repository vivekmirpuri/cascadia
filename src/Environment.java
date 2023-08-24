import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class Environment {

    private final int  columns = 16;
    private final int rows = 6;
    char[][] environmentTile = new char[rows][columns];

    public HabitatTile tileToAdd;
    public WildlifeToken tokenToAdd;

    public void printEnvironment() {
        for (char[] row : environmentTile) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public Environment(HabitatTile tileToAdd, WildlifeToken tokenToAdd){
        this.tileToAdd = tileToAdd;
        this.tokenToAdd = tokenToAdd;
        fillTile();
    }

    public void fillTile(){
        for (int n = 0; n < rows; n++) {
            if (n==0||n == 5){
                addLine(3, 10,n);
            }
            else if (n==1||n == 4) {
                addLine(1, 14, n);
            } else{
                addLine(0, 16,n);
            }
        }
    }

    public char[][] getEnvironmentTile() {
        return environmentTile;
    }

    public void addLine(int margin, int stars, int line){
        for (int i =0; i<columns; i++){
            for (int j =0; j<margin; j++){
                this.environmentTile[line][i] = ' ';
                i++;
            }
            for (int j =0; j<stars; j++){
                if (line == 3){
                    if (i == 6 || i == 8){
                        this.environmentTile[line][i] = ' ';
                    } else if (i == 7){
                        this.environmentTile[line][i] = this.tileToAdd.getCharToDisplay();

                    }else {
                        this.environmentTile[line][i] = '*';
                    }
                }else {
                    this.environmentTile[line][i] = '*';
                }
                i++;
            }
            for (int j =0; j<margin; j++){
                this.environmentTile[line][i] = ' ';
                i++;
            }
        }
    }

    public WildlifeToken getTokenToAdd() {
        return this.tokenToAdd;
    }
    public HabitatTile getTileToAdd(){
        return this.tileToAdd;
    }


}
