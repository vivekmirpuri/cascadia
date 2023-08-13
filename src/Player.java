import java.util.List;

public class Player {
    public final static int ROWS = 60;
    public final static int COLS = 210;

    private String name;
    private char[][] playerBoard = new char[ROWS][COLS];

    public void setPlayerBoard() {
        for (int i = 0; i < ROWS ; i++){
            for (int j = 0; j < COLS ; j++){
                playerBoard[i][j] = '·';
            }
        }
    }
    public void getPlayerBoard() {
        for (int j = 0; j < COLS +2; j++){
            System.out.print('*');
        }
        System.out.println();
        for (int i = 0; i < ROWS ; i++){
            System.out.print('*');
            for (int j = 0; j < COLS ; j++){
                System.out.print(playerBoard[i][j]);
            }
            System.out.print('*');
            System.out.println();
        }
        for (int j = 0; j < COLS +2 ; j++){
            System.out.print('*');
        }
    }

    public void setName(String name){
        this.name = name;
    }


    public Object getName() {
        return this.name;
    }




}
