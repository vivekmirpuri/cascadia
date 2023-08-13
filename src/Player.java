import java.util.List;

public class Player {
    public final static int ROWS = 600;
    public final static int COLS = 700;

    private String name;
    private char[][] playerBoard = new char[ROWS][COLS];

    public void setPlayerBoard(char[][] playerBoard) {
        for (int i = 0; i < ROWS ; i++){
            for (int j = 0; j < COLS ; j++){
                playerBoard[i][j] = '·';
            }
        }
    }
    public void getPlayerBoard(char[][] playerBoard) {
        for (int i = 0; i < ROWS ; i++){
            for (int j = 0; j < COLS ; j++){
                System.out.print(playerBoard[i][j] = '·');
            }
        }
    }

    public void setName(String name){
        this.name = name;
    }


    public Object getName() {
        return this.name;
    }




}
