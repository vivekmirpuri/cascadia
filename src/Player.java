import java.util.List;

public class Player {
    public final static int ROWS = 600;
    public final static int COLS = 800;

    private String name;
    private char[][] playerBoard = new char[ROWS][COLS];





    public void setName(String name){
        this.name = name;
    }


    public Object getName() {
        return this.name;
    }
}
