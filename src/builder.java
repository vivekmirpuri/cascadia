import java.util.List;

public class builder {
    List<Player> playerList;
    int indexOfPlayer;
    private final int rows = 6;
    private final int  columns =18;
    private int i =0;
    private int j = 0;

    public builder(List<Player> players){

        this.playerList = players;
    }
    public void emptyTile(int offset, int frequency, int threshold, int x, int y, int playerindex) {

        if (threshold <= rows){
            for (int j = 0; j < offset; j++) {
                playerList.get(indexOfPlayer).changeCharsBoard(x,y,' ');
                x++;
            }
            for (int k = 0; k < columns - 2*offset; k++) {
                if (k % frequency == 0 || k == 0) {
                    playerList.get(indexOfPlayer).changeCharsBoard(x,y,'*');
                    x++;
                } else {
                    playerList.get(indexOfPlayer).changeCharsBoard(x,y,' ');
                    x++;
                }
            }
        }
    }


    public void setI(int x){
        this.i= x;
    }
    public void setJ(int y){
        this.j= y;
    }

    public int getI(){
        return this.i;
    }
    public int getJ(){
        return this.j;
    }
    public int increaseJ(){
        int temp = getJ();
        return temp++;
    }

    public void setIndex(int index){
        this.indexOfPlayer = index;
        setJ(0);
        setI(0);// when indexOfplayer is changed values for playerBoardManipulationChange
    }

    public int getIndex() {
        return indexOfPlayer;
    }

    public void tile() {
        int n = 1;

        emptyTile(3,5,n, 0, 0, getIndex());
        switch (n) {
            case 1:
                setJ(increaseJ());
                n++;
                emptyTile(1,14, n , getI(), getJ(), getIndex());
            case 2:
                setJ(increaseJ());
                n++;
                emptyTile(0,16, n, getI(), getJ(), getIndex());
            case 3:
                setJ(increaseJ());
                n++;
                emptyTile(0,16, n,  getI(), getJ(), getIndex());
            case 4:
                setJ(increaseJ());
                n++;
                emptyTile(1,14, n, getI(), getJ(), getIndex());
            case 5:
                setJ(increaseJ());
                n++;
                emptyTile(3,5, n, getI(), getJ(), getIndex());
            case 6:
                setJ(increaseJ());

        }

    }

}
