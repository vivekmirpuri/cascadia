import java.util.List;

public class Builder {
    public final static int TOTALROWS = 60;
    public final static int XAXIS = 180;
    List<Player> playerList;
    private int pointerToVerticalChar = 0;
    private int pointerToHorizontalChar = 0;

    public int[] pairs = new int[100]; //used to track coordinates for the unfilled hexagons
    int indexOfPlayer;
    private final int  columns =18;
    private final int rows = 6;
    private int i = 0;
    private int j = 0;

    public Builder(List<Player> players){
        this.playerList = players;
    }
    public void emptyTile(int offset, int frequency, int playerIndex) {
        for (int j = 0; j < offset; j++) {
                playerList.get(playerIndex).changeCharsBoard(getI(),getJ(),' ');
                increaseJ();
        }

        for (int k = 0; k < columns - 2*offset; k++) {
                if (k % frequency == 0 || k == 0) {
                    playerList.get(playerIndex).changeCharsBoard(getI(),getJ(),'*');
                } else {
                    playerList.get(playerIndex).changeCharsBoard(getI(),getJ(),' ');
                }
                increaseJ();
        }

    }
    public void fillTileAt(int offset, int frequency, int playerIndex){
        for (int j = 0; j < offset; j++) {
            playerList.get(playerIndex).changeCharsBoard(getI(),getJ(),' ');
            increaseJ();
        }
        for (int k = 0; k < columns - 2*offset; k++) {
            playerList.get(playerIndex).changeCharsBoard(getI(),getJ(),'*');
            increaseJ();
        }

    }

    public void tile() {
        for (int n = 0; n < rows; n++) {
            if (n==0||n == 5){
                emptyTile(3, 5, getIndex());}
            else if (n==1||n == 4) {
                emptyTile(1, 14, getIndex());
            } else{
                emptyTile(0, 16, getIndex());
            }
            setJ(pointerToVerticalChar);
            increaseI();
        }
        increaseVerticalPointer();
        setJ(pointerToVerticalChar);
        if (pointerToVerticalChar == XAXIS){
            increaseHorizontalPointer();
        }else {
            setI(pointerToHorizontalChar);
        }

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

    private int getpointerToHorizontalChar() {
        return pointerToVerticalChar;
    }

    private void increaseVerticalPointer(){
        int temp = getPointerToVerticalChar();
        temp += columns; //this way we make sure the pointer can go by every coordinate and print hexagons where needed
        setPointerToVerticalChar(temp);
    }
    private void increaseHorizontalPointer(){
        int temp = getpointerToHorizontalChar();
        temp += rows; //this way we make sure the pointer can go by every coordinate and print hexagons where needed
        setPointerToHorizontalChar(temp);
    }

    private int getPointerToVerticalChar() {
        return pointerToVerticalChar;
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
    }
}

