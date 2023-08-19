import java.util.List;

public class Player {
    public final static int ROWS = 60;
    public final static int COLS = 180;
    private String name;
    private int playerNumberTurns = 0;
    private char[][] playerBoard = new char[ROWS][COLS];

    public void populatePlayerBoard() {
        for (int i = 0; i < ROWS ; i++){
            for (int j = 0; j < COLS ; j++){
                playerBoard[i][j] = '·';
            }
        }
    }
    public void changeCharsBoard(int i, int j, char charToChange) {
        playerBoard[i][j] = charToChange;
    }
    public void getPlayerBoard() {
        for (int j = 0; j < COLS +2; j++){
            System.out.print('≈');
        }
        System.out.println();
        for (int i = 0; i < ROWS ; i++){
            System.out.print('»');
            for (int j = 0; j < COLS ; j++){
                System.out.print(playerBoard[i][j]);
            }
            System.out.print('«');
            System.out.println();
        }
        for (int j = 0; j < COLS +2 ; j++){
            System.out.print('≈');
        }
    }

    public  char[][] retrieveBoard() {
        return this.playerBoard;
    }

   /* public void setPlayerBoard(char[][] playerBoard) {
        this.playerBoard = playerBoard;
    }*/

    public void setName(String name){
        this.name = name;
    }
    public Object getName() {
        return this.name;
    }

    public void addTurn(){
        if (playerNumberTurns <= 20){
            playerNumberTurns++;
        }else
            throw new IllegalArgumentException("player has already played 20 turns");

    }
    public int getTurn(){
        return this.playerNumberTurns;
    }




}
