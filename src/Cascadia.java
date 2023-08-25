import java.io.Reader;
import java.sql.ClientInfoStatus;
import java.util.*;

public class Cascadia {

    public final static int ROWS = 60;
    public final static int COLS = 180;
    private final int numberPlayers = 2;
    private int next=0;
    private List<Player> players;
    private List<HabitatTile> availableHabitatTiles;
    private List<WildlifeToken> availableWildlifeTokens;
    private List<Environment> environmentsToDisplay;

    private List<WildlifeToken> tokensToDisplay;
    private int tokenPointer = 0;



    public static void main(String[] a) {
        Cascadia trial = new Cascadia();
       trial.startGame();

    }

    public Cascadia() {
        this.players = new ArrayList<>();
        this.availableHabitatTiles = new ArrayList<>();
        this.availableWildlifeTokens = new ArrayList<>();
        this.environmentsToDisplay = new LinkedList<>();
        this.tokensToDisplay = new ArrayList<>();
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
            players.get(i).populatePlayerBoard();
        }
        Collections.shuffle(players); // this is to ensure the order is randomized, the turn is assigned as shuffled
        getOrder();
        Builder tileMaker = new Builder(players);
        for (int x =0; x < players.size(); x++){
            tileMaker.setIndex(x);
            for (int i = 0; i < (95); i++) {   //this is to print the tiles empty, as many times as the board
                tileMaker.tile();
            }
            System.out.println("This is " + players.get(x).getName() + "'s board");
            players.get(x).getPlayerBoard();
        }
        setTiles();

        setTokens();


        setEnvironmentsToDisplay();

        printEnvironments();


    }
    public void getOrder(){
        System.out.println("The order of play will be the following");
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("%d. %s", i+1, players.get(i).getName());
            System.out.println();
        }
    }


    public void setTiles(){
        for (int i=0; i<43; i++){
            availableHabitatTiles.add(new HabitatTile());
        }

    }

    public void setTokens(){
        for (int i=0; i<100; i++){
            this.availableWildlifeTokens.add(new WildlifeToken());
        }
    }
    public HabitatTile getOneTile(){
        return (availableHabitatTiles.get(getNext()));
    }
    public WildlifeToken getOneToken(){
        return (availableWildlifeTokens.get(getTokenPointer()));
    }
    public void increaseToken() {
        int temp = getTokenPointer();
        temp += 1;
        setTokenPointer(temp);

    }
    public int getTokenPointer() {
        return tokenPointer;
    }

    public void setTokenPointer(int tokenPointer) {
        this.tokenPointer = tokenPointer;
    }

    public void sumNext() {
        int temp = getNext();
        temp += 1;
        setNext(temp);
    }

    public int getNext() {
        return this.next;
    }

    public void setNext(int next) {
        this.next = next;
    }


    public void setEnvironmentsToDisplay(){
        for (int i = 0; i<4;i++){
            this.environmentsToDisplay.add(new Environment(getOneTile(),getOneToken()));
            this.tokensToDisplay.add(environmentsToDisplay.get(i).getTokenToAdd());
            sumNext();
            increaseToken();
        }
        if (cull()){
            System.out.println("Automatic cull dues to all WildlifeTokens being the same");
            for (int i = 0; i<environmentsToDisplay.size(); i++){
                this.environmentsToDisplay.get(i).setTokenToAdd(getOneToken());
                this.tokensToDisplay.get(i).setTypeToDisplay(this.environmentsToDisplay.get(i).getTokenToAdd().getTypeToDisplay());
            }
        } else if (optionToCull()) {
            System.out.println("You have the option to cull, if you would like to cull press 1, if not press 2");
            Scanner scanner = new Scanner(System.in);
            while(true){
                int temp= scanner.nextInt();
                if (temp == 1){
                    for (int i = 0; i<environmentsToDisplay.size(); i++){
                        this.environmentsToDisplay.get(i).setTokenToAdd(getOneToken());
                        this.tokensToDisplay.get(i).setTypeToDisplay(this.environmentsToDisplay.get(i).getTokenToAdd().getTypeToDisplay());
                    }
                    break;
                }else if (temp == 2){
                    System.out.println("You have chosen to not cull, proceed");
                    break;
                }
            }


        }
    }
    public void printEnvironments(){
        for (int i = 0; i<4;i++){
           this.environmentsToDisplay.get(i).printEnvironment();
            System.out.println();
        }
    }
    public boolean cull(){
        return this.tokensToDisplay.stream().distinct().count()==1;
    }
    public boolean optionToCull(){
        return this.tokensToDisplay.stream().distinct().count()==2;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
