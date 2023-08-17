import java.util.List;

public class builder {
    List<Player> playerList;
    private final int rows = 6;
    private final int  columns =18;
    private int i =0;
    private int j = 0;

    public builder(List<Player> players){
        this.playerList = players;
    }
    public void emptyTile(int offset, int frequency, int threshold, int x, int y) {

        if (threshold <= rows){
            for (int j = 0; j < offset; j++) {
                System.out.print(" ");

            }
            for (int k = 0; k < columns - 2*offset; k++) {
                if (k % frequency == 0 || k == 0) {

                    System.out.print("*");

                } else {

                    System.out.print(" ");

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

    public void tile() {
        int n = 1;

        emptyTile(3,5,n, 0, 0);
        switch (n) {
            case 1:
                System.out.println();
                n++;
                emptyTile(1,14, n , getI(), getJ());
            case 2:
                System.out.println();
                n++;
                emptyTile(0,16, n, getI(), getJ());
            case 3:
                System.out.println();
                n++;
                emptyTile(0,16, n,  getI(), getJ());
            case 4:
                System.out.println();
                n++;
                emptyTile(1,14, n, getI(), getJ());
            case 5:
                System.out.println();
                n++;
                emptyTile(3,5, n, getI(), getJ());
            case 6:
                System.out.println();

        }

    }

}
