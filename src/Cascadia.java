import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Cascadia {
    private final int numberPlayers = 2;
    private List<Player> players;
    private List<> availableHabitatTiles;
    private List<> availableWildlifeTokens;


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
        for (int i = 0; i < this.numberPlayers; i++) {
            System.out.println(String.format("Enter player name for player %d", i + 1));
            String name = "";

            while (name.isBlank()) {
                name = scanner.nextLine();
            }
            Player p = new Player();
            p.setName(name);
            players.add(p);

        }


    }

}
