import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Builder {
    public final static int XAXIS = 180;
    List<Player> playerList;
    private int pointerToVerticalChar = 0;
    private int pointerToHorizontalChar = 0;
    private char charToChange = '*';
    boolean[] toPlaceTiles = new boolean[95]; //number of possible hexagons per match
    int indexOfPlayer;
    private final int  columns =18;
    private final int rows = 6;
    private int i = 0;
    private int j = 0;

    public Builder(List<Player> players){
        this.playerList = players;
    }
    public void emptyTile(int offset, int frequency, int playerIndex, int n) {
        for (int j = 0; j < offset; j++) {
                playerList.get(playerIndex).changeCharsBoard(getI(),getJ(),' ');
                increaseJ();
        }

        for (int k = 0; k < columns - 2*offset; k++) {
            if (n!=3){
                    if (k % frequency == 0) {
                        playerList.get(playerIndex).changeCharsBoard(getI(), getJ(), charToChange);
                    } else {
                        playerList.get(playerIndex).changeCharsBoard(getI(), getJ(), ' ');
                    }
                    increaseJ();
            }else {
                if (k % frequency == 0) {
                    playerList.get(playerIndex).changeCharsBoard(getI(), getJ(), this.charToChange);
                } else {
                    if (k==5){
                        for (int i = 0; i<5;i++){
                            playerList.get(playerIndex).changeCharsBoard(getI(), getJ(), giveCoordinates().charAt(i));
                            increaseJ();
                            k++;
                        }
                    }else {
                        playerList.get(playerIndex).changeCharsBoard(getI(), getJ(), ' ');
                    }
                }
                increaseJ();
            }
        }

    }


    public void tile() {
        for (int n = 0; n < rows; n++) {
            if (n==0||n == 5){
                emptyTile(3, 5, getIndex(),n);
            }
            else if (n==1||n == 4) {
                emptyTile(1, 14, getIndex(),n);
            } else{
                emptyTile(0, 16, getIndex(),n);
            }
            setJ(pointerToVerticalChar);
            increaseI();
        }

            if (getPointerToVerticalChar() == (XAXIS-columns) ){
                increaseHorizontalPointer();
            } else {
                setI(pointerToHorizontalChar);
            }

            increaseVerticalPointer();
            setJ(pointerToVerticalChar);

        if (((getPointerToHorizontalChar()/6) % 2)!= 0){
                if (getPointerToVerticalChar()==0){
                    pointerToVerticalChar += 9;
                }
                if (getPointerToVerticalChar() == (XAXIS - 9)){
                    setPointerToVerticalChar(0);
                    increaseHorizontalPointer();
                    setI(pointerToHorizontalChar);
                }
            setJ(pointerToVerticalChar);
        }
    }


    public void changing(char charToChange){
        this.charToChange = charToChange;
    }

    private void setI(int x){
        this.i= x;
    }
    private void setJ(int y){
        this.j= y;
    }
    private void setPointerToVerticalChar(int pointerToVerticalChar) {
        this.pointerToVerticalChar = pointerToVerticalChar%XAXIS;
    }


    private void setPointerToHorizontalChar(int pointerToHorizontalChar) {
        this.pointerToHorizontalChar = pointerToHorizontalChar;
    }

    public int getIndex() {
        return indexOfPlayer;
    }
    private int getI(){
        return this.i;
    }
    private int getJ(){
        return this.j;
    }

    private int getPointerToHorizontalChar() {
        return pointerToHorizontalChar;
    }
    private int getPointerToVerticalChar() {
        return pointerToVerticalChar;
    }


    private void increaseVerticalPointer(){
        int temp = getPointerToVerticalChar();
        temp += columns; //this way we make sure the pointer can go by every coordinate and print hexagons where needed
        setPointerToVerticalChar(temp);
    }
    private void increaseHorizontalPointer(){
        int temp = getPointerToHorizontalChar();
        temp += rows; //this way we make sure the pointer can go by every coordinate and print hexagons where needed
        setPointerToHorizontalChar(temp);
    }

    private void increaseI(){
        int temp = getI();
        temp += 1;
        setI(temp);
    }
    private void increaseJ(){
        int temp = getJ();
        temp += 1;
        setJ(temp);
    }
    public void setIndex(int index){
        this.indexOfPlayer = index;
        setI(0);// when indexOfPlayer is changed values for playerBoardManipulationChange
        setJ(0);
        setPointerToHorizontalChar(0);
        setPointerToVerticalChar(0);
        Arrays.fill(toPlaceTiles, false);
    }

    /*public boolean shouldPrint(int index){

    }*/

    public String giveCoordinates(){
        int vertical = getPointerToVerticalChar()/columns ;
        int horizontal = getPointerToHorizontalChar()/rows;
        return "(" + horizontal + "," + vertical + ")";
    }


    public void setHabitatTile(HabitatTile habitat) {

    }
}

