import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> items = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        printDoubled(items);

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        CricketPlayer rick = new CricketPlayer("Rick");

        Team<FootballPlayer> football = new Team("Football Team");
        Team<BaseballPlayer> baseball = new Team("Baseball Team");
        Team<CricketPlayer> cricket = new Team("Cricket Team");
        football.addPlayer(joe);
        baseball.addPlayer(pat);
        cricket.addPlayer(rick);

        System.out.println(football.numPlayers());
        System.out.println(baseball.numPlayers());
        System.out.println(cricket.numPlayers());
    }

    private static void printDoubled(ArrayList<Integer> n) {
        for (Object i: n) {
            System.out.println((Integer) i * 2);
        }
    }
}
