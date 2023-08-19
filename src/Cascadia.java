import java.util.*;

public class Cascadia {

    public final static int ROWS = 60;
    public final static int COLS = 180;
    private final int numberPlayers = 2;
    private List<Player> players;
    private List<HabitatTile> availableHabitatTiles;
    private List<WildlifeToken> availableWildlifeTokens;


    public static void main(String[] a) {
        Cascadia trial = new Cascadia();
       trial.startGame();

    }

    public Cascadia() {
        Random random = new Random();
        this.players = new ArrayList<>();
        this.availableHabitatTiles = new ArrayList<>();
        this.availableWildlifeTokens = new ArrayList<>();

    }
    public void startGame() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("This game is for two players");


        for (int i = 0; i < this.numberPlayers; i++) {
            System.out.printf("Enter player name for player %d%n", i + 1);

            String name = "";
            while (name.isBlank()) {
                name = scanner.nextLine();
            }
            Player p = new Player();
            p.setName(name);
            players.add(p);
            Collections.shuffle(players); // this is to ensure the order is randomized, the turn is assigned as shuffled

            players.get(i).populatePlayerBoard();

        }
        getOrder();
        Builder tileMaker = new Builder(players);
        for (int x =0; x < players.size(); x++){
            tileMaker.setIndex(x);
            for (int i = 0; i < (ROWS/6 * COLS/18); i++) {   //this is to print the tiles empty, as many times as the board
                tileMaker.tile();
            }
            System.out.println("This is " + players.get(x).getName() + "'s board");
            players.get(x).getPlayerBoard();
            System.out.println();
        }




    }
    public void getOrder(){
        System.out.println("The order of play will be the following");
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("%d. %s", i+1, players.get(i).getName());
            System.out.println();
        }
    }




}
